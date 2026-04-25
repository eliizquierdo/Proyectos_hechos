/*
* Guía de laboratorio 07 - Programación 3 - 2012
 * Teo 5: Constructores en Java.
 */
package constructores;

/**
 * @date 18/06/2018
 * @author Fredy Kcrez
 */
public class PruebaFicha {

    public static void main(String[] args) {
        Ficha f1 = new Ficha();
        Ficha f2 = new Ficha(5);
        
        f1.avanzar(3);
        System.out.println(f1.getCasillaActual());
        
        f2.avanzar(5);
        System.out.println(f2.getCasillaActual());
    }
}