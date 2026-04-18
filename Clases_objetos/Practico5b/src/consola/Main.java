package consola;
//package consola;

import java.util.*;
import logica.*;

public class Main {

	public static void main(String[] args) {
		
		int[] array = new int[5];
		
		//carga las notas en forma aleatoria
		for (int i = 0; i < array.length; i++) {
			
			Random azar = new Random();
			array[i] = azar.nextInt(12)+1;
			
		}
		
		Fecha fd = new Fecha(26,07,1978);
		Fecha fid = new Fecha(18,06,2008);
		Fecha fe = new Fecha(01,11,2006);
		Docente d1 = new Docente("0000", "Gomez", fd, "Fisica", "2", fid);
		Estudiante e1 = new Estudiante("1111", "Lopez", fe, array);
		Estudiante e2 = new Estudiante("2222", "Gimenez", fe, array);
		Estudiante e3 = new Estudiante("3333", "Diaz", fe, array);
		Estudiante e4 = new Estudiante("4444", "Hernandez", fe, array);
		Estudiante e5 = new Estudiante("5555", "Messi", fe, array);
		Libreta l1 = new Libreta();
		l1.setD(d1);
		l1.agregar(e1);
		l1.agregar(e2);
		l1.agregar(e3);
		l1.agregar(e4);
		l1.agregar(e5);
		
		
		System.out.println(l1.toString());
		l1.imprimeCarnet("5555");
	}

	
}