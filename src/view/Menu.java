package src.view;

import java.util.ArrayList;
import java.util.Scanner;
import src.*;

public class Menu {
  public static int getRestaurantIndex(App app, Scanner input) {
    int i = 0;
    for (Restaurant restaurant:app.listRestaurants) {
      System.out.println("Index: "+i+" Name: "+ restaurant.getName());
      i++;
    }
    System.out.println("Which restaurant do you select? : ");
    String index = input.nextLine();
    return Integer.parseInt(index);
  }

  public static void restaurantMenu(App app, Scanner input) {
    boolean menu = true;
    int restaurantIndex = getRestaurantIndex(app, input);
    app.getRestaurant(restaurantIndex);
    // Restaurant restaurant = app.getRestaurant(restaurantIndex); // Be sure to know if this is a copy by reference or value
    
    while (menu) {
      // System.out.println("> Welcome to restaurant "+ restaurant.getName() +" options!");
      System.out.println("> Welcome to restaurant "+ app.getCurrentRestaurant().getName() +" options!");

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
    boolean menu = true;
    while (menu) {
      System.out.println("\nHello "+app.getCurrentUser().getName());
      System.out.println("\nWhat would you like to do?: \n 0 -> logout\n 1 -> List restaurants\n 2 -> Add restaurant\n 3 -> Remove restaurant\n 4 -> Restaurant options");

      String userinput = input.nextLine();
      if (userinput.isEmpty()) { System.out.println("> Type something!"); continue; }
      char option = userinput.charAt(0);

      switch (option) {
        case '0':
          System.out.println("> Logging out...");
          app.logoutUser();
          menu = false;
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
          int restaurantIndex = getRestaurantIndex(app, input);
          app.removeRestaurant(restaurantIndex);
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
}
