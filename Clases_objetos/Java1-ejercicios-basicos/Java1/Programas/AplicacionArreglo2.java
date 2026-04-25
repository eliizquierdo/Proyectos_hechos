import java.io.*;

public class AplicacionArreglo2 {
    
    public static void main(String[] args) {
        int arreglo[][] = new int [10][3];
        
        for (int i=0; i<10; i++) {
           for (int j=0; j< 3; j++) {
               arreglo [i][j] = i+j;
           }
        }
        
        for (int i=0; i<10; i++) {
           for (int j=0; j<3; j++) {
              System.out.print("Elemento [" + i + "," + j + "] = " + arreglo[i][j] + " ");
           }
           System.out.println();
        }
    }
 }