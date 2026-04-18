package logica;

import java.util.ArrayList;

public class Biblioteca {
  
ArrayList <Libro> lista = new ArrayList<>();
private int contador;
private int nem;
  public Biblioteca() {
	  
  }
  public Biblioteca(ArrayList <Libro> lista) {
	  this.lista = lista;
  }
  
  public ArrayList<Libro> getLista() {
		return lista;
	}
	public void setLista(ArrayList<Libro> lista) {
		this.lista = lista;
	}
	public void insertar(Libro a) {
		
		lista.add(a);
	}
	public int cantidad() {
		return lista.size();
	}
	public int librosLargos() {
		for(int o=0; o<=lista.size();o++) {
		if (lista.get(o).getPaginas()>500) {
			contador++;
		}
	}
		return contador;
	}
	public Libro elCaro() {
		for (int p=0; p<=lista.size(); p++) {
			if (lista.get(p).precio()>lista.get(p+1).precio()) 
				nem=p;
			else
				nem=nem;
		}
		return lista.get(nem);
	}
}
