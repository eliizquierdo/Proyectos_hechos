package logica;

public class Vendedor  extends Empleado{
    private double extra;

    //constructor por defecto
	public Vendedor() {
		super();
	}

	//Constructor específico
	public Vendedor(double extra) {
		super();
		this.extra = extra;
	}
	
	public double getExtra() {
		return extra;
	}

	public void setExtra(double extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		return "Vendedor [extra=" + extra + "]";
	}
	
	//metodo específico sueldo - modificado para Vendedor
	public double sueldo() {
		return super.sueldo()+extra;
	}
	
	
    
  

  
}


	
		
    

  

  
