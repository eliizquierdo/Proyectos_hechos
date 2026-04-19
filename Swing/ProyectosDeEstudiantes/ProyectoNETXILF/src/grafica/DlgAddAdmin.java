package grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import logica.PersonsDAO;
import logica.PersonsVO;
import logica.Validaciones;
import persistencia.ConnectionMySQL;

/**
 * DlgAddAdmin es una clase que muestra un Jdialog y sirve para agregar administradores.
 * Este Jdialog incluye campos para ingresar información del administrador, como
 * correo electrónico, contraseña, nombre, etc.
 */
public class DlgAddAdmin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JPanel panel;
	private JPasswordField pssPassAdmin;
	private JLabel lblPasswordAdmin;
	private JButton btnBack;
	private JTextField txtEmailAdmin;
	private JLabel lblEmailAdmin;
	private JTextField txtNameAdmin;
	private JLabel lblNameAdmin;
	private JTextField txtLastName;
	private JLabel lblLastName;
	private JTextField txtCity;
	private JLabel lblCity;
	private JLabel lblCountry;
	private JTextField txtCountry;
	private JLabel lblPhone1;
	private JTextField txtPhone1;

	private JButton btnLogin;
	private JLabel lblWarningEmail;
	private JLabel lblWarningPass;
	private JLabel lblWarningName;
	private JLabel lblWarningLastName;
	private JLabel lblWarningCountry;
	private JLabel lblWarningCity;
	private JLabel lblWarningPhone1;
	private JTextField txtPhone2;
	private JLabel lblPhone2;
	private JLabel lblWarningPhone2;
	
	
	/**
     * Inicializa el Jdialog DlgAddAdmin.
     * Configura el aspecto, inicializa los componentes y establece el manejo de eventos.
     */

	public DlgAddAdmin() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		eventStarter();
		eventHandler();

	}
	
	
	 /**
     * Configura la apariencia y el diseño inicial de los componentes del Jdialog.
     */

	private void eventStarter() {
		setResizable(false);
		setTitle("NETXILF - Agregar Admin");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\img\\Nlogo.jpg"));
		setBounds(100, 100, 278, 623);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 0, 0), new Color(255, 0, 0)));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(10, 10, 242, 564);
		contentPanel.add(panel);
		panel.setLayout(null);

		pssPassAdmin = new JPasswordField();
		pssPassAdmin.setBounds(10, 96, 222, 28);
		panel.add(pssPassAdmin);

		lblPasswordAdmin = new JLabel("Contraseña");
		lblPasswordAdmin.setBounds(20, 75, 80, 14);
		panel.add(lblPasswordAdmin);
		lblPasswordAdmin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPasswordAdmin.setForeground(new Color(255, 255, 255));

		btnLogin = new JButton("Ingresar");
		btnLogin.setBounds(10, 530, 103, 23);
		panel.add(btnLogin);

		btnBack = new JButton("Volver");
		btnBack.setBounds(129, 530, 103, 23);
		panel.add(btnBack);

		txtEmailAdmin = new JTextField();
		txtEmailAdmin.setColumns(10);
		txtEmailAdmin.setBounds(12, 36, 222, 28);
		panel.add(txtEmailAdmin);

		lblEmailAdmin = new JLabel("Correo");
		lblEmailAdmin.setForeground(Color.WHITE);
		lblEmailAdmin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmailAdmin.setBounds(20, 11, 48, 14);
		panel.add(lblEmailAdmin);

		txtNameAdmin = new JTextField();
		txtNameAdmin.setColumns(10);
		txtNameAdmin.setBounds(10, 160, 222, 28);
		panel.add(txtNameAdmin);

		lblNameAdmin = new JLabel("Nombre");
		lblNameAdmin.setForeground(Color.WHITE);
		lblNameAdmin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNameAdmin.setBounds(20, 135, 56, 14);
		panel.add(lblNameAdmin);

		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(10, 224, 222, 28);
		panel.add(txtLastName);

		lblLastName = new JLabel("Apellido");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastName.setBounds(20, 199, 56, 14);
		panel.add(lblLastName);

		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(10, 288, 222, 28);
		panel.add(txtCity);

		lblCity = new JLabel("Ciudad");
		lblCity.setForeground(Color.WHITE);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCity.setBounds(20, 263, 48, 14);
		panel.add(lblCity);

		lblCountry = new JLabel("Pais");
		lblCountry.setForeground(Color.WHITE);
		lblCountry.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCountry.setBounds(28, 327, 27, 14);
		panel.add(lblCountry);

		txtCountry = new JTextField();
		txtCountry.setColumns(10);
		txtCountry.setBounds(10, 352, 222, 28);
		panel.add(txtCountry);

		lblPhone1 = new JLabel("Telefono 1");
		lblPhone1.setForeground(Color.WHITE);
		lblPhone1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone1.setBounds(20, 391, 80, 14);
		panel.add(lblPhone1);

		txtPhone1 = new JTextField();
		txtPhone1.setColumns(10);
		txtPhone1.setBounds(10, 416, 222, 28);
		panel.add(txtPhone1);

		lblWarningEmail = new JLabel("");
		lblWarningEmail.setForeground(Color.GRAY);
		lblWarningEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWarningEmail.setBounds(178, 11, 54, 15);
		panel.add(lblWarningEmail);

		lblWarningPass = new JLabel("");
		lblWarningPass.setForeground(Color.GRAY);
		lblWarningPass.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWarningPass.setBounds(178, 75, 54, 14);
		panel.add(lblWarningPass);

		lblWarningName = new JLabel("");
		lblWarningName.setForeground(Color.GRAY);
		lblWarningName.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningName.setBounds(178, 135, 54, 14);
		panel.add(lblWarningName);

		lblWarningLastName = new JLabel("");
		lblWarningLastName.setForeground(Color.GRAY);
		lblWarningLastName.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningLastName.setBounds(178, 199, 54, 14);
		panel.add(lblWarningLastName);

		lblWarningCountry = new JLabel("");
		lblWarningCountry.setForeground(Color.GRAY);
		lblWarningCountry.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningCountry.setBounds(178, 327, 54, 14);
		panel.add(lblWarningCountry);

		lblWarningCity = new JLabel("");
		lblWarningCity.setForeground(Color.GRAY);
		lblWarningCity.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningCity.setBounds(178, 263, 54, 14);
		panel.add(lblWarningCity);

		lblWarningPhone1 = new JLabel("");
		lblWarningPhone1.setForeground(Color.GRAY);
		lblWarningPhone1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningPhone1.setBounds(178, 391, 54, 14);
		panel.add(lblWarningPhone1);

		txtPhone2 = new JTextField();
		txtPhone2.setColumns(10);
		txtPhone2.setBounds(10, 480, 222, 28);
		panel.add(txtPhone2);

		lblPhone2 = new JLabel("Telefono 2");
		lblPhone2.setForeground(Color.WHITE);
		lblPhone2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone2.setBounds(20, 455, 80, 14);
		panel.add(lblPhone2);

		lblWarningPhone2 = new JLabel("");
		lblWarningPhone2.setForeground(Color.GRAY);
		lblWarningPhone2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningPhone2.setBounds(178, 455, 56, 14);
		panel.add(lblWarningPhone2);

	}
	
	/**
     * Configura los manejadores de eventos para botones y realiza validaciones de entrada
     * antes de insertar la información del administrador en la base de datos.
     */

	private void eventHandler() {
		
		/**
	     * ActionListener para el botón de inicio de sesión. Valida los campos de entrada e inserta
	     * la información del administrador en la base de datos si todas las validaciones son exitosas.
	     */

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Validaciones.verifyEmail(txtEmailAdmin)) {
					lblWarningEmail.setText("");
				} else {
					lblWarningEmail.setText("Incorrecto");
				}

				if (Validaciones.verifyPassword(pssPassAdmin)) {
					lblWarningPass.setText("");
				} else {
					lblWarningPass.setText("Incorrecto");
				}

				if (Validaciones.verifyName(txtNameAdmin)) {
					lblWarningName.setText("");
				} else {
					lblWarningName.setText("Incorrecto");
				}

				if (Validaciones.verifyName(txtLastName)) {
					lblWarningLastName.setText("");
				} else {
					lblWarningLastName.setText("Incorrecto");
				}

				if (Validaciones.verifyNameFull(txtCity)) {
					lblWarningCity.setText("");
				} else {
					lblWarningCity.setText("Incorrecto");
				}

				if (Validaciones.verifyName(txtCountry)) {
					lblWarningCountry.setText("");
				} else {
					lblWarningCountry.setText("Incorrecto");
				}

				if (Validaciones.verifyPhoneNumber(txtPhone1)) {
					lblWarningPhone1.setText("");
				} else {
					lblWarningPhone1.setText("Incorrecto");
				}

				if (Validaciones.verifyPhoneNumber2(txtPhone2)) {
					lblWarningPhone2.setText("");
				} else {
					lblWarningPhone2.setText("Incorrecto");
				}

				String[] phones = new String[2];
				phones[0] = txtPhone1.getText();
				phones[1] = txtPhone2.getText();

				if (lblWarningEmail.getText().equals("") && lblWarningPass.getText().equals("")
						&& lblWarningName.getText().equals("") && lblWarningLastName.getText().equals("")
						&& lblWarningCity.getText().equals("") && lblWarningCountry.getText().equals("")
						&& lblWarningPhone1.getText().equals("") && lblWarningPhone2.getText().equals("")) {

					PersonsVO person = new PersonsVO("Admin", txtNameAdmin.getText(), txtLastName.getText(),
							txtCity.getText(), txtCountry.getText(), phones, txtEmailAdmin.getText(),
							pssPassAdmin.getText());

					int insertedId = PersonsDAO.insertPerson(person);

					if (insertedId > 0) {
						JOptionPane.showMessageDialog(null, "Ingresado correctamente.", "Exito",
								JOptionPane.INFORMATION_MESSAGE);
						DlgHiddenMenu oculto = new DlgHiddenMenu();
						oculto.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "No se ingresaron los datos. Vuelva a intentarlo.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});

		/**
	     * ActionListener para el botón de retroceso. Navega de regreso al Jdialog del menú oculto.
	     */
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgHiddenMenu oculto = new DlgHiddenMenu();
				oculto.setVisible(true);
				dispose();
			}
		});

	}

}
