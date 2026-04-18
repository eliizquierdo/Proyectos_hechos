package logica;

public class Becado extends Alumno{
	private double descuento;

	public Becado() {
		//super();
	}


	public Becado(int cod,String ape, int gru, double cu, double desc) {
		super(cod,ape,  gru, cu);
		descuento = desc;
	}


	public double getDescuento() {
		return descuento;
	}


	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}


	@Override
	public String toString() {
		return super.toString()+ "\ndescuento:" + descuento;
	}
	
	
	public double cuotaNeta() {
		return super.cuotaNeta()-descuento;		
	}
	
}
 