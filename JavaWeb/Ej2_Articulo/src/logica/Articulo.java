package logica;

public class Articulo {
	//atributos
	private int codigo;
	private String nombre ;
	private double precioCosto ;
	
	//constructor por defecto
	public Articulo() {
		//precioCosto=10;
	}
	
	//constructor especifico
	public Articulo(int cod, String nom, double pre) {
		codigo=cod;
		nombre=nom;
		precioCosto=pre;
	}
	
	//get-obtener  set-asignar
	//getter  setter
	//metodos get
	public int getCodigo() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getPrecioCosto() {
		return precioCosto;
	}
	
	//metodos setter
	public void setCodigo(int cod) {
		codigo=cod;
	}
	
	public void setNombre(String nom) {
		nombre=nom;
	}
	
	public void setPrecioCosto(double pre) {
		precioCosto=pre;
	}
	
	//metodos específicos
	public double precioVenta() {
		return (precioCosto*0.20+precioCosto);
		
	}
	
	//metodo toString
	public String toString() {
		return "codigo: "+codigo +" nombre: "+ nombre +" "
				+ "precio de costo: "+ precioCosto + 
				" precio de venta es: "+this.precioVenta();
	}
	
	
	
	
	

}
