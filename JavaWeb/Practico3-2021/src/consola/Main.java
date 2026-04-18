package consola;

import logica.*;

public class Main {
	public static void main(String[] args){
	   Fecha f1= new Fecha(30,01,2026);  //constructor especifico
	   Fecha f2= new Fecha();  //constructor por defecto
	   System.out.println(f1.toString());
	   System.out.println(f2.toString());
	   
	   Articulo a1=new Articulo(30,"Pan",50,f1);
	   Articulo a2=new Articulo();
	   System.out.println(a1.toString());
	   //System.out.println(a2.toString());
	   Fecha actual=new Fecha(10,6,2021);
	   System.out.println("\nFecha actual: "+actual.toString());
	   boolean chequear=a1.estaVencido(actual);
	   System.out.println(chequear);
	}
}


