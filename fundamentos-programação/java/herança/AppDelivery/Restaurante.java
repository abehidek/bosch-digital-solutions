package herança.AppDelivery;

import java.util.ArrayList;

public class Restaurante {
    String nome;
    ArrayList<Lanche> cardapio = new ArrayList<>();

    // Construtor
    public Restaurante(String nome) {
        this.nome = nome;
    }

    // Métodos
    void adicionarLanche(Lanche lanche) {
        this.cardapio.add(lanche);
        lanche.restaurante = this;
    }

    void removerLanchePorIndex(int index) {
        this.cardapio.remove(index);
    }

    void removerLanche(Lanche lanche) {
        this.cardapio.remove(lanche);
        lanche.restaurante = null;
    }

    void imprimirCardapio() {
        ArrayList<String> lanches = new ArrayList<>();
        for (Lanche lanche : cardapio) {
            lanches.add(lanche.nome);
        }
        System.out.println(lanches);
    }
}
