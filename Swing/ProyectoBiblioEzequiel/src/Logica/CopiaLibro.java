package Logica;

public class CopiaLibro extends Libro{
	
	private String estado;
	private int cantCopias;
	
	public CopiaLibro() {}

	public CopiaLibro(int isbn, String titulo,int nroPaginas, String edicion, String editorial,
			String autor, String pais,String estado,int cantCopias) {
		super(isbn, titulo, nroPaginas, edicion, editorial, autor, pais);
		this.estado=estado;
		this.cantCopias=cantCopias;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCantCopias() {
		return cantCopias;
	}

	public void setCantCopias(int cantCopias) {
		this.cantCopias = cantCopias;
	}
	
	@Override
	public String toString() {
		return super.toString()+", estado="+estado+", cantidad de copias="+cantCopias;
	}
}
