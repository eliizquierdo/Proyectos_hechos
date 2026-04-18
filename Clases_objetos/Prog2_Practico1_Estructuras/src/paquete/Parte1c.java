package paquete;

public class Parte1c {
	
	
		void iniciarParte1c(){
			int a, b, c, x;
			a = 2;
			b = a + a;
			c= a+1;
			x = funcion(a,b,c);
			System.out.println("el valor de x es: " + x);
			
		}
		
		int funcion(int x, int y, int z){
			x = x + 1;
			y = x + 2;
			z = x + y + z;
			return z;
		}
	}