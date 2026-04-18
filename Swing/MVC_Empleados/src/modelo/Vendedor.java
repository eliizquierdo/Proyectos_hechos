
package modelo;

public class Vendedor extends Empleado {
    private double extra;

    public Vendedor(double extra, String apellido, double jornal, int dias) {
        super(apellido, jornal, dias);
        this.extra = extra;
    }

    @Override
    public double sueldo() {
        return super.sueldo() + extra;
    }

	@Override
	public String toString() {
		return super.toString()+"\t " + extra ;
	}

  
}


