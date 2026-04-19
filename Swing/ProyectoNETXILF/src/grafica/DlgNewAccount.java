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
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import persistencia.ConnectionMySQL;
import logica.AccountsDAO;
import logica.AccountsVO;
import logica.PersonsDAO;
import logica.Validaciones;
import logica.PersonsVO;

import java.util.Date;

/**
 * Diálogo para crear una nueva cuenta de usuario con detalles de registro.
 */

public class DlgNewAccount extends JDialog {

	private static final long serialVersionUID = 1L;
	private DlgNewAccount dlgRegist;
	private JPasswordField pssCardCode;
	private JTextField txtCardNumber;
	private JTextField txtCardName;
	private JPasswordField pssPassword;
	private JTextField txtEmail;
	private JButton btnRegister;
	private JPanel pnlSecondaryPanel;
	private JLabel lblCardCode;
	private JLabel lblCardNumber;
	private JLabel lblCardName;
	private JLabel lblPassword;
	private JLabel lblEmail;
	private JLabel lblLogo;
	private JCheckBox chcxTermsConditions;
	private JButton btnBack;
	private JLabel lblWarningTerms;
	private JLabel lblWarningEmail;
	private JLabel lblWarningPassword;
	private JLabel lblWarningCardName;
	private JLabel lblWarningCardNumber;
	private JLabel lblWarningCardCode;
	private JLabel lblWarningBD;
	private JLabel lblImgMain;
	private JToggleButton tglbtnBronze;
	private JToggleButton tglbtnSilver;
	private JToggleButton tglbtnGold;
	private JToggleButton tglbtnDiamond;
	private ButtonGroup buttonGroup;
	private JLabel lblPlan;
	private String levelandScreens;
	private JLabel lblWarningPlan;

	 /**
     * Constructor por defecto para la clase DlgNewAccount.
     * @param person El objeto PersonsVO para el usuario.
     */

