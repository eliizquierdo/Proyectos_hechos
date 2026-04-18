package logica;
import java.util.*;

public class GestorActividad {
	private Scanner sc = new Scanner(System.in);
    private ArrayList<Actividad> lista = new ArrayList<>();

    public void agregar(Actividad obj) {
        lista.add(obj);
        System.out.println("Actividad agregada correctamente.");
    }

    public void eliminar(String id) {
        boolean eliminado = lista.removeIf(obj -> obj.getId().equals(id));
        System.out.println(eliminado ? "Actividad eliminada." : "Código no encontrado.");
    }

    public void mostrar() {
        if (lista.isEmpty()) System.out.println("Lista vacía.");
        else for (Actividad obj : lista) obj.mostrar();
    }
    public void subMenuActividad() {
    	int opc;

        do {
            System.out.println(">>======<<Menú de actividades>>======<<");
            System.out.println("	1. Agregar actividad.");
            System.out.println("	2. Eliminar actividad.");
            System.out.println("	3. Mostrar lista.");
            System.out.println("	0. Volver.");
            System.out.println(">>======<<Menú de actividades>>======<<");
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
	            String nombre = sc.next();

	            System.out.print("Código: ");
	            String codigo = sc.next();

	            System.out.print("Profesor: ");
	            String profesor = sc.next();
	            int cupo = 0;
	            System.out.print("Cupo: ");
	            while (true) {
	            	try {
	            		cupo = sc.nextInt();
	            		break;
	            	}catch(InputMismatchException e) {
	            		sc.nextLine();
	            		System.out.print("Debe ingresar un número entero: ");
	            	}
	            }
	
	            	Actividad a = new Actividad(nombre, codigo, profesor, cupo);
	            	this.agregar(a);

            }else if(opc == 2) {
            	System.out.print("Ingrese código a eliminar: ");

            	String codigo = sc.next();
            	this.eliminar(codigo);

            }else if(opc == 3) {
            	this.mostrar();

            }else if(opc == 0) {
            	System.out.println("Volviendo...");

            }else {
            	System.out.println("Opción indefinida.");

            }

        }while (opc != 0);

    }

}