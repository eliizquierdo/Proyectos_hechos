package matematicas;

/**
 * @date 18/06/2018
 * @author Fredy Kcrez
 */
public class Matematicas {
    public double sumar(double x, double y) {
        return x+y;
    }
    
    public double sumar(double x, double y, double z) {
        return x+y+z;
    }
    
    public double sumar(double[] array) {
        double total = 0;
        
        for(int i=0; i<array.length; i++)
            total += array[i];
        
        return total;
    }
}