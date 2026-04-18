package logica;

public class Alumno {
	private int cedula;
	private String nombre;
	private double cuota;
	
	public Alumno(int cedula, String nombre, double cuota) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.cuota = cuota;
	}

	public Alumno() {
		
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	@Override
	public String toString() {
		return "Alumno [cedula=" + cedula + ", nombre=" + nombre + "cuota="+ cuota+ "]";
	}
	
	//retorna el cuota aumentada un 10%
	public double precioCuota() {
		return (cuota+ cuota*0.10);
		
	}
	
	
	
	
}
