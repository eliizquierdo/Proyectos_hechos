/*
 * Guía de laboratorio 06 - Programación 3 - 2012
 * Ejercicio 5: Excepciones FileNotFoundException, ArrayIndexOutOfBoundsException y IOException.
 */
package excepciones;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * @date 15/06/2018
 * @author Fredy Kcrez
 */
public class Excepciones {

    public static void main(String[] args) {
        String fileName = "D://Credenciales.txt"; //Colocar un archivo que no exista
        FileReader file = null;
        LineNumberReader reader = null;
        String[] array = {"Ana","Marta","Karla"};
        
        try {
            file = new FileReader(fileName);
            System.out.println("Archivo encontrado");
            reader = new LineNumberReader(file);
            System.out.println(reader.readLine());
            array[3] = "Mateo";
        } catch(FileNotFoundException ex1) {
            System.out.println("Archivo no encontrado");
        } catch(ArrayIndexOutOfBoundsException ex2) {
            System.out.println("Error de acceso a posición de arreglo.");
        } catch(IOException ex3) {
            System.out.println("Error al leer el archivo.");
        } finally {
            System.out.println("Fin de la ejecución");
            System.exit(0);
        }
    }
}