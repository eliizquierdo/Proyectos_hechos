package logica;

import java.util.Scanner;

public class Prestamos {
	
	Scanner tec= new Scanner(System.in);

	private int cedsocio;
	private String finicio;
	private Fecha ffin;
	private int codigo;
	
	public Prestamos(){
		this.cedsocio = 0;
		this.finicio = null;
		this.ffin = null;
		this.codigo = 0;
	}
	
	public Prestamos(int cedsocio, String finicio, Fecha ffin, int codigo, int cantidad) {
		this.cedsocio = cedsocio;
		this.finicio = finicio;
		this.ffin = ffin;
		this.codigo = codigo;
	}

	public int getCedsocio() {
		return this.cedsocio;
	}

	public String getFinicio() {
		return this.finicio;
	}

	public Fecha getFfin() {
		return this.ffin;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCedsocio(int cedsocio) {
		this.cedsocio = cedsocio;
	}

	public void setFinicio(String finicio) {
		this.finicio = finicio;
	}

	public void setFfin(Fecha ffin) {
		this.ffin = ffin;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		return "Prestamos [Cédula del socio=" + cedsocio + ", Código del material="+ codigo + ", Fecha de inicio=" + finicio + ", Fecha de fin=" + ffin.mostrarFecha() + ", Codigo del Material=" + codigo  +"]";
	}	
	
}
