package logica;

public class Alumno extends Socios{

	private String grupo;

	public Alumno() {
		super();
		this.grupo= " ";
	}

	public Alumno(int cedula, String nombre, String apellido, String direccion, int telefono, String grupo) {
		super(cedula, nombre, apellido, direccion, telefono);
		this.grupo= grupo;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	@Override
	public void pedirDatos(){
			
		super.pedirDatos();
		
		System.out.println("Ingrese grupo: ");
		setGrupo(tec.next());		
	}
	
	@Override
	public void modificarDatos(){
		super.modificarDatos();
		
		System.out.println("Ingrese grupo: ");
		setGrupo(tec.next());	
		
	}
	
	public String tipoSocio(){
		return "Alumno";
	}

	@Override
	public String toString() {
		return  super.toString() + " Grupo=" + this.grupo + ", Tipo de Socio=" + tipoSocio() + "]";
	}
	
}
