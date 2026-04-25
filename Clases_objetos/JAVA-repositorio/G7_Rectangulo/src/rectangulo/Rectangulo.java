package rectangulo;

/**
 * @date 20/06/2018
 * @author Fredy Kcrez
 */
public class Rectangulo {
    private double longitud, anchura;
    
    Rectangulo() {
        this.longitud = 1;
        this.anchura = 1;
    }
    
    public double calcularPerimetro() {
        return ((2 * this.getAnchura()) + (2 * this.getLongitud()));
    }
    
    public double calcularArea() {
        return ((this.getLongitud() * this.getAnchura()));
    }

    /**
     * @return the longitud
     */
    public double getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(double longitud) {
        if((longitud > 0.0) && (longitud < 20.0))
            this.longitud = longitud;
        else
            System.out.println("La longitud debe ser mayor que 0.0 y menor que 20.0");
    }

    /**
     * @return the anchura
     */
    public double getAnchura() {
        return anchura;
    }

    /**
     * @param anchura the anchura to set
     */
    public void setAnchura(double anchura) {
        if((longitud > 0.0) && (longitud < 20.0))
            this.anchura = anchura;
        else
            System.out.println("La longitud debe ser mayor que 0.0 y menor que 20.0");
    }
}