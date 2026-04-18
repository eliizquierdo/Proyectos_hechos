package grafica;
/*Completa el código realizando los siguientes cambios:
Crear los botones: Ya está creado btnA. 
Ahora debes crear los otros botones (btnB, btnC, ..., btnI)
 de la misma forma. Usa las coordenadas adecuadas para
 colocarlos correctamente en el tablero.
Asignar eventos a los botones: 
Cada botón debe tener un ActionListener que llame al método
 realizarJugada con las coordenadas correspondientes. 
 Asegúrate de que cada botón, cuando sea presionado, 
 haga la jugada de acuerdo con las reglas del juego.
Deshabilitar los botones cuando termine el juego: 
Cuando un jugador gane o haya empate, 
los botones deben deshabilitarse para evitar más jugadas.*/
import logica.TaTeTiLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaTeTiGUI1 extends JFrame {
    private TaTeTiLogic juegoLogica;
    private JButton btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI;
    private JLabel mensaje;

    public TaTeTiGUI1() {
        juegoLogica = new TaTeTiLogic();
        
        // Configuración del JFrame
        setTitle("Juego 3 en Raya");
        setSize(388, 460);  // Ajuste del tamaño del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Usamos null layout para colocar los componentes manualmente
        
        // Llamamos a los métodos para inicializar los componentes y eventos
        iniciarComponentes();
        // Los estudiantes deben completar este método para asignar los eventos a los botones
        // iniciarManejadoresEventos(); 
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Método para inicializar los componentes gráficos
    private void iniciarComponentes() {
        // Crear los botones y ubicarlos en el JFrame
        int xOffset = 50, yOffset = 50, buttonSize = 80; // Desplazamientos y tamaño de los botones
        
        // Aquí los estudiantes deben completar la creación y disposición de los botones.
        btnA = new JButton("");
        btnA.setFont(new Font("Arial", Font.PLAIN, 40));
        btnA.setFocusPainted(false);
        btnA.setBounds(xOffset, yOffset, buttonSize, buttonSize);
        add(btnA);

        // Los estudiantes deben crear los otros 8 botones (btnB, btnC, ..., btnI) de forma similar.

        // Etiqueta de mensaje
        mensaje = new JLabel("Turno de X", SwingConstants.CENTER);
        mensaje.setFont(new Font("Arial", Font.PLAIN, 20));
        mensaje.setBounds(50, 320, 300, 30); // Ajustamos la posición para que esté visible
        add(mensaje); // Agregar la etiqueta al JFrame
    }

    // Los estudiantes deben completar este método para asignar los eventos a cada botón.
    private void iniciarManejadoresEventos() {
        // Asignar eventos a los botones renombrados
        // Por ejemplo, para el botón A, el estudiante debe agregar el ActionListener de la siguiente manera:
        btnA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Los estudiantes deben completar la lógica para realizar la jugada en el botón adecuado
                realizarJugada(0, 0, btnA);  // El primer botón debe estar asociado con las coordenadas (0, 0)
            }
        });
        
        // Los estudiantes deben asignar eventos a los demás botones (btnB, btnC, ..., btnI)
    }

    // Los estudiantes deben completar este método para manejar la jugada
    private void realizarJugada(int x, int y, JButton boton) {
        if (juegoLogica.hayJuego()) {
            String jugador = juegoLogica.realizarJugada(x, y);
            if (!jugador.equals("")) {
                boton.setText(jugador);
                if (juegoLogica.esVictoriaRecta()) {
                    mensaje.setText("¡Gana " + jugador + "!");
                    juegoLogica.deshabilitarJuego();
                    disableButtons();
                } else if (juegoLogica.esEmpate()) {
                    mensaje.setText("¡Empate!");
                    juegoLogica.deshabilitarJuego();
                    disableButtons();
                } else {
                    mensaje.setText(juegoLogica.getContador() % 2 == 0 ? "Turno de X" : "Turno de O");
                }
            }
        }
    }

    // Deshabilitar botones cuando termine el juego
    private void disableButtons() {
        // Los estudiantes deben completar este método para deshabilitar todos los botones después de terminar el juego
    }

    public static void main(String[] args) {
    	TaTeTiGUI1 ventana = new TaTeTiGUI1();
    	ventana.setVisible(true);
    }
}
