/*
 * Guía de laboratorio 06 - Programación 3 - 2012
 * Ejemplo 3: Triangulo de pascal a partir de la dimensión dada.
 */
package triangulopascal;

import javax.swing.JOptionPane;

/**
 * @date 12/06/2018
 * @author Fredy Kcrez
 */
public class TrianguloPascal {

    public static void main(String[] args) {
        String texto = "";
        int max = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la dimención del triángulo de Pascal"));
        
        int[][] pascal = new int[max][max];
        
        for(int i=0; i<max-1; i++) {
            for(int j=0; j<max-1; j++) {
                if(j==0){
                    pascal[i][j]=1;
                }
                pascal[i+1][j+1] = pascal[i][j]+pascal[i][j+1];
            }
            if(i==max-2)
                pascal[i+1][0] = 1;
        }
        
        for(int i=0; i<pascal.length; i++) {
            for(int j=0; j<pascal.length; j++) {
                texto += pascal[i][j] + "\t";
            }
            texto += "\n";
        }
        System.out.print(texto);
    }    
}
