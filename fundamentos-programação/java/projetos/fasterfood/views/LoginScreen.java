package projetos.fasterfood.views;

import java.util.ArrayList;
import java.util.Scanner;

import projetos.fasterfood.*;

public class LoginScreen {
    public boolean auth;
    public boolean admin;

    public LoginScreen() {
        this.auth = false;
    }

    public void menu(Scanner input, App app) {
        System.out.println("Welcome to menu");
        boolean screen = true;

        while (screen) {
            System.out.println("\nWhat would you like to do?: \n 1 -> login\n 2 -> Sign up\n 9 -> exit");
            char option = input.nextLine().charAt(0);

            switch (option) {
                case '1':
                    System.out.println("> Log in...");

                    System.out.println("Type your name: ");
                    String name = input.nextLine();

                    System.out.println("Type your password: ");
                    String password = input.nextLine();
                     
                    User user = app.authenticateUser(new User(name, password));
                    this.auth = user.authenticated;
                    screen = !this.auth; if (screen) System.out.println("Incorrect user or pass");
                    app.currentUser = user;
                    break;
                case '2':
                    System.out.println("> Sign up...");
                    
                    System.out.println("Type your name: ");
                    String newName = input.nextLine();

                    System.out.println("Type your password: ");
                    String newPassword = input.nextLine();

                    System.out.println("Is your user admin: [Y/N] ");
                    String isAdmin = input.nextLine();
                    boolean newAdmin = false;
                    if (isAdmin.equals("Y")) { newAdmin = true; }

                    app.addUser(new User(newName, newPassword, newAdmin));
                    break;
                case '9':
                    System.out.println("> Bye");
                    screen = false;
                    break;
                default:
                    System.out.println("> An error ocurred");
                    break;
            }
        }
    }
}
