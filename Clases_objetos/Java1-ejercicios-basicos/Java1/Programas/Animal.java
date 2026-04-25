public class Animal {
   private int peso = 0;
   
   public void cambiaPeso(int peso) {
      this.peso = peso;
   }
   
   public int obtenPeso() {
      return peso;
   }
   
   public String habla() {
      return "Los animales no hablan";
   }
}