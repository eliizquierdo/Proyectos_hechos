package logica;

import java.util.*;

public class GestorProfesor {
	static Scanner sc = new Scanner(System.in);
    private ArrayList<Profesor> lista = new ArrayList<>();

    public void agregar(Profesor obj) {
        lista.add(obj);
        System.out.println("Profesor agregado correctamente.");
    }

    public void eliminar(String id) {
        boolean eliminado = lista.removeIf(obj -> obj.getId().equals(id));
        System.out.println(eliminado ? "Profesor eliminado." : "CI no encontrado.");
    }

    public void mostrar() {
        if (lista.isEmpty()) System.out.println("Lista vacía.");
        else for (Profesor obj : lista) obj.mostrar();
    }
    public void subMenuProfesor () {
    	int opc;

        do {
            System.out.println(">>======<<Menú de profesores>>======<<");
            System.out.println("	1. Agregar profesor.");
            System.out.println("	2. Eliminar profesor.");
            System.out.println("	3. Mostrar lista.");
            System.out.println("	0. Volver.");
            System.out.println(">>======<<Menú de profesores>>======<<");
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

            if (opc == 1) {
            	System.out.print("Nombre: ");
            	String nombre = sc.nextLine();

            	System.out.print("CI: ");
            	String ci = sc.nextLine();

            	System.out.print("Especialidad: ");
            	String esp = sc.nextLine();

            	Profesor p = new Profesor(nombre, ci, esp);
            	this.agregar(p);

            }else if (opc == 2) {
            	System.out.print("Ingrese CI a eliminar: ");

            	String ci = sc.next();
            	this.eliminar(ci);

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