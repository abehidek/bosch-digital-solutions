package src.view;

import java.util.Scanner;
import src.*;

public class LoginMenu {
  public static void menu(App app, Scanner input) {
    // System.out.println(">> LoginMenu");
    boolean menu = true;

    while (menu) {
      if (app.isLogged) { menu = false; break; }
      System.out.println("\nWhat would you like to do?:\n 0 -> exit\n 1 -> login\n 2 -> Sign up");
      String userinput = input.nextLine();
      if (userinput.isEmpty()) { System.out.println("> Type something!"); continue; }
      char option = userinput.charAt(0);

      switch (option) {
        case '1':
          System.out.println("> Log in...");

          System.out.println("Type your name: ");
          String name = input.nextLine();
          System.out.println("Type your password: ");
          String password = input.nextLine();

          app.authUser(name, password);
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
          app.addUser(newName, newPassword, newAdmin);
          break;
        case '0':
          System.out.println("> Bye");
          menu = false;
          break;
        default:
          System.out.println("> An error ocurred");
          break;
        }
    }
  }
}
