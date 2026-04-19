package logica;
		
//---------------IMPORTS--------------
import java.util.ArrayList;

public class Productos {
	
	//-------------Variables-------------------
    private ArrayList<Articulo> lista = new ArrayList<Articulo>();


    //-----------------CONSTRUCTORES-----------------
	public Productos(ArrayList<Articulo> lista) {
		super();
		this.lista = lista;
	}
	public Productos() {
		
	}

	
	
	//-----------------GETTERS y SETTERS-----------------
	public ArrayList<Articulo> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Articulo> lista) {
		this.lista = lista;
	}
    
	
	//--------------FUNCIONES----------------
	public Articulo buscar(int codigo) {
		for(Articulo ar : this.lista){
			if(ar.getCodigo() == codigo) {
				return ar;
			}
		}
		return new Articulo(0,"",0,0);
	
	}
    
}
