/*
 * Guía de laboratorio 09 - Programación 3 - 2012
 * Ejercio 2: Clase abstracta Boleto hereda a las diferentes categorias
 * existentes para un partido de la UES.
 */
package bues;

/**
 * @date 05/07/2018
 * @author Fredy Kcrez
 */
public class PruebaBoletos {

    public static void main(String[] args) {
        Boleto boletos [] = new Boleto[5];
        Cortesia cor = new Cortesia(5.3);
        Preventa pre = new Preventa(8.0);
        Taquilla taq = new Taquilla(10.0);
        pFijo pf = new pFijo(5.0);
        pFijo pf2 = new pFijo(5.0);
        
        boletos[0] = cor;
        boletos[1] = pre;
        boletos[2] = taq;
        boletos[3] = pf;
        
        System.out.println(cor.toString());
        System.out.println(pre.toString());
        System.out.println(taq.toString());
        System.out.println(pf.toString());
        System.out.println(pf2.toString());
    }
}