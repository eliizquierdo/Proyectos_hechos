package logica;
import java.util.*;
public class Paquete extends ArrayList{
private ArrayList<Canal> lista;
public Paquete() {
	lista=new ArrayList<>();
}
public void agregar (Canal reCa) {
	lista.add(reCa);
}
public Canal devolver(int i) {
	return(lista.get(i));
}
public int cantidad() {
	return lista.size();
}
public boolean premium() {
	if (cantidad() >= 5) {
		return true;
	}
	else {
		return false;
	}
}
public String toString() {
	String sLista=null;
	for(int i=0; i<cantidad();i++) {
		sLista=sLista + "\n" + lista.get(i);
	}
	return sLista;
}
}
