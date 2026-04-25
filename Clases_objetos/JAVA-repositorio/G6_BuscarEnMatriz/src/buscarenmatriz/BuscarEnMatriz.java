/*
 * Guía de laboratorio 06 - Programación 3 - 2012
 * Ejercicio 6: Buscar un entero en una matriz.
 */
package buscarenmatriz;

import java.util.Scanner;

/**
 * @date 13/06/2018
 * @author Fredy Kcrez
 */
public class BuscarEnMatriz {

    public static void main(String[] args) {
        int cont = 0;
        System.out.print("Ingrese el tamaño de la matriz: ");
        Scanner entrada = new Scanner(System.in);
        int max = entrada.nextInt();
        int[][] matriz = new int[max][max];

        for(int i=0; i<max; i++) {
            for(int j=0; j<max; j++) {
                matriz[i][j] = cont++; 
            }
        }
        System.out.print("Ingrese un entero para ser buscado: ");
        int search = entrada.nextInt();
        
        for(int i=0; i<max; i++) {
            for(int j=0; j<max; j++) {
                if(matriz[i][j] == search) {
                    System.out.println(
                            "El número " + search + " se encuentra en la fila: " + (i+1) + " columna: " + (j+1)
                                    );
                    System.exit(0);
                }
            }
        }
        System.out.println("No se encontro el número que busca");
                    System.exit(0);
    }    
}
