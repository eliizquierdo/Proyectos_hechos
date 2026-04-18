package logica;

public class Empleado {
 private double nroEmpleado;
 private String apellido;
 private String nombre;
 private double jornal;
 private int dias;

 //constructor por defecto
 public Empleado() {
	 
 }

 //constructor especifico
public Empleado(double nroEmpleado, String apellido, String nombre, double jornal, int dias) {
	this.nroEmpleado = nroEmpleado;
	this.apellido = apellido;
	this.nombre = nombre;
	this.jornal = jornal;
	this.dias = dias;
}

public double getNroEmpleado() {
	return nroEmpleado;
}

public void setNroEmpleado(double nroEmpleado) {
	this.nroEmpleado = nroEmpleado;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public double getJornal() {
	return jornal;
}

public void setJornal(double jornal) {
	this.jornal = jornal;
}

public int getDias() {
	return dias;
}

public void setDias(int dias) {
	this.dias = dias;
}

@Override
public String toString() {
	return "Empleado [nroEmpleado=" + nroEmpleado + ", apellido=" + apellido + ", nombre=" + nombre + ", jornal="
			+ jornal + ", dias=" + dias + "]";
}
 
 
//metodo específico sueldo
public double sueldo() {
	double sldo = jornal*dias;
	return sldo;
}
 
 
 
 
 
}