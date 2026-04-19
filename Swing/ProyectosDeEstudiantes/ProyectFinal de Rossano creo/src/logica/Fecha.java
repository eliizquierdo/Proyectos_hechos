package logica;

public class Fecha {
	
	//	----------------Variables----------------
	private int mes;
	private int dia;
	private int anio;

	//	----------------CONSTRUCTORES----------------
	public Fecha(int mes, int dia, int anio) {
		super();
		this.mes = mes;
		this.dia = dia;
		this.anio = anio;
	}

	//	----------------GETTERS Y SETTERS----------------
	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	
}
