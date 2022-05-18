package herança.AppDelivery;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuário {
    String nome;
    String senha;
    String endereço;
    String CPF;
    ArrayList<Pedido> pedidos = new ArrayList<>();

    public Usuário(String nome, String senha, String endereço, String CPF) {
        this.nome = nome;
        this.senha = senha;
        this.endereço = endereço;
        this.CPF = CPF;
    }

    public void adicionarPedido(Scanner input, String nome, Restaurante restaurante) {
        pedidos.add(new Pedido(nome, restaurante));
        while (true) {
            System.out.println("Selecione o lanche: ");
            restaurante.imprimirCardapio();
            System.out.println("\nDeseja adicionar mais um lanche?: ");
            String op = input.nextLine().toUpperCase();
            if (op.startsWith("N"))
                break;
        }
    }

    void imprimirPedidos() {
        ArrayList<String> arr = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            arr.add(pedido.nome);
        }
        System.out.println(arr);
    }
}
