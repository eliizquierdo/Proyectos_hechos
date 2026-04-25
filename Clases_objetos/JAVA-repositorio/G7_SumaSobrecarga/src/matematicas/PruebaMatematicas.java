/*
 * Guía de laboratorio 07 - Programación 3 - 2012
 * Ejemplo 1: Sobrecarga de metodo sumar en la clase Matematicas.
 */
package matematicas;

/**
 * @date 18/06/2018
 * @author Fredy Kcrez
 */
public class PruebaMatematicas {

    public static void main(String[] args) {
        double[] y = {4.5, 2.5, 1.3, 1.7};
        Matematicas x = new Matematicas();

        double z = x.sumar(3.25, 2.75);
        System.out.println(z);
        z = x.sumar(1, 2, 3);
        System.out.println(z);
        System.out.println(x.sumar(y));
    }
}