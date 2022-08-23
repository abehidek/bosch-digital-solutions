public class Guerreiro extends Jogador {
    
    @Override
    boolean atacar(Jogador oponente) {
        int deltaX = Math.abs(x-oponente.x);
        int deltaY = Math.abs(y-oponente.y);

        if (deltaX == 0 && deltaY == 1) {
            oponente.vida  -= 25;
            return true;
        } else if (deltaX == 1 && deltaY == 0) {
            oponente.vida -= 25;
            return true;
        } else {
            return false;
        }
    }
}
