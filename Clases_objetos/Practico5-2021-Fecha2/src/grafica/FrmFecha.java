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
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class FrmFecha extends JFrame {

	private JPanel contentPane;
	private JButton btnCodificar;
	JButton btnLimpiar;
	private JTextField txtAnio;
	private JLabel lblFecha1;
	private JLabel lblFecha;
	private JComboBox cmbDia;
	JSpinner spnMes;

	
	public FrmFecha() {
		iniciarComponentes();
		IniciarManejadorDeEventos();
		}

	

	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 196);
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
		lblFecha.setBounds(180, 40, 109, 17);
		contentPane.add(lblFecha);
		
		txtAnio = new JTextField();
		txtAnio.setBounds(49, 70, 86, 20);
		contentPane.add(txtAnio);
		txtAnio.setColumns(10);
		
		btnCodificar = new JButton("Codificar");
		btnCodificar.setBounds(180, 7, 109, 23);
		contentPane.add(btnCodificar);
		
		lblFecha1 = new JLabel("");
		lblFecha1.setVisible(false);
		lblFecha1.setBounds(180, 62, 110, 23);
		contentPane.add(lblFecha1);
		
		cmbDia = new JComboBox();
		cmbDia.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		cmbDia.setBounds(49, 8, 47, 20);
		contentPane.add(cmbDia);
		
		spnMes = new JSpinner();
		spnMes.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		spnMes.setBounds(43, 39, 53, 20);
		contentPane.add(spnMes);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(26, 124, 109, 23);
		contentPane.add(btnLimpiar);
		
	}
	private void IniciarManejadorDeEventos() {
		btnCodificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fecha f;
				
				int d=Integer.valueOf(cmbDia.getSelectedItem().toString());		//----------
				int m=Integer.valueOf(spnMes.getValue().toString());
				try {
					int a=Integer.valueOf(txtAnio.getText());		//puede ser Integer.parseInt tambien			
					f = new Fecha (d,m,a);
					lblFecha1.setVisible(true);
					lblFecha1.setText(f.toString());
					
				} catch (Exception ex){
					JOptionPane.showMessageDialog(null,ex);
					lblFecha1.setVisible(true);
					lblFecha1.setText("Error");
				};
			}
		});
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbDia.setSelectedIndex(0);		//
				spnMes.setValue(1);			//
				txtAnio.setText(null);
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		FrmFecha frame = new FrmFecha();
		frame.setVisible(true);
	}
}

