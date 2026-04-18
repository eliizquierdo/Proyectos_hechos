
public class Participa{
    
    private int cedulaSocio;
    private String nombreActividad;
    
    public Participa(){}
    
    public Participa(int cedulaSocio, String nombreActividad){
        this.cedulaSocio = cedulaSocio;
        this.nombreActividad = nombreActividad;
    }
    
    public void setCedulaSocio(int cedulaSocio){this.cedulaSocio =  cedulaSocio;}
    public void setNombreActividad(String nombreActividad){this.nombreActividad = nombreActividad;}
    
    public int getCedulaSocio(){return cedulaSocio;}
    public String getNombreActividad(){return nombreActividad;}
    
    @Override
    public String toString(){
        return "[Cedula socio: " + cedulaSocio + "] [Nombre actividad: " + nombreActividad + " ]";
    }
    
}