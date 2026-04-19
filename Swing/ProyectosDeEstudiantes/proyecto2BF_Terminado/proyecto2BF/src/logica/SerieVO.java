package logica;

public class SerieVO extends ContenidoVO{

	 /*
	 la clase Serie hereda de la clase contenido
	 tiene atributos propios: capitulos y temporadas, ambos son INT
	 */
	
	private String capitulos;
	private String temporadas;
	
	public SerieVO() {
		
	}//DEFECTO

	public SerieVO(String nombre, String descripcion, String genero, String capitulos, String temporadas) {
		super(nombre, descripcion, genero);
		this.capitulos = capitulos;
		this.temporadas = temporadas;
	}

	public String getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(String capitulos) {
		this.capitulos = capitulos;
	}

	public String getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(String temporadas) {
		this.temporadas = temporadas;
	}

	
	
}
