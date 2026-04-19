package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import logica.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class prueba extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCI;
	private JTextField textField;
	private JTextField txtAsignatura;
	private JTextField txtGrupo;
	private JTextField txtEdad;
	private JTextField txtCISBN;
	private JTextField txtTitulo;
	private JTextField txtCLibros;
	private JTextField txtNPag;
	private JTextField txtEditorial;
	private JTextField txtNAutor;
	private JTextField txtPais;
	private JPanel pnlAdministrarSocios, pnlAlumno, pnlProfesor, pnlLibros;
	private JRadioButton rdbtnAlumno, rdbtnProfesor;
	public prueba() {
		iniciarManejadoresEvento();
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 473);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnlAdministrarSocios = new JPanel();
		pnlAdministrarSocios.setForeground(new Color(0, 0, 0));
		pnlAdministrarSocios.setBackground(Color.LIGHT_GRAY);
		pnlAdministrarSocios.setBorder(new TitledBorder(null, "Administrar Socios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlAdministrarSocios.setBounds(22, 22, 218, 262);
		contentPane.add(pnlAdministrarSocios);
		pnlAdministrarSocios.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 55, 54, 14);
		pnlAdministrarSocios.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(77, 52, 86, 20);
		pnlAdministrarSocios.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCI = new JTextField();
		txtCI.setBounds(77, 79, 86, 20);
		pnlAdministrarSocios.add(txtCI);
		txtCI.setColumns(10);
		
		JLabel lblCI = new JLabel("Cedula:");
		lblCI.setBounds(10, 82, 46, 14);
		pnlAdministrarSocios.add(lblCI);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 107, 54, 14);
		pnlAdministrarSocios.add(lblDireccion);
		
		textField = new JTextField();
		textField.setBounds(77, 104, 86, 20);
		pnlAdministrarSocios.add(textField);
		textField.setColumns(10);
		
		pnlAlumno = new JPanel();
		pnlAlumno.setLayout(null);
		pnlAlumno.setBorder(null);
		pnlAlumno.setBackground(Color.LIGHT_GRAY);
		pnlAlumno.setBounds(10, 132, 198, 108);
		pnlAdministrarSocios.add(pnlAlumno);
		
		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setBounds(0, 11, 46, 14);
		pnlAlumno.add(lblGrupo);
		
		txtGrupo = new JTextField();
		txtGrupo.setColumns(10);
		txtGrupo.setBounds(68, 8, 86, 20);
		pnlAlumno.add(txtGrupo);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(68, 39, 86, 20);
		pnlAlumno.add(txtEdad);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(0, 42, 46, 14);
		pnlAlumno.add(lblEdad);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaNacimiento.setBounds(48, 69, 99, 14);
		pnlAlumno.add(lblFechaNacimiento);
		
		JDateChooser dtChsrAlumno = new JDateChooser();
		dtChsrAlumno.setBounds(31, 88, 144, 20);
		pnlAlumno.add(dtChsrAlumno);
		
		pnlProfesor = new JPanel();
		pnlProfesor.setBounds(10, 132, 198, 108);
		pnlAdministrarSocios.add(pnlProfesor);
		pnlProfesor.setLayout(null);
		pnlProfesor.setBorder(null);
		pnlProfesor.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblAsignatura = new JLabel("Asignatura:");
		lblAsignatura.setBounds(0, 11, 63, 14);
		pnlProfesor.add(lblAsignatura);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setColumns(10);
		txtAsignatura.setBounds(68, 8, 86, 20);
		pnlProfesor.add(txtAsignatura);
		
		JLabel lblFechaIngreso = new JLabel("Fecha de ingreso");
		lblFechaIngreso.setBounds(52, 45, 86, 14);
		pnlProfesor.add(lblFechaIngreso);
		
		JDateChooser dtChsrProfesor = new JDateChooser();
		dtChsrProfesor.setBounds(25, 70, 150, 20);
		pnlProfesor.add(dtChsrProfesor);
		
		 rdbtnAlumno = new JRadioButton("Alumno");
		 rdbtnAlumno.setBounds(16, 20, 73, 23);
		 pnlAdministrarSocios.add(rdbtnAlumno);
		
		pnlLibros = new JPanel();
		pnlLibros.setBackground(Color.LIGHT_GRAY);
		pnlLibros.setBorder(new TitledBorder(null, "Administrar libros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlLibros.setBounds(250, 22, 218, 279);
		contentPane.add(pnlLibros);
		pnlLibros.setLayout(null);
		
		JLabel lblCISBN = new JLabel("Codigo ISBN:");
		lblCISBN.setBounds(10, 24, 63, 14);
		pnlLibros.add(lblCISBN);
		
		txtCISBN = new JTextField();
		txtCISBN.setBounds(83, 21, 86, 20);
		pnlLibros.add(txtCISBN);
		txtCISBN.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 49, 46, 14);
		pnlLibros.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(83, 46, 86, 20);
		pnlLibros.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblCLibros = new JLabel("Cant de libros:");
		lblCLibros.setBounds(10, 74, 76, 14);
		pnlLibros.add(lblCLibros);
		
		txtCLibros = new JTextField();
		txtCLibros.setBounds(83, 71, 86, 20);
		pnlLibros.add(txtCLibros);
		txtCLibros.setColumns(10);
		
		JLabel lblNPag = new JLabel("Nro paginas:");
		lblNPag.setBounds(10, 99, 63, 14);
		pnlLibros.add(lblNPag);
		
		txtNPag = new JTextField();
		txtNPag.setBounds(83, 96, 86, 20);
		pnlLibros.add(txtNPag);
		txtNPag.setColumns(10);
		
		JLabel lblEditorial = new JLabel("Editorial:");
		lblEditorial.setBounds(10, 124, 46, 14);
		pnlLibros.add(lblEditorial);
		
		txtEditorial = new JTextField();
		txtEditorial.setBounds(83, 121, 86, 20);
		pnlLibros.add(txtEditorial);
		txtEditorial.setColumns(10);
		
		JLabel lblFEdicion = new JLabel("Fecha de edicion:");
		lblFEdicion.setBounds(54, 149, 97, 14);
		pnlLibros.add(lblFEdicion);
		
		JDateChooser dtChsrEdicion = new JDateChooser();
		dtChsrEdicion.setBounds(28, 168, 152, 20);
		pnlLibros.add(dtChsrEdicion);
		
		JLabel lblAutores = new JLabel("Autores");
		lblAutores.setBounds(27, 199, 46, 14);
		pnlLibros.add(lblAutores);
		
		JLabel lblNAutor = new JLabel("Nombre:");
		lblNAutor.setBounds(10, 218, 46, 14);
		pnlLibros.add(lblNAutor);
		
		txtNAutor = new JTextField();
		txtNAutor.setBounds(83, 215, 86, 20);
		pnlLibros.add(txtNAutor);
		txtNAutor.setColumns(10);
		
		JLabel lblPais = new JLabel("Pais:");
		lblPais.setBounds(10, 243, 46, 14);
		pnlLibros.add(lblPais);
		
		txtPais = new JTextField();
		txtPais.setBounds(83, 240, 86, 20);
		pnlLibros.add(txtPais);
		txtPais.setColumns(10);
	}

	private void iniciarManejadoresEvento() {
		rdbtnAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pnlAlumno.setVisible(true);
				pnlProfesor.setVisible(false);
			}
		});
	}
}
