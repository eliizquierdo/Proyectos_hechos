/*
 * Guía de laboratorio 09 - Programación 3 - 2012
 * Ejercio 2 Interfaces: Implementación Figuras Geometricas
 */
package fg;

/**
 * @date 07/07/2018
 * @author Fredy Kcrez
 */
public class TestFigurasGeometricas {

    public static void main(String[] args) {
        Rectangulo rect = new Rectangulo(2, 8);
        Triangulo tri = new Triangulo(3, 3);
        
        rect.calcularArea();
        rect.imprimirLados();
        tri.calcularArea();
        tri.imprimirLados();
    }
}