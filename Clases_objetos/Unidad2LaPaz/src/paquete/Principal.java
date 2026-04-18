package paquete;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Por favor ingrese su nombre"); 
		String nombre = teclado.nextLine();
		System.out.println("Bienvenido " + nombre);
		System.out.println("Por favor ingrese su edad: ");
		int edad = teclado.nextInt();
	}
}

