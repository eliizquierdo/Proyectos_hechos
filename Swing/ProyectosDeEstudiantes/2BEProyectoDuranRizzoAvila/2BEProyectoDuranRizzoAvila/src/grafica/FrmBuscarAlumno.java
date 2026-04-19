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
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import logica.AlumnoVO;
import logica.Fecha;
//                             import logica.PersonaVO;

import javax.swing.border.EtchedBorder;

//                      import static grafica.MenuPrincipal.coleccion;

import java.awt.Color;



public class FrmBuscarAlumno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCi;
	protected JDateChooser dateChooser;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtEdad;
	private JTextField txtGrupo;
	private JTextField txtFecha;

	public FrmBuscarAlumno() {
		setTitle("Buscar Alumno");
		setSize(436, 566);
		setBounds(100, 100, 436, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ingrese C\u00E9dula", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(45, 52, 324, 124);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCIal = new JLabel("C.I :");
		lblCIal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCIal.setBounds(64, 35, 46, 14);
		panel.add(lblCIal);
		
		txtCi = new JTextField();
		txtCi.setColumns(10);
		txtCi.setBounds(120, 33, 138, 20);
		panel.add(txtCi);
		
		JButton btnBuscar = new JButton("Buscar");
		/*btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlumnoVO aVO=new AlumnoVO();
				int auxCedula = 0;
				try{
					auxCedula=Integer.parseInt(AlumnoVO.gettxtCi());
					aVO=ArrayAl.obtenerXCedula(auxCedula); 	//

					if (aVO!=null){
							txtNombre.setText(aVO.getNombre());
							txtTelefono.setText(aVO.getTelefono());
							txtDireccion.setText(aVO.getDireccion());
							txtEdad.setText(aVO.getEdad());
							txtGrupo.setText(aVO.getGrupo());
					}else
						JOptionPane.showMessageDialog(null, "Persona no"
						+ " encontrada \n");
				}catch (Exception e1){
							JOptionPane.showMessageDialog(null, "La c�dula "
							+ "debe ser num�rica  \n");
				}
		
		)};
			}*/
		btnBuscar.setIcon(new ImageIcon("G:\\Class\\ProyectoP&BD\\Imag\\IconButtom\\IcBus.png"));
		btnBuscar.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		btnBuscar.setBounds(100, 64, 126, 38);
		panel.add(btnBuscar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Informaci\u00F3n del Alumno", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(45, 187, 324, 280);
		contentPane.add(panel_1);
		
		JLabel lblNombreAl_1 = new JLabel("Nombre:");
		lblNombreAl_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreAl_1.setBounds(32, 33, 63, 14);
		panel_1.add(lblNombreAl_1);
		
		JLabel lblTelefono_1 = new JLabel("Teléfono:");
		lblTelefono_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefono_1.setBounds(32, 68, 63, 14);
		panel_1.add(lblTelefono_1);
		
		JLabel lblNewLabel_1 = new JLabel("Dirección:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(32, 103, 63, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblfNacimiento_1 = new JLabel("Fecha de Nacimiento:");
		lblfNacimiento_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblfNacimiento_1.setBounds(32, 138, 129, 14);
		panel_1.add(lblfNacimiento_1);
		
		JLabel lblEdad_1 = new JLabel("Edad:");
		lblEdad_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEdad_1.setBounds(32, 171, 46, 14);
		panel_1.add(lblEdad_1);
		
		JLabel lblGrupo_1 = new JLabel("Grupo:");
		lblGrupo_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGrupo_1.setBounds(32, 207, 46, 14);
		panel_1.add(lblGrupo_1);
		
		txtNombre = new JTextField();
		txtNombre.setText("");
		txtNombre.setEnabled(false);
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(177, 31, 128, 20);
		panel_1.add(txtNombre);
		
		txtTelefono = new JTextField();
		txtTelefono.setEnabled(false);
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(177, 66, 129, 20);
		panel_1.add(txtTelefono);
		
		txtDireccion = new JTextField();
		txtDireccion.setEnabled(false);
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(177, 101, 128, 20);
		panel_1.add(txtDireccion);
		
		txtEdad = new JTextField();
		txtEdad.setEnabled(false);
		txtEdad.setEditable(false);
		txtEdad.setColumns(10);
		txtEdad.setBounds(178, 169, 128, 20);
		panel_1.add(txtEdad);
		
		txtGrupo = new JTextField();
		txtGrupo.setText("");
		txtGrupo.setEnabled(false);
		txtGrupo.setEditable(false);
		txtGrupo.setColumns(10);
		txtGrupo.setBounds(177, 205, 129, 20);
		panel_1.add(txtGrupo);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setEnabled(false);
		txtFecha.setBounds(177, 136, 128, 20);
		panel_1.add(txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblBackGroundAlumno = new JLabel("");
		lblBackGroundAlumno.setIcon(new ImageIcon("G:\\Class\\ProyectoP&BD\\Imag\\BackGround\\Backgroud_Al03.png"));
		lblBackGroundAlumno.setBounds(0, 0, 418, 530);
		contentPane.add(lblBackGroundAlumno);
		
	}
}
