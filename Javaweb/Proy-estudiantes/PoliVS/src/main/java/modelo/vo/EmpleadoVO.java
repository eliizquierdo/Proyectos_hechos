package modelo.vo;

public class EmpleadoVO extends PersonaVO {
    private String categoria;
    private double sueldo;

    public EmpleadoVO(int cedula, String nombre, int telefono, String categoria, double sueldo) {
        super(cedula, nombre, telefono);
        this.categoria = categoria;
        this.sueldo = sueldo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Alumno [ " + super.toString() + "categoria=" + categoria + ", sueldo=" + sueldo + " ]";
    }
}
