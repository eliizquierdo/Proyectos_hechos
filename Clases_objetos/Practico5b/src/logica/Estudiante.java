package logica;

//package logica;

import java.util.*;

public class Estudiante extends Persona {
	
	
	//Atributos
	private int[] notas = new int[5];
	
	
	
	//Constructor por defecto
	public Estudiante() {
		
		super();
		
	}
	
	
	//Constructor especifico
	public Estudiante(String cedula, String apellido, Fecha nacimiento, int[] notas) {
		
		super(cedula, apellido, nacimiento);
		
		this.notas = notas;
		
	}


	//Getters
	public int[] getNotas() {
		return notas;
	}


	//Setters
	public void setNotas(int[] notas) {
		this.notas = notas;
	}


	//ToString
	@Override
	public String toString() {
		return " Estudiante: "+ super.toString() + " \nnotas=" + Arrays.toString(notas) + "\n";
	}
	
	
	//Metodos especificos
	public int devolverNota(int p) {
		
		return notas[p];
			
		}


	public void asignarNota(int p, int nota) {
		
		notas[p] = nota;
		
	}
	
	
	public double promedio() {
		
		double suma = 0;
		
		for (int i = 0; i < notas.length; i++) {
			
			suma = suma + notas[i];
			
		}
		
		return suma / notas.length;
		
	}
	

}
