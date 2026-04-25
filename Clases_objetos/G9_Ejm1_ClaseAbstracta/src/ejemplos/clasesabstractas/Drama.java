package ejemplos.clasesabstractas;

/**
 * date 04/07/2018
 * @author Fredy Kcrez
 */
public class Drama extends Libro {
    public Drama(String titulo) {
        super(titulo);
        setPrecio();
    }
    
    @Override
    public void setPrecio() {
        this.precio = 24.99;
    }
}