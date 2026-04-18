package logica;

public class Publicacion {

	private String titulo;
	private String autor;
	private int anio;

	public Publicacion() {

	}

	public Publicacion(String titulo, String autor, int anio) {
		this.titulo = titulo;
		this.autor = autor;
		this.anio = anio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public void mostrarInfo() {
		System.out.println("Titulo: " + titulo);
		System.out.println("Autor: " + autor);
		System.out.println("Año: " + anio);
	}
}