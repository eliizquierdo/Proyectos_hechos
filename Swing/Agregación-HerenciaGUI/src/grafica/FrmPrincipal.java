package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import logica.Alumno;

import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtApellido;
	private JTextField txtGrupo;
	private JTextField txtCuotaBase;
	private JTextField textField_3;
	private JTextField txtCuotaNeta;
	private JButton btnCalcular;
	private JButton btnLimpiar;
	private JButton btnSalir;

	
	public FrmPrincipal() {
		setTitle("Alumnos");
		iniciarComponentes();
		iniciarManejadoresEventos();
	}
	
	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del alumno", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 236, 110);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 30, 96, 14);
		panel.add(lblApellido);
		
		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setBounds(10, 55, 96, 14);
		panel.add(lblGrupo);
		
		JLabel lblCuotaBase = new JLabel("Cuota Base:");
		lblCuotaBase.setBounds(10, 80, 96, 14);
		panel.add(lblCuotaBase);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(116, 27, 110, 20);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtGrupo = new JTextField();
		txtGrupo.setBounds(116, 52, 110, 20);
		panel.add(txtGrupo);
		txtGrupo.setColumns(10);
		
		txtCuotaBase = new JTextField();
		txtCuotaBase.setBounds(116, 77, 110, 20);
		panel.add(txtCuotaBase);
		txtCuotaBase.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new TitledBorder(null, "Calculo de la cuota neta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(256, 11, 213, 58);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtCuotaNeta = new JTextField();
		txtCuotaNeta.setBounds(117, 25, 86, 20);
		panel_1.add(txtCuotaNeta);
		txtCuotaNeta.setColumns(10);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(10, 24, 89, 23);
		panel_1.add(btnCalcular);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(269, 98, 89, 23);
		contentPane.add(btnLimpiar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(368, 98, 89, 23);
		contentPane.add(btnSalir);
	}
	
	
	private void iniciarManejadoresEventos() {
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtApellido.setText(null);
				txtGrupo.setText(null);
				txtCuotaBase.setText(null);
				txtCuotaNeta.setText(null);
			}
		});
		
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alumno a;
				try {
					String apellido=txtApellido.getText();
					int grupo=Integer.valueOf(txtGrupo.getText());
					double cuotaBase=Double.valueOf(txtCuotaBase.getText());
					a=new Alumno(apellido, grupo, cuotaBase);
					txtCuotaNeta.setText(String.valueOf(a.cuotaNeta()));
				}catch(Exception ex) {
					txtCuotaNeta.setText("Error");
					JOptionPane.showMessageDialog(null, ex);
				}
				
			}
		});
		
	}
	
	public static void main(String[] args) {
		FrmPrincipal frm=new FrmPrincipal();
		frm.setVisible(true);
	}
}
