package bues;

/**
 * @date 05/07/2018
 * @author Fredy Kcrez
 */
public abstract class Boleto {
    protected final int lista[] = new int[999];
    private int numeroSerie;
    protected double precio;
    private int num = 0;
    
    public Boleto(double precio) {
        this.setPrecio( precio );
        this.codificarNumeroSerie();
    }
    
    public void codificarNumeroSerie() {
        lista[num] = num + 1;
        num++;
        this.setNumeroSerie(num);
    }

    /**
     * @return the numeroSerie
     */
    public int getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * @param numeroSerie the numeroSerie to set
     */
    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * @return the precio
     */
    public abstract double getPrecio();

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return String.format("Número de Serie: %s\nPrecio del boleto: %.2f", this.numeroSerie, this.precio);
    }
}