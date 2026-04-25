import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una opción:");
        System.out.println("a) Calcular área del triángulo");
        System.out.println("b) Calcular área y perímetro del rectángulo");
        System.out.println("c) Convertir pesos a dólares");
        String opcion = scanner.nextLine().toLowerCase();

        if (opcion.equals("a")) {
            calcularAreaTriangulo(scanner);
        } else if (opcion.equals("b")) {
            calcularAreaPerimetroRectangulo(scanner);
        } else if (opcion.equals("c")) {
            convertirPesosADolares(scanner);
        } else {
            System.out.println("Opción inválida. Por favor, seleccione 'a', 'b' o 'c'.");
        }
    }
public static void calcularAreaTriangulo(Scanner scanner) {
        System.out.print("Ingrese la base: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese la altura: ");
        double altura = scanner.nextDouble();
        double areaTriangulo = (base * altura) / 2;
        System.out.println("El área del triángulo es: " + areaTriangulo);
    }

    public static void calcularAreaPerimetroRectangulo(Scanner scanner) {
        System.out.print("Ingrese el largo: ");
        double largo = scanner.nextDouble();
        System.out.print("Ingrese el ancho: ");
        double ancho = scanner.nextDouble();
        double areaRectangulo = largo * ancho;
        double perimetroRectangulo = 2 * (largo + ancho);
        System.out.println("El área del rectángulo es: " + areaRectangulo);
        System.out.println("El perímetro es: " + perimetroRectangulo);
    }

    public static void convertirPesosADolares(Scanner scanner) {
        System.out.print("Ingrese cantidad de pesos a convertir: ");
        double cantidadPesos = scanner.nextDouble();
        System.out.print("Ingrese precio del dólar: ");
        double valorDolar = scanner.nextDouble();
        double cantidadDolares = cantidadPesos / valorDolar;
        System.out.println(cantidadPesos + " pesos son " + cantidadDolares + " dólares");
    }
}