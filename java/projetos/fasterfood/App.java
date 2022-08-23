package projetos.fasterfood;
import projetos.fasterfood.views.*;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    // ArrayList<> restaurants = new ArrayList<>();
    public ArrayList<User> users = new ArrayList<>(); // List of users
    public User currentUser;

    public void addUser(User user) {
        users.add(user);
    }

    public User authenticateUser(User user) {
        for (User dbuser : users) {
            System.out.println("> "+dbuser.name);
            if (dbuser.name.equals(user.name) && dbuser.password.equals(user.password))
                dbuser.authenticated = true;
                return dbuser;
        }
        return user;
    }
}
