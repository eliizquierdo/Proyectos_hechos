package escrito;
import java.util.Scanner;

public class Biblioteca{
    static final int MAX_LIBROS = 100;
    static String[] titulos = new String[MAX_LIBROS];
    static int[] stocks = new int[MAX_LIBROS];
    static int cantidadLibros = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de la Biblioteca Virtual ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Modificar libro");
            System.out.println("3. Eliminar libro");
            System.out.println("4. Listar stock de libros");
            System.out.println("5. Buscar libro");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Esto lo usamos para limpiar el buffer y que no nos de errores el codigo

            switch (opcion) {
                case 1:
                    agregarLibro(scanner);
                    break;
                case 2:
                    modificarLibro(scanner);
                    break;
                case 3:
                    eliminarLibro(scanner);
                    break;
                case 4:
                    listarLibros();
                    break;
                case 5:
                    buscarLibro(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intentá de nuevo.");
            }
        } while (opcion != 6);

    }

    static void agregarLibro(Scanner scanner) {
        if (cantidadLibros >= MAX_LIBROS) {
            System.out.println("No se pueden agregar más libros. Capacidad máxima alcanzada.");
            return;
        }
        System.out.print("Ingrese el título del libro: ");
        titulos[cantidadLibros] = scanner.nextLine();
        System.out.print("Ingrese el stock del libro: ");
        stocks[cantidadLibros] = scanner.nextInt();
        scanner.nextLine();
        cantidadLibros++;
        System.out.println("Libro agregado al toque jeje.");
    }

    static void modificarLibro(Scanner scanner) {
        System.out.print("Ingrese el título del libro a modificar: ");
        String titulo = scanner.nextLine();
        for (int i = 0; i < cantidadLibros; i++) {
            if (titulos[i].equalsIgnoreCase(titulo)) {
                System.out.print("Ingrese el nuevo stock del libro: ");
                stocks[i] = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Libro modificado al toque jeje.");
                return;
            }
        }
        System.out.println("No se encontró el libro :(");
    }

    static void eliminarLibro(Scanner scanner) {
        System.out.print("Ingrese el título del libro a eliminar: ");
        String titulo = scanner.nextLine();
        for (int i = 0; i < cantidadLibros; i++) {
            if (titulos[i].equalsIgnoreCase(titulo)) {
                for (int j = i; j < cantidadLibros - 1; j++) {
                    titulos[j] = titulos[j + 1];
                    stocks[j] = stocks[j + 1];
                }
                cantidadLibros--;
                System.out.println("Libro eliminado así nomás.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    static void listarLibros() {
        System.out.println("\n--- Lista de Libros en Stock ---");
        for (int i = 0; i < cantidadLibros; i++) {
            System.out.println("Título: " + titulos[i] + " | Stock: " + stocks[i]);
        }
    }

    static void buscarLibro(Scanner scanner) {
        System.out.print("Ingresá el título del libro a buscar: ");
        String titulo = scanner.nextLine();
        for (int i = 0; i < cantidadLibros; i++) {
            if (titulos[i].equalsIgnoreCase(titulo)) {
                System.out.println("Libro encontrado: " + titulos[i] + " | Stock: " + stocks[i]);
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }
}
