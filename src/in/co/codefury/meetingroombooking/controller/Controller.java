package in.co.codefury.meetingroombooking.controller;

import java.sql.SQLException;

import in.co.codefury.meetingroombooking.service.Service;
import in.co.codefury.meetingroombooking.service.impl.ServiceImpl;
import in.co.codefury.meetingroombooking.model.User;
import in.co.codefury.meetingroombooking.dao.impl.MeetingRoomDaoImpl;

public class Controller {
    public static void main(String[] args) {
       try {
        Service service = new ServiceImpl(new MeetingRoomDaoImpl());
        // service.addUser(new User(1, "sarthak", "sarthakgokhale15@gmail.com","root","9172814197", 100, 3));

        service.printAllUsers();



    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
       
    }
}
