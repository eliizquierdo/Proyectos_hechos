/*
 * Guía de laboratorio 06 - Programación 3 - 2012
 * Ejercicio 1: Cantidad de vocales en una cadena de caracteres.
 */
package cantidadvocales;

import javax.swing.JOptionPane;

/**
 * @date 12/06/2018
 * @author Fredy Kcrez
 */
public class CantidadVocales {

    public static void main(String[] args) {
        String str = JOptionPane.showInputDialog(null, "Ingrese una cadena de caracteres");
        int cont = 0;
        char[] vocal = {'a', 'e', 'i', 'o', 'u'};
        
        String str2 = str.toLowerCase();
        for(int i=0; i<vocal.length-1; i++) {
            for(int j=0; j<str2.length(); j++) {
                char x = vocal[i];
                char y = str2.charAt(j);
                if(x==y)
                    cont++;
            }
        }
        
        JOptionPane.showMessageDialog(
                null, "Cantidad de vocales en la cadena: " + cont, "Respuesta", JOptionPane.INFORMATION_MESSAGE
        );
    }    
}