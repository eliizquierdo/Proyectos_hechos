package logica;

public class Vendedor extends Empleado {
	
	 private double extra;

	
	public Vendedor(String apellido, String nombre, double jornal, int dias, double extra) {
		super(apellido, nombre, jornal, dias);
		this.extra = extra;
	}

	

	@Override
	public String toString() {
		return "Vendedor [extra=" + extra + "]";
	}



	public double getExtra() {
		return extra;
	}



	public void setExtra(double extra) {
		this.extra = extra;
	}



	@Override
	public double sueldo() {
		return(super.sueldo() +extra);
	}
	
	
}
