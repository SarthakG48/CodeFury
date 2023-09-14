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
    public MeetingRoom createMeetingRoom(MeetingRoom m) throws SQLException;//done
    public MeetingRoom updateMeetingRoom(MeetingRoom m) throws SQLException;//done
    public void close() throws SQLException, IOException;//done
    public Meeting createMeeting(Meeting m,int userId,int type)throws SQLException;//done
    public Meeting updateMeeting(Meeting m,int type)throws SQLException;//done
    public List<MeetingRoom> getAllMeetingRooms();//done
    public List<Meeting> getAllMeetingsForUser(User u)throws SQLException;//done
    public List<Meeting> getAllMeetingsForManager(Manager m) throws SQLException;//done
    public List<Meeting> getAllMeetings();//done
    public Meeting getMeetingById(int id) throws SQLException ;//done
    public User getUserById(int id);//done
    public MeetingRoom getMeetingRoomByName(String name);//done
    public List<Amenity> getAllAmenities() throws SQLException;
    public Amenity getAmenityByName(String name) throws SQLException;//done
    public void addAmenityToMeeting(Amenity a, Meeting m) throws SQLException;//partially done

}
