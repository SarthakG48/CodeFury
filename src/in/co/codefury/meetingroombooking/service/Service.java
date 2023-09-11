package in.co.codefury.meetingroombooking.service;

import java.sql.SQLException;
import java.util.List;

import in.co.codefury.meetingroombooking.service.exception.AccessDenied;
import in.co.codefury.meetingroombooking.model.Admin;
import in.co.codefury.meetingroombooking.model.Amenity;
import in.co.codefury.meetingroombooking.model.Manager;
import in.co.codefury.meetingroombooking.model.Meeting;
import in.co.codefury.meetingroombooking.model.MeetingRoom;
import in.co.codefury.meetingroombooking.model.User;

public interface Service {
    public void addUser(User u);//add exception user already exist
    public void addManager(Manager m);
    public void addAdmin(Admin a);
    public void printAllUsers();
    public List<Meeting> getAllMeetingsForUser(User u);
    public List<Meeting> getAllMeetingForManager(Manager m);
    public MeetingRoom getMeetingRoomByName(String name);
    public Meeting getMeetingById(int id);
    public List<Amenity> getAllAmenities();
    public Amenity getAmenityByName(String name);
    public MeetingRoom createMeetingRoom(User u,MeetingRoom m) throws SQLException,AccessDenied;//add exception user not authorized
    public MeetingRoom updateMeetingRoom(User u,MeetingRoom m) throws SQLException ,AccessDenied;//add exception user not authorized
    public Meeting createMeeting(User u, Meeting m) throws AccessDenied ;//add exception user not authorized
    public void addAmenityToMeeting(Amenity a, Meeting m);
}
