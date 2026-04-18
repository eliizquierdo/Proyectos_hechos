package logica;

public class  Becado extends Alumno {

	private double saldoBeca;
	
	public Becado() {
		super();
	}
	
	
	public Becado(String ape, int gru, double cuota, double saldoBeca) {
		super(ape, gru, cuota);
		this.saldoBeca=saldoBeca;
	}


	public double getSaldoBeca() {
		return saldoBeca;
	}

	public void setSaldoBeca(double saldoBeca) {
		this.saldoBeca = saldoBeca;
	}


	@Override
	public String toString() {
		return super.toString()+" saldoBeca=" + saldoBeca;
	}
	
	
	
	
}
