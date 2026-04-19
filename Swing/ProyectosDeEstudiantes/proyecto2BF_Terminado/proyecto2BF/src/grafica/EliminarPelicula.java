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

import logica.ClientesVO;
import logica.ContenidoDAO;
import logica.PeliculaVO;

public class EliminarPelicula extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNombrePeli;
    private JLabel lblNombre;
    private JButton btnVolver;
    private JButton btnBuscarEliminar;
    private JTextField txtConfirmacion;

    public EliminarPelicula() {
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

        JLabel lblEliminarPelicula = new JLabel("Eliminar Pelicula");
        lblEliminarPelicula.setForeground(Color.RED);
        lblEliminarPelicula.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
        lblEliminarPelicula.setBounds(10, 10, 540, 45);
        contentPane.add(lblEliminarPelicula);

        txtNombrePeli = new JTextField();
        txtNombrePeli.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtNombrePeli.setBackground(new Color(255, 255, 255));
        txtNombrePeli.setForeground(new Color(255, 0, 0));
        txtNombrePeli.setHorizontalAlignment(SwingConstants.CENTER);
        txtNombrePeli.setBounds(516, 197, 320, 45);
        contentPane.add(txtNombrePeli);
        txtNombrePeli.setColumns(10);

        lblNombre = new JLabel("Nombre");
        lblNombre.setForeground(Color.RED);
        lblNombre.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
        lblNombre.setBounds(186, 197, 320, 45);
        contentPane.add(lblNombre);

        btnVolver = new JButton("Volver");
        btnVolver.setBackground(new Color(0, 0, 0));
        btnVolver.setForeground(new Color(255, 0, 0));
        btnVolver.setBounds(10, 625, 140, 45);
        contentPane.add(btnVolver);

        btnBuscarEliminar = new JButton("Buscar y Eliminar");
        btnBuscarEliminar.setForeground(new Color(255, 0, 0));
        btnBuscarEliminar.setBackground(new Color(0, 0, 0));
        btnBuscarEliminar.setBounds(1094, 625, 160, 45);
        contentPane.add(btnBuscarEliminar);

        txtConfirmacion = new JTextField();
        txtConfirmacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtConfirmacion.setEditable(false);
        txtConfirmacion.setHorizontalAlignment(SwingConstants.CENTER);
        txtConfirmacion.setForeground(Color.RED);
        txtConfirmacion.setColumns(10);
        txtConfirmacion.setBackground(Color.WHITE);
        txtConfirmacion.setBounds(516, 439, 320, 45);
        contentPane.add(txtConfirmacion);
    }

    public void iniciarEventos() {
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MenuPrincipal mp = new MenuPrincipal();
                mp.setVisible(true);
            }
        });

        
        btnBuscarEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String nombreBuscado = txtNombrePeli.getText();
                ContenidoDAO eliminar = new ContenidoDAO();
                
                int res = eliminar.eliminarPelicula(nombreBuscado);

                if (res == 1) {
                	
                	txtConfirmacion.setText("Pelicula eliminada");

                    
  
                
                }//IF
                
                else {
                
                	txtConfirmacion.setText("Pelicula no encontrada");
                
                }//ELSE
            	
            	
            }
        });
        
        
        
    }//EVENTOS

}
