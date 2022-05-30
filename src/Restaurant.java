package src;

import java.util.ArrayList;
import src.view.*;

public class Restaurant {
  public String name;
  public ArrayList<Item> itemMenu = new ArrayList<Item>();

  public Restaurant(String name) {
    this.name = name;
  }

  public String getName() { return name; }

  public void addItem(Item item) { this.itemMenu.add(item); }
  public void removeItem(int itemIndex) { this.itemMenu.remove(itemIndex); }
  public void getItemMenu() {
    ArrayList<String> itemMenuNames = new ArrayList<>();
    System.out.println("--- MENU ---");
    for (Item item:itemMenu) {
      itemMenuNames.add(item.name);
      System.out.println("Price: " + item.price + " | Name: " + item.name);
    }
    // System.out.println(itemMenuNames);
  }
}
