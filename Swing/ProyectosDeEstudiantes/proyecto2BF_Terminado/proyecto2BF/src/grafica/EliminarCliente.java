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

public class EliminarCliente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtEmail;
    private JLabel lblEmail;
    private JButton btnVolver;
    private JButton btnBuscarEliminar;
    private JTextField txtEliminado;

    public EliminarCliente() {
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

        JLabel lblBuscarcliente = new JLabel("Buscar y Eliminar Cliente Por Email");
        lblBuscarcliente.setForeground(Color.RED);
        lblBuscarcliente.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
        lblBuscarcliente.setBounds(10, 10, 540, 45);
        contentPane.add(lblBuscarcliente);

        txtEmail = new JTextField();
        txtEmail.setBackground(new Color(255, 255, 255));
        txtEmail.setForeground(new Color(255, 0, 0));
        txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmail.setBounds(717, 170, 231, 45);
        contentPane.add(txtEmail);
        txtEmail.setColumns(10);

        lblEmail = new JLabel("Email");
        lblEmail.setForeground(Color.RED);
        lblEmail.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
        lblEmail.setBounds(330, 170, 320, 45);
        contentPane.add(lblEmail);

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

        txtEliminado = new JTextField();
        txtEliminado.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtEliminado.setEditable(false);
        txtEliminado.setHorizontalAlignment(SwingConstants.LEFT);
        txtEliminado.setForeground(Color.RED);
        txtEliminado.setColumns(10);
        txtEliminado.setBackground(new Color(255, 255, 255));
        txtEliminado.setBounds(330, 336, 479, 45);
        contentPane.add(txtEliminado);
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
            	
                String emailBuscado = txtEmail.getText();
                ClientesDAO eliminar = new ClientesDAO();
                
                int res = eliminar.eliminarCliente(emailBuscado);

               if (res == 1) {
               
                    txtEliminado.setText("Cliente eliminado");
                
                }//IF
                
                else {
                
                	txtEliminado.setText("Cliente no encontrado");
                
                }//ELSE
            }
        });
        
        
        
    }//EVENTOS
    

}//CLASS