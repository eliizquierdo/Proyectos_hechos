package grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

/**
 * Clase para el diálogo de perfiles que muestra la información de los perfiles de usuario.
 */

public class DlgProfile extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNameClient;
	private JLabel lblLogo;
	private JLabel lblText;

	private JLabel[] lblIcons;
	private JLabel[] lblNameProfiles;
	private JPanel panel;
	private JLabel lblAddProfile;
	private JLabel lblDelAccount;
	private JLabel lblDelProfile;
	private JLabel lblImgDelAccount;
	
	/**
     * Constructor para la clase DlgProfile.
     * @param nombres Arreglo de nombres de perfiles.
     * @param account Nombre de la cuenta actual.
     * @param id_Profiles Arreglo de identificadores de perfiles.
     */

	public DlgProfile(String[] nombres, String account, String [] id_Profiles) {
		setTitle("Perfiles");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\img\\Nlogo.jpg"));
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		eventStarter(nombres, account, id_Profiles);
		eventHandler(nombres, account);
		

	}
	
	/**
     * Configura los manejadores de eventos para varios componentes en el diálogo.
     * @param nombres Arreglo de nombres de perfiles.
     * @param account Nombre de la cuenta actual.
     */

	private void eventHandler(String[] nombres, String account) {

		lblAddProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DlgAddProfile add = new DlgAddProfile(nombres, account);
				add.setVisible(true);
				dispose();
			}
		});
		
		
		lblDelAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DlgDelAccount delAccount = new DlgDelAccount(nombres, account);
				delAccount.setVisible(true);
				dispose();
				
			}
		});
		

		lblDelProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DlgDelProfile profile = new DlgDelProfile(nombres, account);
				profile.setVisible(true);
				dispose();
			}
		});
	}
	
	/**
     * Configura la apariencia inicial y el diseño del diálogo.
     * @param nombres Arreglo de nombres de perfiles.
     * @param account Nombre de la cuenta actual.
     * @param id_Profiles Arreglo de identificadores de perfiles.
     */

	private void eventStarter(String[] nombres, String account, String [] id_Profiles) {

		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 0, 0), new Color(255, 0, 0)));
		panel.setBounds(10, 11, 764, 439);
		contentPanel.add(panel);
		panel.setLayout(null);

		if (nombres.length > 0) {
			lblIcons = new JLabel[nombres.length];
			lblNameProfiles = new JLabel[nombres.length];

			// Calcular la posición inicial para centrar los perfiles
			int startX = (panel.getWidth() - (nombres.length * 110)) / 2;

			// Crear y agregar los elementos adicionales
			for (int i = 0; i < nombres.length; i++) {
				lblIcons[i] = new JLabel("");
				lblIcons[i].setIcon(
						new ImageIcon("C:\\img\\IconProfile.jpg"));
				lblIcons[i].setBounds(startX + i * 110, 183, 100, 100);
				panel.add(lblIcons[i]);

				lblNameProfiles[i] = new JLabel(nombres[i]);
				lblNameProfiles[i].setHorizontalAlignment(SwingConstants.CENTER);
				lblNameProfiles[i].setBackground(new Color(255, 255, 255));
				lblNameProfiles[i].setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNameProfiles[i].setForeground(new Color(255, 255, 255));
				lblNameProfiles[i].setBounds(startX + i * 110, 294, 100, 31);
				panel.add(lblNameProfiles[i]);
				String nombre = lblNameProfiles[i].getText();
				String id_Profile = id_Profiles[i];
				 // Agregar ActionListener a cada lblNameProfiles
		        lblIcons[i].addMouseListener(new java.awt.event.MouseAdapter() {
		            public void mouseClicked(java.awt.event.MouseEvent evt) {
		                DlgValidateProfile validate = new DlgValidateProfile(nombre, nombres, account, id_Profiles);
		                validate.setVisible(true);
		                dispose();
		                
		            }
		        });
				
				
			}
		}

		lblNameClient = new JLabel("Bienvenido " + account);

		lblNameClient.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameClient.setForeground(Color.WHITE);
		lblNameClient.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNameClient.setBounds(300, 11, 454, 31);
		panel.add(lblNameClient);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\img\\NetxilfCh.jpg"));
		lblLogo.setBounds(10, 11, 130, 31);
		panel.add(lblLogo);

		lblText = new JLabel("SELECCIONE SU PERFIL");
		lblText.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblText.setForeground(new Color(255, 255, 255));
		lblText.setBounds(275, 114, 214, 31);
		panel.add(lblText);

		lblAddProfile = new JLabel("");
		lblAddProfile.setIcon(new ImageIcon("C:\\img\\Add.jpg"));
		lblAddProfile.setBounds(615, 393, 35, 35);
		panel.add(lblAddProfile);
		
		lblDelProfile = new JLabel("");
		lblDelProfile.setIcon(new ImageIcon("C:\\img\\DellPro.jpg"));
		lblDelProfile.setBounds(665, 393, 35, 35);
		panel.add(lblDelProfile);
		
		lblDelAccount = new JLabel("");
		lblDelAccount.setBounds(719, 393, 35, 35);
		panel.add(lblDelAccount);
		
		lblImgDelAccount = new JLabel("");
		lblImgDelAccount.setIcon(new ImageIcon("C:\\img\\DelAcc.jpg"));
		lblImgDelAccount.setBounds(719, 393, 35, 35);
		panel.add(lblImgDelAccount);
	}
}
