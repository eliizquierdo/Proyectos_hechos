package metodos;
/* Ejercicio propuesto en Métodos discretos para coordinar con programación Array y funciones y procedimientos.
Link a la letra del ejercicio: https://drive.google.com/file/d/1n9JqNrYwIl2PGq4sEJdQ6h70e_XEdzxo/view?usp=sharing */


import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		int juego[]=new int[50];
		
		cargarJuego(juego);
		mostrarJuego(juego);
		
	}
	
	//metodo tirarDado
	public static int tirarDado() {
		Random azar=new Random();
		
		int dado=1+azar.nextInt(6);
		return dado;	
	}
	
	//cargar el array con numeros al azar
	public static void cargarJuego(int array1[]) {
		
		for(int i=0; i<50; i++) {
			array1[i]=tirarDado();
		}
	}
		
	
	public static void mostrarJuego(int array1[]) {
			
		for(int i=0; i<50; i++) {
			System.out.println(array1[i]);			
		}
	}
}
