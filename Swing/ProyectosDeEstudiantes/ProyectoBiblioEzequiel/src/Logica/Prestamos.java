package Logica;
import java.util.ArrayList;

public class Prestamos {
	ArrayList<Prestamo>list;
	public Prestamos() {
		list=new ArrayList<Prestamo>();
	}

	public void agregarPrestamo(Prestamo Prestamo) {
		list.add(Prestamo);
	}
	
	public void eliminarPrestamo(int i) {
		list.remove(i);
	}
	
	public int size() {
		return list.size();
	}
	
	public Prestamo obtenerPrestamo(int i) {
		return list.get(i);
	}

	@Override
	public String toString() {
		String Prestamos="";
		for(int i=0;i<list.size();i++) {
			Prestamos=Prestamos+list.get(i).toString()+"\n";
		}
		return Prestamos;
	}
	
	
	
}
