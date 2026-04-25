package ejemplos.clasesabstractas;

/**
 * @date 04/07/2018
 * @author Fredy Kcrez
 */
public abstract class Libro {
    protected String titulo;
    protected double precio;
    
    public Libro(String titulo) {
        this.setTitulo( titulo );
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public abstract void setPrecio();
}