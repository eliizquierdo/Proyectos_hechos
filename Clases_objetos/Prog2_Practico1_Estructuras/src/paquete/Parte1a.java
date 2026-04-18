package paquete;

public class Parte1a {
	
		public void iniciarParte1a(){
			int a, b;
			a=2;
			b=5;
			procedimiento(a,b);
			System.out.println("el valor de a es: "+a);
			System.out.println("el valor de b es: "+b);
		}
		
		public void procedimiento (int b, int a){
			System.out.println("el valor de a es: "+a);
			System.out.println("el valor de b es: "+b);
			b=a;
			
		}

}

