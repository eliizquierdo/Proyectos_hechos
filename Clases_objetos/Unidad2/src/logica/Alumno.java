package logica;

public class Alumno {
	 String nombre;
	 int codigo;
	 String grupo;
	 float cuotaBase;
	
	//constructor por defecto
	public Alumno() {
		cuotaBase=20000;
	}
	
	//constructor especifico
	public Alumno(String nom, int cod, String gru, float cBase) {
		nombre=nom;
		codigo=cod;
		grupo=gru;
		cuotaBase=cBase;		
	}
	
	public void setNombre(String nom) {
		nombre=nom;
	}
	
	public void setCodigo(int cod) {
		codigo=cod;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	
	
	
	

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre +
				", codigo=" + codigo +
				", grupo=" + grupo + 
				", cuotaBase=" + cuotaBase
				+ "]";
	}
	
	
	
	

}
