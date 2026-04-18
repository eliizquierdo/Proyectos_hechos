package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import logica.Fecha;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmFecha extends JFrame {

	private JPanel contentPane;
	private JButton btnFechaFormato;
	private JTextField txtAnio;
	private JTextField txtMes;
	private JLabel lblFecha1;
	private JLabel lblFecha;
	private JTextField txtDia;

	/**
	 * Launch the application.
	 */
	
	public FrmFecha() {
		iniciarComponentes();
		IniciarManejadorDeEventos();
		}

	

	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 134);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDia = new JLabel("Día:");
		lblDia.setBounds(10, 8, 38, 20);
		contentPane.add(lblDia);
		
		JLabel lblMes = new JLabel("Mes:");
		lblMes.setBounds(10, 39, 37, 20);
		contentPane.add(lblMes);
		
		JLabel lblAnio = new JLabel("Año:");
		lblAnio.setBounds(10, 70, 37, 20);
		contentPane.add(lblAnio);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setBounds(156, 41, 154, 17);
		contentPane.add(lblFecha);
		
		txtMes = new JTextField();
		txtMes.setBounds(48, 39, 86, 20);
		contentPane.add(txtMes);
		txtMes.setColumns(10);
		
		txtAnio = new JTextField();
		txtAnio.setBounds(48, 70, 86, 20);
		contentPane.add(txtAnio);
		txtAnio.setColumns(10);
		
		btnFechaFormato = new JButton("Mostrar Fecha");
		btnFechaFormato.setBounds(156, 7, 154, 23);
		contentPane.add(btnFechaFormato);
		
		lblFecha1 = new JLabel("");
		lblFecha1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha1.setVisible(false);
		lblFecha1.setBounds(180, 62, 110, 23);
		contentPane.add(lblFecha1);
		
		txtDia = new JTextField();
		txtDia.setColumns(10);
		txtDia.setBounds(48, 8, 86, 20);
		contentPane.add(txtDia);
		
	}
	private void IniciarManejadorDeEventos() {
		btnFechaFormato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fecha f;
				try {
					int d=Integer.valueOf(txtDia.getText());		//----------
					int m=Integer.valueOf(txtMes.getText());
					int a=Integer.valueOf(txtAnio.getText());					
					f = new Fecha (d,m,a);
					lblFecha1.setVisible(true);
					lblFecha1.setText(f.toString());
					LimpiarTxt();
				} catch (Exception ex){
					JOptionPane.showMessageDialog(null,ex);
					LimpiarTxt();
					lblFecha1.setVisible(true);
					lblFecha1.setText("Error");
				};
			}
		});
		
	}
	
	private void LimpiarTxt(){
		txtDia.setText(null);		//----
		txtMes.setText(null);
		txtAnio.setText(null);
	}
	public static void main(String[] args) {
		FrmFecha frame = new FrmFecha();
		frame.setVisible(true);
	}
}

