package logica;

public class Copia {
private String titulo;
private int cantCopias;
private String estado;
public Copia() {
	
}
public Copia(String titulo, int cantCopias, String estado) {
	super();
	this.titulo = titulo;
	this.cantCopias = cantCopias;
	this.estado = estado;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public int getCantCopias() {
	return cantCopias;
}
public void setCantCopias(int cantCopias) {
	this.cantCopias = cantCopias;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
@Override
public String toString() {
	return "Copia [titulo=" + titulo + ", cantCopias=" + cantCopias + ", estado=" + estado + "]";
}

}
