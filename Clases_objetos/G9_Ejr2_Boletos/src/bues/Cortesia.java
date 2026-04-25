package bues;

/**
 * @date 05/07/2018
 * @author Fredy Kcrez
 */
public class Cortesia extends Boleto {
    
    public Cortesia(double precio) {
        super(precio);
    }

    @Override
    public double getPrecio() {
        return this.precio;
    }
}
