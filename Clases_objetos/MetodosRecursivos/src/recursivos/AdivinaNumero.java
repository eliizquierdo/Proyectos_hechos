package recursivos;
//PROYECTO ADIVINADOR DE NÚMERO

import java.util.Scanner;
import java.util.Random;

public class AdivinaNumero {

 // Creamos una instancia de Random para generar el número aleatorio
 private static Random random = new Random();
 private static int numero = random.nextInt(20) + 1;

 public static void main(String[] args) {
     System.out.println("************************************");
     System.out.println("*     BIENVENIDOS AL ADIVINADOR    *");
     System.out.println("************************************");
     System.out.println("Estoy pensando en un número entre 1 y 20. ¡Intenta adivinarlo!");

     pideNumero(); // Inicia el programa llamando a la función
 }

 // Método para solicitar un número al usuario
 public static void pideNumero() {
     Scanner scanner = new Scanner(System.in);

     try {
         System.out.print("Dame un número entre 1 y 20: \n");
         int miNumero = scanner.nextInt();
         comprueba(miNumero);
     } catch (Exception e) {
         System.out.println("Por favor, introduce un número válido.");
         scanner.next(); // Limpiamos el buffer del scanner
         pideNumero();
     }
 }

 // Método para comprobar el número ingresado
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
}
