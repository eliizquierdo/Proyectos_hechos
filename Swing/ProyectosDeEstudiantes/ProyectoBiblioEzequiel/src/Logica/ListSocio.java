package Logica;
import java.util.ArrayList;

public class ListSocio {
	ArrayList<Socio> list;
	public ListSocio() {
		list=new ArrayList<Socio>();
		}
	
	public void eliminarSocio(int i) {
		list.remove(i);
	}
	
	public void agregarSocio(Socio s) {
        list.add(s);
    }
	public Socio obtenerSocio(int i) {
		return list.get(i);
	}

	public int size() {
		return list.size();
	}
	@Override
	public String toString() {
		String Socios="";
		for(int i=0;i<list.size();i++) {
			Socios=Socios+list.get(i).toString()+"\n";
		}
		return Socios;
	}
}
