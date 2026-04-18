package grafica;

import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import static grafica.FrmPrincipal.coleccion; 

public class InVerAlumnos extends JInternalFrame {
	private JButton btnImprimir;
	private JTextArea txtArea;
	private JScrollPane scrollPane;

	
	public InVerAlumnos() {
		setTitle("Imprimir Alumnos");
		setBounds(600, 10, 577, 348);
		iniciarComponentes();
		iniciarManejadoresEventos();
	}
		
		private void iniciarComponentes() {
			getContentPane().setLayout(null);
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 541, 253);
			getContentPane().add(scrollPane);
			btnImprimir = new JButton("Imprimir");
			btnImprimir.setBounds(240, 276, 89, 23);
			getContentPane().add(btnImprimir);
			txtArea = new JTextArea();
			txtArea.setEditable(false);
			txtArea.setBounds(10, 11, 541, 248);
			scrollPane.setViewportView(txtArea);

		
	}
		
		private void iniciarManejadoresEventos() {
			btnImprimir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtArea.setText(coleccion.toString());
				}
			});
		
	}
		
	}
