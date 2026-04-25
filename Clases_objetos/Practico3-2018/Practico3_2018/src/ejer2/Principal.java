package ejer2;

public class Principal {

	public static void main(String[] args) {
		Docente d1=new Docente("1","Perez","inf","2bj");
		Estudiante e1=new Estudiante("2","Garcia",18);
		Estudiante e2=new Estudiante("3","Ruiz",17);
		Estudiante e3=new Estudiante("4","Díaz",19);
		Estudiante e4=new Estudiante("5","Calvette",16);
		Estudiante e5=new Estudiante("6","Torres",22);
		e1.asignarNota(10, 0);
		e1.asignarNota(12, 1);
		e1.asignarNota(10, 2);
		e1.asignarNota(10, 3);
		e1.asignarNota(10, 4);
		System.out.println("Promedio de Garcia: "+e1.promedio());
		e2.asignarNota(1, 0);
		e2.asignarNota(12, 1);
		e2.asignarNota(10, 2);
		e2.asignarNota(10, 3);
		e2.asignarNota(10, 4);
		System.out.println("Promedio de Ruiz: "+e2.promedio());
		
		Libreta l=new Libreta();
		l.setDocente(d1);
		l.insertar(e1);
		l.insertar(e2);
		l.insertar(e3);
		l.insertar(e4);
		l.insertar(e5);
		System.out.println("La lista de estudiantes es: ");
		l.imprimeLista();
		System.out.println("Elimino a Garcia");
		l.eliminar(e3.getCedula());
		System.out.println("La lista de estudiantes es: ");
		l.imprimeLista();
		System.out.println("Busco a Ruiz: ");
		if (l.encontrar(e2.getCedula()))
			System.out.println("Lo encontré ");
		else
			System.out.println("No lo encontré ");
		Estudiante e=new Estudiante();
		e=l.devolver(0);
		System.out.println("El estudiante devuelto es: "+e.toString());
		if (l.esVacia())
			System.out.println("La lista es vacia");
		else
			System.out.println("La lista no es vacia");
		System.out.println("La lista tiene: "+l.cantidad()+" de elementos");
		System.out.println("La cantidad de alumnos aprobados es: "+l.aprobados());
		System.out.println("La edad promedio  de alumnos  es: "+l.edadPromedio());
		System.out.println("El carnet de Ruiz es: ");
		l.imprimeCarnet(e2.getCedula());
		System.out.println("\nLa lista completa es: ");
		l.imprimeLista();
		
	}

}
