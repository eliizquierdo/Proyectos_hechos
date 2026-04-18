package grafica;
import logica.Estudiantes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmPrincipal extends JFrame {
	
	public static Estudiantes coleccion;
	private JPanel contentPane;
	private JMenuItem itemAgregarAlumnos;
	private JMenuItem itemVerAlumnos;
	private JDesktopPane desktopPane;

	
	public FrmPrincipal() {
		coleccion=new Estudiantes();
		iniciarComponentes();
		iniciarManejadorEventos();
	
	}
		private void iniciarManejadorEventos() {
			itemAgregarAlumnos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DialAltaAlumno inAgregarAlu=new DialAltaAlumno();
					//InAgregarAlumno inAgregarAlu=new InAgregarAlumno();
					inAgregarAlu.setVisible(true);
					desktopPane.add(inAgregarAlu);
					
				}
			});
			
			itemVerAlumnos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DialVerAlumnos inVerAlu=new DialVerAlumnos();
					//InVerAlumnos inVerAlu=new InVerAlumnos();
					inVerAlu.setVisible(true);
					desktopPane.add(inVerAlu);
				}
			});
		
	}
		private void iniciarComponentes() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(10, 10, 1200, 700);//--
			
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			JMenu mnNewMenu = new JMenu("Alumnos");
			menuBar.add(mnNewMenu);
			
			itemAgregarAlumnos = new JMenuItem("Agregar alumnos");
			
			
			mnNewMenu.add(itemAgregarAlumnos);
			
			itemVerAlumnos = new JMenuItem("Ver alumnos");
			mnNewMenu.add(itemVerAlumnos);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			desktopPane = new JDesktopPane();
			desktopPane.setBackground(new Color(255, 128, 64));
			desktopPane.setBounds(0, 22, 1200, 678); //----
			contentPane.add(desktopPane);
		
	}
		public static void main(String[] args) {
			
			FrmPrincipal menu=new FrmPrincipal();
			menu.setVisible(true);
			
		}
		
	}
