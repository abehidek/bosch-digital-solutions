package herança.ex01;

public class Main {
    public static void main(String[] args) {
        Compra compra1 = new Compra();
        compra1.cliente = "João Pedro";
        compra1.adicionarItem(new Item("Notebook", 1, 5000));
        compra1.adicionarItem(new Item("Iphone", 2, 6000));
        compra1.adicionarItem(new Item("Amazon Echo", 2, 12000));
        System.out.println(compra1.itens.size());
        System.out.println(compra1.obterValorTotal());
    }
}