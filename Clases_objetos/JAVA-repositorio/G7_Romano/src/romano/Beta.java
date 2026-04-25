/*
 * Guía de laboratorio 07 - Programación 3 - 2012
 * Teo 3: Visibilida publica de metodos y atributos.
 */
package romano;

import griego.Alpha;

/**
 * @date 18/06/2018
 * @author Fredy Kcrez
 */
public class Beta {

    public static void main(String[] args) {
        probarAlpha();
    }
    
    static void probarAlpha() {
        Alpha a = new Alpha();
        a.soyPublico = 10;
        a.metodoPublico();
    }
}