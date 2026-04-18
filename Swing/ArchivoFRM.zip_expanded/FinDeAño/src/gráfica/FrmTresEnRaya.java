package gráfica;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import javax.swing.JLabel;

public class FrmTresEnRaya extends JFrame {


    private JLabel mostrarGanador;
    private int contador = 0;
    private String ganador = "";
    private JPanel contentPane;
    private JPanel tablero;
    boolean turnoX = true;
    private JButton[] botones = new JButton[9];

    public FrmTresEnRaya() {
    	
        iniciarComponentes();
        iniciarManejadoresEventos();
    }

    private void iniciarComponentes() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 450);
        setTitle("3 En Raya");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        tablero = new JPanel();
        tablero.setLayout(new GridLayout(3, 3));
        contentPane.add(tablero, BorderLayout.CENTER);
        mostrarGanador = new JLabel(" ");
        
        mostrarGanador.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(mostrarGanador, BorderLayout.SOUTH);
        mostrarGanador.setVisible(false);
    }

    private void iniciarManejadoresEventos() {
        agregarBotones();
    }

    private void agregarBotones() {
        for (int i = 0; i < 9; i++) {
            botones[i] = new JButton("");
            tablero.add(botones[i]);
            botones[i].setFont(new Font("Arial", Font.PLAIN, 58));

            botones[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton botonPresionado = (JButton) e.getSource();
                    if (botonPresionado.getText().equals("") && !finJuego()) {
                        if (turnoX) {
                            botonPresionado.setText("X");
                        } else {
                            botonPresionado.setText("O");
                        }

                        turnoX = !turnoX;
                        contador++;

                        if (finJuego()) {
                            msjGanador();
                        }
                    }
                }
            });
        }
    }

    private boolean finJuego() {
        // Verificar filas
        for (int i = 0; i < 9; i += 3) {
            if (botones[i].getText().equals(botones[i + 1].getText()) &&
                botones[i].getText().equals(botones[i + 2].getText()) &&
                !botones[i].getText().equals("")) {
                ganador = "Ganó el jugador " + botones[i].getText();
                return true;
            }
        }

        // Verificar columnas
        for (int i = 0; i < 3; i++) {
            if (botones[i].getText().equals(botones[i + 3].getText()) &&
            	botones[i].getText().equals(botones[i + 6].getText()) &&
               !botones[i].getText().equals("")) {
                ganador = "Ganó el jugador " + botones[i].getText();
                return true;
            }
        }

        // Verificar diagonales
        if (botones[0].getText().equals(botones[4].getText()) &&
            botones[0].getText().equals(botones[8].getText()) &&
           !botones[0].getText().equals("")) {
            ganador = "Ganó el jugador " + botones[0].getText();
            return true;
        }

        if (botones[2].getText().equals(botones[4].getText()) &&
            botones[2].getText().equals(botones[6].getText()) &&
           !botones[2].getText().equals("")) {
            ganador = "Ganó el jugador " + botones[2].getText();
            return true;
        }

        // Verificar empate
        if (contador >= 9 && ganador.equals("")) {
            ganador = "Empate";
            return true;
        }

        return false;
    }

    private void msjGanador() {
        mostrarGanador.setText(ganador);
        mostrarGanador.setVisible(true);
    }
    
    public static void main(String[] args) {
    	FrmTresEnRaya ventana = new FrmTresEnRaya();
    	ventana.setVisible(true);
    }
}