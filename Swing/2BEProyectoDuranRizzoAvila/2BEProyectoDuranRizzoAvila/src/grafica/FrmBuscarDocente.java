package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import logica.AlumnoVO;
import logica.Docente;
import logica.Fecha;

public class FrmBuscarDocente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCi;
	private JDateChooser dateChooser;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtAsignatura;
	private JTextField txtFecha;

	public FrmBuscarDocente() {
		setTitle("Buscar Docente");
		setSize(427, 542);
		setBounds(100, 100, 426, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnl = new JPanel();
		pnl.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ingresa C\u00E9dula", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnl.setBounds(41, 71, 325, 113);
		contentPane.add(pnl);
		pnl.setLayout(null);
		
		JLabel lblCIal = new JLabel("C.I :");
		lblCIal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCIal.setBounds(40, 32, 46, 14);
		pnl.add(lblCIal);
		
		txtCi = new JTextField();
		txtCi.setColumns(10);
		txtCi.setBounds(158, 30, 126, 20);
		pnl.add(txtCi);
		
		JButton btnLimpiar = new JButton("Buscar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCi.setText(null);
				txtNombre.setText(null);
				txtTelefono.setText(null);
				txtDireccion.setText(null);
				txtAsignatura.setText(null);
				dateChooser.setToolTipText(null);
			}
		});
		
		btnLimpiar.setIcon(new ImageIcon("G:\\Class\\ProyectoP&BD\\Imag\\IconButtom\\IcBus.png"));
		btnLimpiar.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		btnLimpiar.setBounds(94, 61, 126, 38);
		pnl.add(btnLimpiar);
		
		JPanel pnl_1 = new JPanel();
		pnl_1.setLayout(null);
		pnl_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Informaci\u00F3n del Docente", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnl_1.setBounds(41, 206, 325, 216);
		contentPane.add(pnl_1);
		
		JLabel lblNombreAl_1 = new JLabel("Nombre:");
		lblNombreAl_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreAl_1.setBounds(39, 36, 67, 14);
		pnl_1.add(lblNombreAl_1);
		
		JLabel lblTelefono_1 = new JLabel("Teléfono:");
		lblTelefono_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefono_1.setBounds(39, 71, 67, 14);
		pnl_1.add(lblTelefono_1);
		
		JLabel lblNewLabel_1 = new JLabel("Dirección:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(39, 106, 67, 14);
		pnl_1.add(lblNewLabel_1);
		
		JLabel lblfIngreso_1 = new JLabel("Fecha de Ingreso:");
		lblfIngreso_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblfIngreso_1.setBounds(39, 141, 119, 14);
		pnl_1.add(lblfIngreso_1);
		
		JLabel lblEdad_1 = new JLabel("Asignatura:");
		lblEdad_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEdad_1.setBounds(39, 177, 79, 14);
		pnl_1.add(lblEdad_1);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setText("");
		txtNombre.setColumns(10);
		txtNombre.setBounds(157, 34, 126, 20);
		pnl_1.add(txtNombre);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setEnabled(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(157, 69, 126, 20);
		pnl_1.add(txtTelefono);
		
		txtDireccion = new JTextField();
		txtDireccion.setEnabled(false);
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(157, 104, 126, 20);
		pnl_1.add(txtDireccion);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setEnabled(false);
		txtAsignatura.setEditable(false);
		txtAsignatura.setColumns(10);
		txtAsignatura.setBounds(159, 175, 126, 20);
		pnl_1.add(txtAsignatura);
		
		txtFecha = new JTextField();
		txtFecha.setEnabled(false);
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(157, 139, 126, 20);
		pnl_1.add(txtFecha);
		
		JLabel lblBackGroundDocente = new JLabel("");
		lblBackGroundDocente.setIcon(new ImageIcon("G:\\Class\\ProyectoP&BD\\Imag\\BackGround\\Backgroud_Do02.png"));
		lblBackGroundDocente.setBounds(0, 0, 416, 507);
		contentPane.add(lblBackGroundDocente);
		
	}
}
