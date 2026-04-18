package logica.clasesDePersona;

//---------------IMPORTS-------------------
import logica.*;

public class Empleado extends Persona{
	
	//----------------Variables--------------
	private Fecha antiguedad;
	private int categoria;

	
	//-----------------CONSTRUCTORES_----------------
	public Empleado(String cedula, String apellido, Fecha antiguedad, int categoria) {
		super(cedula, apellido);
		this.antiguedad = antiguedad;
		this.categoria = categoria;
	}


	//-----------------GETTERS y SETTERS------------------
	public Fecha getAntiguedad() {
		return antiguedad;
	}


	public void setAntiguedad(Fecha antiguedad) {
		this.antiguedad = antiguedad;
	}


	public int getCategoria() {
		return categoria;
	}


	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	
	
}
