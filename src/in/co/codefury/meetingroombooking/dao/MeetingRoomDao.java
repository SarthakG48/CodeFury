package in.co.codefury.meetingroombooking.dao;

import java.sql.SQLException;

import in.co.codefury.meetingroombooking.model.MeetingRoom;
import in.co.codefury.meetingroombooking.model.User;

public interface MeetingRoomDao {
    public int save(User u) throws SQLException;
    public void printAllUsers() throws SQLException;
    public MeetingRoom createMeetingRoom(MeetingRoom m) throws SQLException;
    public MeetingRoom updateMeetingRoom(MeetingRoom m) throws SQLException;
    public void close() throws SQLException;
    public Meeting createMeeting(Meeting m);
    public Meeting updateMeeting(Meeting m);
}
