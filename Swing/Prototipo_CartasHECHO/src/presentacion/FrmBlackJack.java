//faltan las imagenes de las cartas de poker
package presentacion;

import javax.swing.*;
import logica.CartasBlackJack;
import logica.BlackJack;
import java.awt.event.ActionListener;

public class FrmBlackJack extends JFrame {

    private JButton btnSiguienteCarta, btnMostrarHistorial, btnFiltrarPalo, btnParar, btnIniciar;
    private JLabel lblCarta;
    private JLabel lblContarCartas;
    private JTextField txtContarCartas, txtSumaCartas;

    private BlackJack juego; 
    private String[] historial, historialMaquina;
    private int indiceHistorial, indiceHistorialMaquina;
    private double puntajeMaquina;

    public FrmBlackJack() {
        iniciarComponentes();
        iniciarManejadoresEventos();
    }

    private void iniciarComponentes() {
        btnSiguienteCarta = new JButton("Siguiente carta");
      
        btnMostrarHistorial = new JButton("Mostrar historial");
        btnFiltrarPalo = new JButton("Filtrar por palo");
        btnParar = new JButton("Parar");
        btnIniciar = new JButton("Iniciar");

        lblCarta = new JLabel();
        lblContarCartas = new JLabel("Cartas sacadas");
        txtContarCartas = new JTextField("0");
        txtSumaCartas = new JTextField("0.0");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Blackjack");

        lblCarta.setBorder(BorderFactory.createEtchedBorder());
        txtContarCartas.setHorizontalAlignment(JTextField.RIGHT);
        txtContarCartas.setEnabled(false);
        txtSumaCartas.setHorizontalAlignment(JTextField.RIGHT);
        txtSumaCartas.setEnabled(false);

        getContentPane().setLayout(null);

        lblCarta.setBounds(50, 50, 215, 320);
        btnSiguienteCarta.setBounds(300, 50, 150, 30);
        btnMostrarHistorial.setBounds(300, 100, 150, 30);
        btnFiltrarPalo.setBounds(300, 150, 150, 30);
        btnParar.setBounds(300, 400, 150, 30);
        btnIniciar.setBounds(300, 450, 150, 30);
        lblContarCartas.setBounds(300, 250, 150, 30);
        txtContarCartas.setBounds(300, 300, 50, 30);
        txtSumaCartas.setBounds(300, 350, 50, 30);

        getContentPane().add(lblCarta);
        getContentPane().add(btnSiguienteCarta);
        getContentPane().add(btnMostrarHistorial);
        getContentPane().add(btnFiltrarPalo);
        getContentPane().add(btnParar);
        getContentPane().add(btnIniciar);
        getContentPane().add(lblContarCartas);
        getContentPane().add(txtContarCartas);
        getContentPane().add(txtSumaCartas);

        setSize(500, 550); // Ajustar tamaño de la ventana
        setLocationRelativeTo(null);
    }

    private void iniciarManejadoresEventos() {
        btnSiguienteCarta.addActionListener(e -> btnSiguienteCartaActionPerformed());
        btnMostrarHistorial.addActionListener(e -> mostrarHistorial());
        btnFiltrarPalo.addActionListener(e -> filtrarPorPalo());
        btnParar.addActionListener(e -> btnPararActionPerformed());
        btnIniciar.addActionListener(e -> btnIniciarActionPerformed());
    }

    private void initJuego() {
        juego = new BlackJack(); // Inicializa el juego
        historial = new String[52];
        historialMaquina = new String[52];
        indiceHistorial = 0;
        indiceHistorialMaquina = 0;
        puntajeMaquina = 0;
        lblCarta.setIcon(new ImageIcon(".\\img2\\Solapa.png"));
        txtContarCartas.setText("0");
        txtSumaCartas.setText("0.0");
    }

