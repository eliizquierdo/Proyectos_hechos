package modelo.vo;

public class AlumnoVO extends PersonaVO {
    private int edad;
    private String calle;
    private int nro;

    public AlumnoVO(int cedula, String nombre, int telefono, int edad, String calle, int nro) {
        super(cedula, nombre, telefono);
        this.edad = edad;
        this.calle = calle;
        this.nro = nro;
    }

    public int getEdad() {
        return edad;
    }

    public String getCalle() {
        return calle;
    }

    public int getNro() {
        return nro;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

}