package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import logica.Articulo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmArticulo extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPrecioCosto;
	private JTextField txtPrecioVenta;
	private JButton btnLimpiar;
	private JButton btnCalcular;

	
	public FrmArticulo() {
		iniciarComponentes();
		iniciarManejadoresEventos();
	}
		
		private void iniciarManejadoresEventos() {
			btnLimpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtCodigo.setText(null);
					txtNombre.setText(null);
					txtPrecioCosto.setText(null);
					txtPrecioVenta.setText(null);
				}
			});
			
			btnCalcular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int cod= Integer.valueOf(txtCodigo.getText());
					String nom=txtNombre.getText();
					double costo=Double.valueOf(txtPrecioCosto.getText());
					Articulo a=new Articulo(cod, nom,costo);
					double pre=a.precioVenta();
					txtPrecioVenta.setText(String.valueOf(pre));
				}
			});
		
		
	}

		private void iniciarComponentes() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos del Articulo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBackground(Color.GRAY);
			panel.setForeground(Color.WHITE);
			panel.setBounds(21, 27, 315, 158);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblCodigo = new JLabel("C\u00F3dido:");
			lblCodigo.setBounds(10, 27, 94, 14);
			panel.add(lblCodigo);
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(130, 24, 86, 20);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 58, 110, 14);
			panel.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(130, 55, 86, 20);
			panel.add(txtNombre);
			
			JLabel lblPrecioDeCosto = new JLabel("Precio de costo:");
			lblPrecioDeCosto.setBounds(10, 92, 110, 14);
			panel.add(lblPrecioDeCosto);
			
			txtPrecioCosto = new JTextField();
			txtPrecioCosto.setColumns(10);
			txtPrecioCosto.setBounds(130, 89, 86, 20);
			panel.add(txtPrecioCosto);
			
			txtPrecioVenta = new JTextField();
			txtPrecioVenta.setColumns(10);
			txtPrecioVenta.setBounds(130, 130, 86, 20);
			panel.add(txtPrecioVenta);
			
			JLabel lblCodigo_1 = new JLabel("Precio de Venta:");
			lblCodigo_1.setBounds(10, 133, 94, 14);
			panel.add(lblCodigo_1);
			
			btnLimpiar = new JButton("Limpiar");
			
			btnLimpiar.setBounds(136, 228, 89, 23);
			contentPane.add(btnLimpiar);
			
			btnCalcular = new JButton("Calcular");
			
			btnCalcular.setBounds(247, 228, 89, 23);
			contentPane.add(btnCalcular);
		
	}
		
	public static void main(String [] args) {
		FrmArticulo f=new FrmArticulo();
		f.setVisible(true);
	}

		
	
}
