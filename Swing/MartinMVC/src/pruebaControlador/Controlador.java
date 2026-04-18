package pruebaControlador;

import java.awt.event.*;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener {
	private Interfaz f;
	private Datos d;

	public Controlador() {
		f = new Interfaz(this);
		d = new Datos();
	}

	public Interfaz getF() {
		return f;
	}

	public void setF(Interfaz f) {
		this.f = f;
	}

	public Datos getD() {
		return d;
	}

	public void setD(Datos d) {
		this.d = d;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Acción para el botón "Agregar"
		if (e.getSource() == this.f.getAgregar()) {
			String nombre = this.f.getNom().getText();
			if (!nombre.isEmpty()) {
				d.agregarNombre(nombre);
				actualizarLista();
				JOptionPane.showMessageDialog(null, "Nombre agregado: " + nombre);
			} else {
				JOptionPane.showMessageDialog(null, "El campo de nombre está vacío.");
			}
		}
	}

	// Método para actualizar el área de texto con los nombres actuales
	private void actualizarLista() {
	    String nombresTexto = ""; // Inicializamos una cadena vacía
	    for (String nombre : d.getNombres()) { // Iteramos sobre la lista de nombres
	        nombresTexto =nombresTexto+ nombre + "\n"; // Concatenamos cada nombre con un salto de línea
	    }
	    f.getTxa().setText(nombresTexto); // Actualizamos el JTextArea con la cadena
	    actualizarPosicion(); // Actualizamos la posición actual
	}
	
	// Método para actualizar la posición actual en el campo "pos"
	private void actualizarPosicion() {
		f.getPos().setText(String.valueOf(d.getPos()));
		f.getNom().setText(d.getNomb());
	}
}
