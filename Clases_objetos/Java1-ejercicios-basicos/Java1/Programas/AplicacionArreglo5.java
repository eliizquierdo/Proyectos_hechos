import java.io.*;

public class AplicacionArreglo5 {
    
    public static void main(String[] args) {
        Punto arreglo[][] = new Punto [3][3];
        
        for (int i=0; i<3; i++) {
           for (int j=0; j< 3; j++) {
               arreglo [i][j] = new Punto(i,j);
           }
        }
        
        for (int i=0; i<3; i++) {
           for (int j=0; j<3; j++) {
              System.out.print("Elemento [" + i + "," + j + "] = " + arreglo[i][j].toString() + " ");
           }
           System.out.println();
        }
    }
 }