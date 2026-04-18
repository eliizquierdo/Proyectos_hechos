package modelo.vo;

public class PersonaVO {
    private int cod;
    private String nombre;

    public PersonaVO(int cod, String nombre) {
        this.cod = cod;
        this.nombre = nombre;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "PersonaVO [cod=" + cod + ", nombre=" + nombre + "]";
    }

}
