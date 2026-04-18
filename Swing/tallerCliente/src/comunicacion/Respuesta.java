package comunicacion;

import java.io.Serializable;
import java.util.ArrayList;

public class Respuesta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String resultado;
	private boolean satisfactoria;
    private boolean hayTabla;
    private ArrayList<ArrayList<String>> tabla;

    public Respuesta(String resultado, boolean hayRespuesta, boolean satisfactoria) {
        this.resultado = resultado;
        this.satisfactoria=satisfactoria;
        this.hayTabla = hayRespuesta;
    }
    
    public boolean isHayTabla() {
		return hayTabla;
	}

	public void setResultado(String resultado) {
    	this.resultado=resultado;
    }

    public String getResultado() {
        return resultado;
    }

    public boolean isHayRespuesta() {
        return hayTabla;
    }
    
    public ArrayList<ArrayList<String>> getTabla(){
    	return this.tabla;
    }
    
    public void setTabla(ArrayList<ArrayList<String>> x){
    	this.tabla=x;
    }
    
    public void setSatisfactoria(boolean x) {
    	this.satisfactoria=x;
    }
    
    public boolean getSatisfactoria() {
    	return this.satisfactoria;
    }
    
    public void setHayTabla(boolean x) {
    	this.hayTabla=x;
    }
}