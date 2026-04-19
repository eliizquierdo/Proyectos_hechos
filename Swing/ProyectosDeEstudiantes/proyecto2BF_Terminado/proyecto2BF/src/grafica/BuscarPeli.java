package grafica;

import java.awt.Color;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logica.ClientesDAO;
import logica.ClientesVO;
import logica.ContenidoDAO;
import logica.ContenidoVO;
import logica.PeliculaVO;

public class BuscarPeli extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombrePelicula;
	private JLabel lblNombre;
	private JButton btnVolver;
	private JButton btnBuscar;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtGenero;

	
	public BuscarPeli() {

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
		
		JLabel lblBuscarPeli = new JLabel("Buscar Pelicula");
		lblBuscarPeli.setForeground(Color.RED);
		lblBuscarPeli.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblBuscarPeli.setBounds(10, 10, 320, 45);
		contentPane.add(lblBuscarPeli);
		
		txtNombrePelicula = new JTextField();
		txtNombrePelicula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNombrePelicula.setBackground(new Color(255, 255, 255));
		txtNombrePelicula.setForeground(new Color(255, 0, 0));
		txtNombrePelicula.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombrePelicula.setBounds(516, 100, 320, 45);
		contentPane.add(txtNombrePelicula);
		txtNombrePelicula.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.RED);
		lblNombre.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblNombre.setBounds(186, 100, 320, 45);
		contentPane.add(lblNombre);
		
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
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNombre.setText("Nombre: ");
		txtNombre.setEditable(false);
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setForeground(Color.RED);
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setBounds(516, 245, 320, 45);
		contentPane.add(txtNombre);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDescripcion.setText("Descripcion:");
		txtDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescripcion.setForeground(Color.RED);
		txtDescripcion.setEditable(false);
		txtDescripcion.setColumns(10);
		txtDescripcion.setBackground(Color.WHITE);
		txtDescripcion.setBounds(516, 390, 320, 45);
		contentPane.add(txtDescripcion);
		
		txtGenero = new JTextField();
		txtGenero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGenero.setText("Genero:");
		txtGenero.setHorizontalAlignment(SwingConstants.CENTER);
		txtGenero.setForeground(Color.RED);
		txtGenero.setEditable(false);
		txtGenero.setColumns(10);
		txtGenero.setBackground(Color.WHITE);
		txtGenero.setBounds(516, 535, 320, 45);
		contentPane.add(txtGenero);
		
		
		
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

			String nombreBuscado = txtNombrePelicula.getText();

			ContenidoDAO buscar = new ContenidoDAO();

			PeliculaVO pelicula= buscar.buscarPelicula(nombreBuscado);

			if ( pelicula!= null) {
			// Mostrar el resultado en el txtNombre
			txtNombre.setText("Nombre: " + pelicula.getNombre());
			txtDescripcion.setText("Descripcion: " + pelicula.getDescripcion());
			txtGenero.setText("Genero: " + pelicula.getGenero());
			}//IF

			else {
			// Pelicula no encontrado
			txtNombre.setText("Pelicula no encontrado");

			}//ELSE
			}
			});
		
		
		
		
		
		
	}//EVENTOS
}
