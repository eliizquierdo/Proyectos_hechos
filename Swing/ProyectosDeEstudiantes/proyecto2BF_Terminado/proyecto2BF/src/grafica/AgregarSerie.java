package grafica;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logica.ContenidoDAO;
import logica.SerieVO;

public class AgregarSerie extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private static final long serialVersionUID1 = 1L;
	private JPanel contentPane1;
	private JButton btnCancelar;
	private JTextField txtDes;
	private JTextField txtNombre;
	private JTextField txtGenero;
	private JButton btnAgregar;
	
	private static int cont=0;
	private JTextField txtCaps;
	private JTextField txtTemp;
	private JLabel lblTemp;
	private JLabel lblCaps;

	public AgregarSerie() {

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
		
		JLabel lblAgregarSerie = new JLabel("Agregar Serie");
		lblAgregarSerie.setForeground(Color.RED);
		lblAgregarSerie.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblAgregarSerie.setBounds(10, 10, 320, 45);
		contentPane.add(lblAgregarSerie);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(0, 0, 0));
		btnCancelar.setForeground(new Color(255, 0, 0));
		btnCancelar.setBounds(10, 630, 130, 40);
		contentPane.add(btnCancelar);
		
		txtDes = new JTextField();
		txtDes.setBounds(443, 197, 378, 45);
		contentPane.add(txtDes);
		txtDes.setColumns(10);
		
		JLabel lblDes = new JLabel("Descripción");
		lblDes.setForeground(Color.RED);
		lblDes.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblDes.setBounds(113, 197, 320, 45);
		contentPane.add(lblDes);
		
		JLabel lblNombrePeli = new JLabel("Nombre");
		lblNombrePeli.setForeground(Color.RED);
		lblNombrePeli.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblNombrePeli.setBounds(113, 76, 320, 45);
		contentPane.add(lblNombrePeli);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(443, 76, 378, 45);
		contentPane.add(txtNombre);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setForeground(Color.RED);
		lblGenero.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblGenero.setBounds(113, 318, 320, 45);
		contentPane.add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		txtGenero.setBounds(443, 318, 378, 45);
		contentPane.add(txtGenero);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setForeground(Color.RED);
		btnAgregar.setBackground(Color.BLACK);
		btnAgregar.setBounds(1124, 630, 130, 40);
		contentPane.add(btnAgregar);
		
		txtCaps = new JTextField();
		txtCaps.setColumns(10);
		txtCaps.setBounds(443, 439, 378, 45);
		contentPane.add(txtCaps);
		
		txtTemp = new JTextField();
		txtTemp.setColumns(10);
		txtTemp.setBounds(443, 560, 378, 45);
		contentPane.add(txtTemp);
		
		lblTemp = new JLabel("Temporadas");
		lblTemp.setForeground(Color.RED);
		lblTemp.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblTemp.setBounds(113, 560, 320, 45);
		contentPane.add(lblTemp);
		
		lblCaps = new JLabel("Capitulos");
		lblCaps.setForeground(Color.RED);
		lblCaps.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblCaps.setBounds(113, 439, 320, 45);
		contentPane.add(lblCaps);
		
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
				
				String nombre = txtNombre.getText();
				String descripcion = txtDes.getText();
				String genero = txtGenero.getText();
				String capitulos = txtCaps.getText();
				String temporadas = txtTemp.getText();

				SerieVO Serie = new SerieVO(nombre, descripcion, genero, capitulos, temporadas);
				ContenidoDAO insertar = new ContenidoDAO();
				insertar.insertarSerie(Serie);
				
				setVisible(false);
				
				MenuPrincipal mp=new MenuPrincipal();
				mp.setVisible(true);
				
			}
		});
		
		
	}//EVENTOS
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//CLASS
