package grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.border.EtchedBorder;

import logica.ListMovies;
import logica.ListPersons;
import logica.ListSeries;
import logica.MoviesDAO;
import logica.PersonsDAO;
import logica.SeriesDAO;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * La clase DlgHiddenMenu proporciona un menú oculto con opciones administrativas para gestionar administradores y programación.
 * Permite agregar o eliminar administradores, así como agregar, eliminar y listar la programación existente.
 */

public class DlgHiddenMenu extends JDialog {

	
	private final JPanel pnlPrincipal = new JPanel();
	private JButton btnAddAdmin;
	private JButton btnDelAdmin;
	private JButton btnDelProg;
	private JButton btnAddProg;
	private JButton btnListClient;
	private JButton btnListProg;
	private JButton btnBack;
	private JLabel lblStartLogo;
	private JPanel pnlSecondaryPanel;
	
	/**
     * Constructor de la clase. Inicializa la interfaz gráfica y los manejadores de eventos asociados.
     */

	public DlgHiddenMenu() {
		try {
		    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\img\\Nlogo.jpg"));
		setTitle("NETXILF - Administradores");
		eventStarter();
		eventHandler();

	}
	
	 /**
     * Inicializa y configura la interfaz gráfica, estableciendo propiedades como el tamaño, la ubicación y la apariencia.
     */

	private void eventStarter() {
		setResizable(false);
		setBounds(100, 100, 368, 726);
		pnlPrincipal.setBounds(0, 0, 354, 688);
		pnlPrincipal.setBackground(new Color(0, 0, 0));
		pnlPrincipal.setBorder(null);
		setLocationRelativeTo(null);
		
		
		getContentPane().setLayout(null);
		pnlPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlPrincipal);
		pnlPrincipal.setLayout(null);

		pnlSecondaryPanel = new JPanel();
		pnlSecondaryPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 0, 0), new Color(255, 0, 0)));
		pnlSecondaryPanel.setBackground(new Color(0, 0, 0));
		pnlSecondaryPanel.setBounds(10, 11, 334, 665);
		pnlPrincipal.add(pnlSecondaryPanel);
		pnlSecondaryPanel.setLayout(null);

		lblStartLogo = new JLabel("");
		lblStartLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartLogo.setBounds(23, 42, 288, 163);
		pnlSecondaryPanel.add(lblStartLogo);
		lblStartLogo.setIcon(new ImageIcon("C:\\img\\NetxilfLogo_InicioBlanco.jpg"));
		
		btnAddAdmin = new JButton("Agregar Administrador");
		btnAddAdmin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddAdmin.setBackground(Color.WHITE);
		btnAddAdmin.setForeground(new Color(216, 31, 37));
		btnAddAdmin.setBounds(57, 226, 229, 51);
		pnlSecondaryPanel.add(btnAddAdmin);
		
		btnDelAdmin = new JButton("Eliminar Administrador");
		btnDelAdmin.setForeground(new Color(216,31,37));
		btnDelAdmin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelAdmin.setBackground(Color.WHITE);
		btnDelAdmin.setBounds(57, 288, 229, 51);
		pnlSecondaryPanel.add(btnDelAdmin);
		
		btnAddProg = new JButton("Agregar Programación");
		btnAddProg.setForeground(new Color(216, 31, 37));
		btnAddProg.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddProg.setBackground(Color.WHITE);
		btnAddProg.setBounds(57, 350, 229, 51);
		pnlSecondaryPanel.add(btnAddProg);
		
		btnDelProg = new JButton("Eliminar Programación");
		btnDelProg.setForeground(new Color(216, 31, 37));
		btnDelProg.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelProg.setBackground(Color.WHITE);
		btnDelProg.setBounds(57, 412, 229, 51);
		pnlSecondaryPanel.add(btnDelProg);
		
		btnListClient = new JButton("Listado de Clientes");
		btnListClient.setForeground(new Color(216, 31, 37));
		btnListClient.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListClient.setBackground(Color.WHITE);
		btnListClient.setBounds(57, 474, 229, 51);
		pnlSecondaryPanel.add(btnListClient);
		
		btnListProg = new JButton("Listado de Programación");
		btnListProg.setForeground(new Color(216, 31, 37));
		btnListProg.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListProg.setBackground(Color.WHITE);
		btnListProg.setBounds(57, 536, 229, 51);
		pnlSecondaryPanel.add(btnListProg);
		
		btnBack = new JButton("Volver");
		btnBack.setBounds(235, 628, 89, 23);
		btnBack.setForeground(new Color(216, 31, 37));
		btnBack.setBackground(Color.WHITE);
		pnlSecondaryPanel.add(btnBack);
		
		
		

	}
	
	/**
     * Configura los manejadores de eventos para los botones de la interfaz.
     */
	
	private void eventHandler() {
		
		/**
	     * Acción al presionar el botón de listar programación.
	     * Muestra una ventana de diálogo con la lista de series y películas programadas.
	     */
		btnListProg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListSeries seriesList = SeriesDAO.listSeries();
				 ListMovies moviesList = MoviesDAO.listMovies();
			        DlgListProgramming dialog = new DlgListProgramming();
			        dialog.setVisible(true);

			        // Pasa la lista de series al diálogo y llama a updateTable
			        dialog.updateTable(seriesList.getList(), moviesList.getList());
			}
		});
		
		/**
	     * Acción al presionar el botón de listar clientes.
	     * Muestra una ventana de diálogo con la lista de clientes registrados.
	     */
		btnListClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPersons personsList = PersonsDAO.listPersons();
				
			        DlgListPersons dialog = new DlgListPersons();
			        dialog.setVisible(true);

			        // Pasa la lista de series al diálogo y llama a updateTable
			        dialog.updateTable(personsList.getList());
			}
				
			
		});
		
		/**
	     * Acción al presionar el botón de eliminar programación.
	     * Muestra una ventana de diálogo para eliminar una programación.
	     */
		btnDelProg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgDelProg eliminar = new DlgDelProg();
				eliminar.setVisible(true);
				dispose();
			}
		});
		
		/**
	     * Acción al presionar el botón de agregar programación.
	     * Muestra una ventana de diálogo para agregar nueva programación.
	     */
		btnAddProg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgAddProg programacion = new DlgAddProg();
				programacion.setVisible(true);
				dispose();
			}
		});
		/**
	     * Acción al presionar el botón de volver.
	     * Muestra la ventana principal al presionar el botón "Volver".
	     */
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgStart principal = new DlgStart();
				principal.setVisible(true);
				dispose();
			}
		});
		/**
	     * Acción al presionar el botón de agregar administrador.
	     * Muestra una ventana de diálogo para agregar un nuevo administrador.
	     */
		btnAddAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgAddAdmin principal = new DlgAddAdmin();
				principal.setVisible(true);
				dispose();
			}
		});
		
		/**
	     * Acción al presionar el botón de eliminar administrador.
	     * Muestra una ventana de diálogo para eliminar un administrador.
	     */
		btnDelAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgDelAdmin eliminar = new DlgDelAdmin();
				eliminar.setVisible(true);
				dispose();
			}
		});
	}

	
}
