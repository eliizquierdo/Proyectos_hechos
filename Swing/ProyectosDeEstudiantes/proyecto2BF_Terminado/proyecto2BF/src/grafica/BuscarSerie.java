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

import logica.ContenidoDAO;
import logica.PeliculaVO;
import logica.SerieVO;

public class BuscarSerie extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreSerie;
	private JLabel lblNombre;
	private JButton btnVolver;
	private JButton btnBuscar;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtGenero;
	private JTextField txtCap;
	private JTextField txtTemp;

	
	public BuscarSerie() {

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
		
		JLabel lblBuscarSerie = new JLabel("Buscar Serie");
		lblBuscarSerie.setForeground(Color.RED);
		lblBuscarSerie.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblBuscarSerie.setBounds(10, 10, 320, 45);
		contentPane.add(lblBuscarSerie);
		
		txtNombreSerie = new JTextField();
		txtNombreSerie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNombreSerie.setBackground(new Color(255, 255, 255));
		txtNombreSerie.setForeground(new Color(255, 0, 0));
		txtNombreSerie.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreSerie.setBounds(516, 58, 320, 45);
		contentPane.add(txtNombreSerie);
		txtNombreSerie.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.RED);
		lblNombre.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblNombre.setBounds(186, 58, 320, 45);
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
		txtNombre.setBounds(516, 161, 320, 45);
		contentPane.add(txtNombre);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDescripcion.setText("Descripcion:");
		txtDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescripcion.setForeground(Color.RED);
		txtDescripcion.setEditable(false);
		txtDescripcion.setColumns(10);
		txtDescripcion.setBackground(Color.WHITE);
		txtDescripcion.setBounds(516, 264, 320, 45);
		contentPane.add(txtDescripcion);
		
		txtGenero = new JTextField();
		txtGenero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGenero.setText("Genero:");
		txtGenero.setHorizontalAlignment(SwingConstants.CENTER);
		txtGenero.setForeground(Color.RED);
		txtGenero.setEditable(false);
		txtGenero.setColumns(10);
		txtGenero.setBackground(Color.WHITE);
		txtGenero.setBounds(516, 367, 320, 45);
		contentPane.add(txtGenero);
		
		txtCap = new JTextField();
		txtCap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCap.setText("Capitulos:");
		txtCap.setHorizontalAlignment(SwingConstants.CENTER);
		txtCap.setForeground(Color.RED);
		txtCap.setEditable(false);
		txtCap.setColumns(10);
		txtCap.setBackground(Color.WHITE);
		txtCap.setBounds(516, 470, 320, 45);
		contentPane.add(txtCap);
		
		txtTemp = new JTextField();
		txtTemp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTemp.setText("Temporadas:");
		txtTemp.setHorizontalAlignment(SwingConstants.CENTER);
		txtTemp.setForeground(Color.RED);
		txtTemp.setEditable(false);
		txtTemp.setColumns(10);
		txtTemp.setBackground(Color.WHITE);
		txtTemp.setBounds(516, 573, 320, 45);
		contentPane.add(txtTemp);
		
		
		
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
		    	
		        String nombreBuscado = txtNombreSerie.getText();
		        
		        ContenidoDAO buscar = new ContenidoDAO();
		        
		        SerieVO serie = buscar.buscarSerie(nombreBuscado);
		        
		        if(serie != null) {
		        	
		        	txtNombre.setText("Nombre: " + serie.getNombre());
					txtDescripcion.setText("Descripcion: " + serie.getDescripcion());
					txtGenero.setText("Genero: " + serie.getGenero());
					txtCap.setText("Capitulos: " + serie.getCapitulos());
					txtTemp.setText("Temporadas: " + serie.getTemporadas());
					
		        }
		        
		        else
		        	txtNombre.setText("Pelicula no encontrada");
		        }

		});
		
		
		
		
		
		
	}//EVENTOS
}//CLASS
