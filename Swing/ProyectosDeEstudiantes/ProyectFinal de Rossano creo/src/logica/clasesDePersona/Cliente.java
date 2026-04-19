package logica.clasesDePersona;

//---------------IMPORTS-------------------
import logica.*;

public class Cliente extends Persona{
	
	//----------------Variables--------------
	private boolean preferencial;

	//---------------CONSTRUCOTRES--------------
	public Cliente(String cedula, String apellido, boolean preferencial) {
		super(cedula, apellido);
		this.preferencial = preferencial;
	}

	//----------------GETTERS Y SETTERS----------------------
	public boolean isPreferencial() {
		return preferencial;
	}

	public void setPreferencial(boolean preferencial) {
		this.preferencial = preferencial;
	}
	
	
	
	
	
}
