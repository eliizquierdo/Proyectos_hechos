package consola;

import logica.*;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		 Arquero a1 = new Arquero("Daniel", 100, 50, 10, 10);
	        a1.recargarFlecha();

	        Guerrero g1 = new Guerrero("Ciro", 90, 50, 7);

	        while (g1.getSalud() > 0 && a1.getCantFlechas() > 0) { 
	            a1.dispararFlecha(g1); 
	            System.out.println("Al guerrero le queda: " + g1.getSalud() + " de vida");
	        }

	        a1.recargarFlecha(); 
	}
}
