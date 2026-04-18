package ejercicio4;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Programa prog4 = new Programa();
		Scanner entrada = new Scanner(System.in);
		
		int cantidadEdades;
		
		System.out.println("Cuantas edades va a ingresar? ");
		cantidadEdades = entrada.nextInt();
		prog4.ingresoEdades(cantidadEdades);
		prog4.contar();
		prog4.mostrar();

	}
}



