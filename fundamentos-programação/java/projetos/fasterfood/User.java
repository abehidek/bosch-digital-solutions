package projetos.fasterfood;

public class User {
    public String name;
    public String password;
    public boolean admin;
    public boolean authenticated;
    
    public User(String name, String password, boolean admin) {
        this.name = name;
        this.password = password;
        this.admin = admin;
        this.authenticated = false;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.admin = false;
        this.authenticated = false;
    }

    public User() {
        this.name = "empty";
        this.password = "empty";
        this.admin = false;
        this.authenticated = false;
    }
}
