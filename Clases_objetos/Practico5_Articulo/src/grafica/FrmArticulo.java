package grafica;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmArticulo extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtCosto;
	private JTextField txtVenta;
	private JButton btnCalcular;
	private JButton btnLimpiar;
	


	public FrmArticulo() {
		iniciarComponentes();
		iniciarManejadoresEventos();
	}
		
	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 323, 158);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 11, 46, 14);
		panel.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 56, 46, 14);
		panel.add(lblNombre);
		
		JLabel lblPrecioCosto = new JLabel("Precio costo");
		lblPrecioCosto.setBounds(10, 96, 58, 14);
		panel.add(lblPrecioCosto);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(56, 8, 86, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(56, 53, 86, 20);
		panel.add(txtNombre);
		
		txtCosto = new JTextField();
		txtCosto.setColumns(10);
		txtCosto.setBounds(73, 93, 86, 20);
		panel.add(txtCosto);
		
		JLabel lblPrecioVenta = new JLabel("Precio venta");
		lblPrecioVenta.setBounds(10, 133, 70, 14);
		panel.add(lblPrecioVenta);
		
		txtVenta = new JTextField();
		txtVenta.setColumns(10);
		txtVenta.setBounds(73, 130, 86, 20);
		panel.add(txtVenta);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(109, 217, 70, 23);
		contentPane.add(btnCalcular);
		
		btnLimpiar = new JButton("Limpiar");
		
		btnLimpiar.setBounds(244, 217, 70, 23);
		contentPane.add(btnLimpiar);
	


		
	}

	private void iniciarManejadoresEventos() {
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCodigo.setText(null);
			}
		});
		
	}
	
	public static void main(String []args) {
		FrmArticulo f=new FrmArticulo();
		f.setVisible(true);
	}
	
	
}

