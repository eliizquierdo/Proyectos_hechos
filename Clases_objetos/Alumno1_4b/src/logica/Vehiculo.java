package logica;
public class Vehiculo {
    private String marca;
    private String modelo;
    private double precioBase;
    private Fecha fechaFabricacion;

    public Vehiculo(String marca, String modelo, double precioBase, Fecha fechaFabricacion) {
        this.marca = marca;
        this.modelo = modelo;
        this.precioBase = precioBase;
        this.fechaFabricacion = fechaFabricacion;
    }

    public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public Fecha getFechaFabricacion() {
		return fechaFabricacion;
	}

	public void setFechaFabricacion(Fecha fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}

	public double calcularPrecio() {
        return precioBase;
    }

    public double descuentoNeto() {
        return calcularPrecio();
    }

	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", precioBase=" + precioBase + ", fechaFabricacion="
				+ fechaFabricacion + "]";
	}

    
}



	