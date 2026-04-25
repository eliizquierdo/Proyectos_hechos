package ejemplos.clasesabstractas;

/**
 * @date 04/07/2018
 * @author Fredy Kcrez
 */
public class Ficcion extends Libro {
    public Ficcion(String titulo) {
        super(titulo);
        setPrecio();
    }
    
    @Override
    public void setPrecio() {
        this.precio = 37.99;
    }
}