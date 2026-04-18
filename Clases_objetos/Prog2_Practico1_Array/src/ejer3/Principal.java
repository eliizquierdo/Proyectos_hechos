package ejer3;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		System.out.println("Ingrese cantidad de valores a cargar:");
		int cant=teclado.nextInt();
		Programa p= new Programa(cant);
		
		p.cargarArrayNaturales();
		p.cargarArrayAzar();
		p.mostrarArray();
		int promedio=p.promedioArray();
		System.out.println("");
		System.out.println("El promedio es: "+promedio);
		int indice = p.devolverIndice2();
		if (cant<=indice)
			System.out.println("El 2 no salio");
		else
			System.out.println("Indice: "+indice);
		
	}

}
