package logica;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorMaterial {
	static Scanner sc = new Scanner(System.in);
    private ArrayList<Material> lista = new ArrayList<>();

    public void agregar(Material obj) {
        lista.add(obj);
        System.out.println("Material agregado correctamente.");
    }

    public void eliminar(String id) {
        boolean eliminado = lista.removeIf(obj -> obj.getId().equals(id));
        System.out.println(eliminado ? "Material eliminado." : "Código no encontrado.");
    }

    public void mostrar() {
        if (lista.isEmpty()) System.out.println("Lista vacía.");
        else for (Material obj : lista) obj.mostrar();
    }
    public void subMenuMaterial() {
    	int opc;

        do {
            System.out.println(">>======<<Menú de materiales>>======<<");
            System.out.println("	1. Agregar material.");
            System.out.println("	2. Eliminar material");
            System.out.println("	3. Mostrar lista.");
            System.out.println("	0. Volver.");
            System.out.println(">>======<<Menú de materiales>>======<<");
            System.out.print(">Seleccione una opción: ");
            while (true) {
            	try {
            		opc = sc.nextInt();
            		break;
            	}catch(InputMismatchException e) {
            		sc.nextLine();
            		System.out.print("Debe ingresar una opción: ");
            	}
            }

            if (opc ==1) {
            	System.out.print("Nombre: ");
            	String nombre = sc.next();

            	System.out.print("Código: ");
            	String codigo = sc.next();

            	System.out.print("Estado: ");
            	String estado = sc.next();

            	int cantidad = 0;
            	System.out.print("Cantidad: ");
            	while (true) {
	            	try {
	            		cantidad = sc.nextInt();
	            		break;
	            	}catch(InputMismatchException e) {
	            		sc.nextLine();
	            		System.out.print("Debe ingresar un número entero: ");
	            	}
	            }

            	Material m = new Material(nombre, codigo, estado, cantidad);
            	this.agregar(m);
            }else if (opc == 2) {
            	System.out.print("Ingrese código a eliminar: ");

            	String codigo = sc.nextLine();
            	this.eliminar(codigo);

            }else if (opc == 3) {
            	this.mostrar();

            }else if (opc == 0) {
            	System.out.println("Volviendo...");

            }else {
            	System.out.println("Opción indefinida.");

            }

        } while (opc != 0);

    }

}