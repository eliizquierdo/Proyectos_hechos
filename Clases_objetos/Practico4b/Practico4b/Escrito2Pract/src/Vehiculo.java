
public class Vehiculo {

	private String marca;
	private double precio;
	private String matricula;
	
	
	public Vehiculo(String marca, double precio, String matricula) {
		this.marca = marca;
		this.precio = precio;
		this.matricula = matricula;
	
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	
    }
    
	public double descontarPatente() {
		double monto=0;
		if (precio>10000)
		
		monto=precio*0.10; 
	    return monto;
	    
	}

	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", precio=" + precio + ", matricula=" + matricula + "]";
	}

}

