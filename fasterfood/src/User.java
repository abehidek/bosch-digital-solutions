package src;

import java.util.ArrayList;

public class User {
    private String name;
    private String password;
    private boolean isAdmin;
    private ArrayList<Order> orders = new ArrayList<Order>();

    public User(String name, String password, boolean isAdmin) {
      this.setName(name);
      this.password = password;
      this.isAdmin = isAdmin;
    }

    public User() {
      this.setName("");
      this.password = "";
      this.isAdmin = false;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPassword() { return password; }
    public boolean getIsAdmin() { return isAdmin; }
    
    public void listOrders() {
      System.out.println("--- ORDERS ---");
      for (Order order:orders) {
        System.out.println("Date: " + order.getCreatedDateTime() + " | Name: " + order.getName());
      }
    }
    public void addOrder(Order order) { this.orders.add(order); }
    public void removeOrder(int orderIndex) { this.orders.remove(orderIndex); }
    public ArrayList<Order> getOrder() { return this.orders; }
}
