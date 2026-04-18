package consola;
import logica.Articulo;

public class Principal {

	public static void main(String[] ar) {
		//crear un objeto con el constructor por defecto
		Articulo art1= new Articulo();
		System.out.println(art1.toString());
		//crear un objeto con el constructor específico
		Articulo art2= new Articulo(10,"cuaderno",20);
		System.out.println(art2.toString());
		art2.setCodigo(100);
		System.out.println(art2.toString());
		art1.setNombre("lapicera");
		art1.setPrecioCosto(25);
		String nombrecito=art1.getNombre();
		System.out.println("El nombrecito es: "+nombrecito);
		System.out.println("El nombrecito es: "+art1.getNombre());
		System.out.println("Elprecio de art1 es: "+art1.getPrecioCosto());
		System.out.println("El precio de venta de art1 es: "+art1.precioVenta());
	}

}
