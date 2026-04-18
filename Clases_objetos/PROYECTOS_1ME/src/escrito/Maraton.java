package escrito;

import java.util.Random;

public class Maraton {

	/*--------------------- Definición de array ------------------*/
    static double[] kilometros = new double[30]; // Array para almacenar los kilómetros recorridos cada día.

    /*----------------- Programa principal ------------*/
    public static void main(String[] args) {
        //Llamar al metodo (está hecho)necesario para qué genere distancias aleatorias.
        System.out.println("Kilómetros registrados durante el año:");
        mostrarKilometros(); // Completar este método.
        
        System.out.println("\nLa mayor distancia recorrida en un día es: " + mayorKilometros() + " km"); // Completar este método.
        //System.out.println("La menor distancia recorrida en un día es: " + menorKilometros() + " km"); // Plantear este método.

        System.out.println("\nLa cantidad de días con exactamente 10 km es: " + cantDias(10.0)); // Completar este método.

    }
    
    /*-----------------Metodos----------------------*/

    // Genera un conjunto de distancias aleatorias entre 0 y 20 km.
    public static void generarKilometrosAleatorios() {
        Random random = new Random();
        for (int i = 0; i < kilometros.length; i++) {
            kilometros[i] = random.nextDouble() * 20; // Genera un valor entre 0 y 20.
        }
    }

    // Mostrar los kilómetros registrados durante el mes.
    public static void mostrarKilometros() {
        // Completar este método para mostrar cada día con su distancia.
    }

    // Encuentra la mayor distancia recorrida en un día.
    public static double mayorKilometros() {
        // Completar este método para encontrar el valor más alto en el array.
        return 0; // Cambiar por el resultado correcto.
    }

        
    // Consultar cuántos días se recorrió una distancia específica.
    public static int cantDias(double distancia) {
        int contador = 0;
        // Completar el conteo de días donde la distancia coincide con el parámetro.
        return contador;
    }

    
}
