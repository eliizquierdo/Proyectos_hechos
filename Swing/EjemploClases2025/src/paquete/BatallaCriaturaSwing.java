package paquete;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class BatallaCriaturaSwing {
    private JFrame frame;
    private JLabel infoCriatura1, infoCriatura2, resultado;
    private JButton atacarBtn;
    private Criatura criatura1, criatura2;
    private boolean turnoJugador1 = true;

    public BatallaCriaturaSwing(Criatura c1, Criatura c2) {
        criatura1 = c1;
        criatura2 = c2;
        frame = new JFrame("Batalla de Criaturas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4, 1));
        
        infoCriatura1 = new JLabel(getInfo(criatura1));
        infoCriatura2 = new JLabel(getInfo(criatura2));
        resultado = new JLabel("¡Que comience la batalla!", SwingConstants.CENTER);
        atacarBtn = new JButton("Atacar");

        atacarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarAtaque();
            }
        });

        frame.add(infoCriatura1);
        frame.add(infoCriatura2);
        frame.add(resultado);
        frame.add(atacarBtn);

        frame.setVisible(true);
    }

    private String getInfo(Criatura c) {
        return c.getNombre() + " - Vida: " + c.getVida();
    }

    private void realizarAtaque() {
        if (turnoJugador1) {
            criatura2.recibirDaño(criatura1.atacar());
            resultado.setText(criatura1.getNombre() + " ataca a " + criatura2.getNombre());
        } else {
            criatura1.recibirDaño(criatura2.atacar());
            resultado.setText(criatura2.getNombre() + " ataca a " + criatura1.getNombre());
        }

        infoCriatura1.setText(getInfo(criatura1));
        infoCriatura2.setText(getInfo(criatura2));
        turnoJugador1 = !turnoJugador1;

        if (!criatura1.estaVivo() || !criatura2.estaVivo()) {
            atacarBtn.setEnabled(false);
            if (!criatura1.estaVivo()) {
                resultado.setText(criatura1.getNombre() + " ha sido derrotado. ¡" + criatura2.getNombre() + " gana!");
            } else {
                resultado.setText(criatura2.getNombre() + " ha sido derrotado. ¡" + criatura1.getNombre() + " gana!");
            }
        }
    }

    public static void main(String[] args) {
        String nombre1 = JOptionPane.showInputDialog("Nombre de la Criatura 1:");
        int vida1 = Integer.parseInt(JOptionPane.showInputDialog("Vida de " + nombre1 + ":"));
        int ataque1 = Integer.parseInt(JOptionPane.showInputDialog("Ataque de " + nombre1 + ":"));
        int defensa1 = Integer.parseInt(JOptionPane.showInputDialog("Defensa de " + nombre1 + ":"));

        String nombre2 = JOptionPane.showInputDialog("Nombre de la Criatura 2:");
        int vida2 = Integer.parseInt(JOptionPane.showInputDialog("Vida de " + nombre2 + ":"));
        int ataque2 = Integer.parseInt(JOptionPane.showInputDialog("Ataque de " + nombre2 + ":"));
        int defensa2 = Integer.parseInt(JOptionPane.showInputDialog("Defensa de " + nombre2 + ":"));

        Criatura c1 = new Criatura(nombre1, vida1, ataque1, defensa1);
        Criatura c2 = new Criatura(nombre2, vida2, ataque2, defensa2);

        new BatallaCriaturaSwing(c1, c2);
    }
}
