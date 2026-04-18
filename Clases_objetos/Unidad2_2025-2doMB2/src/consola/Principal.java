package consola;
import logica.*;

import java.util.ArrayList;

public class Principal {
	public static void main(String[] args) {
		
		ArrayList <String> listaNombres=new ArrayList <>();
		listaNombres.add("Luis");
		listaNombres.add("Pedro");
		listaNombres.add("Ana");
		listaNombres.add("Maria");
		System.out.println("Inicial: "+listaNombres.toString());
		listaNombres.remove(1);
		System.out.println("Después de eliminar el elem 1: "+listaNombres.toString());
		int tamanio=listaNombres.size();
		System.out.println("Tamaño: "+ tamanio);
		
	}
}
