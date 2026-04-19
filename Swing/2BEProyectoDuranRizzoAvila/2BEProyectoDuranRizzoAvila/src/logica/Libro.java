package logica;
import grafica.*;
public class Libro {
	private int iD; // Es la clave;
	private String titulo;
	private int copias;
	private int paginas;
	private String autor;
	private String pais;
	private String editorial;
	private Fecha fEdit;
	
	
	public Libro(int Id, String Titulo, int Copias, int Paginas, String Autor, String Pais, String Editorial, Fecha FechaEd) {
		this.iD = Id;
		this.titulo = Titulo;
		this.copias = Copias;
		this.paginas = Paginas;
		this.autor = Autor;
		this.pais = Pais;
		this.editorial = Editorial;
		this.fEdit = FechaEd;
	}


	public int getiD() {
		return iD;
	}


	public void setiD(int iD) {
		this.iD = iD;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public int getCopias() {
		return copias;
	}


	public void setCopias(int copias) {
		this.copias = copias;
	}


	public int getPaginas() {
		return paginas;
	}


	public void setPaginas(int paginas) {
		this.paginas = paginas;
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


	public String getEditorial() {
		return editorial;
	}


	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}


	public Fecha getfEdit() {
		return fEdit;
	}


	public void setfEdit(Fecha fEdit) {
		this.fEdit = fEdit;
	}


	@Override
	public String toString() {
		return "Libro [iD=" + iD + ", titulo=" + titulo + ", copias=" + copias + ", paginas=" + paginas + ", autor="
				+ autor + ", pais=" + pais + ", editorial=" + editorial + ", fEdit=" + fEdit + "]";
	}
	
	

	
	
	
	
	
	
	
}
