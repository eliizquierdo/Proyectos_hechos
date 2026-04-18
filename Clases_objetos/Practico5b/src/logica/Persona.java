package logica;

//package logica;

public class Persona {
	
	
	//Atributos
	private String cedula;
	private String apellido;
	private Fecha nacimiento;
	
	
	//Constructor por defecto
	public Persona() {
		
	}
	
	
	//Constructor especifico
	public Persona(String cedula, String apellido, Fecha nacimiento) {
		
		this.cedula = cedula;
		this.apellido = apellido;
		this.nacimiento = nacimiento;
		
	}
	

	//Getters
	public String getCedula() {
		return cedula;
	}


	public String getApellido() {
		return apellido;
	}


	public Fecha getNacimiento() {
		return nacimiento;
	}


	//Setters
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public void setNacimiento(Fecha nacimiento) {
		this.nacimiento = nacimiento;
	}

	
	//ToString
	@Override
	public String toString() {
		return "cedula=" + cedula + ", apellido=" + apellido + ", nacimiento=" + nacimiento ;
	}

	
}
