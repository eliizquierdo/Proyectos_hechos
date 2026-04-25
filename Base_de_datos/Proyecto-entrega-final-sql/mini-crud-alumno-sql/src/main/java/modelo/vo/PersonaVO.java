package modelo.vo;


public class PersonaVO {
   private int cedula;
   private String nombre;
   private String apellido;
   private String f_Nacimiento;
   private String direccion;
   private String enfermedad;
   private String mutualista;
   


   public PersonaVO() {
   }


   public PersonaVO(int cedula, String nombre, String f_Nacimiento, String direccion, String enfermedad, String mutualista, String apellido) {
      this.cedula = cedula;
      this.nombre = nombre;
      this.apellido = apellido;
      this.f_Nacimiento = f_Nacimiento;
      this.direccion = direccion;
      this.enfermedad = enfermedad;
      this.mutualista = mutualista;
   }


   public int getCedula() {
      return this.cedula;
   }


   public void setCedula(int cedula) {
      this.cedula = cedula;
   }


   public String getNombre() {
      return this.nombre;
   }


   public void setNombre(String nombre) {
      this.nombre = nombre;
   }
   
    public String getApellido() {
      return this.apellido;
   }


   public void setApellido(String apellido) {
      this.apellido = apellido;
   }
   
   public String getF_Nacimiento() {
      return this.f_Nacimiento;
   }


   public void setF_Nacimiento(String f_Nacimiento) {
      this.f_Nacimiento = f_Nacimiento;
   }
   
   public String getDireccion() {
      return this.direccion;
   }


   public void setDireccion(String direccion) {
      this.direccion = direccion;
   }
   
   public String getEnfermedad() {
      return this.enfermedad;
   }


   public void setEnfermedad(String enfermedad) {
      this.enfermedad = enfermedad;
   }
   
   public String getMutualista() {
      return this.mutualista;
   }


   public void setMutualista(String mutualista) {
      this.mutualista = mutualista;
   }
   
 
   public String toString() {
      return "PersonaVO{cedula=" + this.cedula + ", nombre=" + this.nombre + ", apellido=" + this.apellido +", fecha nacimiento=" + this.f_Nacimiento +", direccion=" + this.direccion + ", enfermedad=" + this.enfermedad + ", mutualista=" + this.mutualista +"}";
   }
}




