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


import logica.Validaciones;
import logica.ProfilesVO;
import logica.ProfilesDAO;


import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;


/**
 * DlgAddProfile es una clase que es un Jdialog para agregar perfiles de usuario.
 * Este diálogo permite ingresar el nombre y el PIN del perfil.
 */

public class DlgAddProfile extends JDialog {

	
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPasswordField pssPIN;
	private JPanel panel;
	private JLabel lblNameProfile;
	private JLabel lblPIN;
	private JButton btnLogin;
	private JButton btnBack;
	private JTextField txtNameProfile;
	private JLabel lblWarningName;
	private JLabel lblWarningPIN;
	
	/**
     * Constructor de la clase DlgAddProfile.
     * @param names Un array de nombres (perfiles asociados a la cuenta).
     * @param account La cuenta asociada al perfil.
     */

	public DlgAddProfile(String [] names, String account) {
		try {
		    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		eventStarter();
		eventHandler(names, account);
		

	}
	
	/**
     * Configura los manejadores de eventos y escuchadores de teclas para la funcionalidad del diálogo.
     * @param names Un array de nombres (perfiles asociados a la cuenta).
     * @param account La cuenta asociada al perfil.
     */

	private void eventHandler(String [] names, String account) {
		

		pssPIN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            // Presionaron Enter, ejecuta la acción del botón "Ingresar"
		            btnLogin.doClick(); // Simula un clic en el botón
		          
		        }
			}
		});
		
		/**
	     * ActionListener para el botón "Volver". Cierra el diálogo.
	     */
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		 /**
	     * ActionListener para el botón "Ingresar". Valida los campos de entrada y agrega el perfil a la base de datos.
	     */
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameProfile = txtNameProfile.getText();
				String PIN = pssPIN.getText();
				
				if(Validaciones.verifyNameFull(txtNameProfile)) {
					lblWarningName.setText("Incorrecto");
				}else {
					lblWarningName.setText("");
				}
				
				if(Validaciones.verifyPIN(pssPIN)) {
					lblWarningName.setText("Incorrecto");
				}else {
					lblWarningName.setText("");
				}
				
				
				
				ProfilesVO profile = new ProfilesVO(nameProfile, PIN);
				
				if(ProfilesDAO.insertProfiles(profile, account) != null) {
					JOptionPane.showMessageDialog(null, "Cuenta ingresada correctamente! Se necesita volver a ingresar para recargar los datos.", "Exito",
							JOptionPane.INFORMATION_MESSAGE);
					DlgLogin login = new DlgLogin();
					login.setVisible(true);
					dispose();
							
				}else {
					JOptionPane.showMessageDialog(null, "Cuenta inexistente. Verifique los datos!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
	}
	
	/**
     * Inicializa y configura la apariencia del JDialog, así como también los componentes y su disposición.
     */

	private void eventStarter() {
		setResizable(false);
		setTitle("NETXILF - Agregar Perfil");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\img\\Nlogo.jpg"));
		setBounds(100, 100, 278, 228);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 0, 0), new Color(255, 0, 0)));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(10, 10, 242, 168);
		contentPanel.add(panel);
		panel.setLayout(null);

		txtNameProfile = new JTextField();
		txtNameProfile.setBounds(10, 36, 222, 28);
		panel.add(txtNameProfile);
		txtNameProfile.setColumns(10);

		lblNameProfile = new JLabel("Nombre");
		lblNameProfile.setBounds(91, 11, 62, 14);
		panel.add(lblNameProfile);
		lblNameProfile.setForeground(new Color(255, 255, 255));
		lblNameProfile.setFont(new Font("Tahoma", Font.BOLD, 14));

		pssPIN = new JPasswordField();
		pssPIN.setBounds(10, 96, 222, 28);
		panel.add(pssPIN);

		lblPIN = new JLabel("PIN");
		lblPIN.setBounds(104, 75, 27, 14);
		panel.add(lblPIN);
		lblPIN.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPIN.setForeground(new Color(255, 255, 255));

		btnLogin = new JButton("Ingresar");
		btnLogin.setBounds(10, 135, 103, 23);
		panel.add(btnLogin);
		btnLogin.setActionCommand("OK");

		btnBack = new JButton("Volver");
		btnBack.setBounds(129, 135, 103, 23);
		panel.add(btnBack);
		btnBack.setActionCommand("Cancel");
		
		lblWarningName = new JLabel("");
		lblWarningName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWarningName.setForeground(new Color(192, 192, 192));
		lblWarningName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWarningName.setBounds(151, 11, 81, 14);
		panel.add(lblWarningName);
		
		lblWarningPIN = new JLabel("");
		lblWarningPIN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWarningPIN.setForeground(Color.LIGHT_GRAY);
		lblWarningPIN.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWarningPIN.setBounds(151, 75, 81, 14);
		panel.add(lblWarningPIN);
		
	}
}
