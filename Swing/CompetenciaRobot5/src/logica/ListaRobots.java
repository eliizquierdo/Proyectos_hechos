package logica;

import java.util.ArrayList;

public class ListaRobots {

	private ArrayList <Robot> lista;
	
	public ListaRobots() {
        lista = new ArrayList<>();
    }

    public void insertar(Robot robot) {
        lista.add(robot);
    }
    
  
    public String robot() {
    	String robot = "ID\tNombre\tAño\tVelocidad\n";
    	robot += "----------------------------------------------------------------------\n";
    	if (lista.isEmpty())
    		return "No hay valores en la lista";	
    	else {
    		for (int i = 0; i < lista.size() ; i++)
    			robot += lista.get(i).toString(); 
    	return robot;
    	}
    	
    }
    
    public boolean eliminarRobot(int ID) {
    	 for (Robot rob : lista) { 
             if (rob.getId() == ID) { 
                 lista.remove(rob); 
                 return true;
             }
         }
         return false; 
     }
    
}
