package Gráfica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class FrmCuatroEnRaya extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private int _contador = 0; 
	private String _ganador = "";
	private boolean _hayJuego = true;
	private boolean turnoRojo = true;
	
	private JLabel mostrarGanador;
	private JPanel contentPane;
	private JPanel tablero; 
	private JButton[][] botones = new JButton[6][7];
	private boolean[][] botonesActivos = new boolean[6][7];
	
	ImageIcon clrRojo = new ImageIcon("C:\\Users\\zaeli\\Descargas 2\\CuatroEnRaya\\Imágenes\\crlRojo.jpg");
	ImageIcon clrAmarillo = new ImageIcon("C:\\Users\\zaeli\\Descargas 2\\CuatroEnRaya\\Imágenes\\crlAmarillo.jpg");
	
	public FrmCuatroEnRaya() {
		
		    iniciarComponentes();
		    iniciarManejadoresEventos();
	}
	
	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        setTitle("4 En Raya");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        tablero = new JPanel();
        tablero.setLayout(new GridLayout(6, 7));
        contentPane.add(tablero, BorderLayout.CENTER);
        
        mostrarGanador = new JLabel(" ");
        mostrarGanador.setHorizontalAlignment(SwingConstants.CENTER); // Centrar texto
        contentPane.add(mostrarGanador, BorderLayout.SOUTH); 
        mostrarGanador.setVisible(false);
	}
	
	private void iniciarManejadoresEventos() {
		
		agregarBotones();
		activarBotones(botonesActivos);
		darValorBotones();
	}

	private void agregarBotones() {
		for(int f = 0; f<6; f++) {
			for(int c= 0; c<7; c++) {
				botones[f][c] = new JButton("");
	            tablero.add(botones[f][c]);
	            botones[f][c].setIcon(null);
			}	
		}
	}
	
	private void activarBotones(boolean matriz[][]) {
		
		for(int a = 0; a<=6; a++) {
			matriz[5][a] = true;
		}
		
		for(int f1 = 0; f1<=4; f1++) {
			for(int c2 = 0; c2<=6; c2++) {
				 if(botones[f1+1][c2].getIcon() != null) {
					 matriz[f1][c2] = true;
				 }
			}
		}
		
		darValorBotones();
		hayJuego();
	} // Fin activarBotones

	private void darValorBotones() {
		for(int f = 0; f<6; f++) {
			for(int c= 0; c<7; c++) {
				
				if(botonesActivos[f][c]) {
					botones[f][c].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JButton botonPresionado = (JButton) e.getSource();
							if(botonPresionado.getIcon() == null && _hayJuego) {
								if(turnoRojo) {
								botonPresionado.setIcon(clrRojo);
								} else {
								botonPresionado.setIcon(clrAmarillo);
								}
								_contador++;
								turnoRojo = !turnoRojo;
								activarBotones(botonesActivos);
								hayJuego();
							}
							if (!_hayJuego) {
	                            mostrarGanador();
	                        }

						}
					});
				}
			}
		}
	} // fin darValorBotones

	private void hayJuego() {
		for(int h=0;h<6 && _hayJuego;h++) {
			for(int i=0; i<4;i++) {
				if (botones[h][i].getIcon() != null && 
					botones[h][i].getIcon()==(botones[h][i+1].getIcon()) &&
					botones[h][i+2].getIcon()==(botones[h][i+3].getIcon()) &&
					botones[h][i].getIcon()==(botones[h][i+2].getIcon())) {
					_hayJuego = false;
					if(botones[h][i].getIcon()==clrRojo) {
						_ganador = "Ganó el jugador Rojo";
					} else {
						_ganador = "Ganó el jugador Amarillo";
					}
				}
			}
		}
		
		for(int i=0;i<7 && _hayJuego;i++) {
			for(int h=0; h<3;h++) {
				if (botones[h][i].getIcon()!= null &&
					botones[h][i].getIcon()==(botones[h+1][i].getIcon()) &&
					botones[h+2][i].getIcon()==(botones[h+3][i].getIcon()) &&
					botones[h][i].getIcon()==(botones[h+2][i].getIcon())) {
					_hayJuego = false;
					if(botones[h][i].getIcon()==(clrRojo)) {
						_ganador = "Ganó el jugador Rojo";
						} else {
						_ganador = "Ganó el jugador Amarillo";
						}
				}
			}
		} 
	
	for(int i=0;i<4 && _hayJuego;i++) {
		for(int h=0; h<3;h++) {
			if (botones[h][i].getIcon()!= null &&
				botones[h][i].getIcon()==(botones[h+1][i+1].getIcon()) &&
				botones[h+2][i+2].getIcon()==(botones[h+3][i+3].getIcon()) &&
				botones[h][i].getIcon()==(botones[h+2][i+2].getIcon())) {
				_hayJuego = false;
				if(botones[h][i].getIcon()==(clrRojo)) {
					_ganador = "Ganó el jugador Rojo";
					} else {
					_ganador = "Ganó el jugador Amarillo";
					}
			}
		}
	} 
	for(int i=0;i<4 && _hayJuego;i++) {
		for(int h=5; h>2;h--) {
			if (botones[h][i].getIcon()!= null &&
				botones[h][i].getIcon()==(botones[h-1][i+1].getIcon()) &&
				botones[h-2][i+2].getIcon()==(botones[h-3][i+3].getIcon()) &&
				botones[h][i].getIcon()==(botones[h-2][i+2].getIcon())) {
				_hayJuego = false;
				if(botones[h][i].getIcon()==(clrRojo)) {
					_ganador = "Ganó el jugador Rojo";
					} else {
					_ganador = "Ganó el jugador Amarillo";
					}
			}
		}
	} 
	
	if(_contador>=42 && _ganador.equals("")) {
		_hayJuego = false;
		_ganador = "El juego quedó en empate";
	}
  }
	
	private void mostrarGanador() {
			mostrarGanador.setText(_ganador);
	        mostrarGanador.setVisible(true);
		}
	
	public static void main(String[] args) {
        FrmCuatroEnRaya ventana = new FrmCuatroEnRaya();
        ventana.setVisible(true);
    }
	}