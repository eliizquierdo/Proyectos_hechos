package modelo.vo;

public class UsuarioVO extends PersonaVO {
   private String adultResponsable;
   private String numAdult;
   

   public UsuarioVO() {
   }

   public UsuarioVO(int cedula, String nombre, String f_Nacimiento, String direccion, String enfermedad, String mutualista, String apellido, String adultResponsable, String numAdult) {
      super (cedula,nombre,apellido,f_Nacimiento,direccion,enfermedad,mutualista);
      this.adultResponsable = adultResponsable;
      this.numAdult = numAdult;


   }

   public String getNumAdult() {
		return numAdult;
	}

	public void setNumAdult(String numAdult) {
		this.numAdult = numAdult;
	}
	
	public String getAdultResponsable() {
		return adultResponsable;
	}

	public void setAdultResponsable(String adultResponsable) {
		this.adultResponsable = adultResponsable;
	}
  
 
   public String toString() {
     return "PersonaVO{cedula=" + this.getCedula() + ", nombre=" + this.getNombre() + ", apellido=" + this.getApellido() +", fecha nacimiento=" + this.getF_Nacimiento() +", direccion=" + this.getDireccion() + ", enfermedad=" + this.getEnfermedad() + ", mutualista=" + this.getMutualista()+ ", Adulto Responsable=" + this.adultResponsable+ ", Numero de adulto=" + this.numAdult  +'}';

   }
}

