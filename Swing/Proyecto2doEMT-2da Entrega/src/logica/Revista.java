package logica;

public class Revista extends Materiales{

	private Fecha fecha_edicion;
	
	public Revista() {
		super();
		this.fecha_edicion= null;
	}
	
	public Revista(int codigo, String titulo, String autor, int cant_ejemplar, Fecha fecha_edicion) {
		super(codigo, titulo, autor, cant_ejemplar);
		this.fecha_edicion= fecha_edicion;
	}

	public Fecha getFecha_edicion() {
		return fecha_edicion;
	}

	public void setFecha_edicion(Fecha fecha_edicion) {
		this.fecha_edicion = fecha_edicion;
	}
	
	public String tipoMaterial(){
		return "Revista";
	}
	
	@Override
	public void pedirDatos() {
		
		super.pedirDatos();

		System.out.println("Ingrese la Fecha de edición: ");
		
		System.out.print("Día: ");
		int dia = tec.nextInt();
		
		System.out.print("Mes: ");
		int mes = tec.nextInt();
		
		System.out.print("Año: ");
		int anio = tec.nextInt();
		
		setFecha_edicion(new Fecha (dia,mes,anio));
		
	}
	
	@Override
	public void modificarDatos() {
		super.modificarDatos();
		
		super.pedirDatos();

		System.out.println("Ingrese la Fecha de edición: ");
		
		System.out.print("Día: ");
		int dia = tec.nextInt();
		
		System.out.print("Mes: ");
		int mes = tec.nextInt();
		
		System.out.print("Año: ");
		int anio = tec.nextInt();
		
		setFecha_edicion(new Fecha (dia,mes,anio));
		
	}
	
	@Override
	public String toString() {
		return super.toString() + " Fecha de edicion=" + fecha_edicion + ", Tipo de material= " + tipoMaterial() + "]";
	}
	
}
