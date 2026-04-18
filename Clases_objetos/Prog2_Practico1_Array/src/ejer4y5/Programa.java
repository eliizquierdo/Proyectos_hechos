package ejer4y5;

public class Programa {
	public int elMayor (int a[]) {
		int mayor = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > mayor)
				mayor = a[i];
		}
		return(mayor);
	}
	
	public int elMenor (int a[]) {
		int menor = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] < menor)
				menor = a[i];
		}
		return(menor);
	}
}
