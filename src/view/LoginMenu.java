package src.view;

import src.*;

public class LoginMenu {
  public static void menu(App app) {
    System.out.println("> LoginMenu");
    app.addUser("Miura", "123");
  }
}
