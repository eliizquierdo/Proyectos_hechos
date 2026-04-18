package consola;
import java.util.Scanner;
import logica.*;

public class Principal {
	public static void main(String[] args) {
			
		Scanner entrada = new Scanner(System.in);
		Estudiantes coleccion = new Estudiantes();
		
		Alumno a1, a2, a3;
		Becado b=new Becado(123,"papu",1,1000,100);
				
		int opcion, grupo;
		double cuota, beca;
		String apellido;
		
		a1=new Alumno(1,"peepe",1,1000);
		a2=new Alumno(2,"pipoo",3,1000);
		a3=new Alumno(3,"pipu",1,1500);
		//a2.pedirDatos();
		coleccion.agregar(a1);	
		coleccion.agregar(a2);	
		coleccion.agregar(a3);
		System.out.println(coleccion.toString());
		coleccion.eliminarXCodigo(3);
		System.out.println(coleccion.toString());
		System.out.println("Becado: "+b.toString());
		System.out.println("La cuota Neta de b es: "+b.cuotaNeta());
		
	}
}