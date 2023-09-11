package in.co.codefury.meetingroombooking.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import in.co.codefury.meetingroombooking.model.Meeting;
import in.co.codefury.meetingroombooking.model.MeetingRoom;
import in.co.codefury.meetingroombooking.model.User;


public interface MeetingRoomDao {
    public MeetingRoom createMeetingRoom(MeetingRoom m) throws SQLException;
    public MeetingRoom updateMeetingRoom(MeetingRoom m) throws SQLException;
    public void close() throws SQLException, IOException;
    public Meeting createMeeting(Meeting m);
    public Meeting updateMeeting(Meeting m);
    public List<MeetingRoom> getAllMeetingRooms();
    public List<Meeting> getAllMeetings();
    public User getUserById(int id);
    public MeetingRoom getMeetingRoomByName(String name);
}
