package logica;

import java.util.ArrayList;

public class GestorBiblioteca {
    private ArrayList<Libro> lista;

    public GestorBiblioteca() {
        lista = new ArrayList<>();
    }

    public GestorBiblioteca(ArrayList<Libro> lista) {
        super();
        this.lista = lista;
    }

    public ArrayList<Libro> getLista() {
        return lista;
    }

    public void insertarLibro(Libro nuevoLibro) {
        lista.add(nuevoLibro);
    }

    public void eliminarPorTitulo(String titulo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                lista.remove(i);
                break;
            }
        }
    }

    public void listarPublicaciones() {
        for (int i = 0; i < lista.size(); i++) {
            Libro libro = lista.get(i);
            libro.mostrarInfo();
        }
    }

    public int contarLibrosDeTerror() {
        int count = 0;
        for (int i = 0; i < lista.size(); i++) {
            Libro libro = lista.get(i);
            if (libro.getGenero().equalsIgnoreCase("Terror")) {
                count++;
            }
        }
        return count;
    }

    public int contarLibrosDelAnio(int anio) {
        int count = 0;
        for (int i = 0; i < lista.size(); i++) {
            Libro libro = lista.get(i);
            if (libro.getAnio() == anio) {
                count++;
            }

        }
        return count;
    }
}
