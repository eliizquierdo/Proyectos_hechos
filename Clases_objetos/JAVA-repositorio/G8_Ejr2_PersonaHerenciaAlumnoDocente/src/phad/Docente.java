package phad;

import java.util.Date;

/**
 * @date 02/07/2018
 * @author Fredy Kcrez
 */
public class Docente extends Persona {
    private String codigoDocente;

    public Docente(String nombre, String direccion, String telefono, char sexo, 
            Date fechaNac, String codDocente) {
        super(nombre, direccion, telefono, sexo, fechaNac);
        this.setCodigoDocente( codDocente );
    }

    /**
     * @return the codigoDocente
     */
    public String getCodigoDocente() {
        return codigoDocente;
    }

    /**
     * @param codigoDocente the codigoDocente to set
     */
    public void setCodigoDocente(String codigoDocente) {
        this.codigoDocente = codigoDocente;
    }
}