package rt;

/**
 * @date 18/06/2018
 * @author Fredy Kcrez
 */
public class Punto {
    private int posX, posY;
    
    Punto(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    
    public void imprimir() {
        System.out.println("X: " + posX + "\nY: " + posY);
    }
}