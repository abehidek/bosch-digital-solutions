package src;

import src.view.*;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("> Init");
    App app = new App();
    // Init setup just for testing purposes
    app.addUser("abe", "123", true);
    app.addUser("test", "123", true);
    app.addRestaurant("mcdonalds");
    app.addRestaurant("burgerking");

    Scanner input = new Scanner(System.in);
    while (true) {
      LoginMenu.menu(app, input);
      if (app.isLogged) { Menu.menu(app, input); }
      else { break; }
    }
  }
}
