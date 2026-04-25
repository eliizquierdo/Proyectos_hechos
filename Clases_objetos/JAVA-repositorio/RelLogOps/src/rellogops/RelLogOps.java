/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rellogops;

/**
 *
 * @author ROBERTO CACERES
 */
public class RelLogOps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i,j;
        boolean b1, b2;
        
        i=10;
        j=11;
        
        if (i<j) System.out.println("i < j");
        if (i<=j) System.out.println("i <= j");
        if (i!=j) System.out.println("i != j");
        if (i==j) System.out.println("i == j");
        if (i>=j) System.out.println("i >= j");
        if (i>j) System.out.println("i > j");
        
        b1 = true;
        b2 = false;
        
        if (b1&b2) System.out.println("Esto no se ejecuta");
        if (!(b1&b2)) System.out.println("!(b1&b2) es verdadero");
        if (b1|b2) System.out.println("b1|b2 es verdadero");
        if (b1^b2) System.out.println("b1^b2 es verdadero"); 
    }
}
