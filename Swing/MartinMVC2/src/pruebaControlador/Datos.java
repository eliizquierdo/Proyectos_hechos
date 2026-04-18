package pruebaControlador;

import java.util.ArrayList;

public class Datos {
    private ArrayList<String> nombres; // Lista de nombres
    private int pos; // Posición actual en la lista

    public Datos() {
        this.nombres = new ArrayList<>(); // Inicializa la lista
        this.pos = 0; // Inicia en la primera posición
    }

    public ArrayList<String> getNombres() {
        return nombres;
    }

    public void agregarNombre(String nombre) {
        this.nombres.add(nombre); // Agrega un nombre a la lista
    }

    public void borrarNombre(int pos) {
        if (pos >= 0 && pos < nombres.size()) {
            nombres.remove(pos); // Elimina el nombre en la posición dada
        }
    }

    public void modificarNombre(int pos, String nuevoNombre) {
        if (pos >= 0 && pos < nombres.size()) {
            nombres.set(pos, nuevoNombre); // Modifica el nombre en la posición dada
        }
    }

    public String getNombreActual() {
        if (pos >= 0 && pos < nombres.size()) {
            return nombres.get(pos); // Retorna el nombre en la posición actual
        }
        return "";
    }

    public void avanzarPosicion() {
        if (pos < nombres.size() - 1) {
            pos++; // Avanza en la lista si no está en la última posición
        }
    }

    public void retrocederPosicion() {
        if (pos > 0) {
            pos--; // Retrocede en la lista si no está en la primera posición
        }
    }

    public int getPos() {
        return pos; // Devuelve la posición actual
    }
    
   
}
