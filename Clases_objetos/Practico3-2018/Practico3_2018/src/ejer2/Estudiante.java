package ejer2;


public class Estudiante extends Persona{
	
	private int edad;
	private int [] notas;
	
	public Estudiante(){
		super();
		notas=new int[5];
		for (int i=0; i<5;i++)
			notas[i]=1;
		
	}
	
	public Estudiante(String cedula, String apellido, int edad) {
		super(cedula, apellido);
		this.edad=edad;
		this.notas = new int [5];
		for (int i=0; i<5;i++)
			notas[i]=1;
	}

	
	public int devolverNota(int i) {
		return notas[i];
	}

	public void asignarNota(int n, int i) {
		if (n>=1 && n<=12)
			notas[i]=n;
	}
	
	
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double promedio(){
		
		int acumulador=0;
		for (int nota: notas)	//for each: toma una nota del arreglo
			acumulador=acumulador+nota;
		return((double) acumulador/notas.length);
	}

	@Override
	public String toString() {
		return 	super.toString()
				+ "\n Promedio final= "+promedio();
	}
	
	
}

