/*
 * Guía de laboratorio 06 - Programación 3 - 2012
 * Ejercicio 4: Verificar carnet de alumno.
 */
package carnet;

import javax.swing.JOptionPane;
import java.lang.Character;

/**
 * @date 13/06/2018
 * @author Fredy Kcrez
 */
public class Carnet {

    public static void main(String[] args) {
        String carnet = JOptionPane.showInputDialog(null, "Ingrese un carnet");
        
        if(carnet.length() == 7) {
            for(int i=0; i<carnet.length(); i++){
                char c = carnet.charAt(i);
                if(Character.isLetter(c)){
                    if( i>1 )
                        salir(carnet);
                } else if(Character.isDigit(c)) {
                    if(i<2)
                        salir(carnet);
                } else
                    salir(carnet);
            }
            JOptionPane.showMessageDialog(null, carnet + " válido.");
            System.exit(0);
        } else
            salir(carnet);
    }
    
    public static void salir(String carnet) {
        JOptionPane.showMessageDialog(null, carnet + " no es válido.");
        System.exit(0);
    }
}