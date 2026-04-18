package consola;
import logica.*;
public class Principal {
	
    public static void main(String[] args) {
        Fecha fechaFabricacion1 = new Fecha(1, 8, 2015);
        Fecha fechaFabricacion2 = new Fecha(15, 7, 2022);
        
        Moto moto1 = new Moto("Honda", "ATR", 8000.0, fechaFabricacion1, 600);
        Moto moto2 = new Moto("Suzuki", "CARBON", 5000.0, fechaFabricacion2, 150);

        System.out.println("Moto 1:");
        System.out.println("Marca: " + moto1.getMarca());
        System.out.println("Modelo: " + moto1.getModelo());
        System.out.println("Precio: $" + moto1.calcularPrecio());
        System.out.println("Descuento neto: $" + moto1.descuentoNeto());
        System.out.println("Fecha de fabricación: " + moto1.getFechaFabricacion());

        System.out.println("Moto 2:");
        System.out.println("Marca: " + moto2.getMarca());
        System.out.println("Modelo: " + moto2.getModelo());
        System.out.println("Precio: $" + moto2.calcularPrecio());
        System.out.println("Descuento neto: $" + moto2.descuentoNeto());
        System.out.println("Fecha de fabricación: " + moto2.getFechaFabricacion());
    }
}


	


