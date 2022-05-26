package src;

public class User {
    private String name;
    private String password;
    private boolean isAdmin;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
