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
 * La clase DlgDelProfile proporciona una interfaz gráfica para eliminar un perfil de usuario en el sistema NETXILF.
 * Permite ingresar el nombre del perfil y su PIN asociado para llevar a cabo la eliminación.
 */

public class DlgDelProfile extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPasswordField pssPIN;
	private JPanel panel;
	private JLabel lblNameProfile;
	private JLabel lblPIN;
	private JButton btnDelete;
	private JButton btnBack;
	private JTextField txtNameProfile;
	private JLabel lblWarning;
	
	/**
     * Constructor de la clase. Inicializa la interfaz gráfica y los manejadores de eventos asociados.
     *
     * @param nombres Array de nombres relacionados con el perfil.
     * @param account Cuenta asociada al perfil.
     */

	public DlgDelProfile(String [] nombres, String account) {
		try {
		    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		eventStarter();
		eventHandler(nombres, account);
		

	}
	
	 /**
     * Configura los manejadores de eventos para los botones de la interfaz y la entrada de teclado.
     */

	private void eventHandler(String [] nombres, String account) {
		

		pssPIN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            // Presionaron Enter, ejecuta la acción del botón "Ingresar"
		            btnDelete.doClick(); // Simula un clic en el botón
		          
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
	     * ActionListener para el botón "Eliminar". Borra los perfiles asociadas al nombre, PIN y de la cuenta correspondiente en la base de datos.
	     */
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameProfile = txtNameProfile.getText();
				String PIN = pssPIN.getText();
				
				String Ok = ProfilesDAO.deleteProfile(nameProfile, PIN, account);
							
				if(Ok.equals("Registro exitoso.")) {
					JOptionPane.showMessageDialog(null, "Perfil eliminado con exito. Debera volver a ingresar", "Exito",
							JOptionPane.INFORMATION_MESSAGE);
					DlgLogin login = new DlgLogin();
					login.setVisible(true);
					dispose();
					
				}else {
					JOptionPane.showMessageDialog(null, "No se ha podido eliminar el perfil.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
	}
	
	/**
     * Inicializa y configura la interfaz gráfica, estableciendo propiedades como el tamaño, la ubicación y la apariencia.
     */

	private void eventStarter() {
		setResizable(false);
		setTitle("NETXILF - Eliminar Perfil");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\img\\Nlogo.jpg"));
		setBounds(100, 100, 422, 284);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 0, 0), new Color(255, 0, 0)));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(10, 11, 387, 226);
		contentPanel.add(panel);
		panel.setLayout(null);

		txtNameProfile = new JTextField();
		txtNameProfile.setBounds(83, 84, 222, 28);
		panel.add(txtNameProfile);
		txtNameProfile.setColumns(10);

		lblNameProfile = new JLabel("Nombre");
		lblNameProfile.setBounds(163, 59, 62, 14);
		panel.add(lblNameProfile);
		lblNameProfile.setForeground(new Color(255, 255, 255));
		lblNameProfile.setFont(new Font("Tahoma", Font.BOLD, 14));

		pssPIN = new JPasswordField();
		pssPIN.setBounds(83, 148, 222, 28);
		panel.add(pssPIN);

		lblPIN = new JLabel("PIN");
		lblPIN.setBounds(178, 123, 27, 14);
		panel.add(lblPIN);
		lblPIN.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPIN.setForeground(new Color(255, 255, 255));

		btnDelete = new JButton("Eliminar");
		btnDelete.setBounds(83, 187, 103, 23);
		panel.add(btnDelete);
		btnDelete.setActionCommand("OK");

		btnBack = new JButton("Volver");
		btnBack.setBounds(202, 187, 103, 23);
		panel.add(btnBack);
		btnBack.setActionCommand("Cancel");
		
		lblWarning = new JLabel("Ingrese nombre y PIN para ELIMINAR un PERFIL");
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setForeground(Color.WHITE);
		lblWarning.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWarning.setBounds(10, 11, 345, 33);
		panel.add(lblWarning);
		
	}
}
