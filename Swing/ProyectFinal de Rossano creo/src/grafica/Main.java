package grafica;

import java.awt.EventQueue;

public class Main {
	// Inciciamos el programa
	public static void main(String[] args) {
		try {
			VentanaPrincipal frame = new VentanaPrincipal();
			frame.setVisible(true);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
