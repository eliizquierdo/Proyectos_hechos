package vista;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import static vista.MenuPrincipal.coleccion;

import java.awt.event.ActionEvent;

public class FrmImprime extends JDialog {
	private JTextArea txtArea;
	private JScrollPane scrollPane;
	private JButton btnImprimir;

	public FrmImprime() {
		iniciarComponentes();
		iniciarManejadorEventos();
	}
		
	private void iniciarComponentes() {
			setTitle("Imprimir Estudiantes");
			setBounds(100, 100, 577, 348);
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
		
		private void iniciarManejadorEventos() {
			btnImprimir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					txtArea.setText(coleccion.toString());
				}
			});
		}
		
}
