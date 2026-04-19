package logica;

import java.util.Date;

/**
 * La clase `MoviesVO` representa una película en el sistema de programación.
 * Extiende la clase abstracta `Programming`.
 */
public class MoviesVO extends Programming {

    /**
     * Constructor por defecto de la clase `MoviesVO`.
     */
    public MoviesVO() {
        super();
    }

    /**
     * Constructor con parámetros de la clase `MoviesVO`.
     *
     * @param typeProgramming El tipo de programación de la película.
     * @param programmingName El nombre de la película.
     * @param description      La descripción de la película.
     * @param cover            La portada de la película.
     * @param gender           El género de la película.
     * @param subGenre         El subgénero de la película.
     * @param releaseDate      La fecha de lanzamiento de la película.
     */
    public MoviesVO(String typeProgramming, String programmingName, String description, String cover, String gender,
            String subGenre, Date releaseDate) {
        super(typeProgramming, programmingName, description, cover, gender, subGenre, releaseDate);
    }
}
