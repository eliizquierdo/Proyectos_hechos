package logica;

public class Libro extends Materiales{
	
	private int codisbn;

	public Libro() {
		super();
		this.codisbn= 0;
	}
	
	public Libro(int codigo, String titulo, String autor, int cant_ejemplar, int codisbn) {
		super(codigo, titulo, autor, cant_ejemplar);
		this.codisbn= codisbn;	
	}

	public int getCodisbn() {
		return codisbn;
	}

	public void setCodisbn(int codisbn) {
		this.codisbn = codisbn;
	}
	
	public String tipoMaterial(){
		return "Revista";
	}
	
	@Override
	public void pedirDatos() {
		
		super.pedirDatos();

		System.out.println("Ingrese el código isbn: ");
		setCodisbn(tec.nextInt());
	}	
	
	@Override
	public void modificarDatos() {
		super.modificarDatos();
		
		System.out.println("Ingrese el código isbn: ");
		setCodisbn(tec.nextInt());
		
	}

	@Override
	public String toString() {
		return super.toString() + " Codigo isbn=" + codisbn + ", Tipo de material: " + tipoMaterial() + "]";
	}	
}
