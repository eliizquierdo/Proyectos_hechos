package logica;

import java.util.ArrayList;

public class Estudiantes {
	
	private ArrayList<Alumno> lista;

	public Estudiantes() {
		lista=new ArrayList<>();
	}
	
	public void agregar(Alumno a) {
		lista.add(a);
	}
	
	public void eliminar(Alumno a) {
		lista.remove(a);
	}
	
	public boolean contiene(Alumno a) {
		boolean esta=false;
		
		if (lista.contains(a))
			esta=true;
		return esta;
	}
	
	public Alumno devolver(int i) {
		return lista.get(i);
	}
	
	public int cantidad() {
		return lista.size();
	}
	
	public double totalCuotas() {
		double suma=0;
		for(Alumno actual:lista) {
			suma=suma+actual.cuotaNeta();
		}
		
		return suma;
	}
	
	public double totalCuotas1() {
		double suma=0;
		for(int x=0; x<=lista.size(); x++) {
			suma=suma+lista.get(x).cuotaNeta();
		}		
		return suma;
	}
	
	public int totalBecados() {
		int cantidad = 0;
		for (Alumno actual : lista) {
			if (actual instanceof Becado)
				cantidad++;
			}
		return cantidad;
		}

	@Override
	public String toString() {
		String temp="Apellido \tGrupo \tCuota Base \tCuota Neta \tFecha nac. \tSaldo Cuota";
		for (Alumno actual : lista) {
			temp=temp+actual.toString();
		}
	
		temp=temp + "\nSuma de cuotas netas = " + totalCuotas()
		+ "\nTotal de estudiantes becados = " + totalBecados();
		return temp;
	}
	
	
}
