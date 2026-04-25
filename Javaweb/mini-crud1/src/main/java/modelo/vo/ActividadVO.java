package modelo.vo;

public class ActividadVO {
    private int idActividad;
    private String nombre;
    private String dia;
    private String hora;

    public ActividadVO() {
    }

    public ActividadVO(int idActividad, String nombre, String dia, String hora) {
        this.idActividad = idActividad;
        this.nombre = nombre;
        this.dia = dia;
        this.hora = hora;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "ActividadVO  idActividad: " + idActividad + ", nombre: " + nombre + ", dia: " + dia + ", hora: " + hora;
    }
}
