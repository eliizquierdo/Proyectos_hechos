package parte2;

public class Alumno {
	
	private String cedula;
	private double cuotaColegio;
	
	public Alumno(String cedula, double cuotaColegio) {
		this.cedula = cedula;
		this.cuotaColegio = cuotaColegio;
	}

	public String getCedula() {
		return cedula;
	}

	
	public double getCuotaColegio() {
		return cuotaColegio;
	}

	public void setCuotaColegio(double cuotaColegio) {
		this.cuotaColegio = cuotaColegio;
	}
	
	//Parte 1
	public double cuotaNeta(int anio){
		double cuota;
		
		if ((anio==1)||(anio==2))
			cuota=getCuotaColegio()*75/100;
		else
			cuota=getCuotaColegio();
		return(cuota);
	}
	
	
	
}
