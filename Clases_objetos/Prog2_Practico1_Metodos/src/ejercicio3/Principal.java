package ejercicio3;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Procesos pro = new Procesos();
			
		int op = 0;
		//MENU
		do {
			
			System.out.println("1. Numero par e Impar: ");
			System.out.println("2. el mayor de tres numeros: ");
			System.out.println("3. Es mayor de edad: ");
			System.out.println("0. Salir ");
			op = entrada.nextInt();
			
			switch (op) {
			case 1:
				
				pro.parImpar();
				break;

			case 2:
				pro.mayorTres();
				break;
				
			case 3:
				pro.esMayorEdad();
				break;
			}
			
		} while (op!=0);
	}
	
}	

