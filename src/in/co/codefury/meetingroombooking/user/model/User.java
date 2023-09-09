package in.co.codefury.meetingroombooking.user.model;
/**
 * User
 */
public class User {

    private int id;//id can be auto incremented in next version
    private String name;
    private String email;
    private String password;
    private String phone;
    private double credits;
    private int role;//3-admin, 2-manager ,1-user higher the number higher the role
    
    public User(int id, String name, String email, String password, String phone, double credits, int role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.credits = credits;
        this.role = role;
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

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public int getRole() {
        return role;
    }

    //set role should be only available to admin
    //other users should not be able to change their role
    public void setRole(int role) {
        this.role = role;
    }




    
    
}