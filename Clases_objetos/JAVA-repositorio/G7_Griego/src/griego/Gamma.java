/*
 * Guía de laboratorio 07 - Programación 3 - 2012
 * Teo 2: Visibilida protegida de métodos y atributos.
 */
package griego;

/**
 * @date 18/06/2018
 * @author Fredy Kcrez
 */
public class Gamma {

    public static void main(String[] args) {
        probarAlpha();
    }
    
    static void probarAlpha() {
        Alpha a = new Alpha();
        
        a.estoyProtegido = 10;              //legal
        a.metodoProtegido();                //legal
    }
}