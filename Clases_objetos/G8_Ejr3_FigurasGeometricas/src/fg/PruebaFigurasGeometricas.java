/*
 * Guía de laboratorio 08 - Programación 3 - 2012
 * Ejercicio 3: Herencia de figuras geometricas.
 * Escriba una jerarquía de herencia para las clases Cuadrilatero, Trapezoide,
 * Paralelogramo, Rectangulo y Cuadrado. Use  Cuadrilatero como la superclase de
 * la jerarquía. Agregue todos los niveles que sea posible a la jerarquía.
 * Especiﬁque los atributos de instancia y los métodos para cada clase. Los
 * atributos de instancia private de Cuadrilatero deben ser los pares de
 * coordenadas x-y para los cuatro puntos ﬁnales del Cuadrilatero. Escriba un
 * programa de prueba que cree instancias de objetos de sus clases, y que
 * imprima el área de cada objeto (excepto Cuadrilatero). 
 */
package fg;

/**
 * @date 03/07/2018
 * @author Fredy Kcrez
 */
public class PruebaFigurasGeometricas {

    public static void main(String[] args) {
        Cuadrado cuad = new Cuadrado(3);
        Paralelograma paral = new Paralelograma(2,3);
        Rectangulo rect = new Rectangulo(3,2);
        Trapezoide trap = new Trapezoide(3,3,2);
        
        System.out.println("Área del cuadrado: " + cuad.area());
        System.out.println("Área del paralelograma: " + paral.area());
        System.out.println("Área del rectangulo: " + rect.area());
        System.out.println("Área del trapezoide: " + trap.area());
    }
}