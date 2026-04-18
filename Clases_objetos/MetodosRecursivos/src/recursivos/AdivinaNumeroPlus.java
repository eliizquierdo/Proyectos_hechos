package recursivos;
import java.util.Scanner;
import java.util.Random;

public class AdivinaNumeroPlus {
	
	    private static Random random = new Random();
	    private static int numero = random.nextInt(20) + 1;
	    private static int[] intentos = new int[20]; // Array para almacenar hasta 20 intentos
	    private static int contadorIntentos = 0; // Lleva la cuenta de los intentos realizados

	    public static void main(String[] args) {
	        System.out.println("************************************");
	        System.out.println("*     BIENVENIDOS AL ADIVINADOR    *");
	        System.out.println("************************************");
	        System.out.println("Estoy pensando en un número entre 1 y 20. ¡Intenta adivinarlo!");

	        pideNumero();
	    }

	    public static void pideNumero() {
	        Scanner scanner = new Scanner(System.in);

	        try {
	            if (contadorIntentos > 0) {
	                System.out.println("Intentos anteriores: ");
	                mostrarIntentos();
	            }
	            
	            System.out.print("Dame un número entre 1 y 20: \n");
	            int miNumero = scanner.nextInt();

	            if (!numeroYaIntentado(miNumero)) {
	                intentos[contadorIntentos] = miNumero; // Guardamos el intento en el array
	                contadorIntentos++;
	                comprueba(miNumero);
	            } else {
	                System.out.println("¡Ya intentaste ese número! Prueba con otro.");
	                pideNumero();
	            }
	        } catch (Exception e) {
	            System.out.println("Por favor, introduce un número válido.");
	            scanner.next(); // Limpiamos el buffer del scanner
	            pideNumero();
	        }
	    }

	    public static void comprueba(int delJugador) {
	        if (delJugador == numero) {
	            System.out.println("¡Felicidades! Adivinaste el número.");
	        } else if (delJugador < numero) {
	            System.out.println("El número es mayor. ¡Intenta de nuevo!");
	            pideNumero();
	        } else {
	            System.out.println("El número es menor. ¡Intenta de nuevo!");
	            pideNumero();
	        }
	    }

	    public static void mostrarIntentos() {
	        for (int i = 0; i < contadorIntentos; i++) {
	            System.out.print(intentos[i] + " ");
	        }
	        System.out.println();
	    }

	    public static boolean numeroYaIntentado(int numero) {
	        for (int i = 0; i < contadorIntentos; i++) {
	            if (intentos[i] == numero) {
	                return true; // El número ya fue intentado
	            }
	        }
	        return false;
	    }
	}
