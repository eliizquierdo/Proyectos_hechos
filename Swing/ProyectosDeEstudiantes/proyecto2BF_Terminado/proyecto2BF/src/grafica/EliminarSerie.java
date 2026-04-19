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

public class EliminarSerie extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNombreSerie;
    private JLabel lblNombre;
    private JButton btnVolver;
    private JButton btnBuscarEliminar;
    private JTextField txtNombre;

    public EliminarSerie() {
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

        JLabel lblBuscarSerie = new JLabel("Eliminar Serie Por Nombre");
        lblBuscarSerie.setForeground(Color.RED);
        lblBuscarSerie.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
        lblBuscarSerie.setBounds(10, 10, 404, 45);
        contentPane.add(lblBuscarSerie);

        txtNombreSerie = new JTextField();
        txtNombreSerie.setBackground(new Color(255, 255, 255));
        txtNombreSerie.setForeground(new Color(255, 0, 0));
        txtNombreSerie.setHorizontalAlignment(SwingConstants.CENTER);
        txtNombreSerie.setBounds(516, 197, 320, 45);
        contentPane.add(txtNombreSerie);
        txtNombreSerie.setColumns(10);

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

        txtNombre = new JTextField();
        txtNombre.setEditable(false);
        txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
        txtNombre.setForeground(Color.RED);
        txtNombre.setColumns(10);
        txtNombre.setBackground(Color.WHITE);
        txtNombre.setBounds(516, 439, 320, 45);
        contentPane.add(txtNombre);
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

                String nombreBuscado = txtNombreSerie.getText();
                ContenidoDAO eliminar = new ContenidoDAO();
                
                int res = eliminar.eliminarSerie(nombreBuscado);

                if (res == 1) {
                
                
                    txtNombre.setText("Serie eliminada");
                
                }//IF
                
                else {
                
                	txtNombre.setText("Serie no encontrada");
                
                }//ELSE
            	
            	
            }
        });
        
        
        
    }//EVENTOS
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}//CLASS
