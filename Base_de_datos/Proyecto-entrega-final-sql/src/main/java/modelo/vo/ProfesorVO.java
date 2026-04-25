package modelo.vo;

public class ProfesorVO extends PersonaVO {
   private boolean carnetSalud;
   

   public ProfesorVO() {
   }

   public ProfesorVO(int cedula, String nombre, String f_Nacimiento, String direccion, String enfermedad, String mutualista, String apellido, boolean carnetSalud) {
      super (cedula,nombre,apellido,f_Nacimiento,direccion,enfermedad,mutualista);
      this.carnetSalud = carnetSalud;


   }

   public boolean getCarnetSalud() {
      return carnetSalud;
   }

   public void setCarentSalud(boolean carnetSalud) {
      this.carnetSalud = carnetSalud;
   }

  
 
   public String toString() {
      return "PersonaVO{cedula=" + this.getCedula() + ", nombre=" + this.getNombre() + ", apellido=" + this.getApellido() +", fecha nacimiento=" + this.getF_Nacimiento() +", direccion=" + this.getDireccion() + ", enfermedad=" + this.getEnfermedad() + ", mutualista=" + this.getMutualista()+ ",carnet de Salud="+ carnetSalud +'}';
   }
}










