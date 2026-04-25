
package controladorjugardados;


public class Dado {
    private int valorCara;

    public Dado (){

    }
    public void lanzar(){
       valorCara = (int)(Math.random()*6)+1;    
    }
    public int obtenerValor(){
        return valorCara;
    }
}
