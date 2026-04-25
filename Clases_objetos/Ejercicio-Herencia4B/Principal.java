import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Fecha d1 = new Fecha();
		Vehiculo v1 = new Vehiculo();
		
		Fecha d2 = new Fecha(13, 05, 2011);
		Vehiculo v2 = new Vehiculo("Nissan", 1500, "MXV-342", d2);
		
		Fecha d3 = new Fecha(24, 12, 2008);
		Moto m1 = new Moto(50, "Zanella", 150.5, "EFG-345", d3);
		
		Fecha d4 = new Fecha(4, 5, 2015);
		Moto m2 = new Moto(150, "Vital", 200.50, "ABC-123", d4);
		
		System.out.println("Ingrese fecha de compra:");
		System.out.print("Día: "); d1.setDia(sc.nextInt());
		System.out.print("Mes: "); d1.setMes(sc.nextInt());
		System.out.print("Año: "); d1.setAnio(sc.nextInt());
		
		System.out.print("\nIngrese marca: "); v1.setMarca(sc.next());
		System.out.print("Ingrese precio: "); v1.setPrecio(sc.nextDouble());
		System.out.print("Ingrese matricula: "); v1.setMatricula(sc.next());
		v1.setFechaCompra(d1);
		
		System.out.println("\n" + v1.toString());
		System.out.print("Descuento neto: " + v1.descuentoNeto(d1));
		
		System.out.println();
		
		System.out.println("\n" + v2.toString());
		System.out.print("Descuento neto: " + v2.descuentoNeto(d2));
		
		System.out.println();
		
		System.out.println("\nIngrese cilindrados:");
		System.out.print("Moto 1: "); m1.setCilindrada(sc.nextInt());
		System.out.print("Moto 2: "); m2.setCilindrada(sc.nextInt());
		
		System.out.println("\n" + m1.toString());
		System.out.println("Descuento neto de Moto 1: " + m1.descuentoNeto());
		System.out.println("\n" + m1.toString());
		System.out.println("Descuento neto de Moto 2: " + m2.descuentoNeto());	
	}
}