	public DlgNewAccount(PersonsVO person) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		eventStarter();
		setResizable(false);
		setLocationRelativeTo(null);
		eventHandler(person);

	}
	
	/**
     * Constructor para la clase DlgNewAccount con un ID de persona existente.
     * @param id_Person El ID de una persona existente.
     */
	
	public DlgNewAccount(int id_Person) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		eventStarter();
		setResizable(false);
		setLocationRelativeTo(null);
		eventHandler(id_Person);

	}
	
	/**
     * Configura el estado inicial del diálogo, incluido el diseño y la apariencia.
     */

	private void eventStarter() {
		setModal(true);
		setFont(new Font("Dialog", Font.PLAIN, 15));
		getContentPane().setBackground(new Color(216, 31, 37));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\img\\Nlogo.jpg"));

		setTitle("NETXILF - Registrarse");
		setBounds(100, 100, 1200, 750);
		getContentPane().setLayout(null);

		pnlSecondaryPanel = new JPanel();
		pnlSecondaryPanel.setLayout(null);
		pnlSecondaryPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlSecondaryPanel.setBackground(Color.BLACK);
		pnlSecondaryPanel.setBounds(10, 11, 334, 689);
		getContentPane().add(pnlSecondaryPanel);

		lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon("C:\\img\\NetxilfLogo_InicioAmpliado.jpg"));
		lblLogo.setBounds(22, 12, 288, 314);
		pnlSecondaryPanel.add(lblLogo);

		lblPassword = new JLabel("Contraseña");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(47, 410, 94, 14);
		pnlSecondaryPanel.add(lblPassword);

		lblCardName = new JLabel("Nombre de la tarjeta");
		lblCardName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCardName.setForeground(Color.WHITE);
		lblCardName.setBounds(45, 460, 137, 17);
		pnlSecondaryPanel.add(lblCardName);

		lblCardNumber = new JLabel("Numero de la tarjeta");
		lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCardNumber.setForeground(Color.WHITE);
		lblCardNumber.setBounds(45, 512, 123, 16);
		pnlSecondaryPanel.add(lblCardNumber);

		lblCardCode = new JLabel("Codigo verificador");
		lblCardCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCardCode.setForeground(Color.WHITE);
		lblCardCode.setBounds(45, 566, 123, 17);
		pnlSecondaryPanel.add(lblCardCode);

		pssCardCode = new JPasswordField();
		pssCardCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pssCardCode.setColumns(10);
		pssCardCode.setBounds(43, 583, 238, 26);
		pnlSecondaryPanel.add(pssCardCode);

		txtCardNumber = new JTextField();
		txtCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCardNumber.setColumns(10);
		txtCardNumber.setBounds(43, 529, 238, 26);
		pnlSecondaryPanel.add(txtCardNumber);

		txtCardName = new JTextField();
		txtCardName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCardName.setColumns(10);
		txtCardName.setBounds(43, 475, 238, 26);
		pnlSecondaryPanel.add(txtCardName);

		pssPassword = new JPasswordField();
		pssPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pssPassword.setColumns(10);
		pssPassword.setBounds(45, 423, 238, 26);
		pnlSecondaryPanel.add(pssPassword);

		btnRegister = new JButton("Resgistrarme");
		btnRegister.setBackground(new Color(216, 31, 37));
		btnRegister.setOpaque(false);
		btnRegister.setBounds(45, 647, 123, 31);
		pnlSecondaryPanel.add(btnRegister);

		txtEmail = new JTextField("");
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBounds(43, 373, 238, 26);
		pnlSecondaryPanel.add(txtEmail);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(45, 357, 63, 14);
		pnlSecondaryPanel.add(lblEmail);

		chcxTermsConditions = new JCheckBox("Acepto Terminos y condiciones");
		chcxTermsConditions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chcxTermsConditions.setForeground(Color.WHITE);
		chcxTermsConditions.setBackground(Color.BLACK);
		chcxTermsConditions.setBounds(47, 616, 236, 26);
		pnlSecondaryPanel.add(chcxTermsConditions);

		btnBack = new JButton("Volver");
		btnBack.setOpaque(false);
		btnBack.setBackground(new Color(216, 31, 37));
		btnBack.setBounds(178, 647, 104, 31);
		pnlSecondaryPanel.add(btnBack);

		lblWarningTerms = new JLabel("");
		lblWarningTerms.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWarningTerms.setForeground(Color.GRAY);
		;
		lblWarningTerms.setBounds(280, 622, 46, 14);
		pnlSecondaryPanel.add(lblWarningTerms);

		lblWarningEmail = new JLabel("");
		lblWarningEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningEmail.setForeground(Color.GRAY);
		lblWarningEmail.setBounds(178, 357, 105, 14);
		pnlSecondaryPanel.add(lblWarningEmail);

		lblWarningPassword = new JLabel("");
		lblWarningPassword.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningPassword.setForeground(Color.GRAY);
		lblWarningPassword.setBounds(178, 410, 105, 14);
		pnlSecondaryPanel.add(lblWarningPassword);

		lblWarningCardName = new JLabel("");
		lblWarningCardName.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningCardName.setForeground(Color.GRAY);
		lblWarningCardName.setBounds(178, 463, 105, 14);
		pnlSecondaryPanel.add(lblWarningCardName);

		lblWarningCardNumber = new JLabel("");
		lblWarningCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningCardNumber.setForeground(Color.GRAY);
		lblWarningCardNumber.setBounds(178, 514, 105, 14);
		pnlSecondaryPanel.add(lblWarningCardNumber);

		lblWarningCardCode = new JLabel("");
		lblWarningCardCode.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningCardCode.setForeground(Color.GRAY);
		lblWarningCardCode.setBounds(180, 569, 105, 14);
		pnlSecondaryPanel.add(lblWarningCardCode);

		lblWarningBD = new JLabel("");
		lblWarningBD.setForeground(new Color(255, 255, 255));
		lblWarningBD.setBounds(22, 326, 288, 26);
		pnlSecondaryPanel.add(lblWarningBD);

		lblWarningPlan = new JLabel("");
		lblWarningPlan.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarningPlan.setForeground(Color.GRAY);
		lblWarningPlan.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningPlan.setBounds(73, 337, 184, 14);
		pnlSecondaryPanel.add(lblWarningPlan);

		lblImgMain = new JLabel("");
		lblImgMain.setIcon(
				new ImageIcon("C:\\img\\imgRegistrarse.jpg"));
		lblImgMain.setBounds(354, 11, 820, 490);
		getContentPane().add(lblImgMain);

		buttonGroup = new ButtonGroup();
		tglbtnBronze = new JToggleButton("");
		tglbtnBronze.setIcon(new ImageIcon("C:\\img\\Bronze.jpg"));
		tglbtnBronze.setBounds(354, 545, 200, 50);
		getContentPane().add(tglbtnBronze);
		buttonGroup.add(tglbtnBronze);

		tglbtnSilver = new JToggleButton("");
		tglbtnSilver.setIcon(new ImageIcon("C:\\img\\Silver.jpg"));
		tglbtnSilver.setBounds(560, 545, 200, 50);
		getContentPane().add(tglbtnSilver);
		buttonGroup.add(tglbtnSilver);

		tglbtnGold = new JToggleButton("");
		tglbtnGold.setIcon(new ImageIcon("C:\\img\\Gold.jpg"));
		tglbtnGold.setBounds(765, 545, 200, 50);
		getContentPane().add(tglbtnGold);
		buttonGroup.add(tglbtnGold);

		tglbtnDiamond = new JToggleButton("");
		tglbtnDiamond
				.setIcon(new ImageIcon("C:\\img\\Diamond.jpg"));
		tglbtnDiamond.setBounds(970, 545, 200, 50);
		getContentPane().add(tglbtnDiamond);
		buttonGroup.add(tglbtnDiamond);

		lblPlan = new JLabel("");
		lblPlan.setIcon(new ImageIcon("C:\\img\\Plan.jpg"));
		lblPlan.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlan.setBackground(new Color(0, 0, 0));
		lblPlan.setForeground(new Color(216, 31, 37));
		lblPlan.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPlan.setBounds(354, 505, 820, 29);
		getContentPane().add(lblPlan);
	}
	
	/**
     * Configura los manejadores de eventos para varios componentes en el diálogo.
     * @param person El objeto PersonsVO para el usuario.
     */

	private void eventHandler(PersonsVO person) {
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DlgStart start = new DlgStart();
				start.setVisible(true);
				dispose();
			}
		});

		tglbtnBronze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tglbtnBronze.setIcon(
						new ImageIcon("C:\\img\\BronzeClick.jpg"));

				if (tglbtnBronze != tglbtnSilver) {
					tglbtnSilver.setIcon(
							new ImageIcon("C:\\img\\Silver.jpg"));
				}
				if (tglbtnBronze != tglbtnGold) {
					tglbtnGold.setIcon(
							new ImageIcon("C:\\img\\Gold.jpg"));
				}
				if (tglbtnBronze != tglbtnDiamond) {
					tglbtnDiamond.setIcon(
							new ImageIcon("C:\\img\\Diamond.jpg"));
				}
			}
		});

		tglbtnSilver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglbtnSilver.setIcon(
						new ImageIcon("C:\\img\\SilverClick.jpg"));
				if (tglbtnSilver != tglbtnBronze) {
					tglbtnBronze.setIcon(
							new ImageIcon("C:\\img\\Bronze.jpg"));
				}

				if (tglbtnSilver != tglbtnGold) {
					tglbtnGold.setIcon(
							new ImageIcon("C:\\img\\Gold.jpg"));
				}
				if (tglbtnSilver != tglbtnDiamond) {
					tglbtnDiamond.setIcon(
							new ImageIcon("C:\\img\\Diamond.jpg"));
				}
			}
		});

		tglbtnGold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglbtnGold.setIcon(
						new ImageIcon("C:\\img\\GoldClick.jpg"));
				if (tglbtnGold != tglbtnBronze) {
					tglbtnBronze.setIcon(
							new ImageIcon("C:\\img\\Bronze.jpg"));
				}
				if (tglbtnGold != tglbtnSilver) {
					tglbtnSilver.setIcon(
							new ImageIcon("C:\\img\\Silver.jpg"));
				}

				if (tglbtnGold != tglbtnDiamond) {
					tglbtnDiamond.setIcon(
							new ImageIcon("C:\\img\\Diamond.jpg"));
				}
			}
		});

		tglbtnDiamond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglbtnDiamond.setIcon(new ImageIcon(
						"C:\\img\\DiamondClick.jpg"));
				if (tglbtnDiamond != tglbtnBronze) {
					tglbtnBronze.setIcon(
							new ImageIcon("C:\\img\\Bronze.jpg"));
				}
				if (tglbtnDiamond != tglbtnSilver) {
					tglbtnSilver.setIcon(
							new ImageIcon("C:\\img\\Silver.jpg"));
				}
				if (tglbtnDiamond != tglbtnGold) {
					tglbtnGold.setIcon(
							new ImageIcon("C:\\img\\Gold.jpg"));
				}

			}
		});

		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!Validaciones.verifyEmail(txtEmail)) {
					lblWarningEmail.setText("Incorrecto");
				} else {
					lblWarningEmail.setText("");
				}

				if (!Validaciones.verifyPassword(pssPassword)) {
					lblWarningPassword.setText("Incorrecto");
				} else {
					lblWarningPassword.setText("");
				}
				if (!Validaciones.verifyName(txtCardName)) {
					lblWarningCardName.setText("Incorrecto");
				} else {
					lblWarningCardName.setText("");
				}
				if (!Validaciones.verifyCardNumber(txtCardNumber)) {
					lblWarningCardNumber.setText("Incorrecto");
				} else {
					lblWarningCardNumber.setText("");
				}
				if (!Validaciones.verifyCardCode(pssCardCode)) {
					lblWarningCardCode.setText("Incorrecto");
				} else {
					lblWarningCardCode.setText("");
				}

				if (chcxTermsConditions.isSelected()) {
					lblWarningTerms.setText("");
				} else {
					lblWarningTerms.setText("Incorrecto");
				}

				if (tglbtnBronze.isSelected()) {
					levelandScreens = "1";
				} else if (tglbtnSilver.isSelected()) {
					levelandScreens = "2";
				} else if (tglbtnGold.isSelected()) {
					levelandScreens = "3";
				} else if (tglbtnDiamond.isSelected()) {
					levelandScreens = "4";
				} else {
					lblWarningPlan.setText("Seleccione un plan");
				}
				if (tglbtnBronze.isSelected() || tglbtnSilver.isSelected() || tglbtnGold.isSelected()
						|| tglbtnDiamond.isSelected()) {
					lblWarningPlan.setText("");
				}
				java.util.Date utilDate = new java.util.Date();
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

				if (lblWarningEmail.getText().equals("") && lblWarningPassword.getText().equals("")
						&& lblWarningCardName.getText().equals("") && lblWarningCardNumber.getText().equals("")
						&& lblWarningCardCode.getText().equals("") && chcxTermsConditions.isSelected()
						&& lblWarningPlan.getText().equals("")) {
					int insertedId = PersonsDAO.insertPerson(person);
					
					AccountsVO account = new AccountsVO(txtEmail.getText(), pssPassword.getText(), txtCardName.getText(), txtCardNumber.getText(), pssCardCode.getText(), levelandScreens,
							levelandScreens, sqlDate);

					boolean insertedId2 = AccountsDAO.insertAccount(account, insertedId);
					if (insertedId2) {
						JOptionPane.showMessageDialog(null, "Cuenta ingresada correctamente!.", "Exito",
								JOptionPane.INFORMATION_MESSAGE);
						DlgLogin login = new DlgLogin();
						login.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "No se ingresaron los datos. Vuelva a intentarlo.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				}
//				

			}
		});
	}
	
	/**
     * Configura los manejadores de eventos para varios componentes en el diálogo utilizando un ID de persona existente.
     * @param id_Person El ID de una persona existente.
     */
		
		private void eventHandler(int id_Person) {
			
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					DlgStart start = new DlgStart();
					start.setVisible(true);
					dispose();
				}
			});

			tglbtnBronze.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					tglbtnBronze.setIcon(
							new ImageIcon("C:\\img\\BronzeClick.jpg"));

					if (tglbtnBronze != tglbtnSilver) {
						tglbtnSilver.setIcon(
								new ImageIcon("C:\\img\\Silver.jpg"));
					}
					if (tglbtnBronze != tglbtnGold) {
						tglbtnGold.setIcon(
								new ImageIcon("C:\\img\\Gold.jpg"));
					}
					if (tglbtnBronze != tglbtnDiamond) {
						tglbtnDiamond.setIcon(
								new ImageIcon("C:\\img\\Diamond.jpg"));
					}
				}
			});

			tglbtnSilver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tglbtnSilver.setIcon(
							new ImageIcon("C:\\img\\SilverClick.jpg"));
					if (tglbtnSilver != tglbtnBronze) {
						tglbtnBronze.setIcon(
								new ImageIcon("C:\\img\\Bronze.jpg"));
					}

					if (tglbtnSilver != tglbtnGold) {
						tglbtnGold.setIcon(
								new ImageIcon("C:\\img\\Gold.jpg"));
					}
					if (tglbtnSilver != tglbtnDiamond) {
						tglbtnDiamond.setIcon(
								new ImageIcon("C:\\img\\Diamond.jpg"));
					}
				}
			});

			tglbtnGold.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tglbtnGold.setIcon(
							new ImageIcon("C:\\img\\GoldClick.jpg"));
					if (tglbtnGold != tglbtnBronze) {
						tglbtnBronze.setIcon(
								new ImageIcon("C:\\img\\Bronze.jpg"));
					}
					if (tglbtnGold != tglbtnSilver) {
						tglbtnSilver.setIcon(
								new ImageIcon("C:\\img\\Silver.jpg"));
					}

					if (tglbtnGold != tglbtnDiamond) {
						tglbtnDiamond.setIcon(
								new ImageIcon("C:\\img\\Diamond.jpg"));
					}
				}
			});

			tglbtnDiamond.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tglbtnDiamond.setIcon(new ImageIcon(
							"C:\\img\\DiamondClick.jpg"));
					if (tglbtnDiamond != tglbtnBronze) {
						tglbtnBronze.setIcon(
								new ImageIcon("C:\\img\\Bronze.jpg"));
					}
					if (tglbtnDiamond != tglbtnSilver) {
						tglbtnSilver.setIcon(
								new ImageIcon("C:\\img\\Silver.jpg"));
					}
					if (tglbtnDiamond != tglbtnGold) {
						tglbtnGold.setIcon(
								new ImageIcon("C:\\img\\Gold.jpg"));
					}

				}
			});

			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (!Validaciones.verifyEmail(txtEmail)) {
						lblWarningEmail.setText("Incorrecto");
					} else {
						lblWarningEmail.setText("");
					}

					if (!Validaciones.verifyPassword(pssPassword)) {
						lblWarningPassword.setText("Incorrecto");
					} else {
						lblWarningPassword.setText("");
					}
					if (!Validaciones.verifyName(txtCardName)) {
						lblWarningCardName.setText("Incorrecto");
					} else {
						lblWarningCardName.setText("");
					}
					if (!Validaciones.verifyCardNumber(txtCardNumber)) {
						lblWarningCardNumber.setText("Incorrecto");
					} else {
						lblWarningCardNumber.setText("");
					}
					if (!Validaciones.verifyCardCode(pssCardCode)) {
						lblWarningCardCode.setText("Incorrecto");
					} else {
						lblWarningCardCode.setText("");
					}

					if (chcxTermsConditions.isSelected()) {
						lblWarningTerms.setText("");
					} else {
						lblWarningTerms.setText("Incorrecto");
					}

					if (tglbtnBronze.isSelected()) {
						levelandScreens = "1";
					} else if (tglbtnSilver.isSelected()) {
						levelandScreens = "2";
					} else if (tglbtnGold.isSelected()) {
						levelandScreens = "3";
					} else if (tglbtnDiamond.isSelected()) {
						levelandScreens = "4";
					} else {
						lblWarningPlan.setText("Seleccione un plan");
					}
					if (tglbtnBronze.isSelected() || tglbtnSilver.isSelected() || tglbtnGold.isSelected()
							|| tglbtnDiamond.isSelected()) {
						lblWarningPlan.setText("");
					}
					java.util.Date utilDate = new java.util.Date();
					java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

					if (lblWarningEmail.getText().equals("") && lblWarningPassword.getText().equals("")
							&& lblWarningCardName.getText().equals("") && lblWarningCardNumber.getText().equals("")
							&& lblWarningCardCode.getText().equals("") && chcxTermsConditions.isSelected()
							&& lblWarningPlan.getText().equals("")) {
						
						
						AccountsVO account = new AccountsVO(txtEmail.getText(), pssPassword.getText(), txtCardName.getText(), txtCardNumber.getText(), pssCardCode.getText(), levelandScreens,
								levelandScreens, sqlDate);

						boolean insertedId = AccountsDAO.insertAccount(account, id_Person);
						if (insertedId) {
							JOptionPane.showMessageDialog(null, "Cuenta ingresada correctamente!.", "Exito",
									JOptionPane.INFORMATION_MESSAGE);
							DlgLogin login = new DlgLogin();
							login.setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "No se ingresaron los datos. Vuelva a intentarlo.", "Error",
									JOptionPane.ERROR_MESSAGE);
						}

					}
//					

				}
			});

		

	}

}
