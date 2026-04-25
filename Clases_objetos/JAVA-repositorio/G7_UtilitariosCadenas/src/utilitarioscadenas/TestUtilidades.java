/*
 * Guía de laboratorio 07 - Programación 3 - 2012
 * Ejercicio 5: Manejo de funciones de cadena.
 */
package utilitarioscadenas;

/**
 * @date 27/08/2018
 * @author Fredy Kcrez
 */
public class TestUtilidades {

    public static void main(String[] args) {
        String Cad = "hola mundo desde Java";
        String [] cad = UtilidadesCadenas.palabrasInversas(Cad);

        for(int i=0; i<cad.length; i++) {
            System.out.println(cad[i]);
        }
        System.out.println(UtilidadesCadenas.inicioMayusculas(Cad));
        System.out.println(UtilidadesCadenas.inicioTodasMayusculas(Cad));
    }
}
