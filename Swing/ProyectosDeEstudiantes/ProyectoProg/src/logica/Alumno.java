package logica;

public class Alumno {
	private int cI;
	private String direccon;
	private String nombre;
	private int grupo;
	private int edad;
	private Fecha fechaNac;
	public Alumno() {
		
	}
	public Alumno(int cI, String direccon, String nombre, int grupo, int edad, Fecha fechaNac) {
		super();
		this.cI = cI;
		this.direccon = direccon;
		this.nombre = nombre;
		this.grupo = grupo;
		this.edad = edad;
		this.fechaNac = fechaNac;
	}
	public int getcI() {
		return cI;
	}
	public void setcI(int cI) {
		this.cI = cI;
	}
	public String getDireccon() {
		return direccon;
	}
	public void setDireccon(String direccon) {
		this.direccon = direccon;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getGrupo() {
		return grupo;
	}
	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Fecha getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Fecha fechaNac) {
		this.fechaNac = fechaNac;
	}
	@Override
	public String toString() {
		return "Alumno [cI=" + cI + ", direccon=" + direccon + ", nombre=" + nombre + ", grupo=" + grupo + ", edad="
				+ edad + ", fechaNac=" + fechaNac + "]";
	}
	
}
