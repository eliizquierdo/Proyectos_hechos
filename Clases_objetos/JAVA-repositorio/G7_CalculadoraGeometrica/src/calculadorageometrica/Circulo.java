package calculadorageometrica;

/**
 * @date 27/06/2018
 * @author Fredy Kcrez
 */
public class Circulo {
    private double radio;
    private double area;
    private double perimetro;
    
    Circulo(double radio){
        this.radio = radio;
        this.calcularArea();
        this.calcularPerimetro();
    }
    
    public void calcularArea(){
        this.area = Math.PI * Math.pow(radio, 2);
    }
    
    public void calcularPerimetro(){
        this.perimetro = 2 * Math.PI * radio;
    }
    
    public String toString() {
        return "Area de la circunferencia: " + this.area + "\nPerimetro de la circunferencia: " + this.perimetro;
    }

    /**
     * @return the radio
     */
    public double getRadio() {
        return radio;
    }

    /**
     * @param radio the radio to set
     */
    public void setRadio(double radio) {
        this.radio = radio;
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

    /**
     * @return the perimetro
     */
    public double getPerimetro() {
        return perimetro;
    }

    /**
     * @param perimetro the perimetro to set
     */
    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }
}