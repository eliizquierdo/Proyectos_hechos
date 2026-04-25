/*
 * Guía de laboratorio 08 - Programación 3 - 2012
 * Ejercicio 4: Uso de composicion en sustitución de la herencia.
 * Muchos programas escritos con herencia podrían escribirse mediante la
 * composición, y viceversa. Vuelva a escribir la clase EmpleadoBaseMasComision
 * de la jerarquía EmpleadoPorComision EmpleadoBaseMasComision para usar la
 * composición en vez de la herencia. 
 */
package composicionEmpleadoPorComision;

/**
 * @date 04/07/2018
 * @author Fredy Kcrez
 */
public class PruebaEmpleadoBaseMasComision {

    public static void main(String[] args) {
        EmpleadoBaseMasComision empleado = new EmpleadoBaseMasComision(
                "Luis", "López", "333-33-3333", 5000, .04, 300 );

        // obtiene datos del empleado por comisión con sueldo base
        System.out.printf( "\n%s:\n\n%s\n", "Informacion actualizada del "
                + "empleado, obtenida por toString", empleado.toString() );
        
        empleado.setSalarioBase( 1000 );                                        // establece el salario base
        System.out.printf( "\n%s:\n\n%s\n", "Informacion actualizada del "
                + "empleado, obtenida por toString", empleado.toString() );
    }
}