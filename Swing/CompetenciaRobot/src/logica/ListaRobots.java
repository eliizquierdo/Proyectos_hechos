package logica;

import java.util.ArrayList;

public class ListaRobots {
    private ArrayList<Robot> robots;

    public ListaRobots() {
        robots = new ArrayList<>();
    }

    public void agregarRobot(Robot r) {
        robots.add(r);
    }

    public void eliminarRobot(String id) {
        robots.removeIf(r -> r.getId().equals(id));
    }

    public ArrayList<Robot> buscarPorNombre(String nombre) {
        ArrayList<Robot> resultado = new ArrayList<>();
        for (Robot r : robots) {
            if (r.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(r);
            }
        }
        return resultado;
    }

    public ArrayList<Robot> obtenerTodos() {
        return robots;
    }
}
