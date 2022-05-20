package projetos.fasterfood;
import projetos.fasterfood.views.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("> Init\n\n");
        Scanner input = new Scanner(System.in);

        App app = new App();
        boolean program = true;

        while (program) {
            LoginScreen login = new LoginScreen();
            login.menu(input, app);
            if (login.auth) { 
                MenuScreen menu = new MenuScreen();
                boolean menuLogOut = menu.menu(input, app);
                if (menuLogOut) {
                    app.currentUser = new User();
                    program = menuLogOut;
                }
            }
        }
    }
}
