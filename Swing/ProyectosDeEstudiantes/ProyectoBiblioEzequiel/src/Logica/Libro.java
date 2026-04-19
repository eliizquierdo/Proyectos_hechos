package Logica;

public class Libro {
	private int isbn,nroPaginas;
	private String edicion;
	private String titulo,editorial,autor,pais;
	
	public Libro() {}

	public Libro(int isbn, String titulo,int nroPaginas, String edicion, String editorial,
			String autor, String pais) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.nroPaginas = nroPaginas;
		this.edicion = edicion;
		this.editorial = editorial;
		this.autor = autor;
		this.pais = pais;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNroPaginas() {
		return nroPaginas;
	}

	public void setNroPaginas(int nroPaginas) {
		this.nroPaginas = nroPaginas;
	}

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "[ Isbn=" + isbn + ", titulo=" + titulo + ", nroPaginas="
				+ nroPaginas + ", edicion=" + edicion + ", editorial=" + editorial + ", autor=" + autor + ", pais="
				+ pais;
	}
	
	
	
}
