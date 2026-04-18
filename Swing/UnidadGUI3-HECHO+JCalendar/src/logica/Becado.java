package logica;

import java.util.Scanner;

public class Becado extends Alumno{
	
	private double saldoBeca;
	
	public Becado() {
		
	}

	public Becado(double s, String a, int g, double c, Fecha fn ) {
		super(a,g,c,fn);
		saldoBeca=s;
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
	
	@Override
	public boolean boletoGratis() {
		boolean corresponde=false;
		
		if (saldoBeca<200)
			corresponde=true;
		return corresponde;
		
	}
	
	@Override
	public void pedirDatos() {
		Scanner teclado = new Scanner(System.in);
		
		super.pedirDatos();
		System.out.println("Ingrese saldo Beca: ");
		setSaldoBeca(teclado.nextDouble());
		
	}
	
}
