/*
 * Guía de laboratorio 07 - Programación 3 - 2012
 * Teo 1: Visibilida privada de metodos y atributos.
 */
package visibilidadPrivada;

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
        //a.soyPrivado = 10             //Ilegal
        //a.metodoPrivado()             //Ilegal
        a.metodoPublico();              //Legal
    }
}