package herança.AppDelivery;

import java.util.ArrayList;

public class App {
    ArrayList<Restaurante> restaurantes = new ArrayList<>();

    public void cadastrarRestaurante(Restaurante restaurante) {
        System.out.println("Cadastrando restaurante...");
        this.restaurantes.add(restaurante);
    }
}
