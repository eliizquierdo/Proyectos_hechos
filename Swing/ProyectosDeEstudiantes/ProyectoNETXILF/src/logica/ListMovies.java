package logica;

import java.util.ArrayList;

/**
 * La clase `ListMovies` representa una lista de películas.
 */
public class ListMovies {

    /**
     * Lista de películas almacenadas.
     */
    private ArrayList<MoviesVO> list;

    /**
     * Crea una nueva instancia de la lista de películas.
     */
    public ListMovies() {
        list = new ArrayList<>();
    }

    /**
     * Agrega una película a la lista.
     *
     * @param movie La película que se va a agregar a la lista.
     */
    public void add(MoviesVO movie) {
        list.add(movie);
    }

    /**
     * Obtiene la lista de películas.
     *
     * @return La lista de películas.
     */
    public ArrayList<MoviesVO> getList() {
        return list;
    }
}
