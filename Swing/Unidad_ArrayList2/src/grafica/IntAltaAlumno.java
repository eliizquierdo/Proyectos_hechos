package grafica;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class IntAltaAlumno extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntAltaAlumno frame = new IntAltaAlumno();
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
	public IntAltaAlumno() {
		setBounds(100, 100, 450, 300);

	}

}
