package in.co.codefury.meetingroombooking.service.impl;



import java.sql.SQLException;

import in.co.codefury.meetingroombooking.dao.MeetingRoomDao;
import in.co.codefury.meetingroombooking.service.Service;
import in.co.codefury.meetingroombooking.model.Admin;
import in.co.codefury.meetingroombooking.model.Meeting;
import in.co.codefury.meetingroombooking.model.MeetingRoom;
import in.co.codefury.meetingroombooking.model.User;
import in.co.codefury.meetingroombooking.model.Manager;

public class ServiceImpl implements Service {
    private MeetingRoomDao meetingRoomDao;

    public ServiceImpl(MeetingRoomDao meetingRoomDao) {
        this.meetingRoomDao = meetingRoomDao;
    }

    @Override
    public void addUser(User u) {
       
        try {
            this.meetingRoomDao.save(u);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printAllUsers() {
       try {
        this.meetingRoomDao.printAllUsers();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    @Override
    public MeetingRoom createMeetingRoom(User u,MeetingRoom m) throws SQLException {
       if(u instanceof Admin){
              
              return this.meetingRoomDao.createMeetingRoom(m);
         }
         else{
              System.out.println("You are not authorized to create a meeting room");
              return null;
       }
    }

     @Override
    public MeetingRoom updateMeetingRoom(User u,MeetingRoom m) throws SQLException {
       if(u instanceof Admin){
              
              return this.meetingRoomDao.updateMeetingRoom(m);
         }
         else{
              System.out.println("You are not authorized to create a meeting room");
              return null;
       }
    }

    @Override
    public Meeting createMeeting(User u,Meeting m){
        if(u instanceof Manager){
              
              return this.meetingRoomDao.createMeeting(m);
         }
         else{
              System.out.println("You are not authorized to create a meeting room");
              return null;
    }
    


}
