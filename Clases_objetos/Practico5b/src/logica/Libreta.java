package logica;

//package logica;

import java.util.*;

public class Libreta {

	
	//Atributos
	private Docente d;
	private ArrayList <Persona> lista;
	
	
	
	//Constructor por defecto
	public Libreta() {
		
		lista = new ArrayList<>();
		
	}
	
	
	//Metodos Primitivos
	public void agregar(Persona p) {
		
		lista.add(p);
		
	}
	
	
	public Persona devolver(int pos) {
		
		return lista.get(pos);
		
	}
	
	
	public void eliminar(int pos) {
		
		lista.remove(pos);
		
	}
	
	
	public int cantidad() {
		
		return lista.size();
		
	}
	
	
	public void setD(Docente d) {
		
		this.d = d;
		
	}
	
	
	public Docente getD() {
		
		return d;
		
	}
	
	
	//ToString
	@Override
	public String toString() {
		return "Libreta: \n" + d.toString() +"\n"+lista+  "\n"; 
	}


	//Metodos Especificos
	public int aprobados() {
		
		int cant = 0;
		
		for (Persona persona : lista) {
			
			if(persona instanceof Estudiante && ((Estudiante) persona).promedio() >= 8)
				
				cant++;
			
		}
		
		return cant;
		
	}
	
	
	public void imprimeCarnet(String cedula) {
		
		for (Persona persona : lista) {
			
			if(cedula == persona.getCedula())
				
				System.out.println("Apellido: " + persona.getApellido() + " Promedio: " + ((Estudiante)persona).promedio());
			
		}
		
	}
	
	
	
	
}
