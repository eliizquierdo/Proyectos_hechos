package logica;

import logica.*;

public class Libro{
	private String nombre;
	private Autor suAutor;
	private int paginas;
	private double prec;
	private double div;
	private double cant;
	
	public Libro(String nombre, Autor suAutor, int paginas) {
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


	public Autor getSuAutor() {
		return suAutor;
	}


	public void setSuAutor(Autor suAutor) {
		this.suAutor = suAutor;
	}


	public int getPaginas() {
		return paginas;
	}


	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}


public double precio() {
		double div =getPaginas()/50;
		double cant = 100*div;
		if (suAutor.getPais().equals("Uruguay"))
			return  cant-(cant*0.20);
		else 
			return cant;
}
@Override
public String toString() {
	return "Libro [nombre=" + nombre + ", suAutor=" + suAutor + ", paginas=" + paginas + "]";
}
}