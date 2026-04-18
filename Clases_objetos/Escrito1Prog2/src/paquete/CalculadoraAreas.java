package paquete;

import java.util.Scanner;

public class CalculadoraAreas {

	Scanner sc=new Scanner(System.in);
	
	public double pedirDato() {
		double num;
		num=sc.nextDouble();
		return (num);
	}
	
	
	public double calcularAreaTriangulo(double base1, double altura1) {
        //completar
    }

    public double calcularAreaCirculo(double radio) {
        
        return Math.PI * radio * radio;
    }

    //Escribir el método calcularAreaCuadrado
    
    
}


