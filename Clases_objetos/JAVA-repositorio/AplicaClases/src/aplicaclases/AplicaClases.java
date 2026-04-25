package aplicaclases;
import java.util.*;
import java.lang.String;
import javax.swing.JOptionPane;

public class AplicaClases {

    public static void main(String[] args)
    {
        String Name = JOptionPane.showInputDialog("Digite el nombre del alumno:");
        Double Nota1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite la nota 1 del alumno:"));
        Double Nota2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite la nota 2 del alumno:"));
        Double Nota3 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite la nota 3 del alumno:"));
        
        Alumno estudent = new Alumno(Name, Nota1, Nota2, Nota3);
        
        JOptionPane.showMessageDialog(null, estudent);
        
    }
}
