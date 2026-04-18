package logica;
import java.util.ArrayList;

public class ListaProductos {
	private ArrayList<Producto> lista;
	
	//constructor
	public 	ListaProductos() {
		lista=new ArrayList<>(); //crear la lista vacia
	}
	
	public void insertarProducto(Producto p) {
		lista.add(p);
	}
	
	public void eliminarProducto(int codigo) {
		
		int x=0;
		boolean encontre=false;
		do{
			if(lista.get(x).getCodigo()==codigo) {
				lista.remove(x);
				encontre=true;
			 }else
				x++;
		 }while( x<lista.size()||!encontre);
					
	
	}
	
	public Producto devolver(int i) {
		
		return (lista.get(i));
	}
	
	public String toString() {
		return lista.toString();
	}

}
