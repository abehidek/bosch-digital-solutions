public class App {
    public static void main(String[] args) throws Exception {
        Jogador j1 = new Jogador();

        j1.x = 10;
        j1.y = 20;

        Jogador j2 = new Jogador();

        j2.x = 10;
        j2.y = 21;

        j1.atacar(j2);

        System.out.println(j1.vida);
        System.out.println(j2.vida);

        j1.andar(Direcao.NORTE);
        j1.andar(Direcao.SUL);
        j1.andar(Direcao.LESTE);
        j1.andar(Direcao.OESTE);

        System.out.println(j1.y);
    }
}
