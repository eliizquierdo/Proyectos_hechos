package grafica;

import logica.TaTeTi1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaTeTiImag extends JFrame {
    private TaTeTi1 juegoLogica;
    private JButton btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI;
    private JLabel mensaje;

    public TaTeTiImag() {
        juegoLogica = new TaTeTi1();
        
        // Configuración del JFrame
        setTitle("Juego 3 en Raya");
        setSize(388, 460);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Usamos null layout para colocar los componentes manualmente
        
        // Llamamos a los métodos para inicializar los componentes y eventos
        iniciarComponentes();
        iniciarManejadoresEventos();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void iniciarComponentes() {
        int xOffset = 50, yOffset = 50, buttonSize = 80; // Desplazamientos y tamaño de los botones

        // Cargar imágenes
        ImageIcon imgX = new ImageIcon("images/NO.png");
        ImageIcon imgO = new ImageIcon("images/SI.png");

        // Crear los botones y ubicarlos en el JFrame
        btnA = new JButton("");
        btnA.setFont(new Font("Arial", Font.PLAIN, 40));
        btnA.setFocusPainted(false);
        btnA.setBounds(xOffset, yOffset, buttonSize, buttonSize);
        add(btnA);

        btnB = new JButton("");
        btnB.setFont(new Font("Arial", Font.PLAIN, 40));
        btnB.setFocusPainted(false);
        btnB.setBounds(xOffset + buttonSize + 10, yOffset, buttonSize, buttonSize);
        add(btnB);

        btnC = new JButton("");
        btnC.setFont(new Font("Arial", Font.PLAIN, 40));
        btnC.setFocusPainted(false);
        btnC.setBounds(xOffset + 2 * (buttonSize + 10), yOffset, buttonSize, buttonSize);
        add(btnC);

        btnD = new JButton("");
        btnD.setFont(new Font("Arial", Font.PLAIN, 40));
        btnD.setFocusPainted(false);
        btnD.setBounds(xOffset, yOffset + buttonSize + 10, buttonSize, buttonSize);
        add(btnD);

        btnE = new JButton("");
        btnE.setFont(new Font("Arial", Font.PLAIN, 40));
        btnE.setFocusPainted(false);
        btnE.setBounds(xOffset + buttonSize + 10, yOffset + buttonSize + 10, buttonSize, buttonSize);
        add(btnE);

        btnF = new JButton("");
        btnF.setFont(new Font("Arial", Font.PLAIN, 40));
        btnF.setFocusPainted(false);
        btnF.setBounds(xOffset + 2 * (buttonSize + 10), yOffset + buttonSize + 10, buttonSize, buttonSize);
        add(btnF);

        btnG = new JButton("");
        btnG.setFont(new Font("Arial", Font.PLAIN, 40));
        btnG.setFocusPainted(false);
        btnG.setBounds(xOffset, yOffset + 2 * (buttonSize + 10), buttonSize, buttonSize);
        add(btnG);

        btnH = new JButton("");
        btnH.setFont(new Font("Arial", Font.PLAIN, 40));
        btnH.setFocusPainted(false);
        btnH.setBounds(xOffset + buttonSize + 10, yOffset + 2 * (buttonSize + 10), buttonSize, buttonSize);
        add(btnH);

        btnI = new JButton("");
        btnI.setFont(new Font("Arial", Font.PLAIN, 40));
        btnI.setFocusPainted(false);
        btnI.setBounds(xOffset + 2 * (buttonSize + 10), yOffset + 2 * (buttonSize + 10), buttonSize, buttonSize);
        add(btnI);

        // Etiqueta de mensaje
        mensaje = new JLabel("Turno de X", SwingConstants.CENTER);
        mensaje.setFont(new Font("Arial", Font.PLAIN, 20));
        mensaje.setBounds(50, 320, 300, 30);
        add(mensaje);
    }

// Método para inicializar los manejadores de eventos
private void iniciarManejadoresEventos() {
    // Asignar eventos a los botones renombrados
    btnA.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            realizarJugada(0, 0, btnA);
        }
    });

    btnB.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            realizarJugada(0, 1, btnB);
        }
    });

    btnC.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            realizarJugada(0, 2, btnC);
        }
    });

    btnD.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            realizarJugada(1, 0, btnD);
        }
    });

    btnE.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            realizarJugada(1, 1, btnE);
        }
    });

    btnF.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            realizarJugada(1, 2, btnF);
        }
    });

    btnG.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            realizarJugada(2, 0, btnG);
        }
    });

    btnH.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            realizarJugada(2, 1, btnH);
        }
    });

    btnI.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            realizarJugada(2, 2, btnI);
        }
    });
}

private void realizarJugada(int x, int y, JButton boton) {
    String jugador = juegoLogica.realizarJugada(x, y);
    if (!jugador.equals("")) {
        if (jugador.equals("X")) {
            boton.setIcon(cargarImagen("images/NO.png", boton.getWidth(), boton.getHeight()));
        } else if (jugador.equals("O")) {
            boton.setIcon(cargarImagen("images/SI.png", boton.getWidth(), boton.getHeight()));
        }
        if (juegoLogica.esVictoriaRecta()) {
            mensaje.setText("¡Gana " + jugador + "!");
            deshabilitarTablero();
        } else if (juegoLogica.esEmpate()) {
            mensaje.setText("¡Empate!");
            deshabilitarTablero();
        } else {
            mensaje.setText(jugador.equals("X") ? "Turno de O" : "Turno de X");
        }
    }
}

//Método para cargar y escalar imágenes
private ImageIcon cargarImagen(String ruta, int ancho, int alto) {
 ImageIcon icono = new ImageIcon(ruta);
 Image imagen = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
 return new ImageIcon(imagen);
}



// Deshabilitar todos los botones cuando termine el juego
private void deshabilitarTablero() {
    btnA.setEnabled(false);
    btnB.setEnabled(false);
    btnC.setEnabled(false);
    btnD.setEnabled(false);
    btnE.setEnabled(false);
    btnF.setEnabled(false);
    btnG.setEnabled(false);
    btnH.setEnabled(false);
    btnI.setEnabled(false);
}



public static void main(String[] args) {
	TaTeTiImag v=new TaTeTiImag();
	v.setVisible(true);
}
}
