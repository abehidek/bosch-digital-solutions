package src.view;

import java.util.Scanner;
import src.*;

public class Menu {
  public static void menu(App app, Scanner input) {
    System.out.println(">> MainMenu");
    System.out.println("Hello "+app.getCurrentUser().getName());
    System.out.println("\nWhat would you like to do?: \n 0 -> logout\n 1 -> ?");
    char option = input.nextLine().charAt(0);

    switch (option) {
      case '0':
        System.out.println("> Logging out...");
        app.logoutUser();
        break;
      case '1':
        System.out.println("> One");
        break;
      default:
        src.Error.printError("> Something bad happened");
        break;
    }
  }
}
