package ejercicio1;

public class Calculadora {
	
	int suma(int a, int b) {
		return(a+b);
	}
	int resta(int a, int b) {
		return(a-b);
	}
	int multiplica(int a, int b) {
		return(a*b);
	}
	float divide(int a, int b) {
		int valor;
		if (b != 0)
			valor = a/b;
		else valor = -1;
		return(valor);
	}
	float residuo(int a, int b) {
		int valor;
		if (b != 0)
			valor = a%b;
		else valor = -1;
		return(valor);
	}

}
