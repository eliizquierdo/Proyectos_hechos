package grafica;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JToolBar;


import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class MenuPrincipal extends JDialog {

	
	
	private static final long serialVersionUID = 1L;
	private JButton btnAgC;
	private JButton btnBuscarClientes;
	private JButton btnAgP;
	private JButton btnBorrarPeli;
	private JButton btnBuscarPelicula;
	private JButton btnBorrarClientes;
	private JButton btnAgS;
	private JButton btnBorrarSerie;
	private JButton btnBuscarSerie;
	
	public MenuPrincipal() {
		
		iniciarComponentes();
		iniciarEventos();
		
	}//DEFECTO
	
	
		private void iniciarComponentes() {
			
			setBounds(100, 100, 1280, 720);
			getContentPane().setLayout(null);
			
			JPanel ContentPanel = new JPanel();
			ContentPanel.setBackground(Color.BLACK);
			ContentPanel.setBounds(0, 0, 1264, 681);
			getContentPane().add(ContentPanel, BorderLayout.NORTH);
			ContentPanel.setLayout(null);
			JLabel lblNetxilf = new JLabel("NEFLIZ");
			lblNetxilf.setBounds(10, 10, 167, 37);
			lblNetxilf.setFont(new Font("Yu Gothic UI", Font.BOLD, 40));
			lblNetxilf.setForeground(new Color(255, 0, 0));
			ContentPanel.add(lblNetxilf);
			
			JLabel lblNewLabel = new JLabel("MenuPrincipal");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBounds(4, 645, 173, 25);
			ContentPanel.add(lblNewLabel);
			
			btnAgC = new JButton("Agregar Clientes");
			btnAgC.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnAgC.setForeground(new Color(255, 0, 0));
			btnAgC.setBackground(new Color(0, 0, 0));
			btnAgC.setBounds(181, 120, 179, 40);
			ContentPanel.add(btnAgC);
			
			btnBorrarClientes = new JButton("Borrar Clientes");
			btnBorrarClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnBorrarClientes.setForeground(new Color(255, 0, 0));
			btnBorrarClientes.setBackground(new Color(0, 0, 0));
			btnBorrarClientes.setBounds(181, 170, 179, 40);
			ContentPanel.add(btnBorrarClientes);
			
			btnBuscarClientes = new JButton("Buscar Clientes");
			btnBuscarClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnBuscarClientes.setForeground(new Color(255, 0, 0));
			btnBuscarClientes.setBackground(new Color(0, 0, 0));
			btnBuscarClientes.setBounds(181, 220, 179, 40);
			ContentPanel.add(btnBuscarClientes);
			
			JLabel lblSobreClientes = new JLabel("Sobre Clientes");
			lblSobreClientes.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblSobreClientes.setHorizontalAlignment(SwingConstants.CENTER);
			lblSobreClientes.setForeground(new Color(255, 0, 0));
			lblSobreClientes.setBackground(new Color(0, 0, 0));
			lblSobreClientes.setBounds(181, 70, 170, 40);
			ContentPanel.add(lblSobreClientes);
			
			btnAgP = new JButton("Agregar Pelicula");
			btnAgP.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnAgP.setForeground(Color.RED);
			btnAgP.setBackground(Color.BLACK);
			btnAgP.setBounds(541, 120, 179, 40);
			ContentPanel.add(btnAgP);
			
			btnBorrarPeli = new JButton("Borrar Pelicula");
			btnBorrarPeli.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnBorrarPeli.setForeground(Color.RED);
			btnBorrarPeli.setBackground(Color.BLACK);
			btnBorrarPeli.setBounds(541, 170, 179, 40);
			ContentPanel.add(btnBorrarPeli);
			
			btnBuscarPelicula = new JButton("Buscar Pelicula");
			btnBuscarPelicula.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnBuscarPelicula.setForeground(Color.RED);
			btnBuscarPelicula.setBackground(Color.BLACK);
			btnBuscarPelicula.setBounds(541, 220, 179, 40);
			ContentPanel.add(btnBuscarPelicula);
			
			JLabel lblPeliculas = new JLabel("Sobre Peliculas");
			lblPeliculas.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblPeliculas.setHorizontalAlignment(SwingConstants.CENTER);
			lblPeliculas.setForeground(Color.RED);
			lblPeliculas.setBackground(Color.BLACK);
			lblPeliculas.setBounds(541, 70, 179, 40);
			ContentPanel.add(lblPeliculas);
			
			btnAgS = new JButton("Agregar Serie");
			btnAgS.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnAgS.setForeground(Color.RED);
			btnAgS.setBackground(Color.BLACK);
			btnAgS.setBounds(901, 120, 179, 40);
			ContentPanel.add(btnAgS);
			
			btnBorrarSerie = new JButton("Borrar Serie");
			btnBorrarSerie.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnBorrarSerie.setForeground(Color.RED);
			btnBorrarSerie.setBackground(Color.BLACK);
			btnBorrarSerie.setBounds(901, 170, 179, 40);
			ContentPanel.add(btnBorrarSerie);
			
			btnBuscarSerie = new JButton("Buscar Serie");
			btnBuscarSerie.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnBuscarSerie.setForeground(Color.RED);
			btnBuscarSerie.setBackground(Color.BLACK);
			btnBuscarSerie.setBounds(901, 220, 179, 40);
			ContentPanel.add(btnBuscarSerie);
			
			JLabel lblPeliculas_1 = new JLabel("Sobre Series");
			lblPeliculas_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblPeliculas_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblPeliculas_1.setForeground(Color.RED);
			lblPeliculas_1.setBackground(Color.BLACK);
			lblPeliculas_1.setBounds(901, 70, 179, 40);
			ContentPanel.add(lblPeliculas_1);
			
			JLabel lblS = new JLabel("S");
			lblS.setHorizontalAlignment(SwingConstants.CENTER);
			lblS.setToolTipText("");
			lblS.setForeground(Color.RED);
			lblS.setFont(new Font("Noto Serif Cond", Font.BOLD, 70));
			lblS.setBounds(994, 574, 80, 96);
			ContentPanel.add(lblS);
			
			JLabel lblS_1 = new JLabel("S");
			lblS_1.setToolTipText("");
			lblS_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblS_1.setForeground(Color.RED);
			lblS_1.setFont(new Font("Noto Serif Cond", Font.BOLD, 70));
			lblS_1.setBounds(1084, 574, 80, 96);
			ContentPanel.add(lblS_1);
			
			JLabel lblB = new JLabel("B");
			lblB.setToolTipText("");
			lblB.setHorizontalAlignment(SwingConstants.CENTER);
			lblB.setForeground(Color.RED);
			lblB.setFont(new Font("Noto Serif Cond", Font.BOLD, 70));
			lblB.setBounds(1174, 574, 80, 96);
			ContentPanel.add(lblB);
		
	}//INICIAR COMPONENTES


		private void iniciarEventos() {
			
			btnAgC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					AgregarCliente aG=new AgregarCliente();
					aG.setVisible(true);
					
				}
			});
			
			btnBuscarClientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					BuscarCliente bc=new BuscarCliente();
					bc.setVisible(true);
					
				}
			});
			
			btnBorrarClientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					EliminarCliente ec=new EliminarCliente();
					ec.setVisible(true);
					
				}
			});
			
			btnAgP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					AgregarPeli ap=new AgregarPeli();
					ap.setVisible(true);
					
					
				}
			});
			
			btnBorrarPeli.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					EliminarPelicula ep=new EliminarPelicula();
					ep.setVisible(true);
					
					
				}
			});
			
			btnBuscarPelicula.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					BuscarPeli bp=new BuscarPeli();
					bp.setVisible(true);
					
				}
			});
			
			btnAgS.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					AgregarSerie as=new AgregarSerie();
					as.setVisible(true);
					
				}
			});
			
			btnBorrarSerie.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					EliminarSerie es=new EliminarSerie();
					es.setVisible(true);
					
				}
			});
			
			
			btnBuscarSerie.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					BuscarSerie bS = new BuscarSerie();
					bS.setVisible(true);
					
				}
			});
			
			
			
		}//INICIAR EVENTOS
}//CLASS


