package prog1;
import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		int calificaciones[]=new int [10];
		Random azar=new Random();
		int nota;
		int suma=0, promedio=0;
		
		//cargo el array con las notas al azar
		for(int i=0; i<10;i++) {
			nota=azar.nextInt(12)+1;
			calificaciones[i]=nota;
		}
		//muestro las calificaciones cargadas
		for(int i=0; i<10;i++) {
			System.out.println(calificaciones[i]);
		}
		
		//Halla el promedio
		for(int i=0; i<10;i++) {
			suma=suma+calificaciones[i];
		}
		promedio=suma/10;
		System.out.println("El promedio es: "+ promedio);
		
		
		
		
	}

}
