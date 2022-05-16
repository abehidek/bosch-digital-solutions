package herança.AppDelivery;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    ArrayList<Restaurante> restaurantes = new ArrayList<>();
    ArrayList<Usuário> usuários = new ArrayList<>();

    public int selecionarRestaurante(Scanner input) {
        if (restaurantes.isEmpty()) {
            System.out.println("Você nao tem restaurantes");
            return -1;
        }
        System.out.println("Selecione o restaurante: ");
        System.out.println(this.imprimirRestaurantes());
        int restauranteIndex = Integer.parseInt(input.nextLine());
        return restauranteIndex;
    }

    public void cadastrarRestaurante(Restaurante restaurante) {
        System.out.println("Tentando cadastrar restaurante...");
        this.restaurantes.add(restaurante);
    }

    public void removerRestaurante(Scanner input) {
        System.out.println("Tentando remover restaurante...");
        int restauranteIndex = this.selecionarRestaurante(input);
        if (restauranteIndex != -1)
            this.restaurantes.remove(restauranteIndex);
    }

    public ArrayList<String> imprimirRestaurantes() {
        ArrayList<String> arr = new ArrayList<>();
        for (Restaurante restaurante : restaurantes) {
            arr.add(restaurante.nome);
        }
        return arr;
    }

    void imprimirCardapioRestaurante(Scanner input) {
        System.out.println("Selecione o restaurante para saber o cardapio: (Digite o indice) ");
        System.out.println(this.imprimirRestaurantes());
        int objIndex = Integer.parseInt(input.nextLine());
        this.restaurantes.get(objIndex).imprimirCardapio();
    }

    void imprimirCardapioRestaurante(Scanner input, int restauranteIndex) {
        this.restaurantes.get(restauranteIndex).imprimirCardapio();
    }

    void adicionarItemsRestaurante(Scanner input, Lanche lanche) {
        System.out.println("Selecione o restaurante para adicionar o lanche: (Digite o indice) ");
        System.out.println(this.imprimirRestaurantes());
        int restauranteIndex = Integer.parseInt(input.nextLine());
        this.restaurantes.get(restauranteIndex).adicionarLanche(lanche);
    }

    void adicionarItemsRestaurante(Lanche lanche, int restauranteIndex) {
        this.restaurantes.get(restauranteIndex).adicionarLanche(lanche);
    }

    void removerItemsRestaurante(Scanner input) {
        System.out.println("Selecione o restaurante: (Digite o indice) ");
        System.out.println(this.imprimirRestaurantes());
        int restauranteIndex = Integer.parseInt(input.nextLine());
        System.out.println("Selecione o lanche do cardapio para remover: (Digite o indice) ");
        this.imprimirCardapioRestaurante(input, restauranteIndex);
        int lancheIndex = Integer.parseInt(input.nextLine());
        this.restaurantes.get(restauranteIndex).removerLanchePorIndex(lancheIndex);
    }

    void removerItemsRestaurante(Scanner input, int restauranteIndex) {
        System.out.println("Selecione o lanche do cardapio para remover: (Digite o indice) ");
        this.imprimirCardapioRestaurante(input, restauranteIndex);
        int lancheIndex = Integer.parseInt(input.nextLine());
        this.restaurantes.get(restauranteIndex).removerLanchePorIndex(lancheIndex);
    }

    public void cadastrarUsuario(Usuário usuario) {
        System.out.println("Cadastrando usuário...");
        boolean userExists = false;
        for (Usuário usuário : usuários) {
            if (usuário.nome.equals(usuario.nome))
                userExists = true;
        }
        if (!userExists)
            this.usuários.add(usuario);
        else
            System.out.println("Usuario ja existe");
    }

    public boolean autenticarUsuario(String usuario, String senha) {
        for (Usuário usuário : usuários) {
            if (usuário.nome.equals(usuario) && usuário.senha.equals(senha))
                return true;
        }
        return false;
    }

    void imprimirUsuários() {
        ArrayList<String> arr = new ArrayList<>();
        for (Usuário usuário : usuários) {
            arr.add(usuário.nome);
        }
        System.out.println(arr);
    }

    public void criarPedido(Scanner input, String user) {
        for (Usuário usuário : usuários) {
            if (usuário.nome.equals(user)) {
                int restauranteIndex = this.selecionarRestaurante(input);
                if (restauranteIndex != -1) {
                    System.out.println("Digite o nome do pedido: ");
                    String nomePedido = input.nextLine();
                    usuário.adicionarPedido(nomePedido, restaurantes.get(restauranteIndex));
                }
            }
        }
    }

    public void listarPedido(String user) {
        for (Usuário usuário : usuários) {
            if (usuário.nome.equals(user)) {
                usuário.imprimirPedidos();
            }
        }
    }
}
