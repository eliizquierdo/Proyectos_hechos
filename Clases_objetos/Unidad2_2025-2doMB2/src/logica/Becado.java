package logica;

public class Becado extends Alumno{
	private double descuento;

	
	
	@Override
	public String toString() {
		return "Becado ["+ super.toString()+ " descuento=" + descuento + "]";
	}

	public Becado(int cedula, String nombre, double cuota, double descuento) {
		super(cedula, nombre, cuota);
		this.descuento = descuento;
	}
	
	//retorna el cuota del alumno con el descuento
		@Override
		public double precioCuota() {
			return super.precioCuota()-descuento;
			
		}
		
	
	


	
	
	
	

}
