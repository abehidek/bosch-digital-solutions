package src.view;

import java.util.Scanner;
import src.*;

public class Menu {
  public static void restaurantMenu(App app, Scanner input) {
    boolean menu = true;
    while (menu) {
      System.out.println("> Welcome to restaurant x options!");
      // menu = false;

      System.out.println("\nWhat would you like to do?:\n 0 -> exit\n 1 -> Option 1");
      String userinput = input.nextLine();
      if (userinput.isEmpty()) { System.out.println("> Type something!"); continue; }
      char option = userinput.charAt(0);

      switch (option) {
        case '0':
          menu = false;
          break;
        case '1':
          System.out.println("> Option 1");
          break;
      }
    }
  }
  public static void menu(App app, Scanner input) {
    // System.out.println(">> MainMenu");
    System.out.println("\nHello "+app.getCurrentUser().getName());
    System.out.println("\nWhat would you like to do?: \n 0 -> logout\n 1 -> List restaurants\n 2 -> Add restaurant\n 3 -> Remove restaurant\n 4 -> Restaurant options");
    char option = input.nextLine().charAt(0);

    switch (option) {
      case '0':
        System.out.println("> Logging out...");
        app.logoutUser();
        break;
      case '1':
        System.out.println("> Listing restaurants...");
        app.getRestaurants();
        break;
      case '2':
        System.out.println("> Adding restaurant...");
        System.out.println("Type the name of the restaurant: ");
        String restaurantName = input.nextLine();
        app.addRestaurant(restaurantName);
        break;
      case '3':
        System.out.println("> Removing restaurant...");
        break;
      case '4':
        System.out.println("> Entering restaurant options...");
        restaurantMenu(app, input);
        break;
      default:
        src.Error.printError("> Something bad happened");
        break;
    }
  }
}
