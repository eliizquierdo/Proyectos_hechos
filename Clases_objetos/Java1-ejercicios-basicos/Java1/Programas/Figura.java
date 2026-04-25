public abstract class Figura{
    protected int x, y, ancho, alto;
    
    public void cambiaX(int x) {
       this.x = x;
    }
    
    public void cambiaY(int y) {
       this.y = y;
    }
    
    public void cambiaAncho(int ancho) {
       this.ancho = ancho;
    }
    
    public void cambiaAlto(int alto) {
       this.alto = alto;
    }
    
    public abstract float obtenPerimetro();
    
    public abstract float obtenArea();
}