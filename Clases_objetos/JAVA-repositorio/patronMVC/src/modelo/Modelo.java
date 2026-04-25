package modelo;

/**
 * @date 09/08/2018
 * @author Fredy Kcrez
 */
public class Modelo {
    private float numero1, numero2;

    /**
     * @return the numero1
     */
    public float getNumero1() {
        return numero1;
    }

    /**
     * @param numero1 the numero1 to set
     */
    public void setNumero1(float numero1) {
        this.numero1 = numero1;
    }

    /**
     * @return the numero2
     */
    public float getNumero2() {
        return numero2;
    }

    /**
     * @param numero2 the numero2 to set
     */
    public void setNumero2(float numero2) {
        this.numero2 = numero2;
    }
    
    public float multiplicar() {
        return this.numero1 * this.numero2;
    }
}