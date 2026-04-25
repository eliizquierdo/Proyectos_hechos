package ejer2;

public class Docente extends Persona {

	private String asignatura;
	private String grupo;
	
	public Docente() {
		super();
	}

	public Docente(String cedula, String apellido, String asignatura, String grupo) {
		super(cedula, apellido);
		this.asignatura = asignatura;
		this.grupo = grupo;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return super.toString()+" asignatura=" + asignatura + ", grupo=" + grupo;
	}
	
	
	
	
}
