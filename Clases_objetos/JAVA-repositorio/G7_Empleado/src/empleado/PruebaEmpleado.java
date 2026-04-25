/*
 * Guía de laboratorio 07 - Programación 3 - 2012
 * Ejercicio 3: Empleados usa Fechas.
 */
package empleado;

/**
 * @date 23/06/2018
 * @author Fredy Kcrez
 */
public class PruebaEmpleado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fecha nacimiento = new Fecha(7, 24, 1970);
        Fecha contratacion = new Fecha(12, 31, 2016);
        Empleado empleado = new Empleado();

        if(!nacimiento.equals(contratacion)) {
            empleado.setPrimerNombre("Juan");
            empleado.setApellidoPaterno("Perez");
            empleado.setFechaNacimiento(nacimiento);
            empleado.setFechaContratacion(contratacion);
        }

        System.out.println(empleado);                 //Invoca el método “toString”
        
        System.out.println("\n--- Mes siguiente a la fecha de contratacion ---");
        System.out.println("Mes siguiente: " + contratacion.siguienteMes());
        System.out.println("\n--- Anho siguiente a la fecha de contratacion ---");
        System.out.println("Anho siguiente: " + contratacion.siguienteAnho());
        
        System.out.println("\n--- Días siguientes a la fecha de contratacion ---");
        for (int i=contratacion.getDia(); i<=contratacion.getDiasPorMes(); i++) {
            contratacion.siguienteDia();
            System.out.println("Día siguiente: " + empleado.getFechaContratacion());                 //Invoca el método “toString”
        }
    }
    
}
