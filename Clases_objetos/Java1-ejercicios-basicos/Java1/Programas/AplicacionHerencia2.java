public class AplicacionHerencia2 {
   public static void main(String[] args) {
      Cuadrado c = new Cuadrado();
      c.cambiaAncho(10);
      c.cambiaAlto(10);
      Rectangulo r = new Rectangulo();
      r.cambiaAncho(20);
      r.cambiaAlto(30);
      System.out.println("Perimetro Cuadrado = " + c.obtenPerimetro());
      System.out.println("Area Cuadrado = " + c.obtenArea());
      System.out.println("Perimetro Rectangulo = " + r.obtenPerimetro());
      System.out.println("Area Rectangulo = " + r.obtenArea());
   }
}      