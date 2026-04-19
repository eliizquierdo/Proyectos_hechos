package grafica;

import java.sql.Date;


import java.time.LocalDate;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logica.PeliculaVO;
import logica.ContenidoDAO;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;

public class AgregarPeli extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JPanel contentPane1;
	private JButton btnCancelar;
	private JTextField txtDes;
	private JTextField txtNombre;
	private JTextField txtGenero;
	private JButton btnAgregar;
	
	private static int cont=0;

	public AgregarPeli() {

		iniciarComponentes();
		iniciarEventos();
		
	}
	
	
	
	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	
	
	public void iniciarComponentes() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgregarPelicula = new JLabel("Agregar Pelicula");
		lblAgregarPelicula.setForeground(Color.RED);
		lblAgregarPelicula.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblAgregarPelicula.setBounds(10, 10, 320, 45);
		contentPane.add(lblAgregarPelicula);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(0, 0, 0));
		btnCancelar.setForeground(new Color(255, 0, 0));
		btnCancelar.setBounds(10, 630, 130, 40);
		contentPane.add(btnCancelar);
		
		txtDes = new JTextField();
		txtDes.setBounds(443, 317, 378, 45);
		contentPane.add(txtDes);
		txtDes.setColumns(10);
		
		JLabel lblDes = new JLabel("Descripción");
		lblDes.setForeground(Color.RED);
		lblDes.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblDes.setBounds(113, 317, 320, 45);
		contentPane.add(lblDes);
		
		JLabel lblNombrePeli = new JLabel("Nombre");
		lblNombrePeli.setForeground(Color.RED);
		lblNombrePeli.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblNombrePeli.setBounds(113, 136, 320, 45);
		contentPane.add(lblNombrePeli);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(443, 136, 378, 45);
		contentPane.add(txtNombre);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setForeground(Color.RED);
		lblGenero.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblGenero.setBounds(113, 498, 320, 45);
		contentPane.add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		txtGenero.setBounds(443, 498, 378, 45);
		contentPane.add(txtGenero);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setForeground(Color.RED);
		btnAgregar.setBackground(Color.BLACK);
		btnAgregar.setBounds(1124, 630, 130, 40);
		contentPane.add(btnAgregar);
		
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
				
				
				String descripcion = txtDes.getText();
				String nombre = txtNombre.getText();
				String genero = txtGenero.getText();

				PeliculaVO peli = new PeliculaVO(nombre, descripcion, genero);
				ContenidoDAO insertar = new ContenidoDAO();
				insertar.insertarPelicula(peli);
				
				setVisible(false);
				
				MenuPrincipal mp=new MenuPrincipal();
				mp.setVisible(true);
				
			}
		});
		
		
	}//EVENTOS
}
