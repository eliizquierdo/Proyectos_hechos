package logica;

public class Robot {
	
	private int id;
	private String nombre;
	private int anio;
	
	
	public Robot() {
		super();
	}
	
	public Robot(int id, String nombre, int anio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.anio = anio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return id + "\t" +
			   nombre + "\t" +
			   anio
			   ;
	}
	

}
