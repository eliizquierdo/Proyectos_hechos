package fg;

import javax.swing.JOptionPane;

/**
 * @date 07/07/2018
 * @author Fredy Kcrez
 */
public class Rectangulo implements FiguraGeometrica {
    private double area, base, altura;

    Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public void calcularArea() {
        area = base * altura; 
    }

    @Override
    public void imprimirLados() {
        JOptionPane.showMessageDialog(null, "Altura del rectangulo: " + altura +
                "\nBase del rectangulo: " + base);
    }
}