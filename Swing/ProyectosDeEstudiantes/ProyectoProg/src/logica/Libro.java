package logica;

public class Libro {

	private int codigoisbn;
	private String titulo;
	private int cantLibros;
	private int nroPaginas;
	private Autor nombre;
	private Editorial editorial;
	
	public Libro () {
		
	}

	public Libro(int codigoisbn, String titulo, int cantLibros, int nroPaginas, Autor nombre, Editorial editorial) {
		super();
		this.codigoisbn = codigoisbn;
		this.titulo = titulo;
		this.cantLibros = cantLibros;
		this.nroPaginas = nroPaginas;
		this.nombre = nombre;
		this.editorial = editorial;
	}

	public int getCodigoisbn() {
		return codigoisbn;
	}

	public void setCodigoisbn(int codigoisbn) {
		this.codigoisbn = codigoisbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getCantLibros() {
		return cantLibros;
	}

	public void setCantLibros(int cantLibros) {
		this.cantLibros = cantLibros;
	}

	public int getNroPaginas() {
		return nroPaginas;
	}

	public void setNroPaginas(int nroPaginas) {
		this.nroPaginas = nroPaginas;
	}

	public Autor getNombre() {
		return nombre;
	}

	public void setNombre(Autor nombre) {
		this.nombre = nombre;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Libro [codigoisbn=" + codigoisbn + ", titulo=" + titulo + ", cantLibros=" + cantLibros + ", nroPaginas="
				+ nroPaginas + "]";
	}
	
}
