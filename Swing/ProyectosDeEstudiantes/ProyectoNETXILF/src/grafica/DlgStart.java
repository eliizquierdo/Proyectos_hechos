package grafica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

import grafica.DlgListProgramming;
import logica.ListMovies;
import logica.ListSeries;
import logica.MoviesDAO;
import logica.MoviesVO;
import logica.SeriesDAO;
import logica.SeriesVO;

import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DropMode;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.Frame;

/**
 * Clase para la ventana de inicio (DlgStart) que muestra opciones para ver programación,
 * ingresar al sistema o crear una nueva cuenta.
 */

public class DlgStart extends JFrame {

	
	private JPanel pnlMain;
	private JPanel pnlAdminData;
	private JButton btnProg;
	private JButton btnLogin;
	private JButton btnCreateAccount;
	private JLabel lblIcon;
	private JPanel pnlSecondaryPanel;
	private JTextField txtHiddenText;
	
	/**
     * Constructor para la clase DlgStart que configura la apariencia inicial de la ventana.
     */

	public DlgStart() {
		try {
		    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		eventStarter();
		eventHandler();
	}
	
	/**
     * Configura la apariencia inicial y el diseño de la ventana de inicio.
     */
	
	public void eventStarter() {
		setTitle("NETXILF");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\img\\Nlogo.jpg"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 600);
		pnlMain = new JPanel();
		pnlMain.setBackground(new Color(0, 0, 0));
		pnlMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		

		setContentPane(pnlMain);
		pnlMain.setLayout(null);

		pnlSecondaryPanel = new JPanel();
		pnlSecondaryPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 0, 0), new Color(255, 0, 0)));
		pnlSecondaryPanel.setBackground(new Color(0, 0, 0));
		pnlSecondaryPanel.setBounds(10, 11, 334, 539);
		pnlMain.add(pnlSecondaryPanel);
		pnlSecondaryPanel.setLayout(null);

		btnProg = new JButton("Ver Programación");
		btnProg.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnProg.setForeground(new Color(255, 0, 0));
		btnProg.setBounds(87, 373, 160, 40);
		pnlSecondaryPanel.add(btnProg);

		btnProg.setBackground(new Color(255, 255, 255));

		btnLogin = new JButton("Ingresar");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.setForeground(new Color(255, 0, 0));
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setBounds(87, 242, 160, 40);
		pnlSecondaryPanel.add(btnLogin);

		btnCreateAccount = new JButton("Crear Cuenta");
		btnCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCreateAccount.setForeground(new Color(255, 0, 0));
		btnCreateAccount.setBackground(new Color(255, 255, 255));
		btnCreateAccount.setBounds(87, 307, 160, 40);
		pnlSecondaryPanel.add(btnCreateAccount);

		lblIcon = new JLabel("New label");
		lblIcon.setIcon(new ImageIcon("C:\\img\\NetxilfLogo_Inicio.jpg"));
		lblIcon.setBounds(23, 42, 288, 163);
		pnlSecondaryPanel.add(lblIcon);
		
		txtHiddenText = new JTextField();
		txtHiddenText.setBackground(new Color(0, 0, 0));
		txtHiddenText.setForeground(new Color(0, 0, 0));
		txtHiddenText.setBounds(290, 31, 0, 0);
		txtHiddenText.setBorder(null);
		pnlSecondaryPanel.add(txtHiddenText);
		txtHiddenText.setColumns(10);
	}
	
	 /**
     * Configura los manejadores de eventos para los botones y otros componentes en la ventana de inicio.
     */

	public void eventHandler() {
		
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgNewClient dlgCliente = new DlgNewClient();
				dlgCliente.setVisible(true);
				dispose();
			}
		});
		

		txtHiddenText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String key = txtHiddenText.getText();
				if(key.equals("informatica")) {
					DlgLoginAdmin loginOculto = new DlgLoginAdmin();
					loginOculto.setVisible(true);
					dispose();
					
					
				}
			}
		});
		
		btnProg.addActionListener(new ActionListener() {
			
			private ArrayList<SeriesVO> dataSerie;
			private ArrayList<MoviesVO> dataMovie;

			public void actionPerformed(ActionEvent e) {
				 ListSeries seriesList = SeriesDAO.listSeries();
				 ListMovies moviesList = MoviesDAO.listMovies();
			        DlgListProgramming dialog = new DlgListProgramming();
			        dialog.setVisible(true);

			        // Pasa la lista de series al diálogo y llama a updateTable
			        dialog.updateTable(seriesList.getList(), moviesList.getList());
			}

			
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent irMenuIngresar) {
				DlgLogin dlgIngresar = new DlgLogin();
		        dlgIngresar.setVisible(true);
		        dispose();
			}
		});
	}
}
