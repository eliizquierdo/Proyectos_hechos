package logica;

public class Articulo {
	
	//	----------------Variables----------------
	private int codigo;
	private String nombre;
	private double precioCosto;
	private int unidades;
	
	//	----------------CONSTRUCTORES----------------
	public Articulo(int codigo, String nombre, double precioCosto, int unidades) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precioCosto = precioCosto;
		this.unidades = unidades;
	}
	public Articulo() {
		
	}
		
	//	----------------GETTERS Y SETTERS----------------
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
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
	//	----------------FUNCIONES----------------

	public double precioVenta() {
		return precioCosto + ( precioCosto * 0*10 );
	}

	
}
