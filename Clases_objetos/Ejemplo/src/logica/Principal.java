package logica;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String cadena1;
		String cadena2 = null;//new String();
		System.out.print("Ingrese una cadena: ");
		cadena1 = entrada.next();
			for (int i = 0; i < cadena1.length(); i++) {
		        	cadena2 += cadena1.charAt(0);
		    	}
		    	System.out.println(cadena2);

	}

}
