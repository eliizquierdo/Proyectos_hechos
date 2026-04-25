public class Cuenta {
    private double saldo;  //  variable para manejar el saldo

    public Punto() {  // metodo para construir una cuenta vacia          
     saldo = 0.0;          
     }
           
   public Punto(double saldo) {  // método para construir una cuenta con un saldo inicial 
      this.saldo = saldo;            
   }       
   
   public double getSaldo() {         // método que te dá el saldo de una cuenta  
       return x;       
   }       

   public void setSaldo(double saldo) {  // método que sirve para cambiar el valor del saldo       
       this.saldo = saldo;         // this se utiliza porque se esta utilizando (saldo) como parámetro y como   
                                       // variable de instancia y esto es para que no se confunda      
   }      
}
