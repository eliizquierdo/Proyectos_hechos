package aplicacionnew;
import java.util.*;
import java.lang.String;
import javax.swing.JOptionPane;

public class AplicacionNew {

    public static void main(String[] args) {
        String name;
        String carnet;
        Double nota1, nota2, nota3;
        
        name = JOptionPane.showInputDialog("Digite el nombre:");
        carnet = JOptionPane.showInputDialog("Digite el carnet:");
        nota1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite la primera nota:"));
        nota2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite la segunda nota:"));
        nota3 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite la tercera nota:"));
        
        double prom = (nota1 + nota2 + nota3)/3;
        JOptionPane.showMessageDialog(null, "Alumno: " + name + "\nCarnet: " + carnet + "\nPromedio: " + prom);
    }
}