package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import logica.Fecha;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Fecha2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtMes;
	private JTextField txtAnio;
	private JTextField txtDia;
	private JButton btnLimpiar;
	private JButton btnMostrar;
	private JLabel lblFecha;

	
	public Fecha2() {
		setTitle("Mi Ventana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		iniciarComponentes();
		iniciarManejoresEventos();
		
		
	}
	
	public void iniciarComponentes() {
		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(null, "Mi Fecha", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel1.setBackground(Color.PINK);
		panel1.setForeground(Color.DARK_GRAY);
		panel1.setBounds(10, 25, 403, 176);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel lblMes = new JLabel("Mes:");
		lblMes.setBounds(10, 73, 78, 14);
		panel1.add(lblMes);
		
		JLabel lblNewLabel_1 = new JLabel("D\u00EDa: ");
		lblNewLabel_1.setBounds(10, 39, 78, 14);
		panel1.add(lblNewLabel_1);
		
		JLabel lblAnio = new JLabel("A\u00F1o:");
		lblAnio.setBounds(10, 109, 78, 14);
		panel1.add(lblAnio);
		
		txtDia = new JTextField();
		txtDia.setBounds(98, 36, 78, 20);
		panel1.add(txtDia);
		txtDia.setColumns(10);
		
		txtMes = new JTextField();
		txtMes.setColumns(10);
		txtMes.setBounds(98, 70, 78, 20);
		panel1.add(txtMes);
		
		txtAnio = new JTextField();
		txtAnio.setColumns(10);
		txtAnio.setBounds(98, 106, 78, 20);
		panel1.add(txtAnio);
		
		btnMostrar = new JButton("Mostrar Fecha");
		btnMostrar.setBounds(218, 35, 149, 23);
		panel1.add(btnMostrar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(218, 134, 149, 23);
		panel1.add(btnLimpiar);
		
		lblFecha = new JLabel("dd/mm/aaaa");
		lblFecha.setBounds(228, 76, 149, 14);
		panel1.add(lblFecha);
	}
	
	public void iniciarManejoresEventos() {
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDia.setText(null);
				txtMes.setText(null);
				txtAnio.setText(null);
			}
		});
		
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fecha f=new Fecha();
				lblFecha.setText(f.toString());
			}
		});
		
	}//iniciarManejoresEventos
	
	public static void main(String[] args) {
		Fecha2 frm=new Fecha2();
		frm.setVisible(true);
		
	}
}
