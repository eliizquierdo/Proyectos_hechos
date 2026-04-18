package paquete;

public class Recursividad {
	
	public static void main(String[] args) {
		
		System.out.println("tio (5) es: "+tio(5));
		cuentaRegresiva(5);
		//System.out.println("El resultado de fun(3) es: ") //COMPLETAR EL SYSO
		//System.out.println("La suma de los 4 primeros cuadrados es:"+sumaCuadrados(5));
		//decir("Hola",1);
		//System.out.println("La potencia de 2 a la 4 es:"+potencia(8,0));
	}
	
	public static int tio(int n) {
		
		if (n==2)
			return 100;
		else
			return(9 + tio(n -1));
	}
	
public static void cuentaRegresiva(int numero) {
		
		System.out.println(numero); 
	    if(numero==0)
	    	System.out.println(0); 
	    else	
	    	cuentaRegresiva(numero - 1);
	   
	}
	
	/*****************Ejercicio*****************/
	
/*Definir la función fun:Int ->Int tal que fun(1) = 1 
 * y para el resto de los enteros x, es 2*fun(x-1)	
 */

	public static int fun(int x) {
		if (x==1)
			return 1;
		else
			return(2*fun(x-1));
		
	}
	
	/*Escribir un método que dado una palabra y un número n, imprima 
	 * en pantalla la palabra n veces.
	 */
	public static void decir(String texto, int n) {
		System.out.println(texto+" ");
		if (n>1)
			decir(texto, n-1);
		
		
	}
	
	/*Definir por recursión la función sumaCuadrados:Int -> Int
	 *  tal que (sumaCuadrados n) es la suma de los cuadrados 
	 *  de los números de 1 a n.
	 *   Por ejemplo: sumaCuadrados(4) es 30  */
	
	public static int sumaCuadrados(int n) {
		if (n==1)
			return 1;
		else
			return (n*n+ sumaCuadrados(n-1));
			
		
	}
	
	/*Definir la función potencia:Int->Int-> Int
	 *  Por ejemplo: potencia(2,3) >>8
	 */
	public static int potencia(int x, int n) {
		
			if (n==0)
				return 1;
			else
				return (x*potencia (x,n-1));
	}
	
	

}
