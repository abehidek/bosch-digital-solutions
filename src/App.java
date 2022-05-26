package src;

import java.util.ArrayList;

public class App {
    private ArrayList<User> listUsers = new ArrayList<>();
    private User currentUser = new User();

    public void addUser(String name, String password) {
        for (User user:listUsers) {
            if (user.getName().equals(name)) { Error.printError("> User already taken"); return; }
        }

        listUsers.add(new User(name, password, false));
        System.out.println("> Lista de usuarios: "+listUsers);
    }
}
