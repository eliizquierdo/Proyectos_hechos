package grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logica.Alumno;
import logica.Becado;
import static grafica.FrmPrincipal.coleccion;

public class InAgregarAlumno extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtApellido;
	private JTextField txtGrupo;
	private JTextField txtCuotaBase;
	private JTextField txtCuotaNeta;
	private JButton btnCalcular;
	private JButton btnLimpiar;
	private JButton btnGuardar;
	private JTextField txtSaldoCuota;
	private JCheckBox chkEsBecado;


	Alumno a;
	Becado b;
	
	public InAgregarAlumno() {
		setBounds(10, 10, 495, 227);
		setTitle("Agregar Alumnos");
		iniciarComponentes();
		iniciarManejadoresEventos();

	}
	

	private void iniciarComponentes() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.LIGHT_GRAY);
		panel1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del alumno",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel1.setBounds(10, 11, 236, 110);
		contentPane.add(panel1);
		panel1.setLayout(null);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 30, 96, 14);
		panel1.add(lblApellido);

		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setBounds(10, 55, 96, 14);
		panel1.add(lblGrupo);

		JLabel lblCuotaBase = new JLabel("Cuota Base:");
		lblCuotaBase.setBounds(10, 80, 96, 14);
		panel1.add(lblCuotaBase);

		txtApellido = new JTextField();
		txtApellido.setBounds(116, 27, 110, 20);
		panel1.add(txtApellido);
		txtApellido.setColumns(10);

		txtGrupo = new JTextField();
		txtGrupo.setBounds(116, 52, 110, 20);
		panel1.add(txtGrupo);
		txtGrupo.setColumns(10);

		txtCuotaBase = new JTextField();
		txtCuotaBase.setBounds(116, 77, 110, 20);
		panel1.add(txtCuotaBase);
		txtCuotaBase.setColumns(10);

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.LIGHT_GRAY);
		panel2.setBorder(
				new TitledBorder(null, "Calculo de la cuota neta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel2.setBounds(256, 115, 213, 58);
		contentPane.add(panel2);
		panel2.setLayout(null);

		txtCuotaNeta = new JTextField();
		txtCuotaNeta.setEditable(false);
		txtCuotaNeta.setBounds(117, 25, 86, 20);
		panel2.add(txtCuotaNeta);
		txtCuotaNeta.setColumns(10);

		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCalcular.setBounds(10, 24, 89, 23);
		panel2.add(btnCalcular);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(10, 150, 89, 23);
		contentPane.add(btnLimpiar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(123, 150, 89, 23);
		contentPane.add(btnGuardar);

		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(192, 192, 192));
		panel3.setBorder(new TitledBorder(null, "Datos de becado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel3.setBounds(259, 11, 210, 93);
		contentPane.add(panel3);
		panel3.setLayout(null);

		chkEsBecado = new JCheckBox("Es becado?");
		chkEsBecado.setBounds(6, 23, 97, 23);
		panel3.add(chkEsBecado);

		JLabel lblSaldoCuota = new JLabel("Saldo Cuota:");
		lblSaldoCuota.setBounds(6, 53, 97, 14);
		panel3.add(lblSaldoCuota);

		txtSaldoCuota = new JTextField();
		txtSaldoCuota.setEnabled(false);
		txtSaldoCuota.setBounds(113, 51, 86, 20);
		panel3.add(txtSaldoCuota);
		txtSaldoCuota.setColumns(10);
	}

	private void iniciarManejadoresEventos() {
		chkEsBecado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Habilitar o deshabilitar el JTextField según el estado del JCheckBox
            	txtSaldoCuota.setEnabled(chkEsBecado.isSelected());
            }
        });
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String apellido = txtApellido.getText();
					int grupo = Integer.valueOf(txtGrupo.getText());
					double cuotaBase = Double.valueOf(txtCuotaBase.getText());
					if (chkEsBecado.isSelected()) {
						
						double saldoCuota = Double.valueOf(txtSaldoCuota.getText());
						b = new Becado(saldoCuota, apellido, grupo, cuotaBase);
						txtCuotaNeta.setText(String.valueOf(b.cuotaNeta()));

					} else {
						a = new Alumno(apellido, grupo, cuotaBase);
						txtCuotaNeta.setText(String.valueOf(a.cuotaNeta()));
					}
				} catch (Exception ex) {
					txtCuotaNeta.setText("Error");
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chkEsBecado.isSelected()) {
					coleccion.agregar(b);
					JOptionPane.showMessageDialog(null, "Becado agregado correctamente");
				}else {
					coleccion.agregar(a);
					JOptionPane.showMessageDialog(null, "Alumno agregado correctamente");
				}
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
	}


}