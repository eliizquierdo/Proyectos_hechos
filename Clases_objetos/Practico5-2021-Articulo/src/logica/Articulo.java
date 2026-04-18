package logica;


public class Articulo {
		
	private int codigo;
	private String nombre;
	private double precioCosto;
		
	public Articulo() {
			
	}
		
	public Articulo(int codigo, String nombre, double precioCosto) {
			this.codigo = codigo;
			this.nombre = nombre;
			this.precioCosto = precioCosto;
	}
		
		

	public int getCodigo() {
			return codigo;
	}

	public void setCodigo(int codigo) {
			this.codigo = codigo;
	}

	public String getNombre() {
			return nombre;
	}

	public void setNombre(String nombre) {
			this.nombre = nombre;
	}

	public double getPrecioCosto() {
			return precioCosto;
	}

	public void setPrecioCosto(double precioCosto) {
			this.precioCosto = precioCosto;
	}
		
	/////////////////////////////////////////////

		public double precioVenta() {
			double precioVenta;
			precioVenta = precioCosto + (precioCosto*20/100);
			return precioVenta;
		}
		
				
		public String toString() {
			return "Codigo: " + codigo + "\nNombre: " + nombre + "\nPrecio de venta: " + precioVenta();
		}
}
