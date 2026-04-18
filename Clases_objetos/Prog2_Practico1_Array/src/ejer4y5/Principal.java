package ejer4y5;
import java.util.Scanner;
class Principal {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		Programa p = new Programa();
		int total = 10;
		int num[] = new int [total];
		
		System.out.println("Ingrese "+ total+" números:");
		for (int i = 0; i < num.length; i++) {
			num[i] = input.nextInt();
		}
		int resultMay = p.elMayor(num);
		int resultMen = p.elMenor(num);
		System.out.println("Mayor: " + resultMay);
		System.out.println("Menor: " + resultMen);
	}
	
	
}
