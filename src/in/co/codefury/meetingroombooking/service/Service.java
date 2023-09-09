package in.co.codefury.meetingroombooking.service;

import in.co.codefury.meetingroombooking.user.model.User;

public interface Service {
    public void addUser(User u);//add exception user already exist
    public void printAllUsers();
}
