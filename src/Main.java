package src;

import src.view.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("> Init");
        App app = new App();

        app.addUser("Abe", "123");
        app.addUser("Abe", "1235");

        LoginMenu.menu(app);
    }
}
