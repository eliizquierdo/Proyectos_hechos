package logica;

import logica.clasesDePersona.*;
import logica.clasesDeArticulo.*;

public class Factura {
	
	//-----------------VARIABLES----------------------
	private Productos venta;
	private Fecha realizada;
	private Empleado vendedor;
	private Cliente comprador;

	//-----------------CONSTRUCTORES-----------------
	public Factura(Productos venta, Fecha realizada, Empleado vendedor, Cliente comprador) {
		super();
		this.venta = venta;
		this.realizada = realizada;
		this.vendedor = vendedor;
		this.comprador = comprador;
	}

	//------------------Getters y Setters--------------------
	public Productos getVenta() {
		return venta;
	}

	public void setVenta(Productos venta) {
		this.venta = venta;
	}

	public Fecha getRealizada() {
		return realizada;
	}

	public void setRealizada(Fecha realizada) {
		this.realizada = realizada;
	}

	public Empleado getVendedor() {
		return vendedor;
	}

	public void setVendedor(Empleado vendedor) {
		this.vendedor = vendedor;
	}

	public Cliente getComprador() {
		return comprador;
	}

	public void setComprador(Cliente comprador) {
		this.comprador = comprador;
	}
	
	
	//---------------FUNCIONES------------
	public double impuestoIva() {
		return 0;
	}
	
	public double subTotal() {
		return 0;
	}
	
	public double totalVenta() {
		return 0;
	}
	
	
}
