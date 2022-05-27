package src;

import java.util.ArrayList;
import src.view.*;

public class Restaurant {
  String name;
  ArrayList<Item> itemMenu = new ArrayList<Item>();

  public Restaurant(String name) {
    this.name = name;
  }

  public void addItem(Item item) { this.itemMenu.add(item); }
  public void removeItem(int itemIndex) { this.itemMenu.remove(itemIndex); }
  public void getItemMenu() {
    ArrayList<String> itemMenuNames = new ArrayList<>();
    for (Item item:itemMenu) {
      itemMenuNames.add(item.name);
    }
    System.out.println(itemMenuNames);
  }
}
