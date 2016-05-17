package at.ac.univie.labofthings.backend.session;

/**
 * Created by Patrick on 13/05/2016.
 */
enum UserType
{
    Lab,
    Control,
    Admin
}
public class User {
    private String userName;
    private String password;
    private UserType userType;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public User(String userName, String password, UserType userType)
    {
        this.userName = userName;
        this.password = password;
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }
    
}
