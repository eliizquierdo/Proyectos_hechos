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

        // Acción para el botón "Modificar"
        else if (e.getSource() == this.f.getModificar()) {
            String nuevoNombre = this.f.getNom().getText();
            int pos = d.getPos();
            d.modificarNombre(pos, nuevoNombre);
            actualizarLista();
            JOptionPane.showMessageDialog(null, "Nombre modificado en la posición: " + pos);
        }

        // Acción para el botón "Borrar"
        else if (e.getSource() == this.f.getBorrar()) {
            int pos = d.getPos();
            d.borrarNombre(pos);
            actualizarLista();
            JOptionPane.showMessageDialog(null, "Nombre borrado en la posición: " + pos);
        }

        // Acción para el botón "Adelante"
        else if (e.getSource() == this.f.getAdelante()) {
            d.avanzarPosicion();
            actualizarPosicion();
        }

        // Acción para el botón "Atrás"
        else if (e.getSource() == this.f.getAtras()) {
            d.retrocederPosicion();
            actualizarPosicion();
        }
    }

    // Método para actualizar el área de texto con los nombres actuales
    private void actualizarLista() {
        String listaNombres = ""; // Inicializamos una cadena vacía
        for (int i = 0; i < d.getNombres().size(); i++) {
            listaNombres += d.getNombres().get(i); // Concatenamos cada nombre
            listaNombres += "\n"; // Añadimos un salto de línea después de cada nombre
        }
        f.getTxa().setText(listaNombres); // Actualizamos el JTextArea
        actualizarPosicion(); // Actualizamos la posición actual
    }


    // Método para actualizar la posición actual en el campo "pos"
    private void actualizarPosicion() {
        f.getPos().setText(String.valueOf(d.getPos()));
        f.getNom().setText(d.getNombreActual());
    }
    
    public Interfaz getF() {
		return f;
	}
}

