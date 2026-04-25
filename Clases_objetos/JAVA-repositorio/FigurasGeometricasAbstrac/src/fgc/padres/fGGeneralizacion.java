package fgc.padres;

/**
 * @date 02/08/2018
 * @author Fredy Kcrez
 */
public class fGGeneralizacion {
    private float base;
    private float altura;
    private String figura;
    
    public fGGeneralizacion(float b, float a) {
        this.base = b;
        this.altura = a;
    }

    public float area() {
        return getBase() * getAltura();
    }

    @Override
    public String toString() {
        return "Área " + getFigura() + ": " + area();
    }

    /**
     * @return the base
     */
    public float getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(float base) {
        this.base = base;
    }

    /**
     * @return the altura
     */
    public float getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(float altura) {
        this.altura = altura;
    }

    /**
     * @return the figura
     */
    public String getFigura() {
        return figura;
    }

    /**
     * @param figura the figura to set
     */
    public void setFigura(String figura) {
        this.figura = figura;
    }
}