package fgc.models;

import fgc.padres.fGGeneralizacion;

/**
 * @date 02/08/2018
 * @author Fredy Kcrez
 */
public class Triangulo extends fGGeneralizacion {
    private float lado1, lado2, lado3;
    
    public Triangulo(float l1, float l2, float l3, float b, float a) {
        super(b, a);
        this.lado1 = l1;
        this.lado2 = l2;
        this.lado3 = l3;
        setTipoTriangulo(l1, l2, l3);
    }
    
    private void setTipoTriangulo(float x1, float x2, float x3) {
        String fig = "Triangulo ";
        if(((x1 == x2) && (x1 == x3)))
            fig += "equilatero";
        else {
            if((x1 != x2) && (x1 != x3)) {
                fig += "escaleno";
            }
            else
                fig += "isoceles";
        }
        super.setFigura(fig);
    }
    
    @Override
    public float area() {
        return super.area() / 2;
    }
    
    @Override
    public String toString() {
        return "Área del " + getFigura() + ": " + this.area();
    }

    /**
     * @return the lado1
     */
    public float getLado1() {
        return lado1;
    }

    /**
     * @param lado1 the lado1 to set
     */
    public void setLado1(float lado1) {
        this.lado1 = lado1;
    }

    /**
     * @return the lado2
     */
    public float getLado2() {
        return lado2;
    }

    /**
     * @param lado2 the lado2 to set
     */
    public void setLado2(float lado2) {
        this.lado2 = lado2;
    }

    /**
     * @return the lado3
     */
    public float getLado3() {
        return lado3;
    }

    /**
     * @param lado3 the lado3 to set
     */
    public void setLado3(float lado3) {
        this.lado3 = lado3;
    }
}