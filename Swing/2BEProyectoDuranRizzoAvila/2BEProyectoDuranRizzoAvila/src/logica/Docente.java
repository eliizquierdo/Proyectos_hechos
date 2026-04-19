package logica;
import grafica.*;
import java.util.ArrayList;

import javax.swing.JTextField;
public class Docente {
	private int CId; // Es la clave;
	private String nombre;
	private int telefono;
	private String direccion;
	private String asignatura;
	private Fecha fIng;
	
	
	
	
	public Docente(int CiDo, String NombreDo, int TelefonoDo, String DireccionDo, String Asignatura, Fecha FechaIn) {
		this.CId = CiDo;
		this.nombre = NombreDo;
		this.telefono = TelefonoDo;
		this.direccion = DireccionDo;
		this.asignatura = Asignatura;
		this.fIng = FechaIn;
	}




	public int getCI() {
		return CId;
	}




	public void setCI(int CiDo) {
		CId = CiDo;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String NombreDo) {
		this.nombre = NombreDo;
	}




	public int getTelefono() {
		return telefono;
	}




	public void setTelefono(int TelefonoDo) {
		this.telefono = TelefonoDo;
	}




	public String getDireccion() {
		return direccion;
	}




	public void setDireccion(String DireccionDo) {
		this.direccion = DireccionDo;
	}




	public String getAsignatura() {
		return asignatura;
	}




	public void setAsignatura(String Asignatura) {
		this.asignatura = Asignatura;
	}




	public Fecha getfIng() {
		return fIng;
	}




	public void setfIng(Fecha FechaIn) {
		this.fIng = FechaIn;
	}




	@Override
	public String toString() {
		return "Docente [CI=" + CId + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion
				+ ", asignatura=" + asignatura + ", fIng=" + fIng + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
