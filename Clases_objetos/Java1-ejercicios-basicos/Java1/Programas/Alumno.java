public class Alumno extends Persona {
   protected int matricula;
   
   public Alumno() {
      super();
      matricula = 0;
   }
   
   public int getMatricula() {
      return matricula;
   }
   
   public void setMatricula(int matricula) {
      this.matricula = matricula;
   }
   
   public void setNombre(String nombre) {
       this.nombre = "al " + nombre;
   }
   
   public String toString() {
      return "" + super.toString() + " " + matricula;
   }
}
   
