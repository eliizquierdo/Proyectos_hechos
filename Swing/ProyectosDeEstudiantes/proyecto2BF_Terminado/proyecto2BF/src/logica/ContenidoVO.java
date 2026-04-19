package logica;



public class ContenidoVO {


	private static String nombre;
	private String descripcion;
	private String genero;

	
	public ContenidoVO () {
		
	}//DEFECTO

	public ContenidoVO(String nombre, String descripcion, String genero) {
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.genero = genero;

	}//ESPECIFICO

	//COMIENZA GETTERS AND SETTERS
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}//TERMINAN GETTERS AND SETTERS

	
	@Override
	public String toString() {
		return "Contenido [descripcion=" + descripcion + ", nombre=" + nombre + ", genero=" + genero + "]";
	}
	
	
	
	
	
	
	
}
