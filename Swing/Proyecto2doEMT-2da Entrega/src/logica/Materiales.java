package logica;

import java.util.Scanner;

public abstract class Materiales {
	
	Scanner tec= new Scanner(System.in);

	private int codigo;
	private String titulo;
	private String autor;
	private int cant_ejemplar;
	private int cant_disponible;
	
	public Materiales() {
		this.codigo = 0;
		this.titulo = " ";
		this.autor = " ";
		this.cant_ejemplar= 0;
		this.cant_disponible= 0;
	}
	
	public Materiales(int codigo, String titulo, String autor, int cant_ejemplar) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.cant_disponible= cant_ejemplar;
		this.cant_ejemplar= cant_ejemplar;
	}


	public int getCodigo() {
		return this.codigo;
	}


	public String getTitulo() {
		return this.titulo;
	}


	public String getAutor() {
		return this.autor;
	}

	public int getCant_ejemplar() {
		return this.cant_ejemplar;
	}


	public int getCant_disponible() {
		return this.cant_disponible;
	}


	public void setCant_ejemplar(int cant_ejemplar) {
		this.cant_ejemplar = cant_ejemplar;
	}

	public void setCant_disponible(int cant) {
		this.cant_disponible = this.cant_ejemplar - cant;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public void pedirDatos() {

		System.out.println("------------------------------- Ingrese los datos del material -------------------------------  " );
		
				
		System.out.println("Ingrese el código: ");
		setCodigo(tec.nextInt());
		
		System.out.println("Titulo: ");
		setTitulo(tec.next());
		
		System.out.println("Autor: ");
		setAutor(tec.next());
		
		System.out.println("Cantidad de ejemplares: ");
		setCant_ejemplar(tec.nextInt());
	
		this.cant_disponible=this.cant_ejemplar;
	}
	
	public void modificarDatos() {

		System.out.println("------------------------------- Modifique los datos del material -------------------------------  " );
		
		System.out.println("Titulo: ");
		setTitulo(tec.next());
		
		System.out.println("Autor: ");
		setAutor(tec.next());
		
		System.out.println("Cantidad de ejemplares: ");
		setCant_ejemplar(tec.nextInt());		
	}

	
	@Override
	public String toString() {
		return "Material [Código=" + codigo + ", Titulo=" + titulo + ", Autor=" + autor + ", Cantidad de Ejemplares="
				+ cant_ejemplar + ", Cantidad Disponible=" + cant_disponible;
	}
	
	public abstract String tipoMaterial();

}
	
