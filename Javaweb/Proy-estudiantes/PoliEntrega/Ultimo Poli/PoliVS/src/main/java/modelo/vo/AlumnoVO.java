package modelo.vo;

public class AlumnoVO extends PersonaVO{
    private int edad;
    private String calle;
    private int nro;

    public AlumnoVO(int cedula, String nombre, int telefono, int edad, String calle, int nro) {
        super(cedula, nombre, telefono);
        this.edad = edad;
        this.calle = calle;
        this.nro = nro;
    }

    public int getedad() {
        return edad;
    }
    public void setedad(int edad) {
        this.edad = edad;
    }
    public String getcalle() {
        return calle;
    }
    public void setcalle(String calle) {
        this.calle = calle;
    }
    public int getnro() {
        return nro;
    }
    public void setnro(int nro) {
        this.nro = nro;
    }

    @Override
    public String toString() {
        return "Alumno [ " + super.toString() + "edad=" + edad + ", calle=" + calle + ", nro=" + nro + " ]";
    }
}
