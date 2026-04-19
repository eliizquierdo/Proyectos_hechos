package grafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import static grafica.MenuPrincipal.lista;
public class BuscArtic extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public BuscArtic() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JTextPane txtCodigo = new JTextPane();
			txtCodigo.setBounds(127, 11, 106, 20);
			contentPanel.add(txtCodigo);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int codigo=Integer.valueOf(txtCodigo.getText());
				if (lista.buscar(codigo) != null) {
					GenFactura Fac = new GenFactura();
					Fac.setVisible(true);
					
					
				}
				else {
					JOptionPane.showMessageDialog(null,"No existe articulo","Buscar",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(144, 57, 89, 23);
		contentPanel.add(btnBuscar);
		
		JLabel lblBuscarCodigo = new JLabel("Buscar Codigo :");
		lblBuscarCodigo.setBounds(31, 11, 119, 23);
		contentPanel.add(lblBuscarCodigo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
