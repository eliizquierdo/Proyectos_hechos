package paquete;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		int []numeros= {3,2,6,5,7};
		int []numeros2=new int[6];
		Scanner teclado=new Scanner(System.in);
		
		
		for(int i=0;i<numeros.length;i++) {
			System.out.println(numeros[i]);
		}
		//cargando el array con numeros enteros
		for(int i=0;i<numeros2.length;i++) {
			System.out.println("Ingrese el valor para la posición "+i+":");
			numeros2[i]=teclado.nextInt();
		}
		
		//mostrar el array de numeros
		for(int i=0;i<numeros2.length;i++) {
			System.out.println("Valor para la posición "+i+":");
			System.out.println(numeros2[i]);
		}
		
		
	}

}
