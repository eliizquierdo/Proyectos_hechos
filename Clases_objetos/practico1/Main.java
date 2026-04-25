import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();

        System.out.print("Ingrese el tercer número: ");
        double num3 = scanner.nextDouble();


        double suma = num1 + num2 + num3;


        System.out.println("La suma de los tres números es: " + suma);
        scanner.close();
    }
}