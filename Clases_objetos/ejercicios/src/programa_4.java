import java.util.InputMismatchException;
import java.util.Scanner;

public class programa_4 {
	Scanner input = new Scanner(System.in);

	public double setNum() {
		double num=0;
		boolean error;
		
		do {
			error=false;
			try {
				System.out.print("Ingrese un número\n->");
				num = input.nextDouble();
			}catch(InputMismatchException e) {
				System.out.println("Error de entrada.");
				error=true;
			}
		}while(error==true);
		return num;
	}

	public void bhaskara(double a, double b, double c) {
		double delta, r1, r2;
		
		delta = (b*b) - (4*a*c);
		if((2*a==0) || (delta<0)){
			System.out.print("Imposivel calcular\n");
		}else{
			r1 = ((-1 * b) + Math.sqrt(delta))/(2*a);
			r2 = ((-1 * b) - Math.sqrt(delta))/(2*a);
			System.out.print("R1 = ");
			System.out.printf("%.5f", r1);
			System.out.print("\nR2 = ");
			System.out.printf("%.5f", r2);
			System.out.print("\n");
		}
	    
	}
	
	public double square(double x) {
		return Math.sqrt(x);
	}
	
	public double cube(double x) {
		return x*x;
	}
	
	public double mayorDeDosNumeros(double x, double y) {
	    if (x > y) {
	        return x;
	    } else {
	        return y;
	    }
	}

	public double mayorDeTresNumeros(double x, double y, double z) {
	    double mayor = mayorDeDosNumeros(x, y);
	    mayor = mayorDeDosNumeros(mayor, z);
	    return mayor;
	}
	
	
	public void menu() {
		
		double num1, num2, num3;
		
		num1 = setNum();
		num2 = setNum();
		num3 = setNum();
		int select = 0;
		boolean error;
		
		do {
			error=false;
			try {
				System.out.println("Elija una opción:");
				System.out.print("1 - Cuadrado y raíz cuadrada\n2 - Bhaskara\n3 - El mayor número\n->");
				select = input.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Error de entrada");
				error=true;
			}
		}while(error==true);
		
		switch(select){
		case 1:
			System.out.println("El cuadrado de cada número es:\n1. " + cube(num1) + "\n2. " + cube(num2) + "\n3. " + cube(num3));
			System.out.println("La raíz cuadrada de cada uno es:\n1. " + square(num1) + "\n2. " + square(num2) + "\n3. " + square(num3));
		break;
		case 2:
			bhaskara(num1, num2, num3);
		break;
		case 3:
			System.out.println("El mayor número de los tres es " + mayorDeTresNumeros(num1, num2, num3));
		break;
		default:
			System.out.println("no");
		}
			
	}
	
}
