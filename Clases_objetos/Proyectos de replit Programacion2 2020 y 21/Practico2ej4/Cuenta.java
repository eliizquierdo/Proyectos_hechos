public class Cuenta {
  private String nombre;
  private double saldo;
  
  //Constructor por defecto
  
  
  //Constructor especifico
  public Cuenta(String n, double s) {
  nombre = n;
  if (s > 0.0)
    saldo = s;
  }
  
  /* Continuan getters y setters   .... */
  
  
  //método toString
  
  
  //métodos especificos
  public void depositar(double dinero) {
    if (dinero > 0.0)
        saldo = saldo + dinero;
  }
  
  } // Fin de la clase Cuenta
  
  //Responder preguntas aquí:
  
  //1.
  
  //2.
  
  //3.