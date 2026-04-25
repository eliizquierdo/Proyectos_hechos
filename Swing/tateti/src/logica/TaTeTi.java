package logica;

import java.util.Scanner;
public class TaTeTi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String posiciones[][] = new String[3][3];
		int contador = 0;
		boolean hayJuego = true;
		posiciones[0][0] = "a";
		posiciones[1][0] = "b";
		posiciones[2][0] = "c";
		posiciones[0][1] = "d";
		posiciones[1][1] = "e";
		posiciones[2][1] = "f";
		posiciones[0][2] = "g";
		posiciones[1][2] = "h";
		posiciones[2][2] = "i";
		while(hayJuego) {
			System.out.println(posiciones[0][0]+posiciones[1][0]+posiciones[2][0]);
			System.out.println(posiciones[0][1]+posiciones[1][1]+posiciones[2][1]);
			System.out.println(posiciones[0][2]+posiciones[1][2]+posiciones[2][2]);
			System.out.println("Ingresa posición x y la posición y");
			int cordenadaX = sc.nextInt();
			int cordenadaY = sc.nextInt();
			if(posiciones[cordenadaX-1][cordenadaY-1]!="o" && posiciones[cordenadaX-1][cordenadaY-1]!="x") {
				if(contador%2==0) {
					posiciones[cordenadaX-1][cordenadaY-1] = "x";
				} else 
					posiciones[cordenadaX-1][cordenadaY-1] = "o";
				
				contador++;
			}
			
			if(contador>9) {
				hayJuego = false;
			}
			hayJuego = esVictoriaRecta(posiciones);
			if(hayJuego == false) {
				if(contador%2==0) {
					System.out.println("Gana O");
				}
					System.out.println("Gana X");
			}
		}
	}
	public static boolean esVictoriaRecta ( String matriz[][]) {
		boolean pruebaSigueJuego = true;
	 	for (int x = 0; x<3; x++) {
	 		if(matriz[x][0].equals(matriz[x][1]) && matriz[x][0].equals(matriz[x][2])) {
	 		 pruebaSigueJuego = false; 
	 		}
	 	}
	 	for (int x = 0; x<3; x++) {
	 		if(matriz[0][x].equals(matriz[1][x]) && matriz[0][x].equals(matriz[2][x])) {
	 		 pruebaSigueJuego = false; 
	 		}
	 	}
	 	return pruebaSigueJuego; 
   }
}