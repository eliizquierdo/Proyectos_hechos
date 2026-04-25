/*
 * Guía de laboratorio 05 - Programación 3 - 2012
 * Ejercicio 1a: Cálculo de impuestos a una venta
 */
package g1_impuestoventa;

import javax.swing.JOptionPane;

/**
 * @date 11/06/2018
 * @author Fredy Kcrez
 */
public class G1_ImpuestoVenta {

    public static void main(String[] args) {
        final double IVA = 0.13;
        final double IMPUESTO_ESPECIAL = 0.12;
        
        double venta = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a gravar"));
        double valorGravado = venta + (venta*IVA) + (venta*IMPUESTO_ESPECIAL);
        
        JOptionPane.showMessageDialog(null, "El total a pagar es: " + valorGravado);
    }    
}
