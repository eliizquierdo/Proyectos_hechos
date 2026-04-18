package paquete;

import java.util.Scanner;

public class Programa1 {

	Scanner entrada = new Scanner(System.in);
	
	String apellido;
	int edad;
	double altura;
	int cedula;
	
	
	//Cargar datos 
	
	public void cargar() {
		System.out.println("Ingrese su apellido: ");
		apellido = entrada.next();
		
		System.out.println("Ingrese su edad: ");
		edad = entrada.nextInt();
		
		System.out.println("Ingrese su altura: ");
		altura = entrada.nextDouble();
		
		System.out.println("Ingrese su cedula: ");
		cedula = entrada.nextInt();
	}
	
	//Imprimir datos
	
	public void imprimir() {
		
		System.out.println("Su Apellido es: " + apellido);
		System.out.println("Su Edad es: " + edad);
		System.out.println("Su Altura es: " + altura);
		System.out.println("Su Cedula es: " + cedula);
		
	}
}
