package herança.ex01;

public class Item {
    String nome;
    int quantidade;
    double preço;
    Compra compra;

    Item(String nome, int quantidade, double preço) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preço = preço;
    }
}
