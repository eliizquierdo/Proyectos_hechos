import java.util.InputMismatchException;
import java.util.Scanner;

public class programa_1 {
	Scanner input = new Scanner(System.in);
	
	public int countDigit(int x) {
		int count = 0;
		while (x != 0) {
			x = x / 10;
			++count;
		}
		return count;
	}
	
	public String setApellido() {
		String apellido;
		
		System.out.print("Ingrese su apellido\n->");
		apellido = input.next();
		
		return apellido;	
	}
	
	public int setCedula() {
		int cedula = 0;
		boolean error;
		
		do {
			error=false;
			try {
				System.out.print("Ingrese su cedula\n->");
				cedula = input.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Error de entrada");
				error=true;
				input.next();
			}
			if(countDigit(cedula)<8 || countDigit(cedula)>8) {
				System.out.println("Cantidad de digitos insuficientes o demasiados");
				error=true;
			}
		}while(error==true);
		return cedula;
	}

	public int setEdad() {
		int edad = 0;
		boolean error;
		
		do {
			error=false;
			try {
				System.out.print("Ingrese su edad\n->");
				edad = input.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Error de entrada");
				input.next();
				error=false;
			}
		}while(error==true);
		return edad;
	}
	
	public double setPeso() {
		double peso = 0;
		boolean error;
		
		do {
			error=false;
			try {
				System.out.print("Ingrese su peso\n->");
				peso = input.nextDouble();
			}catch(InputMismatchException e) {
				System.out.println("Error de entrada");
				error = true;
				input.next();
			}
		}while(error==true);
		return peso;
	}
	
	public double setAltura() {
		double altura = 0;
		boolean error;
		
		do {
			error=false;
			try {
				System.out.print("Ingrese su altura\n->");
				altura = input.nextDouble();
			}catch(InputMismatchException e) {
				System.out.println("Error de entrada");
				error = true;
				input.next();
			}
		}while(error==true);
		return altura;
	}
	
	public void mostrar() {
		String apellido;
		int cedula, edad;
		double peso, altura;
		
		apellido = setApellido();
		cedula = setCedula();
		edad = setEdad();
		peso = setPeso();
		altura = setAltura();
		
		System.out.println("Apellido: " + apellido + "\nCedula: " + cedula + "\nEdad: " + edad + "\nPeso: " + peso + "\nAltura: " + altura);
	}
}
