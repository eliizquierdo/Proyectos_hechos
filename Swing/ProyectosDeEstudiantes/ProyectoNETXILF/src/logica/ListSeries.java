package logica;

import java.util.ArrayList;

/**
 * La clase `ListSeries` representa una lista de series.
 */
public class ListSeries {

    /**
     * Lista de series almacenadas.
     */
    private ArrayList<SeriesVO> list;

    /**
     * Crea una nueva instancia de la lista de series.
     */
    public ListSeries() {
        list = new ArrayList<>();
    }

    /**
     * Agrega una serie a la lista.
     *
     * @param series La serie que se va a agregar a la lista.
     */
    public void add(SeriesVO series) {
        list.add(series);
    }

    /**
     * Obtiene la lista de series.
     *
     * @return La lista de series.
     */
    public ArrayList<SeriesVO> getList() {
        return list;
    }
}
