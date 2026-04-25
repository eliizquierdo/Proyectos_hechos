/*
 * Guía de laboratorio 06 - Programación 3 - 2012
 * Ejercicio 7: Buscar el número más grande del vector de números reales.
 */
package buscarvector;

import java.util.Random;

/**
 * @date 17/06/2018
 * @author Fredy Kcrez
 */
public class BuscarVector {

    public static void main(String[] args) {
        int n = 100;  //numeros aleatorios
        int k = n;  //auxiliar;
        int may = -1;
        int[] numeros = new int[n];
        int[] resultado = new int[n];
        Random rnd = new Random();
        int res = 0;
        
        //se rellena una matriz ordenada del 1 al 31(1..n)
        for(int i=0; i<n; i++)
            numeros[i] = i+1;
        
        for(int i=0; i<n; i++) {
            res = rnd.nextInt(k);            
            resultado[i] = numeros[res];
            numeros[res] = numeros[k-1];
            k--;
        }
        
        //se imprime el resultado;
        for(int i=0; i<n; i++) {
            //System.out.println(resultado[i]);
            if(resultado[i] > may) {
                may = resultado[i];
                res = i+1;
            }
        }
        System.out.println("El número mayor es: " + may + " y se encuentra en la posición " + res);
    }    
}