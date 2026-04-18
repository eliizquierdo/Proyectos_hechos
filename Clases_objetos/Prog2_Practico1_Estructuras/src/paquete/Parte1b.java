package paquete;

public class Parte1b {
	
	
		void iniciarParte1b(){
			int a= niIdea();
			int b= menos();
			int c= tampoco();
			System.out.println(a+", "+b + ", "+c);
			
		}
		
		int menos (){
			
			int z=-1;
			z--;
			return z;
		}
		
		int tampoco(){
			
			int x =3;
			int y =x+3;
			return x;
		}
			
		int niIdea(){
			
			int a =2;
			int b =a+1;
			return b;
		}
	}