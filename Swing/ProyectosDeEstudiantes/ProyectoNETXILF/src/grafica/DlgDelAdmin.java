package grafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import logica.PersonsDAO;
import logica.Validaciones;

import persistencia.GestionCuentas;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * La clase DlgDelAdmin proporciona una interfaz gráfica para eliminar un administrador del sistema NETXILF.
 * Permite ingresar el correo electrónico del administrador a eliminar y realiza la operación correspondiente.
 */

public class DlgDelAdmin extends JDialog {

	
	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JLabel lblMail;
	private JButton btnDelete;
	private JButton btnBack;
	private JTextField txtCorreo;
	
	 /**
     * Constructor de la clase. Inicializa la interfaz gráfica y los manejadores de eventos asociados.
     */

	public DlgDelAdmin() {
		try {
		    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		eventStarter();
		eventHandler();

	}
	
	 /**
     * Configura los manejadores de eventos para los botones de la interfaz.
     */

	private void eventHandler() {
		
		/**
	     * ActionListener para el botón "Volver". Cierra el diálogo y muestra el menú de perfiles.
	     */

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgHiddenMenu oculto = new DlgHiddenMenu();
				oculto.setVisible(true);
				dispose();
			}
		});
		
		/**
	     * ActionListener para el botón "Eliminar". Borra los admin asociados al mail de la base de datos.
	     */
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mail = txtCorreo.getText();
							
				PersonsDAO.DeleteAdmin(mail);
				DlgHiddenMenu oculto = new DlgHiddenMenu();
				oculto.setVisible(true);
				dispose();

			}
		});
	}
	
	/**
     * Inicializa y configura la interfaz gráfica, estableciendo propiedades como el tamaño, la ubicación y la apariencia.
     */

	private void eventStarter() {
		setResizable(false);
		setTitle("NETXILF - Eliminar Admin");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\img\\Nlogo.jpg"));
		setBounds(100, 100, 300, 176);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 0, 0), new Color(255, 0, 0)));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(10, 10, 264, 120);
		contentPanel.add(panel);
		panel.setLayout(null);

		lblMail = new JLabel("Administrador a Eliminar - Correo");
		lblMail.setBounds(15, 11, 234, 14);
		panel.add(lblMail);
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMail.setForeground(new Color(255, 255, 255));

		btnDelete = new JButton("Eliminar");
		btnDelete.setBounds(10, 86, 103, 23);
		panel.add(btnDelete);
		btnDelete.setActionCommand("OK");

		btnBack = new JButton("Volver");
		btnBack.setBounds(146, 86, 103, 23);
		panel.add(btnBack);
		btnBack.setActionCommand("Cancel");

		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(10, 36, 244, 28);
		panel.add(txtCorreo);

	}

}