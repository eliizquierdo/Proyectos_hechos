import java.io.*;

public class AplicacionArreglo4 {
    
    public static void main(String[] args) {
        int arreglo[] = {1,2,3};
                
        for (int i=0; i<arreglo.length+1; i++) {
           System.out.println("Elemento [" + i + "] = " + arreglo[i]);
        }
    }
}