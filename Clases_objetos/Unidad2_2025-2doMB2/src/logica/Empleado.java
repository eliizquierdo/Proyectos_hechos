package logica;

public class Empleado {
	private String cedula;
	private String nombre;
	private int edad;
	private double sueldo;
	private Direccion domicilio;
	
	public Empleado(String cedula, String nombre, int edad, double sueldo, Direccion domicilio) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
		this.domicilio = domicilio;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public Direccion getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(Direccion domicilio) {
		this.domicilio = domicilio;
	}
	@Override
	public String toString() {
		return "cedula=" + cedula + ", nombre=" + nombre + ", edad=" + edad + ", sueldo=" + sueldo
				 + " y domicilio= "+domicilio;
	}

	//faltan los métodos especificos
	
	
}
