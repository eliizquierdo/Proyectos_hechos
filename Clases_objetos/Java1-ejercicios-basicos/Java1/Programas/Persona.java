public class Persona {
   protected String nombre;
   protected char sexo;
   
   public Persona() {
      nombre = new String();
      sexo = ' ';
   }
   
   public String getNombre() {
      return nombre;
   }
   
   public void setNombre(String nombre) {
      this.nombre = nombre;
   }
    
   public char getSexo() {
      return sexo;
   }
   
   public void setSexo(char sexo) {
      this.sexo = sexo;
   }
   
   public String toString() {
        return "" + nombre + " " + sexo;
   }
}
   