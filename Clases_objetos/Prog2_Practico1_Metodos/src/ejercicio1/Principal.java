package ejercicio1;

public class Principal {

	public static void main(String[] args) {
		
		Calculadora p=new Calculadora();
		int a=6, b=3;	
		int result1= p.suma(a, b);
		System.out.println("El resultado de la suma es: "+ result1);

		int result2= p.resta(a, b);
		System.out.println("El resultado de la resta es: "+ result2);
		
		int result3= p.multiplica(a, b);
		System.out.println("El resultado de la multiplicación es: "+ result3);
		
		float result4= p.divide(a, b);
		System.out.println("El resultado de la división es: "+ result4);
		
		float result5= p.residuo(a, b);
		System.out.println("El residuo es: "+ result5);
	}
}
	
