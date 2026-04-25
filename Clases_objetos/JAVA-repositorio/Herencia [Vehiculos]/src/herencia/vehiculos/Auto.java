package herencia.vehiculos;

//Clase hija
public class Auto extends Vehiculo //extendes es para que herede de vehiculo
{
    private int kilometraje;
    private int capacidadEstanque;
    
    public Auto(String patente, String marca, int anioFabricacion, int kilometraje, int capacidadEstanque)
    {
        super(patente, marca, anioFabricacion);
        this.kilometraje = kilometraje;
        this.capacidadEstanque = capacidadEstanque;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public int getCapacidadEstanque() {
        return capacidadEstanque;
    }

    public void setCapacidadEstanque(int capacidadEstanque) {
        this.capacidadEstanque = capacidadEstanque;
    }
}
