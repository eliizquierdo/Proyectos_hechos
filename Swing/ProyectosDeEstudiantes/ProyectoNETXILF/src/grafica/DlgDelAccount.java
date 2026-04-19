package grafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import logica.AccountsDAO;
import logica.PersonsDAO;
import logica.ProfilesDAO;
import logica.Validaciones;

import persistencia.GestionCuentas;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

/**
 * DlgDelAccount es una clase que es un JDialog para eliminar una cuenta de usuario en la aplicación NETXILF.
 * Requiere la entrada de la contraseña del usuario para confirmar la eliminación de la cuenta.
 */

public class DlgDelAccount extends JDialog {

	
	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JLabel lblWarning;
	private JButton btnDelete;
	private JButton btnBack;
	private JPasswordField txtPass;
	private JLabel lblQuestion;
	

    /**
     * Constructor de la clase DlgDelAccount.
     * @param nombres Un array de nombres asociados a la cuenta.
     * @param account El nombre de la cuenta que se eliminará.
     */

	public DlgDelAccount(String [] nombres, String account) {
		try {
		    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		eventStarter();
		eventHandler(nombres, account);

	}

	 /**
     * Configura y maneja los eventos de los botones.
     * @param nombres Un array de nombres asociados a la cuenta.
     * @param account El nombre de la cuenta que se eliminará.
     */
	
	private void eventHandler(String [] nombres, String account) {

		/**
	     * ActionListener para el botón "Volver". Cierra el diálogo y muestra el menú de perfiles.
	     */
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] id_Profiles = ProfilesDAO.returnIdProfile(account);				
				DlgProfile profile = new DlgProfile(nombres, account, id_Profiles);
				profile.setVisible(true);
				dispose();
			}
		});
		
		 /**
	     * ActionListener para el botón "Eliminar". Borra las cuentas asociadas al mail y password de la base de datos.
	     */
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = txtPass.getText();
							
				String Ok = AccountsDAO.deleteAccount(account, pass);
				System.out.println(Ok);
				if(Ok.equals("Registro exitoso.")) {
					JOptionPane.showMessageDialog(null, "Cuenta eliminada con exito.", "Exito",
							JOptionPane.INFORMATION_MESSAGE);
					DlgLogin login = new DlgLogin();
					login.setVisible(true);
					dispose();
					
				}else {
					JOptionPane.showMessageDialog(null, "No se ha podido eliminar la cuenta.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				

			}
		});
	}

	private void eventStarter() {
		setResizable(false);
		setTitle("NETXILF - Eliminar Cuenta");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\img\\Nlogo.jpg"));
		setBounds(100, 100, 416, 210);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 0, 0), new Color(255, 0, 0)));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(10, 10, 382, 150);
		contentPanel.add(panel);
		panel.setLayout(null);

		lblWarning = new JLabel("Ingrese la contraseña para ELIMINAR LA CUENTA");
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setBounds(0, 45, 382, 23);
		panel.add(lblWarning);
		lblWarning.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWarning.setForeground(new Color(255, 255, 255));

		btnDelete = new JButton("Eliminar");
		btnDelete.setBounds(68, 118, 103, 23);
		panel.add(btnDelete);
		btnDelete.setActionCommand("OK");

		btnBack = new JButton("Volver");
		btnBack.setBounds(209, 118, 103, 23);
		panel.add(btnBack);
		btnBack.setActionCommand("Cancel");

		txtPass = new JPasswordField();
		txtPass.setColumns(10);
		txtPass.setBounds(68, 79, 244, 28);
		panel.add(txtPass);
		
		lblQuestion = new JLabel("Se eliminara su suscripción. ¿Esta seguro?");
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setForeground(Color.WHITE);
		lblQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuestion.setBounds(0, 11, 379, 23);
		panel.add(lblQuestion);

	}

}