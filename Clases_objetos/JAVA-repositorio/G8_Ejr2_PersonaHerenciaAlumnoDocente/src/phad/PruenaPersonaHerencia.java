/*
 * Guía de laboratorio 08 - Programación 3 - 2012
 * Ejercicio 2: Alumno y Docente heredan de Persona.
 *  Definir una clase base Persona que contenga la información de propósito
 * general común a toda la gente (nombre, dirección, telefono, sexo y fecha de
 * nacimiento) y los respectivos métodos set y get; ademas, crear un constructor
 * de persona que inicialice los valores de los atributos. Luego, diseñar una
 * jerarquía de clases que contemple las siguiente: Alumno y Docente, y cada uno
 * se identifica por medio de un carnet y código del docente respectivamente.
 * Finalmente, agregar una clase que pruebe la creación de un objeto de Alumno y
 * un objeto de docente, con todos sus métodos.
 */
package phad;

import java.util.Date;

/**
 * @date 02/07/2018
 * @author Fredy Kcrez
 */
public class PruenaPersonaHerencia {

    public static void main(String[] args) {
        Date date = new Date(2012, 07, 02);
        Alumno al = new Alumno("Juan Ramirez", "San Martin, San Salvador, El"
                + " Salvador", "2789-2589", 'H', date, "JR12953");
        Docente doc = new Docente("Monica Cardona", "San Marcos, El"
                + " Salvador", "5962-15987", 'm', date, "49845");
        
        System.out.println("---- Datos de alumno ----");
        System.out.println("Nombre: " + al.getNombre() + "\nDireccion: " + 
                al.getDireccion() + "\nTelefono: " + al.getTelefono() +
                "\nSexo: " + al.getSexo() + "\nCarnet: " + al.getCarnet());
        
        System.out.println("\n---- Datos de docente ----");
        System.out.println("Nombre: " + doc.getNombre() + "\nDireccion: " + 
                doc.getDireccion() + "\nTelefono: " + doc.getTelefono() +
                "\nSexo: " + doc.getSexo() + "\nCarnet: " +
                doc.getCodigoDocente());
    }
}