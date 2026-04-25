package ejer2;

public class Persona {
	
	private String cedula;
	private String apellido;
	
	public Persona() {
		
	}

	public Persona(String cedula, String apellido) {
		this.cedula = cedula;
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "cedula=" + cedula + ", apellido=" + apellido;
	}
	
	
	
	
}
