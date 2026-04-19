package grafica;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;

import logica.AccountsDAO;
import logica.PersonsDAO;
import logica.PersonsVO;
import logica.Validaciones;
import persistencia.ConnectionMySQL;

import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * Clase para el diálogo de registro de nuevos clientes en la aplicación.
 * Extiende JDialog para representar una ventana de diálogo.
 */

public class DlgNewClient extends JDialog {

	private DlgNewClient dlgRegistrar;
	private JTextField txtPhone1;
	private JTextField txtCity;
	private JTextField txtCountry;
	private JTextField txtLastName;
	private JTextField txtNamePersons;
	private JButton btnRegister;
	private JPanel pnlSecondaryPanel;
	private JLabel lblPhone;
	private JLabel lblCity;
	private JLabel lblCountry;
	private JLabel lblLastName;
	private JLabel lblName;
	private JLabel lblLogo;
	private JCheckBox chcxTermsConditions;
	private JButton btnBack;
	private JLabel lblWarningTerms;
	private JLabel lblWarningName;
	private JLabel lblWarningLastName;
	private JLabel lblWarningCountry;
	private JLabel lblWarningCity;
	private JLabel lblWarningPhone;
	private JLabel lblWarningBD;
	private JLabel lblImgMain;
	private ButtonGroup buttonGroup;
	private JTextField txtPhone2;
	private JLabel lblPressHere;
	private JLabel lblYouAreClient;
	private JLabel lblWarningPhone2;
	private JLabel lblPhoneOptional;

	/**
     * Constructor por defecto para la clase DlgNewClient.
     * Inicializa la apariencia y los manejadores de eventos.
     */
	
