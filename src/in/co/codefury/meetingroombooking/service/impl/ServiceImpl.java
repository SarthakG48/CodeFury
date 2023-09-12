package in.co.codefury.meetingroombooking.service.impl;

import java.sql.SQLException;
import java.util.List;

import in.co.codefury.meetingroombooking.dao.MeetingRoomDao;
import in.co.codefury.meetingroombooking.service.Service;
import in.co.codefury.meetingroombooking.service.exception.AccessDenied;
import in.co.codefury.meetingroombooking.model.Admin;
import in.co.codefury.meetingroombooking.model.Amenity;
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

       
    }

    @Override
    public void printAllUsers() {
        
    }

    @Override
    public MeetingRoom createMeetingRoom(User u, MeetingRoom m) throws SQLException, AccessDenied {
        if (u instanceof Admin) {
            return meetingRoomDao.createMeetingRoom(m);
        } else {
            throw new AccessDenied("Access Denied. This action is only allowed for Admins.");
        }
    }

    @Override
    public MeetingRoom updateMeetingRoom(User u, MeetingRoom m) throws SQLException, AccessDenied {
        if (u instanceof Admin) {

            return meetingRoomDao.updateMeetingRoom(m);
        } else {
            throw new AccessDenied("Access Denied. This action is only allowed for Admins.");
        }
    }

    @Override
    public Meeting createMeeting(User u, Meeting m) throws AccessDenied {
        if (u instanceof Manager) {
            return meetingRoomDao.createMeeting(m);
        } else {
            throw new AccessDenied("Access Denied. This action is only allowed for Managers.");
        }

    }

	@Override
	public void addManager(Manager m) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addManager'");
	}

	@Override
	public void addAdmin(Admin a) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addAdmin'");
	}

    @Override
    public List<Meeting> getAllMeetingsForUser(User u) {
        return meetingRoomDao.getAllMeetingsForUser(u);
    }

    @Override
    public List<Meeting> getAllMeetingForManager(Manager m) {
        return meetingRoomDao.getAllMeetingsForManager(m);
    }

    @Override
    public MeetingRoom getMeetingRoomByName(String name) {
        return meetingRoomDao.getMeetingRoomByName(name);
    }

    @Override
    public Meeting getMeetingById(int id) {
        return meetingRoomDao.getMeetingById(id);    
    }

    @Override
    public List<Amenity> getAllAmenities() {
        return meetingRoomDao.getAllAmenities();
    }

    @Override
    public Amenity getAmenityByName(String name) {
        return meetingRoomDao.getAmenityByName(name);
    }

    @Override
    public void addAmenityToMeeting(Amenity a, Meeting m) {
        meetingRoomDao.addAmenityToMeeting(a, m);
    }

    @Override
    public List<MeetingRoom> getAllMeetingRoom() {
        return meetingRoomDao.getAllMeetingRooms();
    }

    @Override
    public User getUserById(int id) {
        return meetingRoomDao.getUserById(id);
    }
}
