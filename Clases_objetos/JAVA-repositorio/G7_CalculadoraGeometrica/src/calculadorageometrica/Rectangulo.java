package calculadorageometrica;

/**
 * @date 27/06/2018
 * @author Fredy Kcrez
 */
public class Rectangulo {
    private double base;
    private double altura;
    private double area;
    private double perimetro;
    
    Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
        this.calcularArea();
        this.calcularPerimetro();
    }
    
    private void calcularArea() {
        this.setArea(this.getBase() * this.getAltura());
    }
    
    public void calcularPerimetro(){
        this.perimetro = 2 * (this.base + this.altura);
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