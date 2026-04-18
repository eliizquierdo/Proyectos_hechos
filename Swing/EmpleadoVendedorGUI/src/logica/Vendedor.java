package logica;

import java.util.Scanner;

public class Vendedor extends Empleado{
	
	private double extra;
	
	public Vendedor() {
		
	}

	public Vendedor(String apellido, String nombre, double jornal, int dias, double extra) {
		super(apellido, nombre, jornal,dias);
		this.extra = extra;
	}

	public double getExtra() {
		return extra;
	}

	public void setExtra(double extra) {
		this.extra = extra;
	}
	
	//metodo específico
	@Override
	public double sueldo() {
		return(super.sueldo()+extra);
	}
	

	
	

	
	
		
	
	
}
