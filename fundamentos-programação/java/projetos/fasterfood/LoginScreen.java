package projetos.fasterfood;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginScreen {
    boolean auth;

    public LoginScreen() {
        this.auth = false;
    }

    public void authenticate(Scanner input, ArrayList<User> users) {
        System.out.println("Welcome");
        boolean screen = true;
        while (screen) {
            System.out.println("\nWhat would you like to do?: \n 1 -> login\n 2 -> Sign up\n 9 -> exit");
            char option = input.nextLine().charAt(0);

            switch (option) {
                case '1':
                    System.out.println("> Log in...");
                    this.auth = true;
                    screen = false;
                    break;
                case '2':
                    System.out.println("> Sign up...");
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
