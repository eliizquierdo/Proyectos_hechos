package grafica;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.ClientesDAO;
import logica.ClientesVO;
import logica.ContenidoDAO;
import logica.PeliculaVO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class BuscarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JButton btnVolver;
	private JButton btnBuscar;
	private JTextArea txtLista;

	
	public BuscarCliente() {

		iniciarComponentes();
		iniciarEventos();
		
	}//DEFECTO
	
	public void iniciarComponentes() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuscarcliente = new JLabel("Buscar Cliente Por Email");
		lblBuscarcliente.setForeground(Color.RED);
		lblBuscarcliente.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblBuscarcliente.setBounds(10, 11, 320, 45);
		contentPane.add(lblBuscarcliente);
		
		txtEmail = new JTextField();
		txtEmail.setBackground(new Color(255, 255, 255));
		txtEmail.setForeground(new Color(255, 0, 0));
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setBounds(680, 183, 231, 45);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.RED);
		lblEmail.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblEmail.setBounds(350, 183, 278, 45);
		contentPane.add(lblEmail);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(0, 0, 0));
		btnVolver.setForeground(new Color(255, 0, 0));
		btnVolver.setBounds(10, 625, 140, 45);
		contentPane.add(btnVolver);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(255, 0, 0));
		btnBuscar.setBackground(new Color(0, 0, 0));
		btnBuscar.setBounds(1114, 625, 140, 45);
		contentPane.add(btnBuscar);
		
		txtLista = new JTextArea();
		txtLista.setEditable(false);
		txtLista.setBounds(350, 343, 561, 327);
		contentPane.add(txtLista);
		
		
		
	}//COMPONENTES
	
	
	
	
	public void iniciarEventos() {
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				MenuPrincipal mp=new MenuPrincipal();
				mp.setVisible(true);
				
			}
		});
		
		
		
		
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			String emailBuscado = txtEmail.getText();

			ClientesDAO buscar = new ClientesDAO();

			ClientesVO cliente = buscar.buscarXEmail(emailBuscado);

			if ( cliente != null) {
				
				
			txtLista.setText("Nombre: " + cliente.getNombre()
			+ "\n Apellido: " + cliente.getApellido()
			+ "\n Email: " + cliente.getEmail()
			+ "\n Contraseña: " + cliente.getPassword()
			+ "\n Ciudad: " + cliente.getCiudad()
			+ "\n Pais: " + cliente.getPais()
			+ "\n Nombre del propietario de la tarjeta: " + cliente.getNombrePropietario()
			+ "\n Numero de la tarjeta: " + cliente.getNumeroTarjeta()
			+ "\n Codigo de la tarjeta: " + cliente.getCodigoTarjeta());
			}//IF

			else {
			// Cliente no encontrado
			txtLista.setText("Cliente no encontrado");

			}//ELSE
			}
			});
		
		
		
		
		
	}//EVENTOS
}//CLASS
