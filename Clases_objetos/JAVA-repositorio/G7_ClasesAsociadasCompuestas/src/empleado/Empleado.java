package empleado;

import empleado.Fecha;

/**
 * @date 18/06/2018
 * @author Fredy Kcrez
 */
public class Empleado {
    private String primerNombre, apellidoPaterno;
    private Fecha fechaNacimiento, fechaContratacion;

    //Constructor para inicializar nombre, fecha de nacimiento y fecha de contratación
    Empleado(String nombre, String apellido, Fecha fechaDeNacimiento, Fecha fechaDeContratacion) {
        this.primerNombre = nombre;
        this.apellidoPaterno = apellido;
        this.fechaNacimiento = fechaDeNacimiento;
        this.fechaContratacion = fechaDeContratacion;
    }
    
    //Convierte Empleado a format String
    public String toString() {
        return String.format("%s, %s  Contratado: %s  Cumpleanios: %s", apellidoPaterno, primerNombre, fechaContratacion, fechaNacimiento);
    }
}