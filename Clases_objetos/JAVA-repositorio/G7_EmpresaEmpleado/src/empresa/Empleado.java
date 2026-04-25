package empresa;

import empresa.Fecha;

/**
 * @date 18/06/2018
 * @author Fredy Kcrez
 */
public class Empleado {
    private String primerNombre, apellidoPaterno;
    private Fecha fechaNacimiento, fechaContratacion;
    private static int cantidadEmpleados = 0;

    Empleado() {
        this.cantidadEmpleados++;
    }

    //Constructor para inicializar nombre, fecha de nacimiento y fecha de contratación
    Empleado(String nombre, String apellido, Fecha fechaDeNacimiento, Fecha fechaDeContratacion) {
        this.primerNombre = nombre;
        this.apellidoPaterno = apellido;
        this.fechaNacimiento = fechaDeNacimiento;
        this.fechaContratacion = fechaDeContratacion;
        this.cantidadEmpleados++;
    }
    
    //Convierte Empleado a format String
    public String toString() {
        return String.format("%s, %s  Contratado: %s  Cumpleanios: %s", getApellidoPaterno(), getPrimerNombre(), getFechaContratacion(), getFechaNacimiento());
    }

    /**
     * @return the primerNombre
     */
    public String getPrimerNombre() {
        return primerNombre;
    }

    /**
     * @param primerNombre the primerNombre to set
     */
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return the fechaNacimiento
     */
    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the fechaContratacion
     */
    public Fecha getFechaContratacion() {
        return fechaContratacion;
    }

    /**
     * @param fechaContratacion the fechaContratacion to set
     */
    public void setFechaContratacion(Fecha fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    /**
     * @return the cantidadEmpleados
     */
    public static int getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    /**
     * @param aCantidadEmpleados the cantidadEmpleados to set
     */
    public static void setCantidadEmpleados(int aCantidadEmpleados) {
        cantidadEmpleados = aCantidadEmpleados;
    }
}