public class Punto {    
    private int x;  //  variable para la coordenada en x    
    private int y; // variable para la coordenada en y  
    private static int puntos=0;
    
    public Punto() {  // metodo para construir un objeto sin parámetros          
       x = 0;          
       y = 0;
       puntos++;    
    }
    
    public Punto(int x, int y) {  // método para construir un objeto con parámetros enteros          
       this.x = x;          
       this.y = y; 
       puntos++;   
    }
    
    public Punto(double x, double y) {  // método para construir un objeto con parámetros double
       this.x = (int) x;
       this.y = (int) y;
       puntos++;
    }

    public Punto(Punto obj) {  // método para construir un objeto con parámetro objeto Punto
       this.x = obj.x;
       this.y = obj.y;
       puntos++;
    }
  
    public int getX() {         // método que te dá el valor de la coordenada x          
       return x;    
    }    
    
    public int getY() {         // método que te dá el valor de la coordenada y          
       return y;    
    }   
    
    public void setX(int x) {  // método que sirve para cambiar el valor de la coordenada x          
       this.x = x;         // this se utiliza porque se esta utilizando (x) como parámetro y como         
                              // variable de instancia y esto es para que no se confunda    
    }
    
    public void setX(double x) {  // método que sirve para cambiar el valor de la coordenada x
       this.x = (int) x;       // con un valor double       
    }
   
    public void setY(int y) {  // método que te sirve para cambiar el valor de la coordenada y
          this.y = y;        // this se utiliza porque se esta utilizando (y)  como parámetro y como   
                               // variable de instancia y esto es para que no se confunda                                    
    }
   
    public void setY(double y) {  // método que te sirve para cambiar el valor de la coordenada y          
         this.y = (int) y;        // con un valor double     
    }
    
    public String toString() {   // para obtener un objeto Punto en formato String
        return "(" + getX() + "," + getY() + ")";
    }
    
    public static int getPuntos() {   // para acceder a la cantidad de objetos creados
        return puntos;
    }
}
