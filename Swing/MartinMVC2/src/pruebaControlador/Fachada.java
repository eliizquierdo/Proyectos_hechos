package pruebaControlador;

public class Fachada {
	
	//constructor
    public Fachada(Controlador c) {
       
    }

    public static void main(String[] args) {
       
        Controlador c = new Controlador();
		Fachada f = new Fachada(c);
		c.getF().setVisible(true);
    }
}
