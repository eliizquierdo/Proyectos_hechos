package paquete;

public class Libro {
	private String nombre;
	private String suAutor;
	private int paginas;
	
	public Libro() {
		
	}
	
	
	public Libro(String nombre, String suAutor, int paginas) {
		this.nombre = nombre;
		this.suAutor = suAutor;
		this.paginas = paginas;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getSuAutor() {
		return suAutor;
	}


	public void setSuAutor(String suAutor) {
		this.suAutor = suAutor;
	}


	public int getPaginas() {
		return paginas;
	}


	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}


	@Override
	public String toString() {
		return "nombre=" + nombre + ", suAutor=" + suAutor + ", paginas=" + paginas;
	}
	
	public double precio() {
		
		double pre=50;
		pre=pre+this.paginas/50*100;
		return pre;
	}
	
	

}
