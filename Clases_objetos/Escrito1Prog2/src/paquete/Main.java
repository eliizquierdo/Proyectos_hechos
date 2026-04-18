package paquete;

import java.util.Scanner;

public class Main{
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    CalculadoraAreas c=new CalculadoraAreas();
    int opcion;

    
        System.out.println("\nMenú de cálculo de áreas:");
        System.out.println("1. Área del triángulo");
        System.out.println("2. Área del círculo");
        System.out.println("3. Área del cuadrado");
        System.out.println("4. Salir");
        System.out.print("Ingrese la opción deseada: ");

        opcion = sc.nextInt();

        switch (opcion) {
            case 1:
            	double base, altura;
            	System.out.print("Ingrese la base del triángulo: ");
        	    base = c.pedirDato();
        	    System.out.print("Ingrese la altura del triángulo: ");
        	    altura = c.pedirDato();
                double areaTriangulo = c.calcularAreaTriangulo(base,altura);
                System.out.println("El área del triángulo es: " + areaTriangulo);
                break;
            case 2://completar
            	double r;
            	
            	
                double areaCirculo=0 ;
                System.out.println("El área del círculo es: " + areaCirculo);
                break;
            case 3://completar
            	System.out.println("El área del cuadrado es: ");
                break;
            case 4:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida.");
        }//fin switch
        sc.close();
	}//fin main
}//fin Main