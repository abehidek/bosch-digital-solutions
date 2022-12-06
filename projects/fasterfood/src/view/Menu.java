package src.view;

import java.time.LocalDateTime;
import java.util.Scanner;
import src.*;

public class Menu {
  public static int getOrderIndex(App app, Scanner input) {
    int i = 0;
    for (Order order:app.getCurrentUser().getOrder()) {
      System.out.println("Index: "+i+" Name: "+ order.getName());
      i++;
    }
    System.out.println("Which order do you select? : ");
    String index = input.nextLine();
    return Integer.parseInt(index);
  }

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

  public static int getItemIndex(App app, Scanner input) {
    int i = 0;
    for (Item item:app.getCurrentRestaurant().itemMenu) {
      System.out.println("Index: "+i+" Name: "+ item.name);
      i++;
    }
    System.out.println("Which item do you select? : ");
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

      System.out.println("\nWhat would you like to do?:\n 0 -> exit\n 1 -> List item menu\n 2 -> Add item\n 3 -> Remove item");
      String userinput = input.nextLine();
      if (userinput.isEmpty()) { System.out.println("> Type something!"); continue; }
      char option = userinput.charAt(0);

      switch (option) {
        case '0':
          menu = false;
          break;
        case '1':
          System.out.println("> Listing Item menu...");
          app.getCurrentRestaurant().getItemMenu();
          break;
        case '2':
          System.out.println("> Adding new item to menu...");
          try {
            System.out.println("Type the name of the item: ");
            String itemName = input.nextLine();
            System.out.println("Type the price of the item "+itemName);
            double itemPrice = Double.parseDouble(input.nextLine());
            app.getCurrentRestaurant().addItem(new Item(itemName, itemPrice));
          } catch (Exception e) {
            System.out.println(e);
          } break;
        case '3':
          System.out.println("> Removing item from menu...");
          int index = getItemIndex(app, input);
          app.getCurrentRestaurant().removeItem(index);
          break;
      }
    }
  }
  
  public static void menu(App app, Scanner input) {
    // System.out.println(">> MainMenu");
    boolean menu = true;
    while (menu) {
      System.out.println("\n\n--------------------------------------\n\n");
      System.out.println("\nHello "+app.getCurrentUser().getName());
      System.out.println("\nWhat would you like to do?: \n 0 -> logout\n 1 -> List restaurants\n 2 -> Add restaurant\n 3 -> Remove restaurant\n 4 -> Restaurant options\n 5 -> List order\n 6 -> View order\n 7 -> Add order\n 8 -> Remove order");

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
        case '5':
          System.out.println("> Listing user orders...");
          app.getCurrentUser().listOrders();
          break;
        case '6':
          int SelectOrderIndex = getOrderIndex(app, input);
          app.getCurrentUser().getOrder().get(SelectOrderIndex).printOrder();
          break;
        case '7':
          System.out.println("> Adding new user order...");
          System.out.println("Type the name of your order: ");
          String orderName = input.nextLine();
          Order newOrder = new Order(orderName +" "+app.getCurrentUser().getName() + "'s order", LocalDateTime.now());

          int restaurantIndexOrder = getRestaurantIndex(app, input);
          app.getRestaurant(restaurantIndexOrder);
          System.out.println("You selected: "+ app.getCurrentRestaurant().name);

          while (true) {
            int index = getItemIndex(app, input);
            
            System.out.println("How many items?: ");
            int itemQuantity = Integer.parseInt(input.nextLine());
            for (int c = 0; c < itemQuantity; c++) {
              newOrder.addItem(app.getCurrentRestaurant().itemMenu.get(index));
            }
            
            System.out.println("Do you want to add more items? [Y/N]: ");
            String more = input.nextLine();
            if (more.equalsIgnoreCase("N")) break;
          }

          newOrder.printOrder();
          System.out.println("\nAre you sure you want to create this order? [Y/N]: ");
          if (input.nextLine().equalsIgnoreCase("Y")) { app.getCurrentUser().addOrder(newOrder); System.out.println("Order created successfully"); }
          else System.out.println("Cancelling this order...");
          break;
        case '8':
          System.out.println("> Removing user order...");
          int orderIndex = getOrderIndex(app, input);
          app.getCurrentUser().removeOrder(orderIndex);
          break;
        default:
          src.Error.printError("> Something bad happened");
          break;
      }
    }
  }
}
