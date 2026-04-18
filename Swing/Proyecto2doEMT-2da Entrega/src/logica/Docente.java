package logica;

public class Docente extends Socios{

	private String asignatura;

	public Docente() {
		super();
		this.asignatura= " ";
	}

	public Docente(int cedula, String nombre, String apellido, String direccion, int telefono, String asignatura) {
		super(cedula, nombre, apellido,  direccion, telefono);
		this.asignatura= asignatura;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	
	@Override
	public void pedirDatos(){
		
		super.pedirDatos();
		
		System.out.println("Ingrese asignatura: ");
		setAsignatura(tec.next());
			
	}
	
	@Override
	public void modificarDatos(){
		super.modificarDatos();
		
		System.out.println("Ingrese asignatura: ");
		setAsignatura(tec.next());
			
	}
	
	public String tipoSocio(){
		return "Docente";
	}
	
	@Override
	public String toString() {
		return super.toString() +" Asignatura=" + this.asignatura + ", Tipo de Socio=" + tipoSocio() + "]";
	}
}
