package ejer1;
import java.util.Scanner;

public class CalculadorAreas {
	 
	 
    public static void main(String[] args) {
    	Scanner teclado = new Scanner(System.in);
        int opcion;
        Programa p = new Programa();
        
        do {
            p.mostrarMenu();
            opcion = teclado.nextInt();
            teclado.nextLine(); // Consumir el salto de línea después de leer la opción

            switch (opcion) {
                case 1:
                	System.out.println("El área del triángulo es: " + p.calcularAreaTriangulo());
                    break;
                case 2:
                	 System.out.println("El área del círculo es: " + p.calcularAreaCirculo());
                    break;
                case 3:
                	System.out.println("El área del cuadrado es: " + p.calcularAreaCuadrado());
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                    break;
            }
        } while (opcion != 4);
    }

   
}
