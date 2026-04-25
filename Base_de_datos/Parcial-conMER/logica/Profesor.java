package logica;

public class Profesor extends Persona {
    private String especialidad;

    public Profesor(String nombre, String ci, String especialidad) {
        super(nombre, ci);
        this.especialidad = especialidad;
    }

    @Override
    public void mostrar() {
        System.out.println("Profesor: [Nombre: " + nombre + ", CI: " + ci + ", Especialidad: " + especialidad + "]");
    }
}