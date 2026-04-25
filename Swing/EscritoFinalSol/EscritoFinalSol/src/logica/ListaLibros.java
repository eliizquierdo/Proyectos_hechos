package logica;

import java.util.ArrayList; 

public class ListaLibros { 

   public   ArrayList<Libro> lista;

  //crea la lista de Libros
   public ListaLibros(){ 
	   lista = new ArrayList(); 
   } 

    //Agrega un Libro a la lista 
   public void agregar(Libro lib){ 
	   lista.add(lib); 
   } 

     
   //dada una codigo elimina al Libro de la lista
   public void borrar(int cod){ 
	   lista.remove(this.obtenerXCodigo(cod)); 
   } 
   
   //retorna el alumno que esté en la posición i de la lista
   public Libro devolver(int i){
	   return (lista.get(i));
	   
   }
   
   //devuelte true si ya existe un alumno con la cedula ced
   public boolean estaLibro(int cod){
	   
	   boolean  esta=lista.contains(obtenerXCodigo(cod));
	   return(esta);
   }
   
    //Busca un Libro por la codigo, si no la encuentra retorna null 
   public Libro obtenerXCodigo(int codigo){ 
	   for (int i=0 ; i<lista.size() ; i++){
		   if (lista.get(i).getCodigo() == codigo){
			  return lista.get(i); 
		   }
	   } 
	   return null; 
   } 
   
  
   @Override
   public String toString(){
		return ("Lista de Libros: "+lista);
	}
	
   //retorna el largo de la lista
   public int largo(){
	   int cant=0;
	   
	   if (this!=null)
		   cant=lista.size();
	   return cant;
		   
   }

   //retorna la lista	
   public  ArrayList<Libro> getLista() {
	   return lista;
   }

} 
