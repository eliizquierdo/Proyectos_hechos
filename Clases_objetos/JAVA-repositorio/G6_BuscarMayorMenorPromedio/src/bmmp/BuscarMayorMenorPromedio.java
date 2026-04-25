/*
 * Guía de laboratorio 06 - Programación 3 - 2012
 * Ejercicio 8: Buscar el número mayor, menor, el promedio y la lista ordenada.
 */
package bmmp;

import java.util.Random;
import java.util.Scanner;

/**
 * @date 17/06/2018
 * @author Fredy Kcrez
 */
public class BuscarMayorMenorPromedio {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de números que quiere almacenar: ");
        int n = entrada.nextInt();  //numeros aleatorios
        int k = n;  //auxiliar;
        int may = -1, min = n+1;
        int[] numeros = new int[n];
        int[] resultado = new int[n];
        Random rnd = new Random();
        int res, sum=0, aux;
        float prom;

        // Se rellena una matriz ordenada del 1 al 31(1..n)
        for(int i=0; i<n; i++)
            numeros[i] = i+1;

        for(int i=0; i<n; i++) {
            res = rnd.nextInt(k);            
            resultado[i] = numeros[res];
            numeros[res] = numeros[k-1];
            k--;
        }
        
        // Ordenamos el arreglo
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++){
                if(resultado[i]>resultado[j]){
                    aux = resultado[i];
                    resultado[i] = resultado[j];
                    resultado[j] = aux;
                }
            }
        }

        // Buscamos el número mayor y el menor del arreglo ordenado
        for(int i=0; i<n; i++) {
            sum += resultado[i]; // Sumamos los valores para luego sacar el promedio
            if(resultado[i] > may)
                may = resultado[i];
            if(resultado[i] < min)
                min = resultado[i];
        }
        prom = (float) sum/n; // Convierte sum a número real, obtenemos el promedio
        System.out.printf("El número mayor es:%d \nEl número menor es: %d \nEl promedio es: %.2f\n", may, min, prom);
        System.out.println("\n- Lista ordenada de forma ascendente -");
        for(int i=0; i<n; i++)
            System.out.println(resultado[i]);
    }
}