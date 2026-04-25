/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calcularpulgadas;

/**
 *
 * @author ROBERTO CACERES
 */
public class CalcularPulgadas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /* Calcula el número de pulgadas cúbicas en
 una milla cúbica.
3       */
       long ci;
       long im;
       im = 5280 * 12;
       ci = im * im * im;
       System.out.println("Hay " + ci + " pulgadas cúbicas en una milla cúbica.");
    }
}
