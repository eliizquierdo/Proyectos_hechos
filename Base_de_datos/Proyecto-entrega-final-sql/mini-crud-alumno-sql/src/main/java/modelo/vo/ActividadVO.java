 package modelo.vo;


public class ActividadVO {
private int id;  
private String fecha;
private String nombre;
private String horarios;
   


   public ActividadVO() {
   }


   public ActividadVO(int id, String fecha, String nombre, String horarios) {
      this.id = id;
      this.fecha = fecha;
      this.nombre = nombre;
      this.horarios = horarios;
   }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
   
    public String getFecha() {
        return fecha;
    }


    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


   
public String getHorarios() {
        return horarios;
    }


    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }




 
 
   public String toString() {
      return "ActividadVO{id=" + this.id + ", fecha=" + this.fecha + ", nombre=" + this.nombre +", horario=" + this.horarios + "}";
   }




}
