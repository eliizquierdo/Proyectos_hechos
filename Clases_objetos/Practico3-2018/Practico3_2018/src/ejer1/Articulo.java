package ejer1;

import java.util.Scanner;

public   class   Articulo {
	private int codigo;
	private String nombre;
	private double precioCosto;
	
	public Articulo(){
		
	}
	
	public Articulo(int codigo, String nombre, double precioCosto) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precioCosto = precioCosto;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioCosto() {
		return precioCosto;
	}
	
	public void setPrecioCosto(double precioCosto) {
		this.precioCosto = precioCosto;
	}

		
	@Override
	public String toString() {
		return "\n\nCodigo=" + codigo
				+ "\nNombre=" + nombre
				+ "\nPrecio de Costo=" + precioCosto;
	}

	public double precioVenta(){
		return(precioCosto+precioCosto*20/100);
		
	}
	
		
	public void pedirDatos(){
		
			Scanner teclado=new Scanner(System.in);
			System.out.println(" ");
			System.out.println("Ingrese codigo: ");
			this.setCodigo(teclado.nextInt());
			System.out.println("Ingrese nombre: ");
			this.setNombre(teclado.next());
			System.out.println(" ");
			System.out.println("Ingrese Precio de Costo: ");
			this.setPrecioCosto(teclado.nextDouble());
	}
	
		
	
}
