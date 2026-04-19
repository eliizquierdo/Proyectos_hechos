package logica;

public class Empleado extends Persona{
	private Fecha antiguedad;
	private String categoria;

	public Empleado(Fecha f,String categoria ,String c,String a){
		super(c,a);
		antiguedad=f;
		categoria=categoria;
	}

	public Fecha getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(Fecha antiguedad) {
		this.antiguedad = antiguedad;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return super.toString() + "Empleado [antiguedad=" + antiguedad + ", categoria=" + categoria +  "]";
	}


}

