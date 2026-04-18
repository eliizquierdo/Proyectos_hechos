package logica;

public class Canal {
private int numero;
private String nombre;
private String tematica;

public Canal() {
	
}

public Canal(int numero, String nombre, String tematica) {
	super();
	this.numero = numero;
	this.nombre = nombre;
	this.tematica = tematica;
}

public int getNumero() {
	return numero;
}

public void setNumero(int numero) {
	this.numero = numero;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getTematica() {
	return tematica;
}

public void setTematica(String tematica) {
	this.tematica = tematica;
}

@Override
public String toString() {
	return "Canal [numero=" + numero + ", nombre=" + nombre + ", tematica=" + tematica + "]";
}

}
