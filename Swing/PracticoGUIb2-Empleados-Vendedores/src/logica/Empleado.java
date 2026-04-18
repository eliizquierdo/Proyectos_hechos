package logica;

public class Empleado {
	//atributos
	private String apellido;
	private String nombre;
	private double jornal;
	private int dias;
	public Empleado(String apellido, String nombre, double jornal, int dias) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.jornal = jornal;
		this.dias = dias;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getJornal() {
		return jornal;
	}
	public void setJornal(double jornal) {
		this.jornal = jornal;
	}
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	@Override
	public String toString() {
		return "Empleado [apellido=" + apellido + ", nombre=" + nombre + ", jornal=" + jornal + ", dias=" + dias + "]";
	}

	public double sueldo() {
		return jornal*dias;
	}

}
