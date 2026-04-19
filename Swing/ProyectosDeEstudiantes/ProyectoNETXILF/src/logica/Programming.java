package logica;

import java.util.Date;

/**
 * La clase `Programming` representa una programación genérica con atributos como el tipo de programación, nombre, descripción, portada, género, subgénero y fecha de lanzamiento.
 */
public class Programming {
    
    private String typeProgramming;
    private String programmingName;
    private String description;
    private String cover;
    private String gender;
    private String subGenre;
    private Date releaseDate; 
    
    /**
     * Constructor predeterminado de la clase `Programming`.
     */
    public Programming() {
        
    }

    /**
     * Constructor de la clase `Programming` con parámetros para inicializar sus atributos.
     *
     * @param typeProgramming  El tipo de programación.
     * @param programmingName  El nombre de la programación.
     * @param description      La descripción de la programación.
     * @param cover            La portada de la programación.
     * @param gender           El género de la programación.
     * @param subGenre         El subgénero de la programación.
     * @param releaseDate      La fecha de lanzamiento de la programación.
     */
    public Programming(String typeProgramming, String programmingName, String description, String cover, String gender,
            String subGenre, Date releaseDate) {
        this.typeProgramming = typeProgramming;
        this.programmingName = programmingName;
        this.description = description;
        this.cover = cover;
        this.gender = gender;
        this.subGenre = subGenre;
        this.releaseDate = releaseDate;
    }

	public String getTypeProgramming() {
		return typeProgramming;
	}

	public void setTypeProgramming(String typeProgramming) {
		this.typeProgramming = typeProgramming;
	}

	public String getProgrammingName() {
		return programmingName;
	}

	public void setProgrammingName(String programmingName) {
		this.programmingName = programmingName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSubGenre() {
		return subGenre;
	}

	public void setSubGenre(String subGenre) {
		this.subGenre = subGenre;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	
}


