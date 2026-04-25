/*
 * Guía de laboratorio 07 - Programación 3 - 2012
 * Ejercicio 3.1: Empresa usa Empleados.
 */
package empresa;

/**
 *
 * @author Fredy Kcrez
 */
public class PruebaEmpresa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fecha nacimiento = new Fecha(7, 24, 1970);
        Fecha contratacion = new Fecha(12, 31, 2016);
        Empresa em = new Empresa();

        if(!nacimiento.equals(contratacion)) {
            em.agregarEmpleado("Juan", "Hernandez", nacimiento, contratacion);
            System.out.println(em.toString());
            em.agregarEmpleado("Marta", "Perez", nacimiento, contratacion);
            System.out.println(em.toString());
            em.agregarEmpleado("Saul", "Aquino", nacimiento, contratacion);
            System.out.println(em.toString());
            em.agregarEmpleado("Maria", "Lopez", nacimiento, contratacion);
            System.out.println(em.toString());
            em.agregarEmpleado("Mercedez", "Umaña", nacimiento, contratacion);
            System.out.println(em.toString());
        }

        /*System.out.println("\n--- Mes siguiente a la fecha de contratacion ---");
        System.out.println("Mes siguiente: " + contratacion.siguienteMes());
        System.out.println("\n--- Anho siguiente a la fecha de contratacion ---");
        System.out.println("Anho siguiente: " + contratacion.siguienteAnho());
        
        System.out.println("\n--- Días siguientes a la fecha de contratacion ---");
        for (int i=contratacion.getDia(); i<=contratacion.getDiasPorMes(); i++) {
            contratacion.siguienteDia();
            System.out.println("Día siguiente: " + empleado.getFechaContratacion());                 //Invoca el método “toString”
        }*/
    }
    
}
