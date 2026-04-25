package logica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class GestorAlumno {
	static Scanner sc = new Scanner(System.in);
    private ArrayList<Alumno> lista = new ArrayList<>();

    public void agregar(Alumno obj) {
        lista.add(obj);
        System.out.println("Alumno agregado correctamente.");
    }

    public void eliminar(String id) {
        boolean eliminado = lista.removeIf(obj -> obj.getId().equals(id));
        System.out.println(eliminado ? "Alumno eliminado." : "CI no encontrado.");
    }

    public void mostrar() {
        if (lista.isEmpty()) System.out.println("Lista vacía.");
        else for (Alumno obj : lista) obj.mostrar();
    }

    public ArrayList<Alumno> getLista() {
        return lista;
    }
    public void subMenuAlumno () {
    	
    	int opc;
        
        do {
            System.out.println(">>======<<Menú de alumnos>>======<<");
            System.out.println("	1. Agregar alumno.");
            System.out.println("	2. Eliminar alumno.");
            System.out.println("	3. Mostrar lista.");
            System.out.println("	0. Volver.");
            System.out.println(">>======<<Menú de alumnos>>======<<");
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

            	System.out.print("CI: ");
            	String ci = sc.next();

            	System.out.print("Actividad: ");
            	String act = sc.next();

            	int edad = 0;
            	System.out.print("Edad: ");
            	while (true) {
	            	try {
	            		edad = sc.nextInt();
	            		break;
	            	}catch(InputMismatchException e) {
	            		sc.nextLine();
	            		System.out.print("Debe ingresar un número entero: ");
	            	}
            	}

            	System.out.print("Alergia: ");
            	String alergia = sc.next();

            	System.out.print("Medicación: ");
            	String medicacion = sc.next();

            	boolean fichaMedica = false;
            	System.out.print("¿Entregó ficha médica? (true/false): ");
            	while (true) {
	            	try {
	            		fichaMedica = sc.nextBoolean();
	            		break;
	            	}catch(InputMismatchException e) {
	            		sc.nextLine();
	            		System.out.print("Debe ingresar true o false: ");
	            	}
	            }

            	Alumno a = new Alumno(nombre, ci, act, edad, alergia, medicacion, fichaMedica);
            	this.agregar(a);

            }else if (opc == 2) {
            	System.out.print("Ingrese CI a eliminar: ");

            	String ci = sc.nextLine();
            	this.eliminar(ci);

            }else if (opc == 3) {
            	this.mostrar();

            }else if (opc == 0) {
            	System.out.println("Volviendo...");

            }else {
				System.out.println("Opción invalida.");

            }

        }while (opc != 0);

    }

    public void contarAlumnosPorActividad() {
    	Map<String, Integer> conteo = new HashMap<>();
        for (Alumno a : this.getLista()) {
            conteo.put(a.getActividad(), conteo.getOrDefault(a.getActividad(), 0) + 1);
        }
        System.out.println("--- Alumnos por actividad ---");

        conteo.forEach((actividad, cantidad) ->
            System.out.printf("%s: %d alumno(s)%n", actividad, cantidad));
    }

}