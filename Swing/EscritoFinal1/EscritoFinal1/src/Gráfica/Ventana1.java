package Gráfica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Lógica.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Ventana1 extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtCosto;
	private JTextField txtPrecio;
	private JButton btnAceptar;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					Ventana1 frame = new Ventana1();
					frame.setVisible(true);
				
		
	}

	/**
	 * Create the frame.
	 */
	public Ventana1() {
		setTitle("Ingreso de Producto: ");
		iniciarComponentes();
		iniciarManejadoresEventos(); 
}
	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 243, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 235, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 36, 62, 22);
		panel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(82, 37, 86, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(10, 81, 62, 17);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(82, 78, 86, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setBounds(10, 121, 46, 14);
		panel.add(lblCosto);
		
		txtCosto = new JTextField();
		txtCosto.setBounds(82, 118, 86, 20);
		panel.add(txtCosto);
		txtCosto.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 161, 46, 14);
		panel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setText("");
		txtPrecio.setBounds(82, 158, 86, 20);
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(24, 213, 89, 23);
		panel.add(btnAceptar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(123, 213, 89, 23);
		panel.add(btnLimpiar);
	}
	private void iniciarManejadoresEventos() {
		btnLimpiar.addActionListener(new ActionListener    () {
            public void actionPerformed(ActionEvent arg0) {
                txtCodigo.setText(null);
                txtNombre.setText(null);
                txtCosto.setText(null);
                txtPrecio.setText(null);
            }
        });
		btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo= Integer.valueOf(txtCodigo.getText());
                    String nombre= txtNombre.getText().toString();
                    double costo=Double.valueOf(txtCosto.getText());
                    Producto a = new Producto(codigo,nombre,costo);
                    double precio=a.precio();
                    txtPrecio.setText(String.valueOf(a.getCosto()));
                    JOptionPane.showMessageDialog(null, "Codigo: "+ codigo + "\n Nombre: "+ nombre + "\n Costo: " +costo + "\n Precio:" + precio,"Datos Ingresados", JOptionPane.INFORMATION_MESSAGE);

                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error", "Dato Incorrecto", JOptionPane.ERROR_MESSAGE);
                }
        }

    });
}
		
	}

	
	
	
	
	
	
	