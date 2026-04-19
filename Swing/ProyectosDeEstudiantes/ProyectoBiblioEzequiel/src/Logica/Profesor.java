package Logica;

public class Profesor extends Socio{
	private String asignatura;
	private	String fechaIngreso;
	
	public Profesor() {}

	public Profesor(int ci, String nombre, String direccion, String telefono,String asignatura, String fechaIngreso) {
		super(ci, nombre, direccion, telefono);
		this.asignatura = asignatura;
		this.fechaIngreso = fechaIngreso;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return super.toString()+" asignatura=" + asignatura + ", fechaIngreso=" + fechaIngreso + "]";
	}
	

	
}
