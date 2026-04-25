import java.util.Scanner;

public class Programa {
	
	void iniciar(){
		
		int valor=generarAleatorio();
		int num;
		int resul;
		
		do{
			num=pedirNumero();
			resul=compararNumeros(num, valor);
			System.out.println(resul);
		}while(resul!=0);
		System.out.println("Felicitaciones acertaste!!");
	}
	
	//devuelve un numero aleatorio entre 1 y 1000
	int generarAleatorio(){
		//completar aquí
	}
	
	//pide un nro por pantalla
	 int pedirNumero(){
		 Scanner entrada=new Scanner(System.in);
		 
		////completar aquí
		 
	 }
	
	 //compara dos enteros a y b. Devuelve un String indicando si es menor, mayor o igual
	 String compararNumeros(int a, int b){
		 //completar aquí
	 }
	
}


}