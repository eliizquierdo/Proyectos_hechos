package grafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import logica.Cliente;
import logica.Persona;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static grafica.MenuPrincipal.listaP;
public class GenCliente extends JDialog {
    Persona listaP = new Persona() ;
    static Cliente Cli;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtApellido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GenCliente dialog = new GenCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GenCliente() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(21, 22, 182, 112);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JLabel lblCedula = new JLabel("Cedula :");
			lblCedula.setBounds(20, 21, 72, 14);
			panel.add(lblCedula);
		}
		
		JLabel lblApellido = new JLabel("Apellido :");
		lblApellido.setBounds(10, 46, 88, 14);
		panel.add(lblApellido);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(86, 18, 86, 20);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(86, 43, 86, 20);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Cliente preferencial", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(234, 31, 190, 103);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JCheckBox chkClientePreferencial = new JCheckBox("\u00BFEs Cliente preferencial?");
		chkClientePreferencial.setBounds(6, 36, 178, 23);
		panel_1.add(chkClientePreferencial);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						boolean ClienteP=false;
						if (chkClientePreferencial.isSelected()) {
							ClienteP=true;
						}
						String Cedula =txtCedula.getText();
						String Apellido=txtApellido.getText();
						Cli=new Cliente(ClienteP,Cedula,Apellido);
						JOptionPane.showMessageDialog(null,"Registrado Cliente Con exito","Creado",JOptionPane.INFORMATION_MESSAGE);
						listaP.agregar(Cli);
					}
				});
				btnGuardar.setActionCommand("");
				buttonPane.add(btnGuardar);
				getRootPane().setDefaultButton(btnGuardar);
			}
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.exit(HIDE_ON_CLOSE);
					}
				});
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
	}
}
