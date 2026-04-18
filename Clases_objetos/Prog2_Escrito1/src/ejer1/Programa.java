package ejer1;

import java.util.Scanner;

public class Programa {
	Scanner teclado = new Scanner(System.in);
	
	 public  void mostrarMenu() {
	      	System.out.println("MENÚ");
	        System.out.println("1. Área del triángulo");
	        System.out.println("2. Área del círculo");
	        System.out.println("3. Área del cuadrado");
	        System.out.println("4. Salir");
	        System.out.println("Elija una opción:");
	    }

	    public  double calcularAreaTriangulo() {
	        System.out.println("Ingrese la base del triángulo:");
	        double base = teclado.nextDouble();

	        System.out.println("Ingrese la altura del triángulo:");
	        double altura = teclado.nextDouble();

	        double area = 0.5 * base * altura;
	        return area;
	    }

	    public  double calcularAreaCirculo() {
	        System.out.println("Ingrese el radio del círculo:");
	        double radio = teclado.nextDouble();

	        double area = Math.PI * Math.pow(radio, 2);
	        return area;
	    }

	    public  double calcularAreaCuadrado( ) {
	        System.out.println("Ingrese el lado del cuadrado:");
	        double lado = teclado.nextDouble();

	        double area = Math.pow(lado, 2);
	        return area;
	        
	    }
}
