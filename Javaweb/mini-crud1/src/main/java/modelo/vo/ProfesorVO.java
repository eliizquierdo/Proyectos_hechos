package modelo.vo;

public class ProfesorVO extends PersonaVO {
    private String especialidad;

    public ProfesorVO() {
    }

    public ProfesorVO(int cedula, String nombre, String especialidad) {
        super(cedula, nombre);
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
        return "ProfesorVO" + super.toString() + "[especialidad=" + especialidad + "]";
    }
}
