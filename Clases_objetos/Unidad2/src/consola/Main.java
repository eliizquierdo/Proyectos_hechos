package consola;
import logica.Alumno;

public class Main {

	public static void main(String[] args) {
		Alumno a=new Alumno();//creando un objeto de tipo Alumno
		System.out.println("a tiene lo siguiente: "+a.toString());
		Alumno b=new Alumno("Francisco",111,"2bc",10000);
		System.out.println("b tiene los siguiente datos: "+b);
	
	}

}
