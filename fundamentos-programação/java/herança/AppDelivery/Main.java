package herança.AppDelivery;

public class Main {
    public static void main(String args[]) {
        System.out.println("--- MAIN PROGRAM ---");
        App app = new App();
        app.cadastrarRestaurante(new Restaurante("Mc Donald's"));
    }
}
