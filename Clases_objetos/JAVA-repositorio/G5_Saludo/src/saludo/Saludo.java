/*
 * Guía de laboratorio 05 - Programación 3 - 2012
 * Ejercicio 2c: Imprimir saludo con nombre
 */
package saludo;

import javax.swing.JOptionPane;

/**
 * @date 11/06/2018
 * @author Fredy Kcrez
 */
public class Saludo {

    public static void main(String[] args) {
        final String name = JOptionPane.showInputDialog("Ingrese su nombre");

        JOptionPane.showMessageDialog(null,"Hola " + name);
    }
}