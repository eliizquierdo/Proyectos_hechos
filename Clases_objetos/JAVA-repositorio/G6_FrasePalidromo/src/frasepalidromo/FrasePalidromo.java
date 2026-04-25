/*
 * Guía de laboratorio 06 - Programación 3 - 2012
 * Ejercicio 2: Determinar si una cadena de texto es un palindromo.
 */
package frasepalidromo;

import javax.swing.JOptionPane;

/**
 * @date 12/06/2018
 * @author Fredy Kcrez
 */
public class FrasePalidromo {

    public static void main(String[] args) {
        String str = JOptionPane.showInputDialog(null, "Ingrese una cadena de texto");
        String strInvert = "";
        
        //Modificaciones sobre la cadena
        str = str.toLowerCase(); //pongo la cadena en minuscual
        str = str.replaceAll(" ", "");
        
        for(int i= str.length()-1; i>=0; i--) {
            strInvert += str.charAt(i);
        }
        
        if(str.equals(strInvert)) {
            JOptionPane.showMessageDialog(null, "La cadena es Palindromo", "¡Felicidades!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "La cadena no es Palindromo", "Lo siento", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
