package modelo.vo;

public class ProfesorVO extends PersonaVO {
    private String especialidad;

    public ProfesorVO(int cedula, String nombre, int telefono, String especialidad) {
        super(cedula, nombre, telefono);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Profesor [ " + super.toString() + "especialidad=" + especialidad + " ]";
    }
}
