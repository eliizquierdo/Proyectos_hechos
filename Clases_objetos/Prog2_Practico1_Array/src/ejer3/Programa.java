package ejer3;
import java.util.Random;

public class Programa {
	private int array1[];
	
	Random azar = new Random();
	
	public Programa(int cant) {
		array1= new int [cant];
	}
	
	public void cargarArrayAzar() {
		for(int i=0; i<array1.length; i++) {
			int valor = azar.nextInt(1,50);
			array1[i]= valor;
		}
	}
	
	public void cargarArrayNaturales() {
		int valor;
		for(int i=0; i<array1.length; i++) {
			 valor = i;
			array1[i]= valor;
		}
	}
	
	public void mostrarArray() {
		for(int i=0; i<array1.length; i++) {
			System.out.print(array1[i]+", ");
		}
	}
	
	public int promedioArray() {
		int prom=0;
		
		for(int i=0; i<array1.length; i++) {
			prom=prom + array1[i];
		}
		prom=prom/array1.length;
		return prom;
	}
	
	//Crear un metodo, que devuelva el primer 2 que encuentre, sino devuelva un 0
	 public int devolver2() {
		 int i=0;
		 int resul=0;
		 boolean bandera=false;
		 do {
			 if(array1[i]==2) {
				 resul=2;
				 bandera=true;
			 }
				 
			 else
				 i++;
		 }while((bandera!=true) || (i<array1.length));
		 
		 
		 return resul;
	 }
	 
	 public int devolverIndice2() {
		 int i=0;
		 int resul=0;
		 boolean bandera=false;
		 do {
			 if(array1[i]==2) 
				 bandera=true;
			  else
				 i++;
			 }while((bandera!=true) && (i<array1.length));
		 return i;
	 }
}
