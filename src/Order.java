package src;

import src.view.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
  private String name;
  private ArrayList<Item> listItems = new ArrayList<Item>();
  private LocalDateTime createdDateTime;
  private double total;

  public Order(String name, LocalDateTime createdDateTime) {
    this.setName(name);
    this.setCreatedDateTime(createdDateTime);
  }

  public String getCreatedDateTime() { DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"); return createdDateTime.format(format); }
  public void setCreatedDateTime(LocalDateTime createdDateTime) { this.createdDateTime = createdDateTime; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public void addItem(Item item) { this.listItems.add(item); calculateTotal(); }
  public void removeItem(int itemIndex) { this.listItems.remove(itemIndex); calculateTotal(); }
  public void getListItems() { System.out.println(listItems); }

  public void printOrder() {
    System.out.println("\n--- "+ this.name + ": ---\n Date: "+ getCreatedDateTime());
    for (Item item:listItems) {
      System.out.println(" Price: " + item.price + " | Name: " + item.name);
    }
    System.out.println(" Total: "+this.total);
  }

  public void calculateTotal() {
    double sum = 0;
    for (Item item:listItems) {
      sum += item.price;
    }
    this.total = sum;
  }
}
