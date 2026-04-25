package fg;

import javax.swing.JOptionPane;

/**
 * @date 07/07/2018
 * @author Fredy Kcrez
 */
public class Triangulo implements FiguraGeometrica {
    private double area, cateto1, cateto2, hipotenusa;

    Triangulo(double cat1, double cat2) {
        this.cateto1 = cat1;
        this.cateto2 = cat2;
        this.hipotenusa = Math.sqrt((Math.pow(cat1, 2) + Math.pow(cat2, 2)));
    }
    
    @Override
    public void calcularArea() {
        area = (cateto1 * cateto2) / 2;
    }

    @Override
    public void imprimirLados() {
        JOptionPane.showMessageDialog(null, String.format("Cateto 1 del "
                + "triangulo: %.2f\nCateto 2 del triangulo: %.2f\nHipotenusa: "
                + "%.2f", cateto1, cateto2, hipotenusa));
    }
}