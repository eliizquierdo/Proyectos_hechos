package consola;
import logica.Auto;


public class Principal {
	public static void main(String[] args) {
        
		Auto a=new Auto();  //creando una instancia de Auto
        System.out.println("a tiene la marca: "+a.getMarca()+ " y el precio es: "+a.getPrecio());
		a.setMarca("Fiat");
        Auto b=new Auto("Chevrolet", 20000);
        System.out.println("b tiene los valores: "+ b.toString());
        a.arrancar();
        a.frenar();
        
	}
}
