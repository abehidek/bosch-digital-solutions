package herança.fasterfood;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("> Init\n\n");
        Scanner input = new Scanner(System.in);

        App app = new App();

        LoginScreen login = new LoginScreen();
        login.authenticate(input, app.users);

        if (!login.auth) { return; }
        
        MenuScreen menu = new MenuScreen();
        menu.menu();
    }
}
