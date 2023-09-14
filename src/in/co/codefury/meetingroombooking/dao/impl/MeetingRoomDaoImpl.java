package in.co.codefury.meetingroombooking.dao.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.swing.event.SwingPropertyChangeSupport;

import in.co.codefury.meetingroombooking.dao.MeetingRoomDao;
import in.co.codefury.meetingroombooking.model.Amenity;
import in.co.codefury.meetingroombooking.model.Manager;
import in.co.codefury.meetingroombooking.model.Meeting;
import in.co.codefury.meetingroombooking.model.MeetingRoom;
import in.co.codefury.meetingroombooking.model.User;

public class MeetingRoomDaoImpl implements MeetingRoomDao, AutoCloseable {

	private Connection con;
	private PreparedStatement pstmt;
	private FileReader reader;
	private Properties p;
	

	public MeetingRoomDaoImpl() throws ClassNotFoundException, SQLException {

		init();
		try {
			reader = new FileReader("/Users/sarthakgokhale/Desktop/CodeFury/CodeFury/src/resources/application.properties");
			p = new Properties();
			p.load(reader);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * this is helper method hence it is private
	 * initializing connection object
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void init() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/meetingroombooking_db", "root",
				"adminadmin");// change username and password here

	}

	/**
	 * this is helper method hence it is private
	 * closing connection object
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */

	@Override
	public void close() throws SQLException, IOException {
		con.close();
		reader.close();
	}

	



	@Override
	public MeetingRoom createMeetingRoom(MeetingRoom m)throws SQLException {
		String query = p.getProperty("sql.createMeetingRoom");
		pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();

		pstmt.setString(1, m.getName());
		pstmt.setInt(2, m.getCapacity());
		pstmt.setDouble(3, m.getCreditsPerHour());
		pstmt.setDouble(4, m.getRatings());
		pstmt.setDouble(5, m.getPerHourCost());
		int numberOfRows=pstmt.executeUpdate();
		if(numberOfRows>0) {
			return m;
		}

		return null;
	}

	@Override
	public MeetingRoom updateMeetingRoom(MeetingRoom m)throws SQLException {
		String query = p.getProperty("sql.updateMeetingRoom");
		pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();

		pstmt.setString(1, m.getName());
		pstmt.setInt(2, m.getCapacity());
		pstmt.setDouble(3, m.getCreditsPerHour());
		pstmt.setDouble(4, m.getRatings());
		pstmt.setDouble(5, m.getPerHourCost());
		int numberOfRows=pstmt.executeUpdate();
		if(numberOfRows>0) {
			return m;
		}

		return null;
	}

	@Override
	public Meeting createMeeting(Meeting m,int userId,int type)throws SQLException {
		String query = p.getProperty("sql.createMeeting");
		pstmt = con.prepareStatement(query);
		
		pstmt.setInt(1, m.getId());
		pstmt.setString(2, m.getTitle());
		pstmt.setInt(3, userId);
		pstmt.setDate(4, m.getMeetingDate());
		pstmt.setTime(5, m.getStartTime());
		pstmt.setTime(6, m.getEndTime());
		pstmt.setString(7, m.getMeetingRoom().getName());
		pstmt.setInt(8, type);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			Meeting meet=new Meeting(rs.getInt(1), rs.getString(2), getUserById(rs.getInt(3)), rs.getDate(4), rs.getTime(5), rs.getTime(6), null, getMeetingRoomByName(rs.getString(7)));
			return meet;
		}

