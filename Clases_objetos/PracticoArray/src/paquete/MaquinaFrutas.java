package paquete;
import java.util.Random;
import java.util.Scanner;

public class MaquinaFrutas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Array de símbolos
        String[] simbolos = {"🍒", "🔔", "🍋", "⭐", "💀"
        		+ ""};

        // Ciclo del juego
        while (true) {
            System.out.println("Presiona ENTER para hacer una tirada o escribe 'salir' para terminar:");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("salir")) {
                System.out.println("Gracias por jugar.");
                break;
            }

            // Tirar tres símbolos al azar
            String[] tirada = new String[3];
            for (int i = 0; i < 3; i++) {
                tirada[i] = simbolos[random.nextInt(simbolos.length)];
            }

            // Mostrar la tirada
            System.out.println("Tirada: " + tirada[0] + " | " + tirada[1] + " | " + tirada[2]);

            // Evaluar el resultado
            evaluarTirada(tirada);
        }

        scanner.close();
    }

    // Método para evaluar la tirada
    public static void evaluarTirada(String[] tirada) {
        if (tirada[0].equals("💀") && tirada[1].equals("💀") && tirada[2].equals("💀")) {
            System.out.println("¡Tres calaveras! Has perdido todo.");
        } else if (tirada[0].equals("💀") && tirada[1].equals("💀") || 
                   tirada[1].equals("💀") && tirada[2].equals("💀") || 
                   tirada[0].equals("💀") && tirada[2].equals("💀")) {
            System.out.println("¡Dos calaveras! Cuidado.");
        } else if (tirada[0].equals("🔔") && tirada[1].equals("🔔") && tirada[2].equals("🔔")) {
            System.out.println("¡Tres campanas! Ganaste.");
        } else if (tirada[0].equals(tirada[1]) && tirada[1].equals(tirada[2])) {
            System.out.println("¡Tres iguales! Buen trabajo.");
        } else if (tirada[0].equals(tirada[1]) || tirada[1].equals(tirada[2]) || tirada[0].equals(tirada[2])) {
            System.out.println("¡Dos iguales!");
        } else {
            System.out.println("Sigue intentando.");
        }
    }
}
