package logica;

public class Alumno extends Persona {
    private String actividad;
    private int edad;
    private String alergia;
    private String medicacion;
    private boolean fichaMedica;

    public Alumno(String nombre, String ci, String actividad, int edad, String alergia, String medicacion, boolean fichaMedica) {
        super(nombre, ci);
        this.actividad = actividad;
        this.edad = edad;
        this.alergia = alergia;
        this.medicacion = medicacion;
        this.fichaMedica = fichaMedica;
    }

    public String getActividad() {
        return actividad;
    }

    @Override
    public void mostrar() {
        System.out.println("Alumno: [Nombre: " + nombre + ", CI: " + ci + ", Actividad: " + actividad +
            ", Edad: " + edad + ", Alergia: " + alergia + ", Medicación: " + medicacion +
            ", Ficha Médica: " + (fichaMedica ? "Sí" : "No") + "]");
    }
}
