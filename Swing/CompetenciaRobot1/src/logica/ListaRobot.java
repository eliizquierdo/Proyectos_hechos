package logica;

import java.util.ArrayList;

public class ListaRobot{
    private ArrayList<Robot>lista;

    public ListaRobot() {
        lista = new ArrayList<Robot>();
    }
    
    public void insertar(Robot robot) {
        lista.add(robot);
    }

    public boolean borrar(int Id) {
        for (Robot robot : lista) {
        	if (robot.getId()== Id){
        		lista.remove(robot);
        	}        	
        }
        return true;
    }

    public String listar() {
        String listas = "id \t\tnombre \t\tanio \t\tvelocidad\n";
        if (lista.isEmpty()) {
            listas = "No hay robots en la lista.";
        } else {
            for (int i = 0; i < lista.size(); i++) {
                listas += lista.get(i).toString() + "\n";
            }
        }
        return listas;
    }

 }