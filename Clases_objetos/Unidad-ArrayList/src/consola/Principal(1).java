package consola;
import java.util.ArrayList;
import java.util.Scanner;
import logica.*;

public class Principal{
	public static void main(String[] args) {
			
		Scanner entrada = new Scanner(System.in);
		Estudiantes coleccion = new Estudiantes();
		Fecha nac = new Fecha();
		Alumno a;
		Becado b;
		int opcion, grupo;
		double cuota, beca;
		String apellido;
		
		/* Ejercicio: Completar el desarrollo de la clase Principal,
		permitir agregar tres objetos de Alumno y/o Becado.
		Al final imprimir el contenido del objeto colección */
		for (int i=0; i<3; i++) {
			System.out.println("Presione (1) para agregar Alumno (2)para agregar Becado");
			opcion=entrada.nextInt();
			if (opcion==1) {
				a=new Alumno();
				a.pedirDatos();
				coleccion.agregar(a);
			}
			else {
				b=new Becado();
				b.pedirDatos();
				coleccion.agregar(b);
				
			}
		}//for
		System.out.println(coleccion.toString());
		
	}
}

