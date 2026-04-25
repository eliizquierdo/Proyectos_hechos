package calculadorageometrica;

/**
 * @date 27/06/2018
 * @author Fredy Kcrez
 */
public class Triangulo {
    private double base;
    private double altura;
    private double area;
    
    Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
        this.calcularArea();
    }
    
    private void calcularArea() {
        this.area = (this.base * this.altura) / 2;
    }
    
    public String toString() {
        return "Base: " + this.base + "\nAltura: " + this.altura + "\nArea: " + this.area;
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

    /**
     * @return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(double area) {
        this.area = area;
    }
    
    
}