package grafica;
import grafica.Main;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Articulo;
import logica.Persona;
import logica.Productos;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {
public static Productos  lista = new Productos();
public static Productos listaFac = new Productos();
public static Persona listaP = new Persona();
	private JPanel contentPane;

	
	public MenuPrincipal() {
		iniciarComponentes();
		iniciarManejadoresEventos();
	}
	public void iniciarComponentes(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
	}
	public void iniciarManejadoresEventos(){
		JMenuBar menuPrincipal = new JMenuBar();
		setJMenuBar(menuPrincipal);
		
		JMenuBar menuPrincipal2 = new JMenuBar();
		menuPrincipal.add(menuPrincipal2);
		
		JMenu mnEmpleado = new JMenu("Empleado");
		menuPrincipal.add(mnEmpleado);
		
		JMenuItem mntmAgregarEmpleado = new JMenuItem("Agregar Empleado");
		mntmAgregarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GenEmp AltaEmpleado = new GenEmp();
				AltaEmpleado.setVisible(true);
			}
		});
		mnEmpleado.add(mntmAgregarEmpleado);
		
		JMenu mnCliente = new JMenu("Cliente");
		menuPrincipal.add(mnCliente);
		
		JMenuItem mntmAgregarCliente = new JMenuItem("Agregar Cliente");
		mntmAgregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GenCliente AltaCliente = new GenCliente();
				AltaCliente.setVisible(true);
			}
		});
		mnCliente.add(mntmAgregarCliente);
		
		JMenu mnProductos = new JMenu("Productos");
		menuPrincipal.add(mnProductos);
		
		JMenuItem mnmAgregarProductos = new JMenuItem("Agregar Producto");
		mnmAgregarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GenArtic altaArticulo = new GenArtic();
				altaArticulo.setVisible(true);
				
				
				
			}
		});
		mnProductos.add(mnmAgregarProductos);
		
		JMenuItem mntmGenerarFactura = new JMenuItem("Generar Factura");
		mntmGenerarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GenFactura Generarfactura = new GenFactura();
			Generarfactura.setVisible(true);
			}
		});
		mnProductos.add(mntmGenerarFactura);
		
		JMenuItem mntmVerFactura = new JMenuItem("Ver Factura");
		mntmVerFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VerFactura verFact= new VerFactura();
				verFact.setVisible(true);
			}
		});
		mnProductos.add(mntmVerFactura);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	 }

