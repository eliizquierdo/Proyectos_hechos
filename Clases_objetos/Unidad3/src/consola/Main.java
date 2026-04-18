package consola;

import logica.*;

public class Main {

	public static void main(String[] args) {
		Alumno a=new Alumno();  //cree el objeto Alumno
		Alumno b=new Alumno("Ruiz",2,2000);
		
		a.setApellido("Perez");
		a.setGrupo(4);
		a.setCuotaBase(1000);
		
		System.out.println("El alumno a es:"+a.toString() );
		System.out.println("El alumno b es: "+b.toString());
		
	}

}