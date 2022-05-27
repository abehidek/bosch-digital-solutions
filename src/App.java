package src;

import java.util.ArrayList;

public class App {
  private ArrayList<User> listUsers = new ArrayList<>();
  private User currentUser = new User();
  public boolean isLogged = false;
  public ArrayList<Restaurant> listRestaurants = new ArrayList<>();

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

  public void getRestaurants() {
    ArrayList<String> listRestaurantsName = new ArrayList<>();
    for (Restaurant restaurant:listRestaurants) {
      listRestaurantsName.add(restaurant.name);
    }
    System.out.println(listRestaurantsName);
  }

  public void addRestaurant(String name) {
    listRestaurants.add(new Restaurant(name));
  }
}
