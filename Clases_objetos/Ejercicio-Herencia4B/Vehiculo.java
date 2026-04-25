
public class Vehiculo {
	private String marca;
	private double precio;
	private String matricula;
	private Fecha fechaCompra;
	
	public Vehiculo() {}

	public Vehiculo(String marca, double precio, String matricula, Fecha fechaCompra) {
		this.marca = marca;
		this.precio = precio;
		this.matricula = matricula;
		this.fechaCompra = fechaCompra;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
    }
    
	public Fecha getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Fecha fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public double descontarPatente() {
		double monto = 0;
		
		if(precio > 10000)
			monto = precio * 0.10; 
	    	return monto;
	}
	
	public double descuentoNeto(Fecha f) {
		double descNet = 0;
		
		if(f.getAnio() < 2010) 
			descNet = precio * 0.20;
		return precio - descNet;
	}

	@Override
	public String toString() {
		return String.format("Marca: %s\nPrecio: %s\nMatricula: %s\nFecha de compra: %s", marca, precio,
				matricula, fechaCompra);
	}
}