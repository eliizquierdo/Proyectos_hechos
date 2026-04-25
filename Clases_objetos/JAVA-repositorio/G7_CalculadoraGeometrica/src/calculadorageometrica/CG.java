/*
 * Guía de laboratorio 07 - Programación 3 - 2012
 * Ejercicio 4: Test de figuras geometricas.
 */
package calculadorageometrica;

/**
 * @date 27/06/2018
 * @author Fredy Kcrez
 */
public class CG {

    public static void main(String[] args) {
        Triangulo t1 = new Triangulo(22.6, 25.6);
        Triangulo t2 = new Triangulo(32.3, 12.9);
        Circulo c = new Circulo(2.6);
        
        if(t1.getArea() > t2.getArea())
            System.out.println(t1.toString());
        else
            System.out.println(t2.toString());
        
        System.out.println(c.toString());
    }
}