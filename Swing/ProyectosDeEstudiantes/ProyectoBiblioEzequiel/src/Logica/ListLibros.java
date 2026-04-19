package Logica;

import java.util.ArrayList;

public class ListLibros {
	ArrayList<Libro> list;
	public ListLibros() {
		list=new ArrayList<Libro>();
		}
	
	public void eliminarLibro(int i) {
		list.remove(i);
	}
	
	public void agregarLibro(Libro l) {
        list.add(l);
    }
	public Libro obtenerLibro(int i) {
		return list.get(i);
	}
	public int size() {
		return list.size();
	}
	@Override
	public String toString() {
		String Libros="";
		for(int i=0;i<list.size();i++) {
			Libros=Libros+"Libros"+(i+1)+":"+list.get(i).toString()+"\n";
		}
		return Libros;
	}
}