package in.co.codefury.meetingroombooking;

import java.sql.SQLException;

import in.co.codefury.meetingroombooking.user.model.User;

public interface MeetingRoomDao {
    public int save(User u) throws SQLException;
    public void printAllUsers() throws SQLException;
}
