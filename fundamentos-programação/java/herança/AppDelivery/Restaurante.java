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

    ArrayList<ArrayList> imprimirCardapio() {
        ArrayList<ArrayList> lanches = new ArrayList<>();
        // ArrayList<String> lanches = new ArrayList<>();
        for (Lanche lanche : cardapio) {
            ArrayList<Object> arrayLanche = new ArrayList<>();
            arrayLanche.add(lanche.nome);
            arrayLanche.add(lanche.preço);
            lanches.add(arrayLanche);
        }
        return lanches;
    }

    public static void main(String[] args) {
        Restaurante restaurante1 = new Restaurante("McDonalds");

        Lanche lanche1 = new Lanche("Big Mac", 25);

        restaurante1.adicionarLanche(lanche1);

        System.out.println(restaurante1.imprimirCardapio());

        restaurante1.adicionarLanche(new Lanche("Big Tasty", 20));
        restaurante1.adicionarLanche(new Lanche("Coca Cola 1L", 15));
        // System.out.println(restaurante1.cardapio.get(0).nome);
        System.out.println(restaurante1.imprimirCardapio());
        // restaurante1.removerLanchePorIndex(0);
        restaurante1.removerLanche(lanche1);
        System.out.println(restaurante1.imprimirCardapio());
    }
}
