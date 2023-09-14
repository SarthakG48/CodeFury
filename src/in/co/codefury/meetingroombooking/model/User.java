package in.co.codefury.meetingroombooking.model;

import java.util.Date;

import com.google.gson.Gson;

/**
 * User
 */
public class User {

    protected int id;//id can be auto incremented in next version
    protected String name;
    protected String email;
    protected String password;
    protected String phone;
    protected Date lastLoggin;
    
    public Date getLastLoggin() {
        return lastLoggin;
    }

    public void setLastLoggin(Date lastLoggin) {
        this.lastLoggin = lastLoggin;
    }

    public User(int id, String name, String email, String password, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        lastLoggin = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   
    public String getDataOfUser(){
        Gson gson=new Gson();
        return gson.toJson(this);
        
        //return "name: "+name+" email: "+email+" lastLoggedIn: "+lastLoggin;
    }

}