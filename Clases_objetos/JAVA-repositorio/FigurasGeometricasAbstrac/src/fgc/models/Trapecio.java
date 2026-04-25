package fgc.models;

import fgc.padres.Cuadrilatero;

/**
 * @date 02/08/2018
 * @author Fredy Kcrez
 */
public class Trapecio extends Cuadrilatero {
    private float baseTop;
    
    Trapecio(float base, float altura, float bTop) {
        super(base, altura, "Trapecio");
        this.setBaseTop(bTop);
    }

    /**
     * @return the baseTop
     */
    public float getBaseTop() {
        return baseTop;
    }

    /**
     * @param baseTop the baseTop to set
     */
    private void setBaseTop(float baseTop) {
        this.baseTop = baseTop;
    }
    
    @Override
    public float area() {
        return ((this.getBase() + this.getBaseTop()) / 2) * this.getAltura();
    }
}
