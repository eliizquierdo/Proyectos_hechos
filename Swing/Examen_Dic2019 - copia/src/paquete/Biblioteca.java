package paquete;
import java.util.ArrayList;

public class Biblioteca {
	
   private   ArrayList<Libro> lista;

	   public Biblioteca(){ 
		   lista = new ArrayList<>(); 
	   } 

	    
	   public void insertar(Libro l){ 
		   lista.add(l); 
	   } 

	   
	   public int cantidad(){
		   int cant=0;
		   
		   if (this!=null)
			   cant=lista.size();
		   return cant;
			   
	   }
	   
	   public int librosLargos() {
		   int cant=0;
		   
		   for(int i=0; i<=this.cantidad();i++)
			   if(lista.get(i).getPaginas()>=500)
				   cant++;
		   return cant;
	   }
	   
	   public  ArrayList<Libro> getLista() {
		   return lista;
	   }

} 


