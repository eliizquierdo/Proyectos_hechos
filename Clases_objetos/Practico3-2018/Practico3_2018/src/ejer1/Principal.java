package ejer1;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		
		 Scanner entrada = new Scanner(System.in);
		 int opcion;
		 Nacional n1=new Nacional(1,"lapiz",20,"Mdeo",true);
		 Nacional n2=new Nacional(2,"goma",10,"Canelones",false);
		 Importado i1=new Importado(3,"vino",100,2018,50);
		 Importado i2=new Importado(4,"whisky",500,2017,200);
		 Articulos misArticulos=new Articulos();
		 misArticulos.insertar(n1);
		 misArticulos.insertar(n2);
		 misArticulos.insertar(i1);
		 misArticulos.insertar(i2);
		 System.out.print("\nLa cantidad de Articulos nacionales es: "+misArticulos.cantidadNacionales()+"\n");
		 System.out.print("\nEl Articulo mas  caro es:\n "+misArticulos.articuloCaro().toString()+"\n");
		 System.out.print("\nLos Articulos ingresos son: \n "+misArticulos.toString()+"\n");
	}

}
