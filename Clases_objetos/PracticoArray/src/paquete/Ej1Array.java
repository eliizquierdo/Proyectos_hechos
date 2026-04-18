package paquete;
import java.util.Scanner;

public class Ej1Array{

    public static void main(String[] args) {
        // Opciones del menú
        String[] menu = {
            "1. Pasta",
            "2. Ravioles",
            "3. Asado",
            "4. Torta de fiambre",
            "5. Ensalada",
            "6. Milanesas",
            "7. Sopa",
            "8. Pizza",
            "9. Empanadas",
            "10. Postre"
        };
        
        // Arreglo para rastrear las opciones seleccionadas (inicialmente todo en false)
        boolean[] seleccionadas = new boolean[menu.length];
        
        System.out.println("Bienvenido al restaurante. Estas son nuestras opciones de menú:");
        for (int i=0; i<menu.length;i++) {
            System.out.println(menu[i]);
        }
        
        Scanner scanner = new Scanner(System.in);
        String continuar;
        
       
        do {
            System.out.print("Seleccione el número de una opción del menú (1-10): ");
            int seleccion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
            
            
            if (seleccion >= 1 && seleccion <= 10) {
                seleccionadas[seleccion - 1] = true; 
                System.out.print("¿Desea seleccionar otra opción? (s/n): ");
                continuar = scanner.nextLine();
            } else {
                System.out.println("Opción inválida. Intente de nuevo.");
                continuar = "s"; 
            }
        } while (continuar.equalsIgnoreCase("s"));
        
        System.out.println("Usted ha seleccionado las siguientes opciones:");
        for (int i = 0; i < menu.length; i++) {
            if (seleccionadas[i]) {
                System.out.println(menu[i]);
            }
        }

        scanner.close();
    }
}

