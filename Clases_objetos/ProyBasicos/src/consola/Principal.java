package consola;

import logica.*;

public class Principal {
	public static void main(String[] args) {

		// Scanner entrada = new Scanner(System.in);
		Estudiantes coleccion = new Estudiantes();

		Alumno a1, a2, a3;

		a1 = new Alumno(1, "peepe", 22, 1000);
		a2 = new Alumno(2, "pipoo", 20, 1000);
		a3 = new Alumno(3, "pipu", 30, 1500);
		coleccion.agregar(a1);
		coleccion.agregar(a2);
		coleccion.agregar(a3);
		System.out.println(coleccion.toString());
		coleccion.eliminarXCodigo(3);
		System.out.println(coleccion.toString());
	}
}