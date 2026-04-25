package grafica;
import logica.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmPrincipal extends JFrame {
	
	public static Estudiantes coleccion; //Declaración de la colección Estudiantes
	private JPanel contentPane;
	private JMenuItem itemVerAlumnos, itemAgregarAlumno; 
	private JDesktopPane desktopPane;

	
	public FrmPrincipal() {
		coleccion=new Estudiantes(); //creacion de la coleccion Estudiantes
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Menú Principal");
		//posición y tamaño ventana Principal
		setBounds(10, 10, 1200, 700);	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		iniciarComponentes();
		iniciarManejadoresEventos();
	}
	
	
	private void iniciarComponentes() {
			//barra de menú principal		
			JMenuBar mnbPrincipal = new JMenuBar();
			mnbPrincipal.setBounds(0, 0, 434, 21);
			contentPane.add(mnbPrincipal);
			//menú Alumnos
			JMenu mnAlumnos = new JMenu("Alumnos");
			mnbPrincipal.add(mnAlumnos);
			//opciones del menú Alumnos
			itemAgregarAlumno = new JMenuItem("Agregar Alumno");
			mnAlumnos.add(itemAgregarAlumno);
			itemVerAlumnos = new JMenuItem("Ver Alumnos");
			mnAlumnos.add(itemVerAlumnos);
			//creación del desktopPane
			desktopPane = new JDesktopPane();
			desktopPane.setBackground(new Color(153, 0, 0));
			desktopPane.setBounds(0, 22, 1200, 678); 	//pos y tam
			contentPane.add(desktopPane);
	}
	
	private void iniciarManejadoresEventos() {
		itemAgregarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InAltaAlumno agrAlumno=new InAltaAlumno();
				agrAlumno.setVisible(true);
				//agregamos la ventana de AgregarAlumno al desktopPane
				desktopPane.add(agrAlumno);
			}
		});
		itemVerAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntVerAlumnos verAlumno=new IntVerAlumnos();
				verAlumno.setVisible(true);
				desktopPane.add(verAlumno);
			}
		});
			
	}
	
	public static void main(String[] args) {
		
		FrmPrincipal menu=new FrmPrincipal();
		menu.setVisible(true);
	}
}
