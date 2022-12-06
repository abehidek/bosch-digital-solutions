package src;

import java.util.ArrayList;

public class App {
  private ArrayList<User> listUsers = new ArrayList<>();
  private User currentUser = new User();
  public boolean isLogged = false;
  public ArrayList<Restaurant> listRestaurants = new ArrayList<>();
  private Restaurant currentRestaurant;

  public void addUser(String name, String password, boolean isAdmin) {
    for (User user:listUsers) {
        if (user.getName().equals(name)) { Error.printError("> User already taken"); return; }
    }

    listUsers.add(new User(name, password, isAdmin));
    System.out.println("> User list: "+listUsers);
  }

  public void authUser(String name, String password) {
    if (listUsers.size() == 0) { Error.printError("> No user created"); }
    for (User user:listUsers) {
      if (user.getName().equals(name) && user.getPassword().equals(password)) { 
        currentUser = user;
        isLogged = true;
        System.out.println("> Authenticated!");
        System.out.println("> Current user: "+currentUser.getName());
      }
      else { Error.printError("> User or password incorrect"); }
    }
  }

  public void logoutUser() {
    isLogged = false;
    currentUser = new User();
  }

  public User getCurrentUser() { return currentUser; }

  public Restaurant getCurrentRestaurant() { return currentRestaurant; }

  public void getRestaurant(int restaurantIndex) {
    currentRestaurant = listRestaurants.get(restaurantIndex);
    // return listRestaurants.get(restaurantIndex);
  }

  public void getRestaurants() {
    ArrayList<String> listRestaurantsName = new ArrayList<>();
    for (Restaurant restaurant:listRestaurants) {
      listRestaurantsName.add(restaurant.name);
    }
    System.out.println(listRestaurantsName);
  }

  public void addRestaurant(String name) { listRestaurants.add(new Restaurant(name)); }

  // Just for testing
  public void addRestaurant(String name, boolean testing) {
    Restaurant test = new Restaurant(name);
    test.addItem(new Item("Big Mac", 30.5));
    test.addItem(new Item("Big Tasty", 20));
    test.addItem(new Item("Mc Lanche Feliz", 15));
    listRestaurants.add(test); 
  }

  public void removeRestaurant(int restaurantIndex) {
    if (restaurantIndex < 0 || restaurantIndex > listRestaurants.size()) { Error.printError("> Invalid index"); return; }
    listRestaurants.remove(restaurantIndex); 
  }
}
