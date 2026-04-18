package consola;
import java.util.InputMismatchException;
import java.util.Scanner;
import logica.*;

public class Principal {
	static Scanner sc = new Scanner(System.in);
    static GestorAlumno gestorAlumnos = new GestorAlumno();
    static GestorProfesor gestorProfesores = new GestorProfesor();
    static GestorActividad gestorActividades = new GestorActividad();
    static GestorMaterial gestorMateriales = new GestorMaterial();

	public static void main(String[] args) {
		int opc = 0;

        do {
            System.out.println(">>============<<Menu Principal>>============<<");
            System.out.println("	1. Gestionar alumnos.");
            System.out.println("	2. Gestionar profesores.");
            System.out.println("	3. Gestionar actividades.");
            System.out.println("	4. Gestionar materiales.");
            System.out.println("	5. Ver cantidad de alumnos por actividad.");
            System.out.println("	0. Salir.");
            System.out.println(">>============<<Menu Principal>>============<<");
            System.out.println(">Seleccione una opción: ");
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
            	System.out.println("Entrando al menú de alumnos...");
            	gestorAlumnos.subMenuAlumno();

            }else if(opc == 2) {
            	System.out.println("Entrando al menú de profesores...");
            	gestorProfesores.subMenuProfesor();

            }else if(opc == 3) {
            	System.out.println("Entrando al menú de actividades...");
            	gestorActividades.subMenuActividad();

            }else if(opc == 4) {
            	System.out.println("Entrando al menú de materiales...");
            	gestorMateriales.subMenuMaterial();

            }else if(opc == 5) {
            	gestorAlumnos.contarAlumnosPorActividad();

            }else if(opc == 0) {
	            System.out.println("Saliendo...");

            }else {
	            System.out.println("Opción indefinida.");

	        }

        }while (opc != 0);

    }

}