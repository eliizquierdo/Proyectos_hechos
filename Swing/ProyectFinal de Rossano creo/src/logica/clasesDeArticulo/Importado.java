package logica.clasesDeArticulo;

//-------------------imports-------------------
import logica.*;

public class Importado extends Articulo{
	
	//----------Variables------------
	private Fecha anioImportacion;
	private double impuesto;

	
	//--------------CONSTRUCTORES----------------
	public Importado(int codigo, String nombre, double precioCosto, int unidades, Fecha anioImportacion,
			double impuesto) {
		super(codigo, nombre, precioCosto, unidades);
		this.anioImportacion = anioImportacion;
		this.impuesto = impuesto;
	}
	
	public Importado(){
	}
	//-------------GETTERS Y SETTERS------------------
	public Fecha getAnioImportacion() {
		return anioImportacion;
	}


	public void setAnioImportacion(Fecha anioImportacion) {
		this.anioImportacion = anioImportacion;
	}


	public double getImpuesto() {
		return impuesto;
	}


	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}
	
	
	//----------------FUNCIONES----------------
	public double precioVenta() {
		return getPrecioCosto() + ( getPrecioCosto() * 0*30 );
	}

	@Override
	public String toString() {
		return "fechainicio"+anioImportacion.getAnio()+"/"+anioImportacion.getDia()+"/"+anioImportacion.getMes()+ "fechafinal Importado inicioImpuesto" + impuesto + "finalImpuesto ";
	}
	
	
}
