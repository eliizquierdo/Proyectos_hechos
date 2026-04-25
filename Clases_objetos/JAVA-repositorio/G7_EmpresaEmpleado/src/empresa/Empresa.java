package empresa;

import java.util.Vector;

/**
 * @date 27/06/2018
 * @author Fredy Kcrez
 */
public class Empresa {
    // Utilizando un objeto vector para almacenar a los empleados
    Vector<Empleado> empleados = new Vector<Empleado>();
    
    public void agregarEmpleado(String nombre, String apellido, Fecha fechaDeNacimiento, Fecha fechaDeContratacion) {
        Empleado empl = new Empleado(nombre, apellido, fechaDeNacimiento, fechaDeContratacion);
        empleados.add(empl);
    }
    
    private int getCantidadEmpleados() {
        return this.empleados.size();
    }
    
    public String toString() {
        return "Cantidad de empleados: " + this.getCantidadEmpleados();
    }
}