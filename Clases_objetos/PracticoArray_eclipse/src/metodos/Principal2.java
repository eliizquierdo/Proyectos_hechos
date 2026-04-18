package metodos;
/* 7/10 - Metodos  discretos
 * Cargar un array A con nros aleatorios y luego ir cargando
 * otro array B con los nros aleatorios ordenados 
 */

import java.util.Random;

public class Principal2 {

	public static void main(String[] args) {
		
		int A[]=new int[5];
		int B[]=new int[5];
		
		cargarA(A);
		mostrarArray(A);
		for (int i=0; i<5; i++) {
			B[i]=menorA(A);
			//System.out.println("i="+i+"B[i]="+B[i]);
			//mostrarArray(B);
			
			
		}
		mostrarArray(B);
		
	}
	
	//metodo nros Aleatorios entre 1 y 10
		public static int generarAleatorio() {
			Random azar=new Random();
			
			int nro=1+azar.nextInt(10);
			return nro;	
		}
		
		//cargar el array con numeros al azar
		public static void cargarA(int array1[]) {
			
			for(int i=0; i<5; i++) {
				array1[i]=generarAleatorio();
			}
		}
		
		//obtener el menor
		public static int menorA(int array1[]) {
			int nro=11;	
			int j=0;
			for(int i=0; i<5; i++) {
				if ((array1[i]<=nro)) {
					nro=array1[i];
					j=i;
				}
			}
			array1[j]=11;
			return nro;
		}
		
		public static void mostrarArray(int array1[]) {
			
			for(int i=0; i<5; i++) {
				System.out.print(array1[i]+" ");			
			}
			System.out.println("\n");

	}
}
