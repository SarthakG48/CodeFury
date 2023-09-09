package in.co.codefury.meetingroombooking.service.impl;

import java.sql.SQLException;

import in.co.codefury.meetingroombooking.MeetingRoomDao;
import in.co.codefury.meetingroombooking.service.Service;
import in.co.codefury.meetingroombooking.user.model.User;

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
    


}
