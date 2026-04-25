package phad;

import java.util.Date;

/**
 * @date 02/07/2018
 * @author Fredy Kcrez
 */
public class Alumno extends Persona {
    private String carnet;
    
    public Alumno(String nombre, String direccion, String telefono, char sexo, 
            Date fechaNac, String carnet) {
        super(nombre, direccion, telefono, sexo, fechaNac);
        this.setCarnet( carnet );
    }

    /**
     * @return the carnet
     */
    public String getCarnet() {
        return carnet;
    }

    /**
     * @param carnet the carnet to set
     */
    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }
}