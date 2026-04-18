package grafica;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class IntVerAlumnos extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntVerAlumnos frame = new IntVerAlumnos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IntVerAlumnos() {
		setBounds(100, 100, 450, 300);

	}

}
