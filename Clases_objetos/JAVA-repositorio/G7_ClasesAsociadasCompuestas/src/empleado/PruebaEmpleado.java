/*
 * Guía de laboratorio 07 - Programación 3 - 2012
 * Teo 7: Clases asociadas o compuestas.
 */
package empleado;

/**
 * @date 18/06/2018
 * @author Fredy Kcrez
 */
public class PruebaEmpleado {

    public static void main(String[] args) {
        Fecha nacimiento = new Fecha(7, 24, 1970);
        Fecha contratacion = new Fecha(3, 12, 2011);
        Empleado empleado = new Empleado("Juan", "Perez", nacimiento, contratacion);

        System.out.println(empleado);                 //Invoca el método “toString”
    }
}