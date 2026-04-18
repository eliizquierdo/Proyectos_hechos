package ejercicio3;

import java.util.Scanner;

public class Procesos {
	
Scanner entrada = new Scanner(System.in);
	
	//RECIBE UN ENTERO Y DETERMINA SI ES PAR DEVOLVIENDO UN BOOLEAN
	void parImpar() {
		
		int numParImpar;
		System.out.println("Ingrese un numero: ");
		numParImpar = entrada.nextInt();
		
		if (numParImpar % 2 == 0) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}
	
	//RECIBE 3 ENTEROS Y DEVUELVE EL MAYOR DE ELLOS
	
	void mayorTres() {
		int num1;
		int num2;
		int num3;
		
		System.out.println("ingrese el primer numero: ");
		num1 = entrada.nextInt();
		System.out.println("ingrese el segundo numero: ");
		num2 = entrada.nextInt();
		System.out.println("ingrese el tercer numero: ");
		num3 = entrada.nextInt();
		
		System.out.println("Sus numero ingresados son: " + num1+ "," + num2 + "," + num3);
		
		if (num1 > num2) {
			System.out.println(num1 + " es el mayor");
			
		} else if (num2 > num3) {
			System.out.println(num2 + " es el mayor");
		} else {
			System.out.println(num3 + " es el mayor");
		}
		
	}
	
	//RECIBE UNA EDAD Y DETERINA SI ES MAYOR O MENOS DE 18
	
	void esMayorEdad() {
		
		int edad;
		
		System.out.println("Ingrese edad: ");
		edad = entrada.nextInt();
		
		if (edad < 18) {
			System.out.println("Es menor de 18");
		} else {
			System.out.println("Es mayor de 18");
		}
	}
	
	
		
}
