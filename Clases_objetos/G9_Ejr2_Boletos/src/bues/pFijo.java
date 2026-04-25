package bues;

/**
 * @date 05/07/2018
 * @author Fredy Kcrez
 */
public class pFijo extends Boleto {

    public pFijo(double precio) {
        super(precio);
    }

    @Override
    public double getPrecio() {
        return this.precio;
    }
}