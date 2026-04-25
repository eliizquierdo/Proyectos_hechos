package calculo;

/**
 * @date 18/06/2018
 * @author Fredy Kcrez
 */
public class Calculadora {
    public static double constantePI = 3.1416;
    
    public static int factorial(int n) {
        int fact = 1;
        
        while(n>0)
            fact *= n--;
        return fact;
    }
}