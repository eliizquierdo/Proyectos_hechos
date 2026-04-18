package logica;
import java.util.ArrayList;

public class ListaRobot {
	
	private ArrayList<Robot> lista;

    public ListaRobot() {
    	lista = new ArrayList<>();
    }
    
    public void agregar(Robot a) {
    	lista.add(a);
    }

    public void borrar(Robot a) {
    	lista.remove(a);
    }
 
    public String listar() {
    	String listar = "ID\t Nombre\t Año\t Velocidad\n";
    	if (lista.isEmpty())
    		return "No hay valores en la lista";	
    	else {
    		for (int i = 0; i < lista.size() ; i++)
    			listar += lista.get(i).toString(); 
    	return listar;
    	}
    	
    }
    
    public boolean eliminar(int c) {
    	boolean encontrado = true;
    	for (int i = 0; i < lista.size(); ++i) {
    		if(c == lista.get(i).getId()) {
    			lista.remove(i);
    		}
    		else 
    			encontrado = false;	
    	}
		return encontrado;
    
    }

}
