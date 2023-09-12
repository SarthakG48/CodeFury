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
        return null;
    }

    @Override
    public List<Meeting> getAllMeetingForManager(Manager m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllMeetingForManager'");
    }

    @Override
    public MeetingRoom getMeetingRoomByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMeetingRoomByName'");
    }

    @Override
    public Meeting getMeetingById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMeetingById'");
    }

    @Override
    public List<Amenity> getAllAmenities() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAmenities'");
    }

    @Override
    public Amenity getAmenityByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAmenityByName'");
    }

    @Override
    public void addAmenityToMeeting(Amenity a, Meeting m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAmenityToMeeting'");
    }

    @Override
    public List<MeetingRoom> getAllMeetingRoom() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllMeetingRoom'");
    }

    @Override
    public User getUserById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }
}
