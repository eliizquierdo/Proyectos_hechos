import java.io.*;

public class AplicacionHerencia1 {
   public static void main(String[] args) {
      Vaca daisy = new Vaca();
      Animal animal = new Vaca();
      Serpiente serpiente = new Animal();
      System.out.println("Daisy dice : " + daisy.habla() );
      System.out.println("Animal dice : " + animal.habla() );
      System.out.println("Serpiente dice : " + serpiente.habla() );
   }
}