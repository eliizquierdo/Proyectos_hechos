package logica;

public class RobotCompetencia extends Robot{
    private double velocidad;

    public RobotCompetencia(int id, String nombre, int anio, double velocidad) {
        super(id, nombre, anio);
        this.velocidad = velocidad;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return velocidad + "\tt" + super.getId() + "\tt" + super.getNombre() + "\tt" + super.getAnio() + "\n";
    }


}
//Luciano Herrera y Danison Bravo