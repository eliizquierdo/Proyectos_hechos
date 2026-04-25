import java.io.*;

public class AplicacionArreglo3 {
    
    public static void main(String[] args) {
        int arreglo[][] = {{1,2,3},{4,5,6},{7,8,9}};
                
        for (int i=0; i<arreglo.length; i++) {
           for (int j=0; j<arreglo[0].length; j++) {
              System.out.print("Elemento [" + i + "," + j + "] = " + arreglo[i][j] + " ");
           }
           System.out.println();
        }
    }
}