package paquete;

import java.util.Scanner;

public class Programa3 {
	
	public void iniciar(){
		String or1, or2;
		
		or1=cargarString();
		or2=cargarString();
		menu(or1,or2);
	}
	
	//carga de teclado dos String
	public String cargarString(){
		
		Scanner entrada=new Scanner(System.in);
		 
		 System.out.println("Ingrese un String: ");
		 String oracion=entrada.nextLine();//para leer lineas de texto sino lee hasta un espacio en blanco
		 return oracion;
		 
		 
	}
	
	//despliega menú
	public void menu(String a, String b){
		int select;
		Scanner entrada=new Scanner(System.in);
		
				
		//Mientras la opción elegida sea distinto de 0, 
		//preguntamos al usuario
			do{
					System.out.println("Menú de opciones\n"+
							    "\n1.- Imprimir ambas cadenas y su largo." +
								"\n2.- Comparar igualdad y quien es menor" +
								"\n3.- Cambiar una cadena a todo mayúsculas y otra a todo minúsculas" +
								"\n4.- Cargar nuevamente ambos String" +
								"\n0.- Salir"
								+ "\nElige opción: ");
						//Recoger una variable por consola
						
						select =entrada.nextInt();
						//Ejemplo de switch case en Java
						switch(select){
						case 1: 
								System.out.println("Primer String: "+a.toString()+"\nSegundo String: "+b.toString());
								System.out.println("Largo del Primer String: "+a.length()+"\nLargo del Segundo String: "+b.length());
								break;
						case 2: 
								System.out.println("Sin hacer!!!!");
								break;
						case 3: 
							System.out.println("Primer String a mayuscula: "+a.toUpperCase().toString()+"\n Segundo String: "+b.toLowerCase().toString());
							
							break;
						case 4: 
							a=cargarString();
							b=cargarString();
							break;
						case 0: 
							System.out.println("Adios!");
							break;
						default:
							System.out.println("Número no reconocido");break;
						}
						
						System.out.println("\n"); //Mostrar un salto de línea en Java
			}while(select != 0);

		}
}
	


