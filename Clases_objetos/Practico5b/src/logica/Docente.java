package logica;
//package logica;

public class Docente extends Persona {
	
	
	//Atributos
	private String asignatura;
	private String grupo;
	private Fecha ingreso;
	
	
	//Constructor por defecto
	public Docente() {
		
		super();
		
	}
	
	
	//Constructor especifico
	public Docente(String cedula, String apellido, Fecha nacimento, String asignatura, String grupo, Fecha ingreso) {
		
		super(cedula, apellido, nacimento);
		
		this.asignatura = asignatura;
		this.grupo = grupo;
		this.ingreso = ingreso;
		
	}


	//Getters
	public String getAsignatura() {
		return asignatura;
	}


	public String getGrupo() {
		return grupo;
	}


	public Fecha getIngreso() {
		return ingreso;
	}


	//Setters
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}


	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}


	public void setIngreso(Fecha ingreso) {
		this.ingreso = ingreso;
	}


	//ToString
	@Override
	public String toString() {
		return " Docente: "+ super.toString() + "\nasignatura=" + asignatura + ", grupo=" + grupo + ", ingreso=" + ingreso;
	}
	
	
	//Metodos especificos
	public int grado(Fecha f) {
	
		int grado = 1;
		
		int antiguedad = f.getAnio() - ingreso.getAnio();
		
		
		for (int i = 4; i < antiguedad && grado < 7; i = i + 4) {
			
			grado++;
			
		}
		
		return grado;
		
	}
	
	

}
