/*
 * Guía de laboratorio 05 - Programación 3 - 2012
 * Ejercicio 2a: Multiplicación de dos números
 */
package g1_multiplicacion;

import java.util.Scanner;

/**
 * @date 11/06/2018
 * @author Fredy Kcrez
 */
public class G1_Multiplicacion {

    public static void main(String[] args) {
        int n1, n2;
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingrese el primer numero: ");
        n1 = entrada.nextInt();
        System.out.print("Ingrese el segundo numero: ");
        n2 = entrada.nextInt();
        
        System.out.println("El producto de los numeros es: " + (n1*n2));
    }    
}
