/*
 * Guía de laboratorio 07 - Programación 3 - 2012
 * Ejercicio 1:
 * En un paquete rectangulo, cree una clase llamada PruebaRectangulo con los atributos longitud y anchura, cada uno 
 * con valor predeterminado de 1. Debe tener métodos para calcular el perímetro y el área del rectángulo. Debe 
 * tener métodos para establecer (set) y obtener (get) la longitud y la anchura. Los métodos establecer deben 
 * verificar que longitud y anchura sean números de punto flotante mayores que 0.0 y menores que 20.0. 
 * Agregue la clase PruebaRectangulo para probar la clase PruebaRectangulo. 
 */
package rectangulo;

/**
 * @date 20/06/2018
 * @author Fredy Kcrez
 */
public class PruebaRectangulo {

    public static void main(String[] args) {
        Rectangulo r1 = new Rectangulo();
        Rectangulo r2 = new Rectangulo();
        
        r1.setAnchura(2.3);
        r1.setLongitud(8.3);
        
        System.out.println("Rectangulo 1\nPerimetro: " + r1.calcularPerimetro()+ "\nArea: " + r1.calcularArea());
        System.out.println("\nRectangulo 2\nPerimetro: " + r2.calcularPerimetro()+ "\nArea: " + r2.calcularArea());
    }
}