package modelo.vo;

public class PersonaVO {
    private int cod;
    private String nombre;
    private String apellido;

    public PersonaVO() {

    }

    public PersonaVO(int cod, String nombre, String apellido) {
        this.cod = cod;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getCodigo() {
        return cod;
    }

    public void setCodigo(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "PersonaVO{" + "cod=" + cod + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }

}
