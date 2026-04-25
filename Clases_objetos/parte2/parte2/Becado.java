package parte2;

public class Becado extends Alumno {
	
	private double saldoBeca;

	public Becado(String cedula, double cuotaBase, double descuento) {
		super(cedula, cuotaBase);
		this.saldoBeca = descuento;
	}

	public double getSaldoBeca() {
		return saldoBeca;
	}

	public void setsaldoBeca(double descuento) {
		this.saldoBeca = descuento;
	}
	
	//Parte 2
	@Override
	public double cuotaNeta(int anio){
			
			return(super.cuotaNeta(anio)-getSaldoBeca());
	}
}
