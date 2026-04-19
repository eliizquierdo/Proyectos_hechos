package logica.clasesDeArticulo;

import logica.*;

public class Nacional extends Articulo{

	//-----------Variables--------------
	private String departamento;
	private boolean subsidiado;

	
	//------------CONSTRUCTORES--------------
	public Nacional(int codigo, String nombre, double precioCosto, int unidades, String departamento,
			boolean subsidiado) {
		super(codigo, nombre, precioCosto, unidades);
		this.departamento = departamento;
		this.subsidiado = subsidiado;
	}
	
	public Nacional() {
		
	}

	//-----------GETTERS Y SETTERS---------------
	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public boolean isSubsidiado() {
		return subsidiado;
	}


	public void setSubsidiado(boolean subsidiado) {
		this.subsidiado = subsidiado;
	}

	//----------------FUNCIONES----------------
	public double precioVenta() {
		return getPrecioCosto() + ( getPrecioCosto() * 0*20 );

	}
	
	
	@Override
	public String toString() {
		return "departamentoInicio "+departamento+" departamentoFinal"+" subsidiadoInicio "+subsidiado+" subsidiadoFinal";
	}
	
}
