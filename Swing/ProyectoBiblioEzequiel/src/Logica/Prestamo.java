package Logica;

public class Prestamo {
	private String fechaPrestamo;
	private String fechaDevolucion;
	private int isbn;
	private int ci;
	
	public Prestamo() {
		
	}
	public Prestamo(int isbn,int ci,String fechaPrestamo,String fechaDevolucion) {
		this.isbn=isbn;
		this.ci=ci;
		this.fechaPrestamo=fechaPrestamo;
		this.fechaDevolucion=fechaDevolucion;
		
	}
	
	public String getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public String getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(String fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getCi() {
		return ci;
	}
	public void setCi(int ci) {
		this.ci = ci;
	}
	@Override
	public String toString() {
		return "[Isbn=" + isbn +", ci=" + ci +", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + "]";
	}
	
	
	
	
}
