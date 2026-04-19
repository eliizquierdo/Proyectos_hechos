package logica;

public class Prestamo {

	private Fecha fechaPrestamo;
	private Fecha fechaDevolucion;

public Prestamo() {
	
}

public Prestamo(Fecha fechaPrestamo, Fecha fechaDevolucion) {
	super();
	this.fechaPrestamo = fechaPrestamo;
	this.fechaDevolucion = fechaDevolucion;
}

public Fecha getFechaPrestamo() {
	return fechaPrestamo;
}

public void setFechaPrestamo(Fecha fechaPrestamo) {
	this.fechaPrestamo = fechaPrestamo;
}

public Fecha getFechaDevolucion() {
	return fechaDevolucion;
}

public void setFechaDevolucion(Fecha fechaDevolucion) {
	this.fechaDevolucion = fechaDevolucion;
}

@Override
public String toString() {
	return "Prestamo [fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + "]";
}

}
