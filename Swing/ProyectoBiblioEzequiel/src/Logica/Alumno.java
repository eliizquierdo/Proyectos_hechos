package Logica;

public class Alumno extends Socio{
	private int edad;
	private String fechaNacimiento;
	private String grupo;
	
	public Alumno(){}

	public Alumno(int ci, String nombre, String direccion, String telefono,int edad,String fechaNacimiento,String grupo) {
		super(ci, nombre, direccion, telefono);
		this.edad=edad;
		this.fechaNacimiento=fechaNacimiento;
		this.grupo=grupo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	@Override
	public String toString() {
		return super.toString()+", edad="+edad+", fecha de nacimiento="+fechaNacimiento+", grupo="+grupo+ "]";
	}
}
