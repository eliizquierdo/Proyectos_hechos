package herencia.vehiculos;

//Clase padre
public abstract class Vehiculo
{
    protected String patente;
    protected String marca;
    protected int anioFabricacion;

    public Vehiculo(String patente, String marca, int anioFabricacion)
    {
        this.setPatente(getPatente());
        this.setMarca(getMarca());
        this.setAnioFabricacion(getAnioFabricacion());
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }   
}
