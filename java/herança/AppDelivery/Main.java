package herança.AppDelivery;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        System.out.println("--- MAIN PROGRAM ---");
        Scanner input = new Scanner(System.in);
        App app = new App();
        boolean auth = false;
        boolean loop = false;
        String user = "";
        while (!auth) {
            System.out.println("\n--LOGIN--\n1 - Logar usuário\n2 - Cadastrar usuário\n9 - Sair");
            char op = input.nextLine().charAt(0);
            switch (op) {
                case '1':
                    System.out.println("Entre seu nome: ");
                    String userName = input.nextLine();
                    System.out.println("Entre sua senha: ");
                    String userPass = input.nextLine();
                    if (app.autenticarUsuario(userName, userPass)) {
                        auth = true;
                        loop = true;
                        user = userName;
                        System.out.println("\nUsuario logado\n");
                    } else {
                        System.out.println("\nUsuario ou senha incorreta\n");
                    }
                    break;
                case '2':
                    System.out.println("Entre seu nome: ");
                    String newuserName = input.nextLine();
                    System.out.println("Entre sua senha: ");
                    String newuserPass = input.nextLine();
                    System.out.println("Entre seu endereço: ");
                    String newuserAdr = input.nextLine();
                    System.out.println("Entre seu CPF: ");
                    String newuserCPF = input.nextLine();
                    app.cadastrarUsuario(new Usuário(newuserName, newuserPass, newuserAdr, newuserCPF));
                    break;
                case '9':
                    auth = true;
                    loop = false;
                    break;

                default:
                    System.out.println("Aconteceu algum erro");
                    break;
            }
        }

        while (loop) {
            System.out.println(
                    "\n--- MENU APP " + user + " ---\n" +
                            "1 - Adicionar Restaurante\n" +
                            "2 - Remover Restaurante\n" +
                            "3 - Listar restaurantes\n" +
                            "4 - Opçoes de restaurante\n" +
                            "5 - Fazer pedido\n" +
                            "6 - Listar pedidos\n" +
                            "9 - Sair");
            char op = input.nextLine().charAt(0);
            switch (op) {
                case '1':
                    System.out.println("Digite o nome do restaurante: ");
                    String nome = input.nextLine();
                    app.cadastrarRestaurante(new Restaurante(nome));
                    break;

                case '2':
                    app.removerRestaurante(input);
                    break;

                case '3':
                    System.out.println(app.imprimirRestaurantes());
                    break;

                case '4':
                    int index = app.selecionarRestaurante(input);
                    System.out.println("Index: " + index);
                    if (index != -1) {
                        boolean loop2 = true;
                        while (loop2) {
                            System.out.println(
                                    "--MENU RESTAURANTE " + app.imprimirRestaurantes().get(index) + "--\n" +
                                            "1 - Adicionar lanche\n" +
                                            "2 - Remover lanche\n" +
                                            "3 - Imprimir cardápio\n" +
                                            "9 - Voltar para menu");
                            char op2 = input.nextLine().charAt(0);
                            switch (op2) {
                                case '1':
                                    System.out.println("Digite o nome do lanche: ");
                                    String nomeLanche = input.nextLine();
                                    System.out.println("Digite o preço do lanche " + nomeLanche + ": ");
                                    double preçoLanche = Double.parseDouble(input.nextLine());
                                    app.adicionarItemsRestaurante(new Lanche(nomeLanche, preçoLanche), index);
                                    break;
                                case '2':
                                    app.removerItemsRestaurante(input, index);
                                    break;
                                case '3':
                                    app.imprimirCardapioRestaurante(input, index);
                                    break;
                                case '9':
                                    loop2 = false;
                                    break;
                                default:
                                    System.out.println("Aconteceu algum erro");
                                    break;
                            }
                        }
                    }
                    break;

                case '5':
                    app.criarPedido(input, user);
                    break;

                case '6':
                    app.listarPedido(user);
                    break;

                case '9':
                    System.out.println("Saindo...");
                    loop = false;
                    break;
                default:
                    System.out.println("Aconteceu algum erro");
                    break;
            }
        }

        // app.cadastrarRestaurante(new Restaurante("Mc Donald's"));
        // app.cadastrarUsuario(new Usuário("Abe", "Rua America", "222.222.111-0"));
        // app.cadastrarUsuario(new Usuário("Marco", "Rua America", "222.222.111-0"));
        // app.cadastrarUsuario(new Usuário("Vitor", "Rua America", "222.222.111-0"));
        // System.out.println(app.imprimirRestaurantes());
        // app.imprimirRestaurantes();
        // app.imprimirUsuários();
        // app.adicionarItemsRestaurante(input, new Lanche("Big Mac", 22.5));
        // app.imprimirCardapioRestaurante(input);
        // app.removerItemsRestaurante(input);
    }
}
