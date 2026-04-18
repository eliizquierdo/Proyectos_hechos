package logica;
//package logica;

public class Fecha {

	
	//Atributos
	private int dia;
	private int mes;
	private int anio;
	
	
	//Constructor por defecto
	public Fecha() {
		
	}
	
	
	//Constructor especifico
	public Fecha(int dia, int mes, int anio) {
		
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
		
	}
	
	
	//Setters
	public void setDia(int dia) {
		
		this.dia = dia;
		
	}
	
	
	public void setMes(int mes) {
		
		this.mes = mes;
		
	}
	
	
	public void setAnio(int anio) {
		
		this.anio = anio;
		
	}
	
	
	//Getters
	public int getDia() {
	
		return dia;
		
	}
	
	
	public int getMes() {
		
		return mes;
		
	}
	
	
	public int getAnio() {
		
		return anio;
		
	}


	//ToString
	@Override
	public String toString() {
		return dia + "/" + mes + "/" + anio;
	}
	
}
