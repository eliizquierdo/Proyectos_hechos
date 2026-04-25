/*
 * Guía de laboratorio 05 - Programación 3 - 2012
 * Ejercicio 1a: Sumatoria de dos números enteros leídos por separado
 */
package sumatoria2;

import java.util.Scanner;

/**
 * @date 11/06/2018
 * @author Fredy Kcrez
 */
public class Sumatoria2 {

    public static void main(String[] args) {
        System.out.println("Bienvenido");
        
        int n1, n2;
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingrese el primer número entero: ");
        n1 = entrada.nextInt();
        
        System.out.print("Ingrese el segundo número entero: ");
        n2 = entrada.nextInt();
        
        System.out.print("La suma de los dos números es: ");
        System.out.print( (n1+n2) + "\n" );
    }    
}