    private void btnIniciarActionPerformed() {
        initJuego();
        JOptionPane.showMessageDialog(this, "¡El juego ha comenzado! Saca cartas o para cuando desees.",
                "Juego Iniciado", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnSiguienteCartaActionPerformed() {
    	
    	if (!juego.getMazo().sinCartas()) {
            CartasBlackJack carta = juego.sacarCarta();
            lblCarta.setIcon(new ImageIcon(carta.toString()));
            juego.sumarPuntaje(carta);
            txtContarCartas.setText(String.valueOf(indiceHistorial + 1));
            txtSumaCartas.setText(String.valueOf(juego.getPuntajeJugador()));

            historial[indiceHistorial] = carta.getNumero() + " de " + carta.getPalo();
            indiceHistorial++;

            if (juego.getPuntajeJugador() > 21) {
                JOptionPane.showMessageDialog(this, "Te pasaste de 21. ¡Perdiste!", "Fin del juego", JOptionPane.ERROR_MESSAGE);
                mostrarCartasMaquina();
                mostrarHistorial();
            }
        }
    }

    private void turnoMaquina() {
        while (puntajeMaquina < 17 && puntajeMaquina <= 21 && !juego.getMazo().sinCartas()) {
            CartasBlackJack carta = juego.sacarCarta();
            puntajeMaquina += carta.obtenerValor();
            historialMaquina[indiceHistorialMaquina] = carta.getNumero() + " de " + carta.getPalo();
            indiceHistorialMaquina++;
        }
    }

    private void btnPararActionPerformed() {
        turnoMaquina();
        String resultado;
        if (puntajeMaquina > 21 || (juego.getPuntajeJugador() > puntajeMaquina && juego.getPuntajeJugador() <= 21)) {
            resultado = "¡Ganaste! Tu puntaje: " + juego.getPuntajeJugador() + " | Puntaje de la máquina: " + puntajeMaquina;
        } else if (juego.getPuntajeJugador() > 21 || puntajeMaquina > juego.getPuntajeJugador()) {
            resultado = "Perdiste. Tu puntaje: " + juego.getPuntajeJugador() + " | Puntaje de la máquina: " + puntajeMaquina;
        } else {
            resultado = "Empate. Ambos tienen " + juego.getPuntajeJugador();
        }

        JOptionPane.showMessageDialog(this, resultado, "Resultado Final", JOptionPane.INFORMATION_MESSAGE);

        mostrarCartasMaquina();
        mostrarHistorial();
    }

    private void mostrarCartasMaquina() {
        String mensaje = "Cartas de la máquina:\n";
        for (int j = 0; j < indiceHistorialMaquina; j++) {
            mensaje += historialMaquina[j] + "\n";
        }
        JOptionPane.showMessageDialog(this, mensaje, "Cartas de la Máquina", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarHistorial() {
        if (indiceHistorial == 0) {
            JOptionPane.showMessageDialog(this, "No se han jugado cartas todavía.", "Historial vacío", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String mensaje = "Historial de cartas jugadas:\n";
        for (int j = 0; j < indiceHistorial; j++) {
            mensaje += historial[j] + "\n";
        }

        JOptionPane.showMessageDialog(this, mensaje, "Historial", JOptionPane.INFORMATION_MESSAGE);
    }

    private void filtrarPorPalo() {
        String palo = JOptionPane.showInputDialog(this, "Ingrese el palo a filtrar (corazones, diamantes, tréboles, picas):");
        String mensaje = "Cartas de " + palo + ":\n";

        for (int j = 0; j < indiceHistorial; j++) {
            if (historial[j].contains(palo)) {
                mensaje += historial[j] + "\n";
            }
        }

        if (mensaje.equals("Cartas de " + palo + ":\n")) {
            mensaje += "No hay cartas de este palo.";
        }

        JOptionPane.showMessageDialog(this, mensaje, "Filtrado por Palo", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        FrmBlackJack ventana = new FrmBlackJack();
        ventana.setVisible(true);
    }
}

