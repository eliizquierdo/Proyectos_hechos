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

public class FrmReDocente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCi;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtAsignatura;
	private JDateChooser dateChooser;

	public FrmReDocente() {
		setTitle("Registar Docente");
		setSize(427, 542);
		setBounds(100, 100, 426, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registrar Docente", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(41, 83, 325, 340);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCIal = new JLabel("C.I :");
		lblCIal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCIal.setBounds(40, 51, 46, 14);
		panel.add(lblCIal);
		
		JLabel lblNombreAl = new JLabel("Nombre:");
		lblNombreAl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreAl.setBounds(40, 87, 67, 14);
		panel.add(lblNombreAl);
		
		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefono.setBounds(40, 122, 67, 14);
		panel.add(lblTelefono);
		
		JLabel lblNewLabel = new JLabel("Dirección:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(40, 157, 67, 14);
		panel.add(lblNewLabel);
		
		JLabel lblfIngreso = new JLabel("Fecha de Ingreso:");
		lblfIngreso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblfIngreso.setBounds(40, 192, 119, 14);
		panel.add(lblfIngreso);
		
		JLabel lblEdad = new JLabel("Asignatura:");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEdad.setBounds(40, 228, 79, 14);
		panel.add(lblEdad);
		
		txtCi = new JTextField();
		txtCi.setColumns(10);
		txtCi.setBounds(158, 49, 126, 20);
		panel.add(txtCi);
		
		txtNombre = new JTextField();
		txtNombre.setText("");
		txtNombre.setBounds(158, 85, 126, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(158, 120, 126, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(158, 155, 126, 20);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setBounds(160, 226, 126, 20);
		panel.add(txtAsignatura);
		txtAsignatura.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(158, 192, 126, 20);
		panel.add(dateChooser);
		
		JButton btnLimpiar = new JButton("Limpiar");
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
		
		btnLimpiar.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\IconButtom\\IcLimp.png"));
		btnLimpiar.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		btnLimpiar.setBounds(21, 277, 126, 38);
		panel.add(btnLimpiar);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int anio = dateChooser.getCalendar().get(Calendar.YEAR);
					int mes = dateChooser.getCalendar().get(Calendar.MONTH);
					int dia = dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH);
					
					
					int CiDo=Integer.valueOf(txtCi.getText());
					String NombreDo=txtNombre.getText();
					int TelefonoDo=Integer.valueOf(txtTelefono.getText());
					String DireccionDo=txtDireccion.getText();
					String Asignatura=txtAsignatura.getText();
					Fecha FechaIn=new Fecha (dia, mes, anio);
					
					Docente ReDo = new Docente(CiDo, NombreDo, TelefonoDo, DireccionDo, Asignatura, FechaIn);
					
				}catch (Exception ex ) {
					JOptionPane.showMessageDialog(null, ex);
				
				}
			}
			
		});
		
		btnRegistrar.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\IconButtom\\IcSave.png"));
		btnRegistrar.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		btnRegistrar.setBounds(168, 277, 135, 38);
		panel.add(btnRegistrar);
		
		
		
		JLabel lblBackGroundDocente = new JLabel("");
		lblBackGroundDocente.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\BackGround\\Backgroud_Do02.png"));
		lblBackGroundDocente.setBounds(0, 0, 416, 507);
		contentPane.add(lblBackGroundDocente);
		
	}
}
