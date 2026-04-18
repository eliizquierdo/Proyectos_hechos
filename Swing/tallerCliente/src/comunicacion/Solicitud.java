package comunicacion;

import java.io.Serializable;

public class Solicitud implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String sentencia;
    private String baseDatos;

    public Solicitud(String consulta, String baseDatos) {
        this.sentencia = consulta;
        this.baseDatos = baseDatos;
    }

    public String getConsulta() {
        return sentencia;
    }

    public String getBaseDatos() {
        return baseDatos;
    }
    
    public void setBaseDatos(String nombre) {
    	this.baseDatos=nombre;
    }
}