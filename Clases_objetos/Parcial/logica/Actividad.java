package logica;

public class Actividad implements Gestionable {
    private String nombre;
    private String codigo;
    private String profesor;
    private int cupo;

    public Actividad(String nombre, String codigo, String profesor, int cupo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.profesor = profesor;
        this.cupo = cupo;
    }

    @Override
    public String getId() {
        return codigo;
    }

    @Override
    public void mostrar() {
        System.out.println("Actividad [Nombre: " + nombre + ", Código: " + codigo + ", Profesor: " + profesor + ", Cupo: " + cupo + "]");
    }
}
