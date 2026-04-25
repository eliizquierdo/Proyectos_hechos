/*
 * Guía de laboratorio 05 - Programación 3 - 2012
 * Ejercicio 1a: Sumatoria de dos números de forma consecutiva
 */
package sumatoria;

import java.util.Scanner;

/**
 * @date 11/06/2018
 * @author Fredy Kcrez
 */
public class Sumatoria {

    public static void main(String[] args) {
        System.out.println("Bienvenido");
        System.out.println("Ingrese dos numeros: ");

        int n1, n2;
        
        Scanner entrada = new Scanner(System.in);
        n1 = entrada.nextInt();
        n2 = entrada.nextInt();
        
        System.out.println("La suma es: " + (n1 + n2));
    }   
}