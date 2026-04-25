/*
 * Guía de laboratorio 06 - Programación 3 - 2012
 * Ejercicio 3: Invierte una cadena leida.
 */
package cadenainvertida;

import javax.swing.JOptionPane;

/**
 * @date 12/06/2018
 * @author Fredy Kcrez
 */
public class CadenaInvertida {

    public static void main(String[] args) {
        String str = JOptionPane.showInputDialog("Ingrese una cadena de texto");
        
        for(int i= str.length()-1; i>=0; i--) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }
    
}
