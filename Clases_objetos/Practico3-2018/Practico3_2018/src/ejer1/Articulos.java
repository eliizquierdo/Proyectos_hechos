package ejer1;

import java.util.ArrayList;

public class Articulos {
	
	private ArrayList<Articulo> lista; 
	
	public Articulos(){	// Constructor de Articulos
		lista=new ArrayList<>();
	}

	/** Métodos primitivos **/
	public void insertar(Articulo a) { 
		lista.add(a);
	}
	
	public void eliminar(int cod){
		lista.remove(this.obtenerXCodigo(cod));
	}
	
	public boolean encontrar(int cod){
		return (lista.contains(this.obtenerXCodigo(cod)));
	}
	
	//devuelve  el Articulo que esta en la posicion i
	public Articulo devolver(int i) {
			return (lista.get(i));
	}
	
	public boolean esVacia(){
		
		return( lista.isEmpty());
	}
	
	public int cantidad(){
		return (lista.size());
			
	}
	
		
	public String toString() {
		return "\n" + lista + "\n";
	}
	
	/** Método específico **/
	public int cantidadNacionales(){
		int nacionales = 0;
		for (Articulo actual : lista){
			if(actual instanceof Nacional) 
				nacionales++;
		}
		return nacionales;
	}
	
	public int cantidadImportados(){
		int importados = 0;
		for (Articulo actual : lista){
			if(actual instanceof Importado) 
				importados++;
		}
		return importados;
	}
	
	public Articulo articuloCaro(){
		
		Articulo extra=this.devolver(0);
		double precio=0;
		for (int i=0;i<this.cantidad(); i++){
			if(this.devolver(i).precioVenta()>precio)
				extra=this.devolver(i);
			
		}
		return (extra);
	}
	
	//Busca un Articulo por la codigo, si no la encuentra retorna null 
		public Articulo obtenerXCodigo(int cod){ 
			boolean encontre=false;
			Articulo temp=new Articulo();
			int i=0;
			
			  do{
				   if (lista.get(i).getCodigo()==cod){
					  temp= lista.get(i); 
					  encontre=true;
				   }
				   else i++;
			   }while(i<lista.size() && !encontre);
			   return temp; 
		} 
			
} // Fin de la clase Articulo
	
