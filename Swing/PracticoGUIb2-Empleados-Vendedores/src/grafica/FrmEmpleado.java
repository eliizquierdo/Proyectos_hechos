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

import logica.*;

import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtJornal;
	private JTextField txtSueldo;
	private JButton btnCalcular;
	private JButton btnLimpiar;
	private JButton btnSalir;
	private JTextField txtExtra;
	private JCheckBox chkEsVendedor;
	private JComboBox cmbDias;

	public FrmEmpleado() {
		setTitle("Empleados");
		iniciarComponentes();
		iniciarManejadoresEventos();
	}

	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.LIGHT_GRAY);
		panel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del empleado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel1.setBounds(10, 11, 195, 222);
		contentPane.add(panel1);
		panel1.setLayout(null);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 30, 96, 14);
		panel1.add(lblApellido);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 83, 96, 14);
		panel1.add(lblNombre);

		JLabel lblJornal = new JLabel("Jornal:");
		lblJornal.setBounds(10, 134, 96, 14);
		panel1.add(lblJornal);

		txtApellido = new JTextField();
		txtApellido.setBounds(67, 27, 110, 20);
		panel1.add(txtApellido);
		txtApellido.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(67, 80, 110, 20);
		panel1.add(txtNombre);
		txtNombre.setColumns(10);

		txtJornal = new JTextField();
		txtJornal.setBounds(67, 131, 110, 20);
		panel1.add(txtJornal);
		txtJornal.setColumns(10);
		
		cmbDias = new JComboBox();
		cmbDias.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		cmbDias.setBounds(67, 189, 110, 22);
		panel1.add(cmbDias);
		
		JLabel lblDias = new JLabel("Días:");
		lblDias.setBounds(10, 193, 46, 14);
		panel1.add(lblDias);

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.LIGHT_GRAY);
		panel2.setBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Calculo del sueldo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel2.setBounds(256, 115, 213, 84);
		contentPane.add(panel2);
		panel2.setLayout(null);

		txtSueldo = new JTextField();
		txtSueldo.setEditable(false);
		txtSueldo.setBounds(117, 40, 86, 20);
		panel2.add(txtSueldo);
		txtSueldo.setColumns(10);

		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCalcular.setBounds(10, 39, 89, 23);
		panel2.add(btnCalcular);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(256, 210, 89, 23);
		contentPane.add(btnLimpiar);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(380, 210, 89, 23);
		contentPane.add(btnSalir);

		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(192, 192, 192));
		panel3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos de vendedor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel3.setBounds(259, 11, 210, 93);
		contentPane.add(panel3);
		panel3.setLayout(null);

		chkEsVendedor = new JCheckBox("Es Vendedor");
		chkEsVendedor.setBounds(38, 22, 124, 23);
		panel3.add(chkEsVendedor);

		JLabel lblExtra = new JLabel("Extra:");
		lblExtra.setBounds(38, 68, 97, 14);
		panel3.add(lblExtra);

		txtExtra = new JTextField();
		txtExtra.setBounds(76, 65, 86, 20);
		panel3.add(txtExtra);
		txtExtra.setColumns(10);
	}

	private void iniciarManejadoresEventos() {
		chkEsVendedor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Habilitar o deshabilitar el JTextField según el estado del JCheckBox
            	txtExtra.setEnabled(chkEsVendedor.isSelected());
            }
        });
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Empleado e;
				Vendedor v;
				try {
					String apellido = txtApellido.getText();
					String nombre = txtNombre.getText();
					double jornal = Double.valueOf(txtJornal.getText());
					String d=(String)cmbDias.getSelectedItem();
					int dias= Integer.valueOf(d);
					if (chkEsVendedor.isSelected()) {
						
						double extra = Double.valueOf(txtExtra.getText());
						v = new Vendedor(apellido, nombre, jornal, dias,extra);
						txtSueldo.setText(String.valueOf(v.sueldo()));

					} else {
						e = new Empleado(apellido, nombre, jornal,dias);
						txtSueldo.setText(String.valueOf(e.sueldo()));
					}
				} catch (Exception ex) {
					txtSueldo.setText("Error");
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtApellido.setText(null);
				txtNombre.setText(null);
				txtJornal.setText(null);
				txtSueldo.setText(null);
			}
		});
	}

	public static void main(String[] args) {
		FrmEmpleado frm = new FrmEmpleado();
		frm.setVisible(true);
	}
}