		return null;
	}

	@Override
	public Meeting updateMeeting(Meeting m,int type) throws SQLException{
		String query = p.getProperty("sql.updateMeeting");
		pstmt = con.prepareStatement(query);
		
		
		pstmt.setString(2, m.getTitle());
		pstmt.setDate(4, m.getMeetingDate());
		pstmt.setTime(5, m.getStartTime());
		pstmt.setTime(6, m.getEndTime());
		pstmt.setString(7, m.getMeetingRoom().getName());
		pstmt.setInt(8, type);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			Meeting meet=new Meeting(rs.getInt(1), rs.getString(2), getUserById(rs.getInt(3)), rs.getDate(4), rs.getTime(5), rs.getTime(6), null, getMeetingRoomByName(rs.getString(7)));
			return meet;
		}

		return null;
	}

	public List<MeetingRoom> getAllMeetingRooms() {

		
		try {
			
			String query = p.getProperty("sql.selectAllMeetingRooms");
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			List<MeetingRoom>meetingRooms=new ArrayList<MeetingRoom>();

			while (rs.next()) {
				MeetingRoom m=new MeetingRoom(rs.getString(1), rs.getInt(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5));
				meetingRooms.add(m);
			}
			return meetingRooms;
		}catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}
	@Override
	public List<Meeting> getAllMeetings() {
		
		try {
			
			String query = p.getProperty("sql.selectAllMeetings");
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			List<Meeting>meetings=new ArrayList<Meeting>();
			while (rs.next()) {
				//cannot use join as foreign key is meeting room name
				User u=getUserById(rs.getInt(3));

				//join can be used here
				MeetingRoom room=getMeetingRoomByName(rs.getString(7));
				Set<User> participants=new HashSet<User>();
				
				Meeting m=new Meeting(rs.getInt(1), rs.getString(2), u, rs.getDate(4), rs.getTime(5), rs.getTime(6),participants, room);
				meetings.add(m);
			}
			return meetings;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserById(int id){
		try {
			String query = p.getProperty("sql.selectUserById");
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				User u=new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				return u;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MeetingRoom getMeetingRoomByName(String name) {
		try {
			String query = p.getProperty("sql.selectMeetingRoomyByName");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				MeetingRoom m=new MeetingRoom(rs.getString(1), rs.getInt(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5));
				return m;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Meeting> getAllMeetingsForUser(User u)throws SQLException {
		String query = p.getProperty("sql.selectAllMeetingsForParticipant");
		pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		List<Meeting>meetings=new ArrayList<Meeting>();
		while (rs.next()) {
			Meeting m=getMeetingById(rs.getInt(1));
			meetings.add(m);
		}
		return meetings;
	}

	@Override
	public List<Meeting> getAllMeetingsForManager(Manager m) throws SQLException{
		
		String query = p.getProperty("sql.selectMeetingsForManager");
		pstmt = con.prepareStatement(query);

		ResultSet rs = pstmt.executeQuery();
		
		List<Meeting>meetings=new ArrayList<Meeting>();
		while (rs.next()) {
			Meeting meet=getMeetingById(rs.getInt(1));
			meetings.add(meet);
		}
		return meetings;
	}

	@Override
	public Meeting getMeetingById(int id) throws SQLException {
		try {
			String query = p.getProperty("sql.selectMeetingById");
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Meeting m=new Meeting(rs.getInt(1), rs.getString(2), getUserById(rs.getInt(3)), rs.getDate(4), rs.getTime(5), rs.getTime(6), null, getMeetingRoomByName(rs.getString(7)));
				return m;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<Amenity> getAllAmenities() throws SQLException{
		String query = p.getProperty("sql.selectAllAmenities");
		pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		List<Amenity>amenities=new ArrayList<Amenity>();
		while (rs.next()) {
			Amenity a=new Amenity(rs.getString(1), rs.getDouble(2));
			amenities.add(a);
		}
		return amenities;
	}

	@Override
	public Amenity getAmenityByName(String name) throws SQLException{
		String query = p.getProperty("sql.selectAmenityByName");
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			Amenity a=new Amenity(rs.getString(1), rs.getDouble(2));
			return a;
		}
		return null;
	}
		
	
	//reduce manager's credit here only
	@Override
	public void addAmenityToMeeting(Amenity a, Meeting m) throws SQLException{
		
		String query = p.getProperty("sql.addAmenityToMeeting");
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, a.getName());
		pstmt.setDouble(2, a.getCreditsRequiredToAdd());
		int rowsAffected=pstmt.executeUpdate();
		if(rowsAffected>0) {
			System.out.println("Amenity added");
			//reduce manager's credit here only
			//reduceManagerCredits(m.getMeetingRoom().getPerHourCost());
		}
		else {
			System.out.println("Insufficient credits");//throw exception here
		}


	}



}
