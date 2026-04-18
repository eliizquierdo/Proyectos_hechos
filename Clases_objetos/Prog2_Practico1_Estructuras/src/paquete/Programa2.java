package paquete;

import java.util.Random;
import java.util.Scanner;

public class Programa2 {
	
	public void juego(){
		
		int valor=generarAleatorio();
		int num;
		String resul;
		
		do{
			num=pedirNumero();
			resul=compararNumeros(num, valor);
			System.out.println(resul);
			
		}while(!(resul.equals("igual")));
		System.out.println("Felicitaciones acertaste!!");
	}
	
	//devuelve un numero aleatorio entre 1 y 100
	public int generarAleatorio(){
		Random aleatorio=new Random();
		
		int valor= 1 + aleatorio.nextInt(100);
		return valor;
	}
	
	//pide un nro por pantalla
	 public int pedirNumero(){
		 
		 Scanner entrada=new Scanner(System.in);
		 
		 System.out.println("Ingrese numero: ");
		 int numero=entrada.nextInt();
		 return numero;
		 
	 }
	
	 //compara dos enteros a y b. Devuelve un String indicando si es menor, mayor o igual
	 public String compararNumeros(int a, int b){
		 String esMenor;
		 if (a < b)
				esMenor="Demasiado chico";
		 else
				if (a > b)
					esMenor="Demasiado grande";
				else
					esMenor="igual";
	 
		 return esMenor;
	 }
	
}