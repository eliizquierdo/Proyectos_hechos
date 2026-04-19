package logica;

import java.util.Date;

/**
 * La clase `SeriesVO` representa una serie de televisión y extiende la clase `Programming`, heredando sus atributos y métodos.
 */
public class SeriesVO extends Programming {
    
    private int numberSeasons;
    private int numberChapter;
    
    /**
     * Constructor predeterminado de la clase `SeriesVO`.
     */
    public SeriesVO() {
        super();
    }

    /**
     * Constructor de la clase `SeriesVO` con parámetros para inicializar sus atributos.
     *
     * @param typeProgramming  El tipo de programación.
     * @param programmingName  El nombre de la programación.
     * @param description      La descripción de la programación.
     * @param cover            La portada de la programación.
     * @param gender           El género de la programación.
     * @param subGenre         El subgénero de la programación.
     * @param releaseDate      La fecha de lanzamiento de la programación.
     * @param numberSeasons    El número de temporadas de la serie.
     * @param numberChapter    El número de capítulos de la serie.
     */
    public SeriesVO(String typeProgramming, String programmingName, String description, String cover, String gender,
            String subGenre, Date releaseDate, int numberSeasons, int numberChapter) {
        super(typeProgramming, programmingName, description, cover, gender, subGenre, releaseDate);
        this.numberSeasons = numberSeasons;
        this.numberChapter = numberChapter;
    }


	public int getNumberSeasons() {
		return numberSeasons;
	}


	public void setNumberSeasons(int numberSeasons) {
		this.numberSeasons = numberSeasons;
	}


	public int getNumberChapter() {
		return numberChapter;
	}


	public void setNumberChapter(int numberChapter) {
		this.numberChapter = numberChapter;
	}
	
	
	
	
	
	
	
	
	

}
