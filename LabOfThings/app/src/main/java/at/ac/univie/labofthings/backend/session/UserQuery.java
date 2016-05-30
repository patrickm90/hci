package at.ac.univie.labofthings.backend.session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 13/05/2016.
 */

/**
 * Provides method to query users
 */
public class UserQuery {
    private final static User admin = new User("admin", "admin", User.UserType.Admin);
    private final static User lab = new User("lab", "lab", User.UserType.User);
    private final static User control = new User("control", "control", User.UserType.Monitor);

    /**
     * A list of users
     * @return a list of users
     */
    public static List<User> getUserList()
    {
        List<User> userList = new ArrayList<>();
        userList.add(admin);
        userList.add(lab);
        userList.add(control);

        return userList;
    }

    /**
     * login method
     * @param userName name of the user
     * @param password passwor dof the user
     * @return if logged in the user if failed returns null
     */
    public static User Login(String userName, String password)
    {
        for(User user : getUserList())
        {
            if(user.getUserName().equals(userName) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }
}
