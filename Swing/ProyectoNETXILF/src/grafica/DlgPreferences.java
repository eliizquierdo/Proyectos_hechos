package grafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import java.awt.Font;

/**
 * Clase para las preferencias que muestra información detallada sobre series y peliculas recomendadas.
 */

public class DlgPreferences extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblSiteNameR1;
	private JLabel lblSiteNameR2;
	private JLabel lblSiteNameR3;
	private JLabel lblSiteNameR4;
	private JLabel lblSiteNameR5;
	
	private JLabel lblSiteDescR1;
	private JLabel lblSiteDescR2;
	private JLabel lblSiteDescR3;
	private JLabel lblSiteDescR5;
	private JLabel lblSiteDescR4;

	private JLabel lblSiteGenreR1;
	private JLabel lblSiteGenreR2;
	private JLabel lblSiteGenreR3;
	private JLabel lblSiteGenreR4;
	private JLabel lblSiteGenreR5;
	
	private JLabel lblSiteSubGenreR1;
	private JLabel lblSiteSubGenreR2;
	private JLabel lblSiteSubGenreR3;
	private JLabel lblSiteSubGenreR4;
	private JLabel lblSiteSubGenreR5;

	private JLabel lblImgR1;
	private JLabel lblImgR2;
	private JLabel lblImgR3;
	private JLabel lblImgR4;
	private JLabel lblImgR5;

	/**
     * Constructor por defecto para la clase DlgPreferences.
     * Inicializa la apariencia y los manejadores de eventos.
     */

	public DlgPreferences() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\img\\Nlogo.jpg"));
		setTitle("Preferencias");
		setResizable(false);
		eventStarter();
		eventHandler();
	}
	
	 /**
     * Configura los manejadores de eventos para varios componentes en el diálogo.
     */

	private void eventHandler() {
		// TODO Auto-generated method stub
		
	}
	
	/**
     * Configura la apariencia inicial y el diseño del diálogo.
     */

	private void eventStarter() {
		setBounds(100, 100, 900, 1080);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlHeader = new JPanel();
		contentPanel.add(pnlHeader, BorderLayout.NORTH);
		
		JLabel lblImgBanner = new JLabel("");
		lblImgBanner.setIcon(new ImageIcon("C:\\img\\BannerPrincipal.jpg"));
		pnlHeader.add(lblImgBanner);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel pnlContainer = new JPanel();
		scrollPane.setViewportView(pnlContainer);
		pnlContainer.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel pnlR1 = new JPanel();
		pnlContainer.add(pnlR1);
		pnlR1.setLayout(new BorderLayout(0, 0));
		
		lblImgR1 = new JLabel("");
		lblImgR1.setIcon(null);
		pnlR1.add(lblImgR1, BorderLayout.WEST);
		
		JPanel pnlDataR1 = new JPanel();
		pnlDataR1.setBackground(new Color(20, 20, 20));
		pnlR1.add(pnlDataR1, BorderLayout.CENTER);
		pnlDataR1.setLayout(null);
		
		JLabel lblNameR1 = new JLabel("Nombre: ");
		lblNameR1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNameR1.setForeground(Color.WHITE);
		lblNameR1.setBounds(10, 11, 88, 22);
		pnlDataR1.add(lblNameR1);
		
		JLabel lblGenreR1 = new JLabel("Genero: ");
		lblGenreR1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenreR1.setForeground(Color.WHITE);
		lblGenreR1.setBounds(10, 44, 88, 25);
		pnlDataR1.add(lblGenreR1);
		
		JLabel lblSubGenreR1 = new JLabel("Sub-Genero:");
		lblSubGenreR1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubGenreR1.setForeground(Color.WHITE);
		lblSubGenreR1.setBounds(10, 80, 88, 22);
		pnlDataR1.add(lblSubGenreR1);
		
		lblSiteDescR1 = new JLabel("");
		lblSiteDescR1.setForeground(Color.WHITE);
		lblSiteDescR1.setBounds(10, 105, 530, 71);
		pnlDataR1.add(lblSiteDescR1);
		
		lblSiteNameR1 = new JLabel("");
		lblSiteNameR1.setForeground(Color.WHITE);
		lblSiteNameR1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSiteNameR1.setBounds(108, 11, 88, 20);
		pnlDataR1.add(lblSiteNameR1);
		
		lblSiteGenreR1 = new JLabel("");
		lblSiteGenreR1.setForeground(Color.WHITE);
		lblSiteGenreR1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSiteGenreR1.setBounds(108, 51, 88, 20);
		pnlDataR1.add(lblSiteGenreR1);
		
		lblSiteSubGenreR1 = new JLabel("");
		lblSiteSubGenreR1.setForeground(Color.WHITE);
		lblSiteSubGenreR1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSiteSubGenreR1.setBounds(108, 80, 88, 20);
		pnlDataR1.add(lblSiteSubGenreR1);
		
		JPanel pnlR2 = new JPanel();
		pnlContainer.add(pnlR2);
		pnlR2.setLayout(new BorderLayout(0, 0));
		
		lblImgR2 = new JLabel("");
		lblImgR2.setIcon(null);
		pnlR2.add(lblImgR2, BorderLayout.WEST);
		
		JPanel pnlDataR2 = new JPanel();
		pnlDataR2.setBackground(new Color(20, 20, 20));
		pnlR2.add(pnlDataR2, BorderLayout.CENTER);
		pnlDataR2.setLayout(null);
		
		JLabel lblNameR2 = new JLabel("Nombre: ");
		lblNameR2.setForeground(Color.WHITE);
		lblNameR2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNameR2.setBounds(10, 11, 88, 22);
		pnlDataR2.add(lblNameR2);
		
		JLabel lblGenreR2 = new JLabel("Genero: ");
		lblGenreR2.setForeground(Color.WHITE);
		lblGenreR2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenreR2.setBounds(10, 44, 88, 22);
		pnlDataR2.add(lblGenreR2);
		
		JLabel lblSubGenreR2 = new JLabel("Sub-Genero:");
		lblSubGenreR2.setForeground(Color.WHITE);
		lblSubGenreR2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubGenreR2.setBounds(10, 77, 88, 22);
		pnlDataR2.add(lblSubGenreR2);
		
		lblSiteDescR2 = new JLabel("");
		lblSiteDescR2.setForeground(Color.WHITE);
		lblSiteDescR2.setBounds(10, 102, 530, 71);
		pnlDataR2.add(lblSiteDescR2);
		
		lblSiteNameR2 = new JLabel("");
		lblSiteNameR2.setForeground(Color.WHITE);
		lblSiteNameR2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSiteNameR2.setBounds(120, 13, 88, 20);
		pnlDataR2.add(lblSiteNameR2);
		
		lblSiteGenreR2 = new JLabel("");
		lblSiteGenreR2.setForeground(Color.WHITE);
		lblSiteGenreR2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSiteGenreR2.setBounds(120, 44, 88, 20);
		pnlDataR2.add(lblSiteGenreR2);
		
		lblSiteSubGenreR2 = new JLabel("");
		lblSiteSubGenreR2.setForeground(Color.WHITE);
		lblSiteSubGenreR2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSiteSubGenreR2.setBounds(120, 83, 88, 20);
		pnlDataR2.add(lblSiteSubGenreR2);
		
		JPanel pnlR3 = new JPanel();
		pnlContainer.add(pnlR3);
		pnlR3.setLayout(new BorderLayout(0, 0));
		
		lblImgR3 = new JLabel("");
		lblImgR3.setIcon(null);
		pnlR3.add(lblImgR3, BorderLayout.WEST);
		
		JPanel pnlDataR3 = new JPanel();
		pnlDataR3.setBackground(new Color(20, 20, 20));
		pnlR3.add(pnlDataR3, BorderLayout.CENTER);
		pnlDataR3.setLayout(null);
		
		JLabel lblNameR3 = new JLabel("Nombre: ");
		lblNameR3.setForeground(Color.WHITE);
		lblNameR3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNameR3.setBounds(10, 11, 88, 22);
		pnlDataR3.add(lblNameR3);
		
		JLabel lblGenreR3 = new JLabel("Genero: ");
		lblGenreR3.setForeground(Color.WHITE);
		lblGenreR3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenreR3.setBounds(10, 44, 88, 22);
		pnlDataR3.add(lblGenreR3);
		
		JLabel lblSubGenre3 = new JLabel("Sub-Genero: ");
		lblSubGenre3.setForeground(Color.WHITE);
		lblSubGenre3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubGenre3.setBounds(10, 77, 88, 22);
		pnlDataR3.add(lblSubGenre3);
		
		lblSiteDescR3 = new JLabel("");
		lblSiteDescR3.setForeground(Color.WHITE);
		lblSiteDescR3.setBounds(10, 110, 530, 71);
		pnlDataR3.add(lblSiteDescR3);
		
		lblSiteNameR3 = new JLabel("");
		lblSiteNameR3.setForeground(Color.WHITE);
		lblSiteNameR3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSiteNameR3.setBounds(101, 11, 88, 20);
		pnlDataR3.add(lblSiteNameR3);
		
		lblSiteGenreR3 = new JLabel("");
		lblSiteGenreR3.setForeground(Color.WHITE);
		lblSiteGenreR3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSiteGenreR3.setBounds(101, 46, 88, 20);
		pnlDataR3.add(lblSiteGenreR3);
		
		lblSiteSubGenreR3 = new JLabel("");
		lblSiteSubGenreR3.setForeground(Color.WHITE);
		lblSiteSubGenreR3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSiteSubGenreR3.setBounds(101, 77, 88, 20);
		pnlDataR3.add(lblSiteSubGenreR3);
		
		JPanel pnlR4 = new JPanel();
		pnlContainer.add(pnlR4);
		pnlR4.setLayout(new BorderLayout(0, 0));
		
		lblImgR4 = new JLabel("");
		lblImgR4.setIcon(new ImageIcon("C:\\img\\ChArrow.jpg"));
		pnlR4.add(lblImgR4, BorderLayout.WEST);
		
		JPanel pnlDataR4 = new JPanel();
		pnlDataR4.setBackground(new Color(20, 20, 20));
		pnlR4.add(pnlDataR4, BorderLayout.CENTER);
		pnlDataR4.setLayout(null);
		
		JLabel lblNameR4 = new JLabel("Nombre: ");
		lblNameR4.setForeground(Color.WHITE);
		lblNameR4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNameR4.setBounds(10, 11, 88, 22);
		pnlDataR4.add(lblNameR4);
		
		JLabel lblGenre4 = new JLabel("Genero: ");
		lblGenre4.setForeground(Color.WHITE);
		lblGenre4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenre4.setBounds(10, 46, 88, 22);
		pnlDataR4.add(lblGenre4);
		

		
		JLabel lblSubGenre4 = new JLabel("Sub-Genero: ");
		lblSubGenre4.setForeground(Color.WHITE);
		lblSubGenre4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubGenre4.setBounds(10, 77, 88, 22);
		pnlDataR4.add(lblSubGenre4);
		
		lblSiteDescR4 = new JLabel("");
		lblSiteDescR4.setForeground(Color.WHITE);
		lblSiteDescR4.setBounds(10, 107, 530, 71);
		pnlDataR4.add(lblSiteDescR4);
		
		lblSiteNameR4 = new JLabel("");
		lblSiteNameR4.setForeground(Color.WHITE);
		lblSiteNameR4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSiteNameR4.setBounds(101, 11, 88, 20);
		pnlDataR4.add(lblSiteNameR4);
		
		lblSiteSubGenreR4 = new JLabel("");
		lblSiteSubGenreR4.setForeground(Color.WHITE);
		lblSiteSubGenreR4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSiteSubGenreR4.setBounds(101, 77, 88, 20);
		pnlDataR4.add(lblSiteSubGenreR4);
		
		lblSiteGenreR4 = new JLabel("");
		lblSiteGenreR4.setForeground(Color.WHITE);
		lblSiteGenreR4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSiteGenreR4.setBounds(101, 46, 88, 20);
		pnlDataR4.add(lblSiteGenreR4);
		
		JPanel pnlR5 = new JPanel();
		pnlContainer.add(pnlR5);
		pnlR5.setLayout(new BorderLayout(0, 0));
		
		lblImgR5 = new JLabel("");
		pnlR5.add(lblImgR5, BorderLayout.WEST);
		
		JPanel pnlDataR5 = new JPanel();
		pnlDataR5.setBackground(new Color(20, 20, 20));
		pnlR5.add(pnlDataR5, BorderLayout.CENTER);
		pnlDataR5.setLayout(null);
		
		JLabel lblNameR5 = new JLabel("Nombre: ");
		lblNameR5.setForeground(Color.WHITE);
		lblNameR5.setForeground(Color.WHITE);
		lblNameR5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNameR5.setBounds(10, 11, 88, 22);
		pnlDataR5.add(lblNameR5);
		
		JLabel lblGenreR5 = new JLabel("Genero: ");
		lblGenreR5.setForeground(Color.WHITE);
		lblGenreR5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenreR5.setBounds(10, 46, 88, 22);
		pnlDataR5.add(lblGenreR5);
		
		JLabel lblSubGenreR5 = new JLabel("Sub-Genero: ");
		lblSubGenreR5.setForeground(Color.WHITE);
		lblSubGenreR5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubGenreR5.setBounds(10, 79, 88, 22);
		pnlDataR5.add(lblSubGenreR5);
		
		lblSiteDescR5 = new JLabel("");
		lblSiteDescR5.setForeground(Color.WHITE);
		lblSiteDescR5.setBounds(10, 107, 530, 71);
		pnlDataR5.add(lblSiteDescR5);
		
		
		lblSiteNameR5 = new JLabel("");
		lblSiteNameR5.setForeground(Color.WHITE);
		lblSiteNameR5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSiteNameR5.setBounds(101, 11, 88, 20);
		pnlDataR5.add(lblSiteNameR5);
		
		lblSiteGenreR5 = new JLabel("");
		lblSiteGenreR5.setForeground(Color.WHITE);
		lblSiteGenreR5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSiteGenreR5.setBounds(101, 46, 88, 20);
		pnlDataR5.add(lblSiteGenreR5);
		
		lblSiteSubGenreR5 = new JLabel("");
		lblSiteSubGenreR5.setForeground(Color.WHITE);
		lblSiteSubGenreR5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSiteSubGenreR5.setBounds(101, 77, 88, 20);
		pnlDataR5.add(lblSiteSubGenreR5);
		
		lblSiteGenreR5 = new JLabel("");
		lblSiteGenreR5.setForeground(Color.WHITE);
		lblSiteGenreR5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSiteGenreR5.setBounds(101, 46, 88, 20);
		pnlDataR5.add(lblSiteGenreR5);
		
		
	}
}
