import java.io.*;

public class AplicacionExcepcion {

    public static void despliegaDivision() {
       System.out.println(" Arithmetic Exception con = " + 3 / 0);
    }
            
    public static void main(String[] args) {
       despliegaDivision();
    }
}