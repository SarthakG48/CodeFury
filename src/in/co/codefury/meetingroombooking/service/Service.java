package in.co.codefury.meetingroombooking.service;

import java.sql.SQLException;

import in.co.codefury.meetingroombooking.model.Meeting;
import in.co.codefury.meetingroombooking.model.MeetingRoom;
import in.co.codefury.meetingroombooking.model.User;

public interface Service {
    public void addUser(User u);//add exception user already exist
    public void printAllUsers();
    public MeetingRoom createMeetingRoom(User u,MeetingRoom m) throws SQLException ;//add exception user not authorized
    public MeetingRoom updateMeetingRoom(User u,MeetingRoom m) throws SQLException ;//add exception user not authorized
    public Meeting createMeeting(User u,Meeting m) throws SQLException ;//add exception user not authorized
}
