//https://fredygeek.com/2020/09/17/mi-primer-laberinto-en-java/  más laberintos

//aquí le agrega niveles https://www.youtube.com/watch?v=BWixEqYHou0

package paquete;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Juego extends JPanel {

	private JPanel contentPane;
	
	Laberinto laberinto=new Laberinto();
	Personaje personaje=new Personaje();
	
	public Juego() {
				
		addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				personaje.teclaPresionada(e);
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
		setFocusable(true);
	}
	
	@Override
	public void paint(Graphics grafico) {
		laberinto.paint(grafico);
		personaje.paint(grafico);
		
	}
	
	public static void main(String[] args) {
		JFrame miVentana=new JFrame();
		Juego game=new Juego();
		miVentana.setTitle("Mi Primer Juego");
		miVentana.setBounds(300, 200, 920, 540);
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana.add(game);
		
		miVentana.setVisible(true);
		
		while(true) {
			//al try-catch no le veo utilidad por ahora
			try {
				Thread.sleep(10);
			}catch(InterruptedException ex) {
				
			}
			game.repaint();
		}

	}

}

