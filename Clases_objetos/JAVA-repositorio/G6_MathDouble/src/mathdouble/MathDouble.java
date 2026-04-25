/*
 * Guía de laboratorio 06 - Programación 3 - 2012
 * Ejemplo 1: Métodos estáticos de las clases Math y Double
 */
package mathdouble;

import javax.swing.JOptionPane;

/**
 * @date 12/06/2018
 * @author Fredy Kcrez
 */
public class MathDouble {

    public static void main(String[] args) {
        double x1, x2, x3, potencia;
        String primero, segundo, tercero;

        //leer el primer numero en caracteres
        primero = JOptionPane.showInputDialog("Escriba el primer número:");

        //leer el segundo numero en caracteres
        segundo = JOptionPane.showInputDialog("Escriba el segundo número:");

        //leer el tercer numero en caracteres
        tercero = JOptionPane.showInputDialog("Escriba el tercer número:");

        //Convertir las cadenas a numeros
        x1 = Double.parseDouble(primero);
        x2 = Double.parseDouble(segundo);
        x3 = Double.parseDouble(tercero);
        potencia = Math.pow(x1, x2);

        String resultado = "";
        resultado = x1 + " elevado a " + x2 + " es: " + potencia;
        
        //mostramos resultado
        JOptionPane.showMessageDialog(null, resultado, "Salida 1:", JOptionPane.PLAIN_MESSAGE);
        
        //línea vacía
        System.out.println();
        x1++;
        potencia = Math.pow(x1, x2);
        
        resultado = x1 + " elevado a " + x2 + " es: " + potencia;
        JOptionPane.showMessageDialog(null, resultado, "Salida 2:", JOptionPane.INFORMATION_MESSAGE);
        
        potencia = Math.pow(x1, x2++);
        resultado = x1 + " elevado a " + x2 + " es: " + potencia;
        JOptionPane.showMessageDialog(null, resultado, "Salida 3:", JOptionPane.WARNING_MESSAGE);
        
        potencia = Math.pow(x1, x2);
        resultado = x1 + " elevado a " + x2 + " es: " + potencia;
        JOptionPane.showMessageDialog(null, resultado, "Salida 4:", JOptionPane.QUESTION_MESSAGE);
        
        //raíz cuadrada de un numero
        double resul = Math.sqrt(x3);
        resultado = "Raíz cuadrada de: " + x3 + " es: " + resul;
        JOptionPane.showMessageDialog(null, resultado, "Salida 5:", JOptionPane.ERROR_MESSAGE);
        
        x3 = Math.pow(x3, 2);
        double res = Math.sqrt(x3);
        resultado = "Raíz cuadrada de: " + x3 + " es: " + res;
        JOptionPane.showMessageDialog(null, resultado, "Salida 6:", JOptionPane.PLAIN_MESSAGE);
        
        //Terminar la ejecución
        System.exit(0);
    }
}
