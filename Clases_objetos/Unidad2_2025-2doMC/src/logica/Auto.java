package logica;
public class Auto {
	//atributos
	private String marca;
	private int precio;
	
	//constructor por defecto
	public Auto() {
		
	}
	
	//constructor especifico
	public Auto(String m, int p) {
		marca = m;
		precio = p;
	}
	
	//metodos
	public void setMarca(String m) {
		marca = m;		
	}
	
	public void setPrecio(int p) {
		precio = p;
		
	}
	
	public String getMarca() {
		return marca;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	@Override
	public String toString() {
		return "marca: "+ marca+
				"precio: "+precio;
		
	}
	
	public void arrancar() {
		System.out.println("arranqué");
	}
	
	public void frenar() {
		System.out.println("Frené");
	}
	
}

