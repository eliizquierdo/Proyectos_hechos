/*
 * Guía de laboratorio 08 - Programación 3 - 2012
 * Ejemplo 1: Herencia de la clase Object.
 */
package ejemploherencia1;

/**
 * @date 02/07/2018
 * @author Fredy Kcrez
 */
public class PruebaEmpleadoPorComision {

    public static void main(String[] args) {
        EmpleadoPorComision empleado = new EmpleadoPorComision(                 // crea instancia de objeto EmpleadoPorComision
                "Juan", "Perez", "222-22-2222", 10000, .06 );

        // obtiene datos del empleado por comisión
        System.out.println( "Informacion del empleado obtenida por los"
                + " metodos set: \n" );
        System.out.printf( "%s %s\n", "El primer nombre es",
                empleado.getPrimerNombre() );
        System.out.printf( "%s %s\n", "El apellido paterno es",
                empleado.getApellidoPaterno() );
        System.out.printf( "%s %s\n", "El numero de seguro social es",
                empleado.getNumeroSeguroSocial() );
        System.out.printf( "%s %.2f\n", "Las ventas brutas son",
                empleado.getVentasTotales() );
        System.out.printf( "%s %.2f\n", "La tarifa de comision es",
                empleado.getTarifaComision() );
        empleado.setVentasTotales( 500 );                                       // establece las ventas Brutas
        empleado.setTarifaComision( .1 );                                       //  establece la tarifa de comisión
        System.out.printf( "\n%s:\n\n%s\n", "Informacion actualizada del "
                + "empleado, obtenida mediante toString", empleado );
    }
}