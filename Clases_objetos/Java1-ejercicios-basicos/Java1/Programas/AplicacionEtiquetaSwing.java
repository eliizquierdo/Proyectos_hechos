import java.awt.*;
import javax.swing.*;

public class AplicacionEtiquetaSwing extends JPanel {

    private JLabel etiquetaArriba;
    private JLabel etiquetaMedio;
    private JLabel etiquetaAbajo;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicacion de etiquetaes Swing");
        frame.setContentPane(new AplicacionEtiquetaSwing());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();    
        frame.setVisible(true);
    }

    public AplicacionEtiquetaSwing() {
        setLayout(new GridLayout(3, 1));
        ImageIcon icono1 = new ImageIcon("JAPAN.gif", "JAPAN");
        ImageIcon icono2 = new ImageIcon("PARIS.gif",
                                       "PARIS");
        etiquetaArriba = new JLabel("Etiqueta Arriba", icono1, JLabel.CENTER);
        etiquetaMedio = new JLabel("Etiqueta en Medio");
        etiquetaAbajo = new JLabel(icono2);
        etiquetaArriba.setVerticalTextPosition(JLabel.TOP);
        etiquetaArriba.setHorizontalTextPosition(JLabel.CENTER);
        etiquetaArriba.setFont(new Font("Helvetica", Font.ITALIC, 14));
        etiquetaMedio.setHorizontalAlignment(JLabel.CENTER);
        etiquetaMedio.setFont(new Font("Courier", Font.BOLD, 24));
        add(etiquetaArriba);
        add(etiquetaMedio);
        add(etiquetaAbajo);
    }
}
