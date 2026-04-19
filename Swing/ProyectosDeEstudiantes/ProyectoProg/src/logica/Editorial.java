package logica;

public class Editorial {

	private String editorial;
	private Fecha fechaEditorial;
	
	public Editorial () {
		
	}

	public Editorial(String editorial, Fecha fechaEditorial) {
		super();
		this.editorial = editorial;
		this.fechaEditorial = fechaEditorial;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Fecha getFechaEditorial() {
		return fechaEditorial;
	}

	public void setFechaEditorial(Fecha fechaEditorial) {
		this.fechaEditorial = fechaEditorial;
	}

	@Override
	public String toString() {
		return "Editorial [editorial=" + editorial + "]";
	}
		
}
