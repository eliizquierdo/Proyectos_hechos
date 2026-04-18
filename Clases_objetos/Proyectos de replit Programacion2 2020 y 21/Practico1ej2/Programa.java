import java.util.Scanner;
import java.util.Random;

public class Programa {
	Scanner entrada = new Scanner(System.in);
	Random aleatorio = new Random();
	
	void iniciar() {
		int salir;
		do {
			jugar();
			System.out.println("Quiere seguir jugando: (1-si 0-no)");
			salir=ingresaRespuesta();
		}while (salir!=0);
		
	} // Fin del método iniciar
	
	void jugar() {
		int resultado;	// Operación aleatoria
		int respuesta;	// Respuesta del usuario
		int aleatorio1 = generarAleatorio();
		int aleatorio2 = generarAleatorio();
		do {			 
			resultado = multiplica(aleatorio1, aleatorio2);
			respuesta = ingresaRespuesta();
			if (resultado!=respuesta)
				System.out.println("No. Por favor intenta de nuevo");
			else
				System.out.println("Su respuesta es correcta");
		} while (resultado != respuesta);
	}
	
	int generarAleatorio() {
		int a;
		a = 1 + aleatorio.nextInt(9);
		return a;
	}
	
	int ingresaRespuesta() {
		int x;
		x = entrada.nextInt();
		return x;
	}
	
	int multiplica(int a1, int a2) {
		System.out.println("¿Cuánto es "+a1+" por "+a2+"?");
		return (a1 * a2);
	}
}
