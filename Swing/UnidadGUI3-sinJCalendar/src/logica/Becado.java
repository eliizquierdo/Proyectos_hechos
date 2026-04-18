package logica;

public class Becado extends Alumno {
	
	 private double saldoBeca;

	public Becado(int cod, double saldoBeca, String apellido, int grupo, double cuotaBase) {
			super(cod,apellido,grupo,cuotaBase);
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
		return super.toString() + "\t" + saldoBeca;
	}

	//si el saldoBeca es <200 le corresponde boletoGratis
	
	
	public boolean boletoGratis() {
		boolean corresponde=false;
		
		if (saldoBeca<200)
			corresponde=true;
		return corresponde;
		
	}
	
	@Override
	public double cuotaNeta() {
		return(super.cuotaNeta() - saldoBeca);
	}
	
	
}
