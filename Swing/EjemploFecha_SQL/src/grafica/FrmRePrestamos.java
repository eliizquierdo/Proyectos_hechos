package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import logica.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;



public class FrmRePrestamos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCi;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JDateChooser dateChooser;
	private JDateChooser  dateChooser2;

	public FrmRePrestamos() {
		setTitle("Registar Alumno");
		setSize(436, 566);
		setBounds(100, 100, 436, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registrar Alumno", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(43, 98, 333, 323);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCIal = new JLabel("C.I :");
		lblCIal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCIal.setBounds(30, 34, 46, 14);
		panel.add(lblCIal);
		
		JLabel lblNombreAl = new JLabel("Nombre:");
		lblNombreAl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreAl.setBounds(30, 70, 63, 14);
		panel.add(lblNombreAl);
		
		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefono.setBounds(30, 105, 63, 14);
		panel.add(lblTelefono);
		
		JLabel lblNewLabel = new JLabel("Dirección:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(30, 140, 63, 14);
		panel.add(lblNewLabel);
		
		JLabel lblfEntrega = new JLabel("Fecha de Entrega:");
		lblfEntrega.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblfEntrega.setBounds(30, 175, 129, 14);
		panel.add(lblfEntrega);
		
		JLabel lblfDevolucion = new JLabel("Fecha de Devolución:");
		lblfDevolucion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblfDevolucion.setBounds(30, 211, 129, 14);
		panel.add(lblfDevolucion);
		
		txtCi = new JTextField();
		txtCi.setColumns(10);
		txtCi.setBounds(175, 32, 129, 20);
		panel.add(txtCi);
		
		txtNombre = new JTextField();
		txtNombre.setText("");
		txtNombre.setBounds(175, 68, 128, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(175, 103, 129, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(175, 138, 128, 20);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCi.setText(null);
				txtNombre.setText(null);
				txtTelefono.setText(null);
				txtDireccion.setText(null);
				dateChooser.setToolTipText(null);
				dateChooser2.setToolTipText(null);
			}
		});
		
		btnLimpiar.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		btnLimpiar.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\IconButtom\\IcLimp.png"));
		btnLimpiar.setBounds(20, 256, 145, 39);
		panel.add(btnLimpiar);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int anio = dateChooser.getCalendar().get(Calendar.YEAR);
					int mes = dateChooser.getCalendar().get(Calendar.MONTH);
					int dia = dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH);
					
					
					int CiSo=Integer.valueOf(txtCi.getText());
					String NombreSo=txtNombre.getText();
					int TelefonoSo=Integer.valueOf(txtTelefono.getText());
					String DireccionSo=txtDireccion.getText();
				////////////////	Fecha FechaEnt=new Fecha (dia, mes, anio);
				///////////////	Fecha FechaDev=new Fecha (dia, mes, anio);
					
				/////////////	PrestamosVO RePre = new PrestamosVO(CiSo, NombreSo, TelefonoSo, DireccionSo, FechaEnt, FechaDev);
					
				}catch (Exception ex ) {
					JOptionPane.showMessageDialog(null, ex);
				
				}
				
				
			}
		});
		
		
		
		btnRegistrar.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		btnRegistrar.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\IconButtom\\IcSave.png"));
		btnRegistrar.setBounds(172, 256, 140, 39);
		panel.add(btnRegistrar);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(175, 175, 129, 20);
		panel.add(dateChooser_1);
		
		JDateChooser dateChooser2 = new JDateChooser();
		dateChooser2.setBounds(175, 211, 129, 20);
		panel.add(dateChooser2);
		
		JLabel lblBackGroundPrestamos = new JLabel("");
		lblBackGroundPrestamos.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\BackGround\\Backgroud_Al03.png"));
		lblBackGroundPrestamos.setBounds(0, 0, 418, 530);
		contentPane.add(lblBackGroundPrestamos);
		
	}
}
