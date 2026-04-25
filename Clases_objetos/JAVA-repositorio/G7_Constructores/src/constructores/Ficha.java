package constructores;

/**
 * @date 18/06/2018
 * @author Fredy Kcrez
 */
public class Ficha {
    private int casilla;
    
    Ficha() {
        this.casilla = 1;
    }
    
    Ficha(int casilla) {
        this.casilla = casilla;
    }
    
    public void avanzar(int n) {
        casilla += n;
    }
    
    public int getCasillaActual() {
        return casilla;
    }
}