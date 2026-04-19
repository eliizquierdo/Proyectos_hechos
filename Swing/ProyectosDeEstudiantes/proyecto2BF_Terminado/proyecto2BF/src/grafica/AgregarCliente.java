package grafica;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.*;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPasswordField;
import java.awt.Rectangle;

public class AgregarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCancelar;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtPais;
	private JTextField txtCiudad;
	private JTextField txtCorreo;
	private JPasswordField psw;
	private JButton btnAgregar;
	private JTextField txtNombreTar;
	private JTextField txtNumeroTar;
	private JLabel lblCodigoTarjeta;
	private JTextField txtCodigo;
	


	public AgregarCliente() {

		iniciarComponentes();
		iniciarEventos();
		
	}
	
	
	public void iniciarComponentes() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgregarCliente = new JLabel("Agregar Cliente");
		lblAgregarCliente.setForeground(Color.RED);
		lblAgregarCliente.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
		lblAgregarCliente.setBounds(479, 11, 320, 45);
		contentPane.add(lblAgregarCliente);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(0, 0, 0));
		btnCancelar.setForeground(new Color(255, 0, 0));
		btnCancelar.setBounds(10, 630, 130, 40);
		contentPane.add(btnCancelar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(169, 76, 378, 45);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.RED);
		lblNombre.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblNombre.setBounds(171, 27, 193, 45);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.RED);
		lblApellido.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblApellido.setBounds(716, 27, 193, 45);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(716, 76, 378, 45);
		contentPane.add(txtApellido);
		
		JLabel lblPais = new JLabel("País");
		lblPais.setForeground(Color.RED);
		lblPais.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblPais.setBounds(169, 141, 138, 45);
		contentPane.add(lblPais);
		
		txtPais = new JTextField();
		txtPais.setColumns(10);
		txtPais.setBounds(169, 197, 378, 45);
		contentPane.add(txtPais);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setForeground(Color.RED);
		lblCiudad.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblCiudad.setBounds(740, 141, 169, 45);
		contentPane.add(lblCiudad);
		
		txtCiudad = new JTextField();
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(716, 197, 378, 45);
		contentPane.add(txtCiudad);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(Color.RED);
		lblCorreo.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblCorreo.setBounds(169, 274, 173, 45);
		contentPane.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(169, 318, 378, 45);
		contentPane.add(txtCorreo);
		
		psw = new JPasswordField();
		psw.setBounds(716, 318, 378, 45);
		contentPane.add(psw);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setForeground(Color.RED);
		lblContrasea.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblContrasea.setBounds(716, 274, 193, 45);
		contentPane.add(lblContrasea);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setForeground(Color.RED);
		btnAgregar.setBackground(Color.BLACK);
		btnAgregar.setBounds(1124, 630, 130, 40);
		contentPane.add(btnAgregar);
		
		JLabel lblNombreTar = new JLabel("Nombre tarjeta");
		lblNombreTar.setForeground(Color.RED);
		lblNombreTar.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblNombreTar.setBounds(179, 384, 298, 45);
		contentPane.add(lblNombreTar);
		
		txtNombreTar = new JTextField();
		txtNombreTar.setColumns(10);
		txtNombreTar.setBounds(169, 439, 378, 45);
		contentPane.add(txtNombreTar);
		
		JLabel lblNumeroTar = new JLabel("Numero tarjeta");
		lblNumeroTar.setForeground(Color.RED);
		lblNumeroTar.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblNumeroTar.setBounds(716, 384, 272, 45);
		contentPane.add(lblNumeroTar);
		
		txtNumeroTar = new JTextField();
		txtNumeroTar.setColumns(10);
		txtNumeroTar.setBounds(716, 439, 378, 45);
		contentPane.add(txtNumeroTar);
		
		lblCodigoTarjeta = new JLabel("Codigo tarjeta");
		lblCodigoTarjeta.setForeground(Color.RED);
		lblCodigoTarjeta.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblCodigoTarjeta.setBounds(179, 504, 272, 45);
		contentPane.add(lblCodigoTarjeta);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(169, 560, 378, 45);
		contentPane.add(txtCodigo);
		
	}//COMPONENTES
	
	public void iniciarEventos() {
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				MenuPrincipal mV=new MenuPrincipal();
				mV.setVisible(true);
				
			}
		});
		
		

		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				/*Clientes.guardarDatosNomb(txtNombre.getText());
				Clientes.guardarDatosApe(txtApellido.getText());
				Ubicacion.cargarDatosC(txtCiudad.getText());
				Ubicacion.cargarDatosP(txtPais.getText());*/
				
				
				String nombre = txtNombre.getText();
				String apellido = txtApellido.getText();
				String ciudad = txtCiudad.getText();
				String pais = txtPais.getText();
				String mail = txtCorreo.getText();
				String pass = psw.getText();
				String nomtar = txtNombreTar.getText();
				String numtar = txtNumeroTar.getText();
				String codigo = txtCodigo.getText();
				ClientesVO cliente = new ClientesVO(mail, pass, nombre, apellido, ciudad, pais, nomtar, numtar, codigo);
				ClientesDAO insertar = new ClientesDAO();
				insertar.insertarCliente(cliente);
				
				setVisible(false);
				
				MenuPrincipal mp=new MenuPrincipal();
				mp.setVisible(true);
				
				
			}
		});
		
		
	}//EVENTOS
}//CLASS
