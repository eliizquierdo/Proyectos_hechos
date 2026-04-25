
package controladorjugardados;


public class ControladorJugarDados {

    
    public static void main(String[] args) {
        // TODO code application logic here
        JuegoDeDados juego=new JuegoDeDados();
        int res=juego.lanzarDados();
        if (res==7)
            System.out.println(res+" es Correcto!!!");
        else
            System.out.println(res+", falló lo sentimos.");
    }
}
