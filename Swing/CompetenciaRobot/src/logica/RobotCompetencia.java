package logica;

public class RobotCompetencia extends Robot {
    private double velocidadMaxima;
    private String categoria;

    public RobotCompetencia(String id, String nombre, String fabricante, int anioConstruccion, double velocidadMaxima, String categoria) {
        super(id, nombre, fabricante, anioConstruccion);
        this.velocidadMaxima = velocidadMaxima;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return super.toString() + ", Velocidad máxima: " + velocidadMaxima + "m/s, Categoría: " + categoria;
    }
}
