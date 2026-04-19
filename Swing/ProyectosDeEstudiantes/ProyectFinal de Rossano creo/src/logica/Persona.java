package logica;

public class Persona {
	
	//	----------------Variables----------------
	private String cedula;
	private String apellido;

	//	----------------CONSTRUCTORES----------------
	public Persona(String cedula, String apellido) {
		super();
		this.cedula = cedula;
		this.apellido = apellido;
	}

	//	----------------GETTERS Y SETTERS----------------
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
			
}
