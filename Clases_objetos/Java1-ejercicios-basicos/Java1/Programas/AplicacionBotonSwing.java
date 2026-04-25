import java.awt.*;
import javax.swing.*;

public class AplicacionBotonSwing extends JPanel {

    private JButton botonArriba;
    private JButton botonMedio;
    private JButton botonAbajo;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicacion de botones Swing");
        frame.setContentPane(new AplicacionBotonSwing());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();    
        frame.setVisible(true);
    }

    public AplicacionBotonSwing() {
        setLayout(new GridLayout(3, 1));
        ImageIcon icono1 = new ImageIcon("JAPAN.gif", "JAPAN");
        ImageIcon icono2 = new ImageIcon("PARIS.gif",
                                       "PARIS");
        botonArriba = new JButton("boton Arriba", icono1);
        botonMedio = new JButton("boton en Medio");
        botonAbajo = new JButton(icono2);
        botonArriba.setVerticalTextPosition(JButton.TOP);
        botonArriba.setHorizontalTextPosition(JButton.CENTER);
        botonArriba.setFont(new Font("Helvetica", Font.ITALIC, 14));
        botonMedio.setHorizontalAlignment(JButton.CENTER);
        botonMedio.setFont(new Font("Courier", Font.BOLD, 24));
        add(botonArriba);
        add(botonMedio);
        add(botonAbajo);
    }
}