	public DlgNewClient() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		eventStarter();
		setResizable(false);
		setLocationRelativeTo(null);
		eventHandler();
	}
	
	/**
     * Configura la apariencia inicial y el diseño del diálogo.
     */

	private void eventStarter() {
		setModal(true);
		setFont(new Font("Dialog", Font.PLAIN, 15));
		getContentPane().setBackground(new Color(216, 31, 37));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\img\\Nlogo.jpg"));

		setTitle("NETXILF - Registrarse");
		setBounds(100, 100, 1200, 700);
		getContentPane().setLayout(null);

		pnlSecondaryPanel = new JPanel();
		pnlSecondaryPanel.setLayout(null);
		pnlSecondaryPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlSecondaryPanel.setBackground(Color.BLACK);
		pnlSecondaryPanel.setBounds(10, 11, 334, 643);
		getContentPane().add(pnlSecondaryPanel);

		lblLogo = new JLabel("New label");
		lblLogo.setIcon(
				new ImageIcon("C:\\img\\NetxilfLogo_Inicio.jpg"));
		lblLogo.setBounds(22, 12, 288, 230);
		pnlSecondaryPanel.add(lblLogo);

		lblLastName = new JLabel("Apellido");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setBounds(45, 338, 69, 14);
		pnlSecondaryPanel.add(lblLastName);

		lblCountry = new JLabel("Pais");
		lblCountry.setForeground(Color.WHITE);
		lblCountry.setBounds(45, 381, 80, 17);
		pnlSecondaryPanel.add(lblCountry);

		lblCity = new JLabel("Ciudad");
		lblCity.setForeground(Color.WHITE);
		lblCity.setBounds(45, 425, 69, 16);
		pnlSecondaryPanel.add(lblCity);

		lblPhone = new JLabel("Telefono");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setBounds(45, 473, 69, 17);
		pnlSecondaryPanel.add(lblPhone);

		txtPhone1 = new JTextField();
		txtPhone1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPhone1.setColumns(10);
		txtPhone1.setBounds(43, 490, 238, 26);
		pnlSecondaryPanel.add(txtPhone1);

		txtCity = new JTextField();
		txtCity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCity.setColumns(10);
		txtCity.setBounds(43, 442, 238, 26);
		pnlSecondaryPanel.add(txtCity);

		txtCountry = new JTextField();
		txtCountry.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCountry.setColumns(10);
		txtCountry.setBounds(43, 396, 238, 26);
		pnlSecondaryPanel.add(txtCountry);

		txtLastName = new JTextField();
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLastName.setColumns(10);
		txtLastName.setBounds(43, 351, 238, 26);
		pnlSecondaryPanel.add(txtLastName);

		btnRegister = new JButton("Resgistrarme");
		btnRegister.setBackground(new Color(216, 31, 37));
		btnRegister.setOpaque(false);
		btnRegister.setBounds(43, 601, 123, 31);
		pnlSecondaryPanel.add(btnRegister);

		txtNamePersons = new JTextField("");
		txtNamePersons.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNamePersons.setColumns(10);
		txtNamePersons.setBounds(43, 306, 238, 26);
		pnlSecondaryPanel.add(txtNamePersons);

		lblName = new JLabel("Nombre");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(45, 290, 69, 14);
		pnlSecondaryPanel.add(lblName);

		chcxTermsConditions = new JCheckBox("Acepto Terminos y condiciones");
		chcxTermsConditions.setForeground(Color.WHITE);
		chcxTermsConditions.setBackground(Color.BLACK);
		chcxTermsConditions.setBounds(45, 570, 227, 26);
		pnlSecondaryPanel.add(chcxTermsConditions);

		btnBack = new JButton("Volver");
		btnBack.setOpaque(false);
		btnBack.setBackground(new Color(216, 31, 37));
		btnBack.setBounds(176, 601, 104, 31);
		pnlSecondaryPanel.add(btnBack);

		lblWarningTerms = new JLabel("");
		lblWarningTerms.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWarningTerms.setForeground(Color.GRAY);
		;
		lblWarningTerms.setBounds(278, 576, 46, 14);
		pnlSecondaryPanel.add(lblWarningTerms);

		lblWarningName = new JLabel("");
		lblWarningName.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningName.setForeground(Color.GRAY);
		lblWarningName.setBounds(176, 290, 105, 14);
		pnlSecondaryPanel.add(lblWarningName);

		lblWarningLastName = new JLabel("");
		lblWarningLastName.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningLastName.setForeground(Color.GRAY);
		lblWarningLastName.setBounds(176, 338, 105, 14);
		pnlSecondaryPanel.add(lblWarningLastName);

		lblWarningCountry = new JLabel("");
		lblWarningCountry.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningCountry.setForeground(Color.GRAY);
		lblWarningCountry.setBounds(176, 384, 105, 14);
		pnlSecondaryPanel.add(lblWarningCountry);

		lblWarningCity = new JLabel("");
		lblWarningCity.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningCity.setForeground(Color.GRAY);
		lblWarningCity.setBounds(176, 427, 105, 14);
		pnlSecondaryPanel.add(lblWarningCity);

		lblWarningPhone = new JLabel("");
		lblWarningPhone.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningPhone.setForeground(Color.GRAY);
		lblWarningPhone.setBounds(176, 476, 105, 14);
		pnlSecondaryPanel.add(lblWarningPhone);

		lblWarningBD = new JLabel("");
		lblWarningBD.setForeground(new Color(255, 255, 255));
		lblWarningBD.setBounds(22, 228, 288, 26);
		pnlSecondaryPanel.add(lblWarningBD);

		txtPhone2 = new JTextField();
		txtPhone2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPhone2.setColumns(10);
		txtPhone2.setBounds(43, 537, 238, 26);
		pnlSecondaryPanel.add(txtPhone2);

		lblPhoneOptional = new JLabel("Telefono (opcional)");
		lblPhoneOptional.setForeground(Color.WHITE);
		lblPhoneOptional.setBounds(45, 520, 92, 17);
		pnlSecondaryPanel.add(lblPhoneOptional);

		lblWarningPhone2 = new JLabel("");
		lblWarningPhone2.setForeground(Color.GRAY);
		lblWarningPhone2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningPhone2.setBounds(176, 523, 105, 14);
		pnlSecondaryPanel.add(lblWarningPhone2);

		lblYouAreClient = new JLabel("¿YA ERES CLIENTE ?");
		lblYouAreClient.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblYouAreClient.setForeground(new Color(255, 255, 255));
		lblYouAreClient.setBounds(45, 253, 128, 26);
		pnlSecondaryPanel.add(lblYouAreClient);

		lblPressHere = new JLabel("PRESIONA AQUI");
		lblPressHere.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPressHere.setForeground(new Color(255, 0, 0));
		lblPressHere.setBounds(176, 253, 105, 26);
		pnlSecondaryPanel.add(lblPressHere);

		lblImgMain = new JLabel("");
		lblImgMain.setIcon(
				new ImageIcon("C:\\img\\imgRegistrarse.jpg"));
		lblImgMain.setBounds(354, 80, 820, 490);
		getContentPane().add(lblImgMain);

		buttonGroup = new ButtonGroup();
	}
	
	/**
     * Configura los manejadores de eventos para varios componentes en el diálogo.
     */

	private void eventHandler() {

		lblPressHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DlgPersonRegister link = new DlgPersonRegister();
				link.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblPressHere.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblPressHere.setForeground(new Color(255, 0, 0));
			}
		});

		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/* txtNamePerson,txtLastName, txtCountry, txtCity, txtPhone, txtPhone1, */

				if (Validaciones.verifyName(txtNamePersons)) {
					lblWarningName.setText("");
				} else {
					lblWarningName.setText("Incorrecto");
				}

				if (Validaciones.verifyName(txtLastName)) {
					lblWarningLastName.setText("");
				} else {
					lblWarningLastName.setText("Incorrecto");
				}

				if (Validaciones.verifyName(txtCountry)) {
					lblWarningCountry.setText("");
				} else {
					lblWarningCountry.setText("Incorrecto");
				}

				if (Validaciones.verifyName(txtCity)) {
					lblWarningCity.setText("");
				} else {
					lblWarningCity.setText("Incorrecto");
				}

				if (Validaciones.verifyPhoneNumber(txtPhone1)) {
					lblWarningPhone.setText("");
				} else {
					lblWarningPhone.setText("Incorrecto");
				}

				if (Validaciones.verifyPhoneNumber2(txtPhone2)) {
					lblWarningPhone2.setText("");
				} else {
					lblWarningPhone2.setText("Incorrecto");
				}

				String[] phones = new String[2];
				phones[0] = txtPhone1.getText();
				phones[1] = txtPhone2.getText();

				if (lblWarningName.getText().equals("") && lblWarningLastName.getText().equals("")
						&& lblWarningCountry.getText().equals("") && lblWarningCity.getText().equals("")
						&& lblWarningPhone.getText().equals("") && lblWarningPhone2.getText().equals("")
						&& chcxTermsConditions.isSelected()) {
					PersonsVO person = new PersonsVO("Cliente", txtNamePersons.getText(), txtLastName.getText(),
							txtCountry.getText(), txtCity.getText(), phones);
					
					
						DlgNewAccount account = new DlgNewAccount(person);
						account.setVisible(true);
						dispose();
				

				}

			}
		});

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DlgStart start = new DlgStart();
				start.setVisible(true);
				dispose();
			}
		});

	}

}
