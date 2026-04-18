package consola;

import logica.*;

public class PrincipalEmpleados {
    public static void main(String[] args) {
    	Direccion dir1= new Direccion("Paraguay", 23,"La Paz");
    	Direccion dir2= new Direccion("Perú", 123,"Las Piedras");
        Empleado empleado1 = new Empleado("Juan", 30000, dir1);
        Vendedor vendedor1 = new Vendedor("María", 25000, dir2, 0.1, 50);
        
        Empleados listaEmpleados = new Empleados();
        listaEmpleados.agregar(empleado1);
        listaEmpleados.agregar(vendedor1);
        
        System.out.println("Total de salarios: " + listaEmpleados.obtenerTotalSalarios());
        
        if (vendedor1 instanceof Vendedor) {
            System.out.println("Comisión total de María (Vendedor): " + vendedor1.calcularComision());
        }
    }
}
