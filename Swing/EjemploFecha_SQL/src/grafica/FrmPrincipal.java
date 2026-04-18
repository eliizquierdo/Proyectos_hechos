package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logica.AlumnoDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public FrmPrincipal() {
		setTitle("Mi Bibloteca");
		setSize(496, 671);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlSocio = new JPanel();
		pnlSocio.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Socios", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlSocio.setBounds(43, 71, 395, 190);
		contentPane.add(pnlSocio);
		pnlSocio.setLayout(null);
		
		JButton btnAlumno = new JButton("Nuevo Alumno");
		btnAlumno.setHorizontalAlignment(SwingConstants.LEFT);
		btnAlumno.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		
		
		btnAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmReAlumno Ra = new FrmReAlumno();
				Ra.setVisible(true);
			}
		});
		
		btnAlumno.setBounds(18, 30, 174, 42);
		btnAlumno.setIcon(new ImageIcon(getClass().getResource("/images/IcAdd.png")));//////////////////////////
		pnlSocio.add(btnAlumno);
		
		JButton btnDocente = new JButton("Nuevo Docente");
		btnDocente.setFont(new Font("Nirmala UI", Font.PLAIN, 12));
		btnDocente.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\IconButtom\\IcAdd.png"));
		btnDocente.setHorizontalAlignment(SwingConstants.LEFT);
		btnDocente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmReDocente Rd = new FrmReDocente();
				Rd.setVisible(true);
			}
		});
		
		btnDocente.setBounds(202, 30, 172, 42);
		pnlSocio.add(btnDocente);
		
		JButton btnBuscarAlumno = new JButton("Buscar Alumno");
		btnBuscarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmBuscarDocente Bd = new FrmBuscarDocente();
				Bd.setVisible(true);
			}
		});
		
		btnBuscarAlumno.setIcon(new ImageIcon("C:\\Users\\GigaI3\\Downloads\\Imag\\IcBus.png"));
		btnBuscarAlumno.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		btnBuscarAlumno.setBounds(18, 136, 174, 42);
		pnlSocio.add(btnBuscarAlumno);
		
		JButton btnListaDeDocente = new JButton("Lista de Docentes");
		btnListaDeDocente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmTablaDocente Td = new FrmTablaDocente();
				Td.setVisible(true);
			}
		});
		
		btnListaDeDocente.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\IconButtom\\IcLista.png"));
		btnListaDeDocente.setFont(new Font("Nirmala UI", Font.PLAIN, 10));
		btnListaDeDocente.setBounds(202, 83, 172, 42);
		pnlSocio.add(btnListaDeDocente);
		
		JButton btnListaDeAlumnos = new JButton("Lista de Alumnos");
		btnListaDeAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*Con las siguientes dos lineas se ve el contenido de la tabla alumno y socio de la base de datos, en la consola*/
				AlumnoDAO a=new AlumnoDAO();
				System.out.println(a.listaAlumno());
				
				
				//FrmTablaAlumno Ta = new FrmTablaAlumno();
				//Ta.setVisible(true);
			}
		});
		
		btnListaDeAlumnos.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\IconButtom\\IcLista.png"));
		btnListaDeAlumnos.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		btnListaDeAlumnos.setBounds(18, 83, 174, 42);
		pnlSocio.add(btnListaDeAlumnos);
		
		JButton btnBuscarDocente = new JButton("Buscar Docente");
		btnBuscarDocente.setIcon(new ImageIcon("G:\\Class\\ProyectoP&BD\\Imag\\IconButtom\\IcBus.png"));
		btnBuscarDocente.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		btnBuscarDocente.setBounds(202, 136, 174, 42);
		pnlSocio.add(btnBuscarDocente);
		
		JPanel pnlAdmin = new JPanel();
		pnlAdmin.setBorder(new TitledBorder(null, "Administraci\u00F3n", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pnlAdmin.setLayout(null);
		pnlAdmin.setBounds(43, 330, 395, 196);
		contentPane.add(pnlAdmin);
		
		JButton btnLibros = new JButton("Nuevo Libro");
		btnLibros.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\IconButtom\\IcLib.png"));
		btnLibros.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		btnLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmReLibros Rl = new FrmReLibros();
				Rl.setVisible(true);
			}
		});
		
		btnLibros.setBounds(18, 32, 175, 42);
		pnlAdmin.add(btnLibros);
		
		JButton btnPrestamos = new JButton("Prestamos");
		btnPrestamos.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		btnPrestamos.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\IconButtom\\IcTrato.png"));
		btnPrestamos.setBounds(203, 32, 171, 42);
		pnlAdmin.add(btnPrestamos);
		
		JButton btnBuscarLibro = new JButton("Buscar Libro");
		btnBuscarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmBuscarLibro Bl = new FrmBuscarLibro();
				Bl.setVisible(true);
			}
			
		});
		
		btnBuscarLibro.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\IconButtom\\IcBus.png"));
		btnBuscarLibro.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		btnBuscarLibro.setBounds(18, 85, 175, 42);
		pnlAdmin.add(btnBuscarLibro);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmTablaPrestamos Tp = new FrmTablaPrestamos();
				Tp.setVisible(true);
			}
		});
		
		btnListado.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\IconButtom\\IcLista.png"));
		btnListado.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		btnListado.setBounds(203, 85, 171, 42);
		pnlAdmin.add(btnListado);
		
		JButton btnLibreria = new JButton("Libreria");
		btnLibreria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmTablaLibros Tl = new FrmTablaLibros();
				Tl.setVisible(true);
			}
		});
		
		btnLibreria.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\IconButtom\\IcLib.png"));
		btnLibreria.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		btnLibreria.setBounds(107, 138, 171, 42);
		pnlAdmin.add(btnLibreria);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/images/fondo.png")));
		//lblNewLabel.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\BackGround\\Backgroud_Original.png"));
		lblNewLabel.setBounds(30, 5, 440, 597);
		contentPane.add(lblNewLabel);
	}
}
