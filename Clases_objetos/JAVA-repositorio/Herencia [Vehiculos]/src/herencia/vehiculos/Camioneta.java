package herencia.vehiculos;

public class Camioneta extends Vehiculo //extendes es para que herede de vehiculo
{
    private int capacidadCarga;
    
    public Camioneta(String patente, String marca, int anioFabricacion, int capacidadCarga)
    {
        super(patente, marca, anioFabricacion);
        this.capacidadCarga = capacidadCarga;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
}
