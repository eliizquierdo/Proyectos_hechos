package logica;

import java.util.ArrayList;

public class ListaRobot {
	
	private ArrayList<Robot> robots;

    public ListaRobot() {
        robots = new ArrayList<>();
    }

    public void agregar(Robot a) {
        robots.add(a);
    }

    
    public void borrar(Robot a) {
        robots.remove(a);
    }


    
    public void listarRobot() {
       for (Robot robot : robots) {
                System.out.println(robot); // Llama al método toString de cada Auto
       }
    }
    
}

