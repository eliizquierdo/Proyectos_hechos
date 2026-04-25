import java.io.*;

public class AplicacionArreglo {
    
    public static void main(String[] args) {
        int arreglo[] = new int [10];
        
        for (int i=0; i<10; i++) {
           arreglo [i] = i;
        }
        
        for (int i=0; i<10; i++) {
           System.out.println("Elemento [" + i + "] = " + arreglo[i]);
        }
    }
 }