package ejercicio4;
import java.util.Scanner;

public class Programa {
	Scanner entrada = new Scanner(System.in);
	int edades[];
	int menores;
	int mayores;
	int adultosMayores;
	
	
	//GUARDA LAS EDADES INGRESADAS Y CONTARLAS
	void ingresoEdades(int a) {
		edades = new int [a];
		
		System.out.println("Introduzca sus " + a + " edades: ");
		for (int i = 0; i < edades.length; i++) {
			edades[i] = entrada.nextInt();
			
				
		}
		
	}
	
	void contar() {
	
		for (int i = 0; i < edades.length; i++) {
			
			if (edades[i] <= 18) {
				menores++;
				
			} else if (edades[i] >= 18 && edades[i] <= 59) {
				mayores++;
				
			} else if (edades[i] >= 60) {
				adultosMayores++;
				
			}
		}
	}
	
	//MOSTRAR EN PANTALLA LA INFORMACION
	void mostrar() {
		
		System.out.println("Los menores de 18 son: " + menores);
		System.out.println("Los mayores de 17 y menores de 60 son: " + mayores);
		System.out.println("Los adultos mayores son: " + adultosMayores);
	}
}
