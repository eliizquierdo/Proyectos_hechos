package fg;

/**
 * @date 03/07/2018
 * @author Fredy Kcrez
 */
public class Cuadrado {
    protected double lado;
    
    public Cuadrado(double lado) {
        this.setLado( lado );
    }

    /**
     * @return the lado
     */
    public double getLado() {
        return lado;
    }

    /**
     * @param lado the lado to set
     */
    public void setLado(double lado) {
        this.lado = lado;
    }
    
    public double area() {
        return Math.pow(lado, 2);
    }
}