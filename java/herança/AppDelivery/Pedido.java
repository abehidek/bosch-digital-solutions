package herança.AppDelivery;

import java.util.ArrayList;

public class Pedido {
    String nome;
    Restaurante restaurante;
    ArrayList<Lanche> items = new ArrayList<>();

    public Pedido(String nome, Restaurante restaurante) {
        this.nome = nome;
        this.restaurante = restaurante;
    }

    public void adicionarItem() {
        System.out.println(restaurante.cardapio);
    }
}
