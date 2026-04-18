package paquete;

import java.util.Scanner;

public class Programa4 {
	Scanner entrada = new Scanner(System.in);
	
	
	public void inicio4() {
	
		double a = pedirNum();
		double b = pedirNum();
		double c = pedirNum();
		
		menu(a,b,c);
	}
	
	//pedir datos a usuario
	public double pedirNum() {
		double num;
		
		System.out.println("ingresa 3 numeros: ");
		num = entrada.nextDouble();
		
		return num;
		
	}
	
	//Menu - metodo
	
	public void menu (double num1, double num2, double num3) {
		
		int op;
		
		//MENU
		do {
			System.out.println("");
			System.out.println("1.El cuadrado y la raíz cuadrada de cada valor.");
			System.out.println("2.Bhaskara");
			System.out.println("3.El mayor de tres números");
			System.out.println("0.Salir");
			System.out.println("ingrese una opcion: ");
			op = entrada.nextInt();
			
			//OPCIONES//
			switch (op) {
			case 1:
				
				//ELEVADO Y LA RAIZ CUADRADA//
				Double elevado1 = Math.pow(num1, 2);
				Double elevado2 = Math.pow(num2, 2);
				Double elevado3 = Math.pow(num3, 2);
				
				Double raiz1 = Math.sqrt(num1);
				Double raiz2 = Math.sqrt(num2);
				Double raiz3 = Math.sqrt(num3);
				
				System.out.println(num1 + " elevado al cuadrado es: " + elevado1 + " Y la raiz cuadrada es: " + raiz1);
				System.out.println(num2 + " elevado al cuadrado es: " + elevado2 + " Y la raiz cuadrada es: " + raiz2);
				System.out.println(num3 + " elevado al cuadrado es: " + elevado3 + " Y la raiz cuadrada es: " + raiz3);
				break;

			case 2:
				//BASKARA//
				
				double delta = Math.pow(num2, 2) - (4*num1*num3);
				double denominador = 2*num1;
				double numeradorx1 = -num2+Math.sqrt(delta);
				double numeradorx2 = -num2-Math.sqrt(delta);
				double x1 = numeradorx1/denominador;
				double x2 = numeradorx2/denominador;
				
				if (delta>=0) {
					if (x1==x2) {
						System.out.println("x1 = x2 = " + x2);
					} else {
						System.out.println("x1 = " + x1);
						System.out.println("x2 = " + x2);
					}
				} else {
					System.out.println("no existe raizes reales");
				}
				
				break;
				
			case 3:
				
				if (num1 > num2) {
					if (num1 > num3) {
						System.out.println("El mayor es: " + num1);
					} else {
						System.out.println("El mayor es " + num3);
					}
					
				} else if (num2 > num3) {
					System.out.println("El mayor es " + num2);
				} else {
					System.out.println("E mayor es " + num3);
				}
				
				break;
				
			}
			
		} while (op!=0);
		
	}
	
	
}