package visibilidadPrivada;

/**
 * @date 18/06/2018
 * @author Fredy Kcrez
 */
public class Alpha {
    private int soyPrivado = 20;
    
    private void metodoPrivado() {
        System.out.println("Método privado");
    }
    
    public void metodoPublico() {
        System.out.println("Método publico");
        System.out.println("Atributo privado: " + soyPrivado);
        System.out.println("Invocando metodo privado: ");
        metodoPrivado();
    }
}