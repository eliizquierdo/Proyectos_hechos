package grafica;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

import logica.AccountsDAO;
import logica.ListMovies;
import logica.ListSeries;
import logica.MoviesDAO;
import logica.ProfilesDAO;
import logica.SeriesDAO;
import persistencia.GestionCuentas;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

/**
 * Ventana de diálogo para el inicio de sesión.
 */
public class DlgLogin extends JDialog {

	private JTextField txtUser;
	private JPanel pnlLogin;
	private JLabel lblImgLogin;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JButton btnBack;
	private JLabel lblNotAccount;
	private JLabel lblRegister;
	private JLabel lblImgLoginBig;
	private JPasswordField pssPassword;

	/**
	 * Constructor de la clase DlgLogin.
	 */
	public DlgLogin() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		eventStarter();
		eventHandler();
	}

	/**
	 * Inicializa y configura los componentes de la interfaz.
	 */
	private void eventStarter() {
		setBounds(100, 100, 1200, 700);
		setTitle("NETXILF - Ingresar");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mauricio\\eclipse-workspace\\ProyectoNETXILF\\img\\Nlogo.jpg"));
		getContentPane().setBackground(new Color(216, 31, 37));
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);

		pnlLogin = new JPanel();
		pnlLogin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)));
		pnlLogin.setBackground(new Color(0, 0, 0));
		pnlLogin.setBounds(10, 11, 320, 639);
		getContentPane().add(pnlLogin);
		pnlLogin.setLayout(null);

		lblImgLogin = new JLabel("");
		lblImgLogin.setIcon(new ImageIcon("C:\\img\\NetxilfLogo_Inicio.jpg"));
		lblImgLogin.setBounds(16, 11, 288, 196);
		pnlLogin.add(lblImgLogin);

		lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setBounds(137, 218, 45, 32);
		pnlLogin.add(lblUser);

		lblPassword = new JLabel("Contraseña");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(126, 304, 70, 32);
		pnlLogin.add(lblPassword);

		txtUser = new JTextField();
		txtUser.setBounds(58, 261, 204, 32);
		pnlLogin.add(txtUser);
		txtUser.setColumns(10);

		btnLogin = new JButton("Ingresar");
		btnLogin.setBounds(107, 427, 112, 38);
		pnlLogin.add(btnLogin);

		btnBack = new JButton("Volver");
		btnBack.setBounds(221, 605, 89, 23);
		pnlLogin.add(btnBack);

		lblNotAccount = new JLabel("¿No eres cliente ?");
		lblNotAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNotAccount.setForeground(new Color(255, 255, 255));
		lblNotAccount.setBounds(49, 566, 112, 23);
		pnlLogin.add(lblNotAccount);

		lblRegister = new JLabel("REGISTRATE");
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegister.setForeground(new Color(255, 0, 0));
		lblRegister.setBounds(170, 566, 92, 23);
		pnlLogin.add(lblRegister);

		pssPassword = new JPasswordField();
		pssPassword.setBounds(58, 347, 204, 32);
		pnlLogin.add(pssPassword);

		lblImgLoginBig = new JLabel("");
		lblImgLoginBig.setIcon(new ImageIcon("C:\\img\\ImgIngresarBrd.jpg"));
		lblImgLoginBig.setBounds(340, 84, 831, 494);
		getContentPane().add(lblImgLoginBig);
	}

	/**
	 * Configura los manejadores de eventos para los componentes de la interfaz.
	 */
	private void eventHandler() {

		lblImgLoginBig.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				ListSeries seriesList = SeriesDAO.listSeries();
				ListMovies movieList = MoviesDAO.listMovies();
				DlgListProgramming dialog = new DlgListProgramming();
				dialog.setVisible(true);

				// Pasa la lista de series al diálogo y llama a updateTable
				dialog.updateTable(seriesList.getList(), movieList.getList());

			}
		});

		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRegister.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblRegister.setForeground(new Color(255, 0, 0));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				DlgNewClient client = new DlgNewClient();
				client.setVisible(true);
				dispose();
			}
		});

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgStart frmPrincipal = new DlgStart();
				frmPrincipal.setVisible(true);
				dispose();
			}
		});

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mail = txtUser.getText();
				String pass = new String(pssPassword.getPassword());

				if (AccountsDAO.verifyAccount(mail, pass) != 0) {
					JOptionPane.showMessageDialog(null, "Cuenta ingresada correctamente!.", "Exito",
							JOptionPane.INFORMATION_MESSAGE);
					String[] nombres = ProfilesDAO.returnNames(mail);
					String[] idProfiles = ProfilesDAO.returnIdProfile(mail);
					DlgProfile profile = new DlgProfile(nombres, mail, idProfiles);
					profile.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Cuenta inexistente. Verifique los datos!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
