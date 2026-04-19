package logica;

import java.util.ArrayList;
import static grafica.MenuPrincipal.lista;
public class Productos {
	
	private ArrayList<Articulo> lista;
	public Productos() {
		lista = new ArrayList<>();
	
	}
	
	public void agregar(Articulo a) {
		lista.add(a);
	}
	
	public void eliminar(Articulo a) {
		lista.remove(a);
	}
	
	public boolean contiene(Articulo a) {
		boolean esta=false;
		
		if (lista.contains(a))
			esta=true;
		return esta;
	}
	
	public Articulo devolver(int i) {
		return lista.get(i);
	}
	
	public int cantidad() {
		return lista.size();
	}
	
	public double totalprecioVenta() {
		double suma=0;
		for(Articulo actual:lista) {
			suma=suma+actual.precioVenta();
		}
		
		return suma;
	}
	public Articulo buscar(int codigo) {
	    
	    int i = 0;
	    
	    while(i < (cantidad())){
	      
	      if(devolver(i).getCodigo() == codigo) {
	        
	        return devolver(i);
	        
	      }
	      
	      i++;
	      
	    }
	    
	    return null;
	    
	  }
public Articulo buscar2(int codigo) {
	    
	    int i = 0;
	    
	    while(i < (cantidad())){
	      
	      if(devolver(i).getCodigo() == codigo) {
	        
	        return lista.get(i);
	        
	      }
	      
	      i++;
	      
	    }
	    
	    return null;
	    
	  } 
	
	public double totalprecioVenta1() {
		double suma=0;
		for(int x=0; x<=lista.size(); x++) {
			suma=suma+lista.get(x).precioVenta();
		}		
		return suma;
	}
	
	public int totalBecados() {
		int cantidad = 0;
		for (Articulo actual : lista) {
			if (actual instanceof Nacional)
				cantidad++;
			}
		return cantidad;
		}
    @Override
	public String toString() {
		return  "\n" + lista + "\n";  
	}

	
	
}