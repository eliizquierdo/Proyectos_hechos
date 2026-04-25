/*
 * Guía de laboratorio 09 - Programación 3 - 2012
 * Ejemplo 1: Clase abstracta Libro, heredan Drama y Ficcion.
 */
package ejemplos.implementacion;

import ejemplos.clasesabstractas.Drama;
import ejemplos.clasesabstractas.Ficcion;
import javax.swing.JOptionPane;

/**
 * @date 04/07/2018
 * @author Fredy Kcrez
 */
public class TestLibreria {

    public static void main(String[] args) {
        Ficcion librosFiccion[] = new Ficcion[5];
        Drama librosDrama[] = new Drama[5];
        boolean continuar = true;
        int contFiccion = 0;
        int contDrama = 0;
        String titulo;
        
        JOptionPane.showMessageDialog(null, "Se introducirán libros de ficción");
        
        while(continuar) {
            titulo = JOptionPane.showInputDialog("Introduzca el título del "
                    + "libro");
            Ficcion ficcion = new Ficcion(titulo);
            librosFiccion[contFiccion] = ficcion;
            contFiccion++;
            
            String sContinuar = JOptionPane.showInputDialog("¿Desea continuar?\n"
                    + "Precione \"s\" para continuar, \n cualquier teclar para"
                    + " dejar de ingresar libros de ficción");
            if(!sContinuar.equals("s") || (contFiccion > 4)){
                continuar = false;
            }
        }

        continuar = true;
        JOptionPane.showMessageDialog(null, "Se introducirán libos de drama");
        
        while(continuar) {
            titulo = JOptionPane.showInputDialog("Introduzca el título del"
                    + " libro");
            Drama drama = new Drama(titulo);
            librosDrama[contDrama] = drama;
            contDrama++;
            
            String sContinuar = JOptionPane.showInputDialog("¿Desea continuar?\n"
                    + "Precione \"s\" para continuar, \n cualquier teclar para"
                    + " dejar de ingresar libros de ficción");
            if(!sContinuar.equals("s") || (contFiccion > 4)){
                continuar = false;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Se han ingresado " + contFiccion + 
                " libros de ficción\n y " + contDrama + " libros de drama");
        
        String salidaFiccion = "Los libros de ficción introducidos son:\n";
        String salidaDrama = "Los libros de drama introducidos son:\n";
        
        for(int i=0; i<contFiccion; i++) {
            salidaFiccion += librosFiccion[i].getTitulo() + "\n";
            salidaFiccion += librosFiccion[i].getPrecio()+ "\n\n";
        }

        for(int i=0; i<contDrama; i++) {
            salidaDrama += librosDrama[i].getTitulo() + "\n";
            salidaDrama += librosDrama[i].getPrecio()+ "\n\n";
        }
        
        JOptionPane.showMessageDialog(null, salidaFiccion);
        JOptionPane.showMessageDialog(null, salidaDrama);
    }
}