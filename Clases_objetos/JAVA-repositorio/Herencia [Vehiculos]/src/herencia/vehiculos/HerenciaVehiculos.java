package herencia.vehiculos;
import java.util.Scanner;

public class HerenciaVehiculos {

    public static void main(String[] args)
    {
        Controlador control = new Controlador();
        
        menu();
        Scanner entrada = new Scanner(System.in);
        int opcion = entrada.nextInt();
        
        while (opcion != 0)
        {
            if(opcion == 1)
            {
                System.out.println("Ingrese tipo vehiculo\n1. Auto\n2. Camioneta");
                int tipoVehiculo = entrada.nextInt();
         
                System.out.println("Ingrese la patente:");
                String patente = entrada.toString();
                
                System.out.println("Ingrese la marca:");
                String marca = entrada.toString();
                
                System.out.println("Ingrese el año:");
                int anio = entrada.nextInt();
                
                if (tipoVehiculo == 1)
                {
                    System.out.println("Ingrese el kilometraje:");
                    int kilometraje = entrada.nextInt();
                    System.out.println("Ingrese la capacidad estanque:");
                    int capacidadEstanque = entrada.nextInt();
                    System.out.println(control.agregarAuto(patente, marca, opcion, kilometraje, capacidadEstanque));
                }
                
                if (tipoVehiculo == 2)
                {
                    System.out.println("Ingrese la capacidad de carga:");
                    int capacidadCarga = entrada.nextInt();
                    System.out.println(control.agregarCamioneta(patente, marca, opcion, capacidadCarga));
                }
            }
            if(opcion == 2)
            {
                System.out.println(control.imprimirListadoVehiculosIngresados());
            }
            
            menu();
            opcion = entrada.nextInt();
        }
    }
    
    public static void menu()
    {
        System.out.println("1. Ingresar vehiculo");
        System.out.println("2. Mostrar listado");
        System.out.println("0. Salir");
    }
}