package fg;

/**
 * @date 03/07/2018
 * @author Fredy Kcrez
 */
public class Trapezoide extends Cuadrilatero {
    private double top;
    
    public Trapezoide(double base, double altura, double top) {
        super(base, altura);
        this.setTop( top );
    }

    /**
     * @return the top
     */
    public double getTop() {
        return top;
    }

    /**
     * @param top the top to set
     */
    public void setTop(double top) {
        this.top = top;
    }
    
    @Override
    public double area() {
        double area = ((0.5) * ( (top + base) * altura )); 
        return area;
    }
}