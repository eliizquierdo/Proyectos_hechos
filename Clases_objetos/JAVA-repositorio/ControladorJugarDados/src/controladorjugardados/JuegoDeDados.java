
package controladorjugardados;


public class JuegoDeDados {

    private Dado d1, d2;
    
    public JuegoDeDados(){
        d1= new Dado();
        d2= new Dado();
    }
    public int lanzarDados(){
        int valor1, valor2;
        d1.lanzar();
        valor1=d1.obtenerValor();
        d2.lanzar();
        valor2=d2.obtenerValor();        
        return (valor1+valor2);
    }
}
