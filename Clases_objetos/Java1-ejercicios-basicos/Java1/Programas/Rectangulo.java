public class Rectangulo extends Figura {

    public float obtenPerimetro() {
       return 2 * ancho + 2 * alto;
    }
    
    public float obtenArea() {
        return ancho * alto;
    }
}