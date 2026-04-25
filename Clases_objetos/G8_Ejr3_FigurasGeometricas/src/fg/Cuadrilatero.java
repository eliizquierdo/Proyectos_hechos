package fg;

/**
 * @date 03/07/2018
 * @author Fredy Kcrez
 */
public class Cuadrilatero {
    protected double base, altura;
    
    public Cuadrilatero(double base, double altura) {
        this.setBase( base );
        this.setAltura( altura );
    }
    
    public double area() {
        return base * altura;
    }

    /**
     * @return the base
     */
    public double getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(double base) {
        this.base = base;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }
}