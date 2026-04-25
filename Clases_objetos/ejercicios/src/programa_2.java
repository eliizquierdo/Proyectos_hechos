import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class programa_2 {
	Random rand = new Random();
	Scanner input = new Scanner(System.in);
	
	public int setNum() {
		return rand.nextInt(1, 1000);
	}
	
	public void game(int RandNum) {
		int num = 0;
		boolean error, game;
		
		do {
			game=false;
			do {
				error = false;
				try {
					System.out.print("Ingrese un número\n->");
					num = input.nextInt();
				}catch(InputMismatchException e) {
					System.out.println("Error de entrada");
					input.next();
					error = true;
				}
			}while(error==true);
			if(num > RandNum) {
				System.out.println("Demasiado grande");
				game=true;
			}
			if(num < RandNum) {
				System.out.println("Demasiado chico");
				game=true;
			}
			if(num == RandNum) {
				System.out.println("Felicitaciones, acertó el número");
			}
		}while(game==true);
		
	}
	
}
