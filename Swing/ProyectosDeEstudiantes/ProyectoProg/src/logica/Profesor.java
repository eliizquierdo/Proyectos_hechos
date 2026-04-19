package logica;

public class Profesor {
private int cI;
private String direccion;
private String nombre;
private Fecha fechaIngreso;
private String asignatura;
public Profesor() {
	
}
public Profesor(int cI, String direccion, String nombre, Fecha fechaIngreso, String asignatura) {
	super();
	cI = cI;
	direccion = direccion;
	this.nombre = nombre;
	this.fechaIngreso = fechaIngreso;
	this.asignatura = asignatura;
}
public int getCI() {
	return cI;
}
public void setCI(int cI) {
	cI = cI;
}
public String getDireccon() {
	return direccion;
}
public void setDireccon(String direccon) {
	direccion = direccon;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Fecha getFechaIngreso() {
	return fechaIngreso;
}
public void setFechaIngreso(Fecha fechaIngreso) {
	this.fechaIngreso = fechaIngreso;
}
public String getAsignatura() {
	return asignatura;
}
public void setAsignatura(String asignatura) {
	this.asignatura = asignatura;
}
@Override
public String toString() {
	return "Profesor [CI=" + cI + ", Direccon=" + direccion + ", nombre=" + nombre + ", fechaIngreso=" + fechaIngreso
			+ ", asignatura=" + asignatura + "]";
}

}
