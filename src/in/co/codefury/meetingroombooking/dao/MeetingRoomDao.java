package in.co.codefury.meetingroombooking.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import in.co.codefury.meetingroombooking.model.Amenity;
import in.co.codefury.meetingroombooking.model.Manager;
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
    public List<Meeting> getAllMeetingsForUser(User u);
    public List<Meeting> getAllMeetingsForManager(Manager m);
    public List<Meeting> getAllMeetings();
    public Meeting getMeetingById(int id);
    public User getUserById(int id);
    public MeetingRoom getMeetingRoomByName(String name);
    public List<Amenity> getAllAmenities();
    public Amenity getAmenityByName(String name);
    public void addAmenityToMeeting(Amenity a, Meeting m);

}
