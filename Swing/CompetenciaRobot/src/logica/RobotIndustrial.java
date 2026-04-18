package logica;

public class RobotIndustrial extends Robot {
    private int capacidadCarga;
    private double energiaConsumida;

    public RobotIndustrial(String id, String nombre, String fabricante, int anioConstruccion, int capacidadCarga, double energiaConsumida) {
        super(id, nombre, fabricante, anioConstruccion);
        this.capacidadCarga = capacidadCarga;
        this.energiaConsumida = energiaConsumida;
    }

    @Override
    public String toString() {
        return super.toString() + ", Capacidad de carga: " + capacidadCarga + "kg, Energía consumida: " + energiaConsumida + "kWh";
    }
}


