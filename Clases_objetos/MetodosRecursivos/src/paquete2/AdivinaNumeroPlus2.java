package paquete2;

import java.util.Scanner;
import java.util.Random;

public class AdivinaNumeroPlus2 {


	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        int numero = random.nextInt(20) + 1; // Número aleatorio entre 1 y 20
	        int[] intentos = new int[20]; // Array para almacenar intentos
	        int contadorIntentos = 0;
	        boolean adivinado = false;

	        System.out.println("************************************");
	        System.out.println("*     BIENVENIDOS AL ADIVINADOR    *");
	        System.out.println("************************************");
	        System.out.println("Estoy pensando en un número entre 1 y 20. ¡Intenta adivinarlo!");

	        while (!adivinado) {
	            adivinado = procesarIntento(scanner, intentos, contadorIntentos, numero);
	            if (!adivinado) {
	                contadorIntentos++;
	            }
	        }

	        System.out.println("¡Gracias por jugar!");
	    }

	    // Método que procesa un intento del jugador
	    public static boolean procesarIntento(Scanner scanner, int[] intentos, int contadorIntentos, int numero) {
	        System.out.print("Dame un número entre 1 y 20: ");
	        int miNumero = scanner.nextInt();

	        // Validar rango del número
	        if (miNumero < 1 || miNumero > 20) {
	            System.out.println("El número debe estar entre 1 y 20.");
	            return false;
	        }

	        // Verificar si el número ya fue intentado
	        if (yaIntentado(intentos, contadorIntentos, miNumero)) {
	            System.out.println("¡Ya intentaste ese número! Prueba con otro.");
	            return false;
	        }

	        // Registrar intento
	        intentos[contadorIntentos] = miNumero;

	        // Comprobar si el número es correcto
	        if (comprobarNumero(miNumero, numero)) {
	            return true; // El número fue adivinado
	        }

	        mostrarIntentos(intentos, contadorIntentos + 1);
	        return false;
	    }

	    // Verifica si el número ya ha sido intentado
	    public static boolean yaIntentado(int[] intentos, int contadorIntentos, int numero) {
	        for (int i = 0; i < contadorIntentos; i++) {
	            if (intentos[i] == numero) {
	                return true;
	            }
	        }
	        return false;
	    }

	    // Comprueba si el número ingresado es el correcto
	    public static boolean comprobarNumero(int miNumero, int numero) {
	        if (miNumero == numero) {
	            System.out.println("¡Felicidades! Adivinaste el número.");
	            return true;
	        } else if (miNumero < numero) {
	            System.out.println("El número es mayor. ¡Intenta de nuevo!");
	        } else {
	            System.out.println("El número es menor. ¡Intenta de nuevo!");
	        }
	        return false;
	    }

	    // Muestra los intentos realizados hasta el momento
	    public static void mostrarIntentos(int[] intentos, int contadorIntentos) {
	        if (contadorIntentos > 0) {
	            System.out.print("Intentos realizados: ");
	            for (int i = 0; i < contadorIntentos; i++) {
	                System.out.print(intentos[i] + " ");
	            }
	            System.out.println();
	        }
	    }
	}


