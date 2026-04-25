package herencia.vehiculos;

public class Controlador
{
    ListadoVehiculos listaVehiculos;
    
    public Controlador()
    {
        this.listaVehiculos = new ListadoVehiculos();
    }
    
    public String agregarAuto(String patente, String marca, int anioFabricacion, int kilometraje, int capacidadEstanque)
    {
        Vehiculo v = new Auto(patente, marca, anioFabricacion, kilometraje, capacidadEstanque);
        return this.listaVehiculos.agregar(v);
    }
    
    public String agregarCamioneta(String patente, String marca, int anioFabricacion, int capacidadCarga)
    {
        Vehiculo v = new Camioneta(patente, marca, anioFabricacion, capacidadCarga);
        return this.listaVehiculos.agregar(v);
    }
    
    public String imprimirListadoVehiculosIngresados()
    {
        String s = "";
        return s;
    }
}