package ejem1;

public class Principal {

	public static void main(String[] args) {
		Programa p=new Programa();
		p.bienvenido();
		int numero1=9;
		int numero2=10;
		int resul =p.sumar(numero1, numero2);
		System.out.println("La suma resul da: "+resul);

	}

}
