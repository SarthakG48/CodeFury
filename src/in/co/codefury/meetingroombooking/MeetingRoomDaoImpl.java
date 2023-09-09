package in.co.codefury.meetingroombooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.co.codefury.meetingroombooking.user.model.User;

public class MeetingRoomDaoImpl implements MeetingRoomDao{

   private Connection con;

	public MeetingRoomDaoImpl() throws ClassNotFoundException, SQLException {

		init();
	}

	/**
	 * this is helper method hence it is private
	 * initializing connection object
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void init() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");	
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/meetingroombookingsystem_db", "root", "adminadmin");//change username and password here


	}
    @Override
	public int save(User u) throws SQLException {
		
		String sql = "INSERT INTO meetingroombookingsystem_db.user_tbl VALUES(?,?,?,?,?,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, u.getId());
		pstmt.setString(2, u.getName());
		pstmt.setString(3, u.getEmail());
        pstmt.setString(4, u.getPassword());
		pstmt.setString(5, u.getPhone());
		pstmt.setDouble(6, u.getCredits());
        pstmt.setInt(7, u.getRole());
		
		
		int numberOfRowsUpdated = pstmt.executeUpdate();//Query is getting executed here
		
		
		return numberOfRowsUpdated;
	}

	@Override
	public void printAllUsers() throws SQLException {
		String sql = "SELECT * FROM meetingroombookingsystem_db.user_tbl";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs=pstmt.executeQuery();

		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getDouble(5)+" "+rs.getInt(6));
		}
		

		
	}

    
}
