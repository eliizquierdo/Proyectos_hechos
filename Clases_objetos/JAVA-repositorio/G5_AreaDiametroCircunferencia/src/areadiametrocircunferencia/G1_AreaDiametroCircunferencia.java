/*
 * Guía de laboratorio 05 - Programación 3 - 2012
 * Ejercicio 2b: Area y Diametro de Circunferencia
 */
package areadiametrocircunferencia;

import javax.swing.JOptionPane;

/**
 * @date 11/06/2018
 * @author Fredy Kcrez
 */
public class G1_AreaDiametroCircunferencia {

    public static void main(String[] args) {
        final double radio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el radio de la circunferencia"));
        
        JOptionPane.showMessageDialog(
                null, "Area de la circunferencia: " + (Math.PI * Math.pow(radio, 2))
                        + "\nDiametro: " + (2*radio)
        );
    }    
}
