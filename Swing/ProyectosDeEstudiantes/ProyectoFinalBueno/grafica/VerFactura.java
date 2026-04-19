package grafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import static grafica.MenuPrincipal.lista;
import javax.swing.JTextPane;
import static grafica.GenFactura.Fact;
public class VerFactura extends JDialog {

	public VerFactura() {
		
		IniciarComponentes();
	}
	public void IniciarComponentes() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 214, 424, -201);
		getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 434, 207);
		getContentPane().add(textArea);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(166, 213, 89, 23);
		getContentPane().add(btnImprimir);
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		textArea.setText(Fact.toString());
			}
		
			
		});
		
		
	}
	
}
