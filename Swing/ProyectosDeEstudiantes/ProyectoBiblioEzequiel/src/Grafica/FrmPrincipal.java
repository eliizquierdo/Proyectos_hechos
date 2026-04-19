package Grafica;

import java.sql.*;
import Logica.*;
import Persistencia.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class FrmPrincipal extends JFrame {
	private Set<Integer> NumeroGenerado = new HashSet<>();
	private Random rd = new Random();
	private JPanel contentPane;

	ListSocio listS = new ListSocio();
	ListLibros listL = new ListLibros();
	Prestamos listP = new Prestamos();
	AlumnoDAO conectAlumno = new AlumnoDAO();
	ProfesorDAO conectProfesor = new ProfesorDAO();
	PrestamoDAO conectPrestamo = new PrestamoDAO();
	SocioDAO conectSocio = new SocioDAO();
	LibroDAO conectLibro = new LibroDAO();
	Conexion c = new Conexion();
	
	DefaultListModel modeloSocio = new DefaultListModel();
	DefaultListModel modeloLibro = new DefaultListModel();
	String nombre, telefono, direccion, grupo, titulo, editorial, asignatura, autor, pais, estado, fecha;
	int dia, mes, anio, edad, ci, isbn, cantLibro, nroPaginas, cantCopias, LIBROREC, SOCIOREC,cantDias;
	String[] CodigoPrestamo;

	private JTextField txtCi;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtAsignatura;
	private JTextField txtGrupo;
	private JTextField txtElmMaterial;
	private JTextField txtElmSocio;
	private JTextField txtElmPrestamo;

	public static void main(String[] args) {
		FrmPrincipal frame = new FrmPrincipal();

		frame.setVisible(true);
	}

	public FrmPrincipal() {
		setTitle("Biblioteca UTU");

		iniciarComponentes();

	}

	private void iniciarComponentes() {
		listS=conectSocio.listaSocios();
		listL=conectLibro.listaLibros();

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		setLocationRelativeTo(null);
		setResizable(false);;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 459);

		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JComboBox cmbSeleccionSocio = new JComboBox();
		cmbSeleccionSocio.setVisible(false);
		JPanel JPMenu = new JPanel();
		JPanel JPInicio = new JPanel();
		JPanel JPAdmSocios = new JPanel();
		JPAdmSocios.setForeground(Color.DARK_GRAY);
		JPAdmSocios.setVisible(false);
		JPanel JPAdmMaterial = new JPanel();
		JPAdmMaterial.setVisible(false);
		JPanel JPPrestamos = new JPanel();
		JPPrestamos.setVisible(false);
		JPanel JPListados = new JPanel();
		JPListados.setVisible(false);

		JPMenu.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Men\u00FA",
				TitledBorder.LEFT, TitledBorder.TOP, null, null));
		JPMenu.setBounds(10, 11, 170, 394);
		contentPane.add(JPMenu);
		JPMenu.setLayout(null);

		JButton btnAdministrarSocios = new JButton("Administrar socios");
		btnAdministrarSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnAdministrarSocios) {
					JPInicio.setVisible(false);
					JPListados.setVisible(false);
					JPPrestamos.setVisible(false);
					JPAdmMaterial.setVisible(false);
					JPAdmSocios.setVisible(true);
					cmbSeleccionSocio.setVisible(true);
				}
			}
		});
		btnAdministrarSocios.setBounds(10, 49, 150, 23);
		JPMenu.add(btnAdministrarSocios);

		JButton btnAdministrarMaterial = new JButton("Administrar material");
		btnAdministrarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnAdministrarMaterial) {
					JPInicio.setVisible(false);
					JPListados.setVisible(false);
					JPAdmSocios.setVisible(false);
					JPPrestamos.setVisible(false);
					JPAdmMaterial.setVisible(true);
				}
			}
		});
		btnAdministrarMaterial.setBounds(10, 83, 150, 23);
		JPMenu.add(btnAdministrarMaterial);

		JButton btnPrestamos = new JButton("Prestamos");
		btnPrestamos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnPrestamos) {
					JPInicio.setVisible(false);
					JPAdmSocios.setVisible(false);
					JPAdmMaterial.setVisible(false);
					JPListados.setVisible(false);
					JPPrestamos.setVisible(true);
				}
			}
		});
		btnPrestamos.setBounds(10, 117, 150, 23);
		JPMenu.add(btnPrestamos);

		JButton btnListados = new JButton("Listados");
		btnListados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnListados) {
					JPInicio.setVisible(false);
					JPAdmMaterial.setVisible(false);
					JPPrestamos.setVisible(false);
					JPAdmSocios.setVisible(false);
					JPListados.setVisible(true);
				}
			}
		});
		btnListados.setBounds(10, 151, 150, 23);
		JPMenu.add(btnListados);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		btnSalir.setBounds(10, 185, 150, 23);
		JPMenu.add(btnSalir);

		JPInicio.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JPInicio.setBounds(205, 11, 427, 394);
		contentPane.add(JPInicio);
		JPInicio.setLayout(null);

		JPAdmSocios.setBackground(SystemColor.menu);
		JPAdmSocios.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JPAdmSocios.setBounds(205, 11, 427, 394);
		contentPane.add(JPAdmSocios);
		JPAdmSocios.setLayout(null);

		JLabel lblTituloAgregarSocio = new JLabel("Agregar socio");
		lblTituloAgregarSocio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTituloAgregarSocio.setBounds(153, 10, 126, 36);
		JPAdmSocios.add(lblTituloAgregarSocio);

		JLabel lblCi = new JLabel("CI");
		lblCi.setBounds(20, 82, 34, 14);
		JPAdmSocios.add(lblCi);

		txtCi = new JTextField();
		txtCi.setBounds(131, 78, 148, 23);
		JPAdmSocios.add(txtCi);
		txtCi.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(20, 116, 101, 14);
		JPAdmSocios.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(131, 112, 148, 23);
		JPAdmSocios.add(txtNombre);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(20, 150, 97, 14);
		JPAdmSocios.add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(131, 146, 148, 23);
		JPAdmSocios.add(txtDireccion);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(20, 184, 87, 14);
		JPAdmSocios.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(131, 180, 148, 23);
		JPAdmSocios.add(txtTelefono);

		cmbSeleccionSocio.setModel(new DefaultComboBoxModel(new String[] { "Alumno", "Profesor" }));
		cmbSeleccionSocio.setBounds(153, 314, 113, 22);
		JPAdmSocios.add(cmbSeleccionSocio);

		JLabel lblAsignatura = new JLabel("Asignatura");
		lblAsignatura.setBounds(20, 218, 85, 14);
		JPAdmSocios.add(lblAsignatura);
		lblAsignatura.setVisible(false);

		txtAsignatura = new JTextField();
		txtAsignatura.setBounds(131, 214, 148, 23);
		JPAdmSocios.add(txtAsignatura);
		txtAsignatura.setColumns(10);
		txtAsignatura.setVisible(false);

		JLabel lblFechaIngreso = new JLabel("Fecha Ingreso");
		lblFechaIngreso.setBounds(20, 248, 87, 23);
		JPAdmSocios.add(lblFechaIngreso);
		lblFechaIngreso.setVisible(false);

		JDateChooser dtcFechaIngreso = new JDateChooser();
		dtcFechaIngreso.setBounds(131, 248, 148, 23);
		JPAdmSocios.add(dtcFechaIngreso);
		dtcFechaIngreso.setVisible(false);

		JLabel lblGrupo = new JLabel("Grupo");
		lblGrupo.setBounds(20, 218, 85, 14);
		JPAdmSocios.add(lblGrupo);

		txtGrupo = new JTextField();
		txtGrupo.setBounds(131, 214, 148, 23);
		JPAdmSocios.add(txtGrupo);
		txtGrupo.setColumns(10);

		JLabel lblFechaNac = new JLabel("Fecha Nacimiento");
		lblFechaNac.setBounds(20, 248, 113, 23);
		JPAdmSocios.add(lblFechaNac);

		JDateChooser dtcFechaNac = new JDateChooser();
		dtcFechaNac.setBounds(131, 248, 148, 23);
		JPAdmSocios.add(dtcFechaNac);

		JButton btnGuardarAlumno = new JButton("Guardar");
		btnGuardarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					ci = Integer.valueOf(txtCi.getText());
                    if(ci<0) {
                		JOptionPane.showMessageDialog(null, "Ingrese un numero positivo en Ci", "Error!", JOptionPane.ERROR_MESSAGE);
                		return;
                	}
                    if(!VerificarCi(txtCi)){
	                	JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de 0-9, y maximo de 8 caracteres en el campo cedula", "Error!", JOptionPane.ERROR_MESSAGE);
	                	return;
	                }
                } catch (NumberFormatException ex) {
                	JOptionPane.showMessageDialog(null, "Ingrese un numero entero en Ci", "Error!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
				 if(txtNombre.getText().equals("") || txtNombre.getText().equals(" ")) {
	                	JOptionPane.showMessageDialog(null, "Rellene el campo Nombre", "Error!", JOptionPane.ERROR_MESSAGE);
	                	return;
	                }else if(!VerificarNombre(txtNombre)){
	                	JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de A-Z, y maximo de 25 caracteres en el campo nombre", "Error!", JOptionPane.ERROR_MESSAGE);
	                	return;
	                }else {						
						nombre = txtNombre.getText();
					}
				 if(txtDireccion.getText().equals("") || txtDireccion.getText().equals(" ")) {
	                	JOptionPane.showMessageDialog(null, "Rellene el campo Direccion", "Error!", JOptionPane.ERROR_MESSAGE);
	                	return;
	                }else if(!VerificarDireccion(txtDireccion)){
	                	JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de A-Z,0-9 puntos y espacios, y maximo de 45 caracteres en el campo direccion", "Error!", JOptionPane.ERROR_MESSAGE);
	                	return;
	                }else{
	                	direccion = txtDireccion.getText();
					}
				 if(txtTelefono.getText().equals("") || txtTelefono.getText().equals(" ")) {
	                	JOptionPane.showMessageDialog(null, "Rellene el campo Telefono", "Error!", JOptionPane.ERROR_MESSAGE);
	                	return;
	                }else if(!VerificarTelefono(txtTelefono)){
	                	JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de 0-9, y maximop de 9 caracteres en el campo telefono", "Error!", JOptionPane.ERROR_MESSAGE);
	                	return;
	                }else{
	                	telefono = txtTelefono.getText();
					}
				 if(txtGrupo.getText().equals("") || txtGrupo.getText().equals(" ")) {
	                	JOptionPane.showMessageDialog(null, "Rellene el campo Grupo", "Error!", JOptionPane.ERROR_MESSAGE);
	                	return;
	                }else if(!VerificarGrupo(txtGrupo)){
	                	JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de A-Z,0-9, y maximo de 5 caracteres en el campo grupo", "Error!", JOptionPane.ERROR_MESSAGE);
	                	return;
	                }else{
	                	grupo = txtGrupo.getText();
					}
				 if(dtcFechaNac.getCalendar()==null) { 
	                	JOptionPane.showMessageDialog(null, "Rellene el campo FechaNacimiento", "Error!", JOptionPane.ERROR_MESSAGE);		
	                	return;
				 }else {
				dia = dtcFechaNac.getCalendar().get(Calendar.DAY_OF_MONTH);
				mes = dtcFechaNac.getCalendar().get(Calendar.MONTH) + 1;
				anio = dtcFechaNac.getCalendar().get(Calendar.YEAR);

				fecha = (dia + "/" + mes + "/" + anio);
				 }
				edad = (LocalDate.now().getYear()) - dtcFechaNac.getCalendar().get(Calendar.YEAR);

				Alumno NuevoAlumno = new Alumno(ci, nombre, direccion, telefono, edad, fecha, grupo);
				String resultIngreso = conectAlumno.insertarAlumno(NuevoAlumno);
				if (resultIngreso == null) {
				    JOptionPane.showMessageDialog(null, "La cédula del Alumno ingresada ya existe", "Error!", JOptionPane.ERROR_MESSAGE);
				    return;
				} else if ("Registro Exitoso!".equals(resultIngreso)) {
				    System.out.println("Alumno " + resultIngreso);
				    JOptionPane.showMessageDialog(null, "Alumno Guardado!", "Mensaje ", JOptionPane.INFORMATION_MESSAGE);
				} else {
				    JOptionPane.showMessageDialog(null, resultIngreso, "Error!", JOptionPane.ERROR_MESSAGE);
				    return;
				}
				listS=conectSocio.listaSocios();
				
				
				txtCi.setText("");
				txtNombre.setText("");
				txtDireccion.setText("");
				txtTelefono.setText("");
				txtGrupo.setText("");
				dtcFechaNac.setCalendar(null);

				JOptionPane.showMessageDialog(null, "Alumno guardado!", "Mensaje ", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnGuardarAlumno.setBounds(153, 347, 113, 36);
		JPAdmSocios.add(btnGuardarAlumno);

		JButton btnGuardarProfesor = new JButton("Guardar");
		btnGuardarProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {					
					ci = Integer.valueOf(txtCi.getText());
                    if(ci<0) {
                		JOptionPane.showMessageDialog(null, "Ingrese un numero positivo en Ci", "Error!", JOptionPane.ERROR_MESSAGE);
                		return;
                	}
                    if(!VerificarCi(txtCi)){
	                	JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de 0-9, y maximo de 8 caracteres en el campo Ci", "Error!", JOptionPane.ERROR_MESSAGE);
	                	return;
	                }
                } catch (NumberFormatException ex) {
                	JOptionPane.showMessageDialog(null, "Ingrese un numero entero en Ci", "Error!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
				 if(txtNombre.getText().equals("") || txtNombre.getText().equals(" ")) {
	                	JOptionPane.showMessageDialog(null, "Rellene el campo Nombre", "Error!", JOptionPane.ERROR_MESSAGE);
	                	return;
	                }else if(!VerificarNombre(txtNombre)){
	                	JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de A-Z, y maximo de 25 caracteres en el campo nombre", "Error!", JOptionPane.ERROR_MESSAGE);
	                	return;
	                }else {						
						nombre = txtNombre.getText();
					}
				 if(txtDireccion.getText().equals("") || txtDireccion.getText().equals(" ")) {
	                	JOptionPane.showMessageDialog(null, "Rellene el campo Direccion", "Error!", JOptionPane.ERROR_MESSAGE);
	                	return;
				 }else if(!VerificarDireccion(txtDireccion)){
	                	JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de A-Z,0-9 puntos y espacios, y maximo de 45 caracteres en el campo direccion", "Error!", JOptionPane.ERROR_MESSAGE);
	                	return;
	                }else{
	                	direccion = txtDireccion.getText();
					}

				 if(txtTelefono.getText().equals("") || txtTelefono.getText().equals(" ")) {
	                	JOptionPane.showMessageDialog(null, "Rellene el campo Telefono", "Error!", JOptionPane.ERROR_MESSAGE);
	                	return;
	                }else if(!VerificarTelefono(txtTelefono)){
	                	JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de 0-9, y maximo de 9 caracteres en el campo telefono", "Error!", JOptionPane.ERROR_MESSAGE);
	                	return;
	                }else{
	                	telefono = txtTelefono.getText();
					}
				 if(txtAsignatura.getText().equals("") || txtAsignatura.getText().equals(" ")) {
	                	JOptionPane.showMessageDialog(null, "Rellene el campo Asignatura", "Error!", JOptionPane.ERROR_MESSAGE);
	                	return;
	                }else if(!VerificarAsignatura(txtAsignatura)){
	                	JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de A-Z, y maximo de caracteres 20 en el campo Asignatura", "Error!", JOptionPane.ERROR_MESSAGE);
	                	return;
	                }else{
	                	asignatura = txtAsignatura.getText();
					}
				 if(dtcFechaIngreso.getCalendar()==null) { 
	                	JOptionPane.showMessageDialog(null, "Rellene el campo FechaIngreso", "Error!", JOptionPane.ERROR_MESSAGE);	
	                	return;
				 }else {
				dia = dtcFechaIngreso.getCalendar().get(Calendar.DAY_OF_MONTH);
				mes = dtcFechaIngreso.getCalendar().get(Calendar.MONTH) + 1;
				anio = dtcFechaIngreso.getCalendar().get(Calendar.YEAR);

				fecha = (dia + "/" + mes + "/" + anio);
				 }
				Profesor NuevoProfesor = new Profesor(ci, nombre, direccion, telefono, asignatura, fecha);
				
				String resultIngreso = conectProfesor.insertarProfesor(NuevoProfesor);
				if (resultIngreso == null) {
				    JOptionPane.showMessageDialog(null, "La cédula del Profesor ingresada ya existe", "Error!", JOptionPane.ERROR_MESSAGE);
				    return;
				} else if ("Registro Exitoso!".equals(resultIngreso)) {
				    System.out.println("Profesor " + resultIngreso);
				    JOptionPane.showMessageDialog(null, "Profesor Guardado!", "Mensaje ", JOptionPane.INFORMATION_MESSAGE);
				} else {
				    JOptionPane.showMessageDialog(null, resultIngreso, "Error!", JOptionPane.ERROR_MESSAGE);
				    return;
				}
				listS=conectSocio.listaSocios();
				
				txtCi.setText("");
				txtNombre.setText("");
				txtDireccion.setText("");
				txtTelefono.setText("");
				txtAsignatura.setText("");
				dtcFechaIngreso.setCalendar(null);

				
			}
		});
		btnGuardarProfesor.setVisible(false);
		btnGuardarProfesor.setBounds(153, 347, 113, 36);
		JPAdmSocios.add(btnGuardarProfesor);
		
		JLabel lblCiCorrecion1 = new JLabel("Ingrese Ci sin puntos.\r\n\r\n");
		lblCiCorrecion1.setForeground(Color.DARK_GRAY);
		lblCiCorrecion1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCiCorrecion1.setBounds(289, 71, 128, 23);
		JPAdmSocios.add(lblCiCorrecion1);
		
		JLabel lblCiCorrecion2 = new JLabel("ni guiones-");
		lblCiCorrecion2.setHorizontalAlignment(SwingConstants.LEFT);
		lblCiCorrecion2.setForeground(Color.DARK_GRAY);
		lblCiCorrecion2.setBounds(289, 82, 128, 23);
		JPAdmSocios.add(lblCiCorrecion2);
		btnGuardarProfesor.setVisible(false);

		cmbSeleccionSocio.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String seleccion = (String) cmbSeleccionSocio.getSelectedItem();

					if ("Profesor".equals(seleccion)) {
						lblAsignatura.setVisible(true);
						txtAsignatura.setVisible(true);
						lblFechaIngreso.setVisible(true);
						dtcFechaIngreso.setVisible(true);
						btnGuardarProfesor.setVisible(true);
						
						lblGrupo.setVisible(false);
						lblFechaNac.setVisible(false);
						txtGrupo.setVisible(false);
						dtcFechaNac.setVisible(false);
						btnGuardarAlumno.setVisible(false);
					} else if ("Alumno".equals(seleccion)) {
						lblGrupo.setVisible(true);
						lblFechaNac.setVisible(true);
						txtGrupo.setVisible(true);
						dtcFechaNac.setVisible(true);
						btnGuardarAlumno.setVisible(true);

						lblAsignatura.setVisible(false);
						txtAsignatura.setVisible(false);
						lblFechaIngreso.setVisible(false);
						dtcFechaIngreso.setVisible(false);
						btnGuardarProfesor.setVisible(false);
					}
				}
			}
		});

		JPAdmMaterial.setBackground(SystemColor.menu);
		JPAdmMaterial.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JPAdmMaterial.setBounds(205, 11, 427, 394);
		contentPane.add(JPAdmMaterial);
		JPAdmMaterial.setLayout(null);

		Label lblIsbn = new Label("Isbn");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIsbn.setBounds(15, 44, 110, 22);
		JPAdmMaterial.add(lblIsbn);

		JTextField txtIsbn = new JTextField();
		txtIsbn.setBounds(131, 44, 148, 23);
		JPAdmMaterial.add(txtIsbn);

		JTextField txtTitulo = new JTextField();
		txtTitulo.setBounds(131, 78, 148, 23);
		JPAdmMaterial.add(txtTitulo);

		JTextField txtNroPaginas = new JTextField();
		txtNroPaginas.setBounds(131, 112, 148, 23);
		JPAdmMaterial.add(txtNroPaginas);

		JTextField txtEditorial = new JTextField();
		txtEditorial.setBounds(131, 146, 148, 23);
		JPAdmMaterial.add(txtEditorial);

		JTextField txtNroCopias = new JTextField();
		txtNroCopias.setBounds(131, 211, 148, 23);
		JPAdmMaterial.add(txtNroCopias);

		Label lblTituloLibro = new Label("Titulo");
		lblTituloLibro.setBounds(15, 79, 110, 22);
		JPAdmMaterial.add(lblTituloLibro);

		Label lblNroPaginas = new Label("Nro. paginas");
		lblNroPaginas.setBounds(15, 112, 110, 22);
		JPAdmMaterial.add(lblNroPaginas);

		Label lblEditorial = new Label("Editorial");
		lblEditorial.setBounds(15, 147, 70, 22);
		JPAdmMaterial.add(lblEditorial);

		Label lblEstado = new Label("Estado");
		lblEstado.setBounds(15, 178, 62, 22);
		JPAdmMaterial.add(lblEstado);

		Label lblNroCopias = new Label("Nro. copias");
		lblNroCopias.setBounds(15, 212, 84, 22);
		JPAdmMaterial.add(lblNroCopias);

		Label lblFechaEdicion = new Label("Fecha edicion");
		lblFechaEdicion.setBounds(15, 246, 84, 22);
		JPAdmMaterial.add(lblFechaEdicion);

		JDateChooser dtcFechaEdicion = new JDateChooser();
		dtcFechaEdicion.setBounds(131, 245, 148, 23);
		JPAdmMaterial.add(dtcFechaEdicion);

		Label lblTituloMateriales = new Label("Agregar libros");
		lblTituloMateriales.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTituloMateriales.setBounds(153, 10, 110, 28);
		JPAdmMaterial.add(lblTituloMateriales);

		Label lblAutor = new Label("Autor");
		lblAutor.setBounds(15, 280, 70, 22);
		JPAdmMaterial.add(lblAutor);

		JTextField txtAutor = new JTextField();
		txtAutor.setBounds(131, 279, 148, 23);
		JPAdmMaterial.add(txtAutor);

		JTextField txtPais = new JTextField();
		txtPais.setBounds(131, 313, 148, 23);
		JPAdmMaterial.add(txtPais);
		
		JComboBox cmbEstado = new JComboBox();
		cmbEstado.setModel(new DefaultComboBoxModel(new String[] {"Disponible", "No Disponible"}));
		cmbEstado.setSelectedIndex(0);
		cmbEstado.setBounds(131, 180, 148, 22);
		JPAdmMaterial.add(cmbEstado);
		
		cmbEstado.addActionListener(e -> {
		
		});
		
		Label lblPais = new Label("Pais");
		lblPais.setBounds(15, 314, 70, 22);
		JPAdmMaterial.add(lblPais);
		
		//Guardar los datos de los libro en la base de datos
		Button btnGuardarLibro = new Button("Guardar");
		btnGuardarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {					
                    isbn=Integer.valueOf(txtIsbn.getText());              
                    if(isbn<0) {
                		JOptionPane.showMessageDialog(null, "Ingrese un numero positivo en Isbn", "Error!", JOptionPane.ERROR_MESSAGE);
                		return;
                	}
                    if(!VerificarIsbn(txtIsbn)){
	                	JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de 0-9, y maximo de 5 caracteres en el campo Isbn", "Error!", JOptionPane.ERROR_MESSAGE);
	                	return;
                    }
                } catch (NumberFormatException ex) {
                	JOptionPane.showMessageDialog(null, "Ingrese un numero entero en Isbn", "Error!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                    
                if(txtTitulo.getText().equals("") || txtTitulo.getText().equals(" ")) {
                	JOptionPane.showMessageDialog(null, "Rellene el campo Titulo", "Error!", JOptionPane.ERROR_MESSAGE);
                	return;
                }else if(!VerificarTitulo(txtTitulo)){
                	JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de A-z y espacios, y maximo de 50 caracteres en el campo Titulo", "Error!", JOptionPane.ERROR_MESSAGE);
                	return;
                }else{
				titulo = txtTitulo.getText();
				}
                
                try {
                	
				nroPaginas = Integer.valueOf(txtNroPaginas.getText());
				if(nroPaginas<0) {
            		JOptionPane.showMessageDialog(null, "Ingrese un numero positivo en Nro.Paginas", "Error!", JOptionPane.ERROR_MESSAGE);
            		return;
            	}
				if(!VerificarNroPaginas(txtNroPaginas)){
                	JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de 0-9, y maximo de 4 caracteres en el campo Nro.Paginas", "Error!", JOptionPane.ERROR_MESSAGE);
                	return;
                }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un numero entero en Nro.Paginas", "Error!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if(txtEditorial.getText().equals("") || txtEditorial.getText().equals(" ")) {
                	JOptionPane.showMessageDialog(null, "Rellene el campo Editorial", "Error!", JOptionPane.ERROR_MESSAGE);
                	return;
                }else if(!VerificarEditorial(txtEditorial)){
                	JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de A-Z y espacios, y maximo de 25 caracteres en el campo Editorial", "Error!", JOptionPane.ERROR_MESSAGE);
                	return;
                }else{
                	editorial = txtEditorial.getText();
				}

                	estado = String.valueOf(cmbEstado.getSelectedItem());
                	
                try {					
                    cantCopias=Integer.valueOf(txtNroCopias.getText());              
                    if(cantCopias<0) {
                		JOptionPane.showMessageDialog(null, "Ingrese un numero positivo en Nro.Copias", "Error!", JOptionPane.ERROR_MESSAGE);
                		return;
                	}
                    if(!VerificarCantCopias(txtNroCopias)){
	                	JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de 0-9, y maximo de 4 caracteres en el campo Nro.Copias", "Error!", JOptionPane.ERROR_MESSAGE);
	                	return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un numero entero en Nro.Copias", "Error!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
				
                if(txtAutor.getText().equals("") || txtAutor.getText().equals(" ")) {
                	JOptionPane.showMessageDialog(null, "Rellene el campo Autor", "Error!", JOptionPane.ERROR_MESSAGE);
                	return;
                }else if(!VerificarAutor(txtAutor)){
                	JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de A-Z y espacios, y maximo de 25 caracteres en el campo Autor", "Error!", JOptionPane.ERROR_MESSAGE);
                	return;
                }else{
                	autor = txtAutor.getText();
				}
                if(txtPais.getText().equals("") || txtPais.getText().equals(" ")) {
                	JOptionPane.showMessageDialog(null, "Rellene el campo Pais", "Error!", JOptionPane.ERROR_MESSAGE);
                	return;
                }else if(!VerificarPais(txtPais)){
                	JOptionPane.showMessageDialog(null, "Solo se permiten caracteres de A-Z y espacios, y maximo de 25 caracteres en el campo Pais", "Error!", JOptionPane.ERROR_MESSAGE);
                	return;
                }else{
                	pais = txtPais.getText();
                	}
                if(dtcFechaEdicion.getCalendar()==null) {
                	JOptionPane.showMessageDialog(null, "Rellene el campo Fecha Edicion", "Error!", JOptionPane.ERROR_MESSAGE);
                	return;
                }else {
				dia = dtcFechaEdicion.getCalendar().get(Calendar.DAY_OF_MONTH);
				mes = dtcFechaEdicion.getCalendar().get(Calendar.MONTH) + 1;
				anio = dtcFechaEdicion.getCalendar().get(Calendar.YEAR);
				fecha = (dia + "/" + mes + "/" + anio);
                }
				//Crear el libro para agregar con los datos de arriba
				CopiaLibro nuevoLibro = new CopiaLibro(isbn, titulo, nroPaginas, fecha, editorial, autor, pais, estado,
						cantCopias);
				listL.agregarLibro(nuevoLibro);
				//Enviar el libro a la base de datos, usando LibroDAo
				System.out.println("Libro " + conectLibro.insertarcopia(nuevoLibro));
				//Agregar las tablas tablas libro y copia a listL a travez de la base de datos, usando LibroDAO
				listL=conectLibro.listaLibros();
				txtIsbn.setText("");
				txtTitulo.setText("");
				txtNroPaginas.setText("");				
				txtNroCopias.setText("");				
				txtEditorial.setText("");
				dtcFechaEdicion.setCalendar(null);
				txtPais.setText("");
				txtAutor.setText("");

				JOptionPane.showMessageDialog(null, "Libro guardado!", " ", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnGuardarLibro.setBounds(153, 347, 113, 36);
		JPAdmMaterial.add(btnGuardarLibro);
		
		JPPrestamos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JPPrestamos.setBounds(205, 11, 427, 394);
		contentPane.add(JPPrestamos);
		JPPrestamos.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Prestamos");
		lblNewLabel_1.setBounds(178, 11, 84, 19);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		JPPrestamos.add(lblNewLabel_1);

		JScrollPane scPPrestamoLibros = new JScrollPane();
		scPPrestamoLibros.setViewportBorder(new CompoundBorder(
				new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				new TitledBorder(
						new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
						"Libros", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));
		scPPrestamoLibros.setBounds(10, 36, 201, 296);
		JPPrestamos.add(scPPrestamoLibros);

		JList lstLibro = new JList();
		scPPrestamoLibros.setViewportView(lstLibro);
		lstLibro.setModel(modeloLibro);

		JScrollPane scPPrestamoSocio = new JScrollPane();
		scPPrestamoSocio.setViewportBorder(new CompoundBorder(
				new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				new TitledBorder(
						new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
						"Socios", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));
		scPPrestamoSocio.setBounds(209, 36, 208, 296);
		JPPrestamos.add(scPPrestamoSocio);

		JList<String> lstSocio = new JList<>(modeloSocio);
		lstSocio.setLayoutOrientation(JList.VERTICAL_WRAP);
		scPPrestamoSocio.setViewportView(lstSocio);
		lstSocio.setModel(modeloSocio);
		JButton btnPrestamo = new JButton("Prestar");
		btnPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fechaInicioPrestamo;
				String fechaDevolucionPrestamo;

				dia = (LocalDate.now().getDayOfMonth());
				mes = (LocalDate.now().getMonthValue());
				anio = (LocalDate.now().getYear());
				cantDias=(LocalDate.now().lengthOfMonth());

				fechaInicioPrestamo = (dia + "/" + mes + "/" + anio);
				fechaDevolucionPrestamo = ControlarFechaDevolucion(dia,mes,anio,cantDias);

				LIBROREC = lstLibro.getSelectedIndex();
				SOCIOREC = lstSocio.getSelectedIndex();

				Prestamo nuevoPrestamo = new Prestamo(	listL.obtenerLibro(lstLibro.getSelectedIndex()).getIsbn(),
						listS.obtenerSocio(lstSocio.getSelectedIndex()).getCi(),fechaInicioPrestamo, fechaDevolucionPrestamo);
				
				String resultIngreso = conectPrestamo.insertarPrestamo(nuevoPrestamo);
				if (resultIngreso == null) {
				    JOptionPane.showMessageDialog(null, "La ci y el isbn del prestmo ingresado ya existe", "Error!", JOptionPane.ERROR_MESSAGE);
				    return;
				} else if ("Registro Exitoso!".equals(resultIngreso)) {
				    System.out.println("Prestamo " + resultIngreso);
				    JOptionPane.showMessageDialog(null, "Prestamo Guardado!", "Mensaje ", JOptionPane.INFORMATION_MESSAGE);
				} else {
				    JOptionPane.showMessageDialog(null, resultIngreso, "Error!", JOptionPane.ERROR_MESSAGE);
				    return;
				}
				listP.agregarPrestamo(nuevoPrestamo);
				listP=conectPrestamo.listaPrestamo();

				JOptionPane.showMessageDialog(null, "Prestamo exitoso!", " ", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnPrestamo.setBounds(258, 343, 116, 40);
		JPPrestamos.add(btnPrestamo);

		JButton btnActualizarPrestamo = new JButton("Actualizar");
		btnActualizarPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listS=conectSocio.listaSocios();
				listL=conectLibro.listaLibros();
				modeloSocio.removeAllElements();
				modeloLibro.removeAllElements();
				
				for (int i = 0; i < listS.size(); i++) {
					modeloSocio.addElement(listS.obtenerSocio(i));
				}
			for (int i = 0; i < listL.size(); i++) {
				modeloLibro.addElement(listL.obtenerLibro(i));
		}
			


			}
		});
		btnActualizarPrestamo.setBounds(54, 343, 116, 40);
		JPPrestamos.add(btnActualizarPrestamo);

		JPListados.setBackground(SystemColor.menu);
		JPListados.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JPListados.setBounds(205, 11, 427, 394);
		contentPane.add(JPListados);
		JPListados.setLayout(null);

		JLabel lblNewLabel = new JLabel("Listados");
		lblNewLabel.setBounds(163, 11, 83, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		JPListados.add(lblNewLabel);

		JTabbedPane TBPListados = new JTabbedPane(JTabbedPane.TOP);
		TBPListados.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		TBPListados.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TBPListados.setBounds(10, 31, 407, 306);
		JPListados.add(TBPListados);
		
		JButton btnElmMaterial = new JButton("Eliminar");
		btnElmMaterial.setForeground(Color.BLACK);
		
		JButton btnElmSocio = new JButton("Eliminar");
		btnElmSocio.setForeground(Color.BLACK);
		btnElmSocio.setVisible(false);
		
		JButton btnElmPrestamo = new JButton("Eliminar");
		btnElmPrestamo.setVisible(false);
		
		txtElmMaterial = new JTextField();
		txtElmMaterial.setForeground(Color.BLACK);
		
		txtElmSocio = new JTextField();
		txtElmSocio.setVisible(false);
		
		txtElmPrestamo = new JTextField();
		txtElmPrestamo.setVisible(false);
		
		btnElmPrestamo.setBounds(301, 352, 113, 36);		
		txtElmPrestamo.setColumns(10);		
		txtElmPrestamo.setBounds(163, 357, 98, 27);
				
		txtElmMaterial.setColumns(10);		
		txtElmMaterial.setBounds(163, 357, 98, 27);		
		btnElmMaterial.setBounds(301, 352, 113, 36);
				
		txtElmSocio.setColumns(10);	
		txtElmSocio.setBounds(163, 357, 98, 27);		
		btnElmSocio.setBounds(301, 352, 113, 36);		
		
		JLabel lblIngreseIsbn = new JLabel("Ingrese isbn");
		lblIngreseIsbn.setForeground(Color.DARK_GRAY);
		lblIngreseIsbn.setBounds(163, 338, 85, 14);
		lblIngreseIsbn.setVisible(true);
			
		JLabel lblIngreseCi = new JLabel("Ingrese Ci");
		lblIngreseCi.setForeground(Color.DARK_GRAY);
		lblIngreseCi.setBounds(163, 338, 85, 14);
		lblIngreseCi.setVisible(false);
		
		JLabel lblIngreseIsbnCi = new JLabel("Ingrese Ci y Isbn separados por coma \",\"");
		lblIngreseIsbnCi.setForeground(Color.DARK_GRAY);
		lblIngreseIsbnCi.setBounds(113, 338, 234, 14);
		lblIngreseIsbnCi.setVisible(false);

		JPListados.add(lblIngreseIsbn);
		JPListados.add(lblIngreseCi);
		JPListados.add(lblIngreseIsbnCi);
		JPListados.add(btnElmPrestamo);
		JPListados.add(btnElmSocio);
		JPListados.add(txtElmPrestamo);
		JPListados.add(btnElmMaterial);
		JPListados.add(txtElmMaterial);
		JPListados.add(txtElmSocio);
		
		JScrollPane SCPMateriales = new JScrollPane();
		SCPMateriales.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		TBPListados.addTab("Materiales", null, SCPMateriales, null);

		JTextArea txtAMateriales = new JTextArea();
		txtAMateriales.setText("");
		SCPMateriales.setViewportView(txtAMateriales);

		JScrollPane SCPSocio = new JScrollPane();
		SCPSocio.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		TBPListados.addTab("Socios", null, SCPSocio, null);

		JTextArea txtASocios = new JTextArea();
		SCPSocio.setViewportView(txtASocios);

		JScrollPane SCPPrestamos = new JScrollPane();
		TBPListados.addTab("Prestamos", null, SCPPrestamos, null);

		JTextArea txtAPrestamos = new JTextArea();
		SCPPrestamos.setViewportView(txtAPrestamos);
		
		TBPListados.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            	
            	switch (TBPListados.getSelectedIndex()) {
                case 0:
                	btnElmSocio.setVisible(false);
        			btnElmPrestamo.setVisible(false);
        			txtElmSocio.setVisible(false);
        			txtElmPrestamo.setVisible(false);
        			lblIngreseIsbnCi.setVisible(false);
        			lblIngreseCi.setVisible(false);
        			lblIngreseIsbn.setVisible(true);
        			txtElmMaterial.setVisible(true);
        			btnElmMaterial.setVisible(true);
                    break;
                case 1:
                	btnElmMaterial.setVisible(false);
                	btnElmPrestamo.setVisible(false);
                	txtElmPrestamo.setVisible(false);
    				txtElmMaterial.setVisible(false);
        			lblIngreseIsbnCi.setVisible(false);
        			lblIngreseIsbn.setVisible(false);
        			lblIngreseCi.setVisible(true);
    				txtElmSocio.setVisible(true);
    				btnElmSocio.setVisible(true);
    				break;
                case 2:
                	btnElmSocio.setVisible(false);
                	btnElmMaterial.setVisible(false);
                	txtElmMaterial.setVisible(false);
                	txtElmSocio.setVisible(false);
        			lblIngreseCi.setVisible(false);
        			lblIngreseIsbn.setVisible(false);
        			lblIngreseIsbnCi.setVisible(true);
    				txtElmPrestamo.setVisible(true);
    				btnElmPrestamo.setVisible(true);
                    break;
                default:
                    break;
            }
          }
        });

		JButton btnActualizarListados = new JButton("Actualizar");
		btnActualizarListados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listS=conectSocio.listaSocios();
				listL=conectLibro.listaLibros();
				listP=conectPrestamo.listaPrestamo();
				txtAMateriales.setText("");				
				txtASocios.setText("");
				txtAPrestamos.setText("");
				

				txtAMateriales.setText(listL.toString());
				txtASocios.setText(listS.toString());
				txtAPrestamos.setText(listP.toString());
			}
		});
		btnActualizarListados.setBounds(20, 352, 113, 36);
		JPListados.add(btnActualizarListados);
		
		btnElmMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isbn=Integer.valueOf(txtElmMaterial.getText());
				conectLibro.eliminarLibro(isbn);
				txtElmMaterial.setText("");
				JOptionPane.showMessageDialog(null, "Material Elminado!", " ", JOptionPane.WARNING_MESSAGE);

			}
		});

		btnElmSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ci=Integer.valueOf(txtElmSocio.getText());
				conectSocio.eliminarSocio(ci);
				txtElmSocio.setText("");
				JOptionPane.showMessageDialog(null, "Socio Eliminado!", " ", JOptionPane.WARNING_MESSAGE);
			}
		});
				
		
		btnElmPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CodigoPrestamo=txtElmPrestamo.getText().split(",");
				isbn=Integer.valueOf(CodigoPrestamo[0]);
				ci=Integer.valueOf(CodigoPrestamo[1]);
				conectPrestamo.eliminarPrestamo(isbn, ci);
				txtElmPrestamo.setText("");
				JOptionPane.showMessageDialog(null, "Prestamo Eliminado!", "Mensaje ", JOptionPane.WARNING_MESSAGE);

			}
		});
		

	}
	public static String ControlarFechaDevolucion(int D,int M,int A, int cant) {

        int dia = D;
        int mes = M;
        int anio = A;
        int DiasDelMes = cant;
        String result=( ( dia+7 )+"/"+mes+"/"+anio);

        if (dia > DiasDelMes) {
        	dia=dia-DiasDelMes;
            mes++;

            if (mes > 12) {
                mes = 1;
                anio++;
         }

          
            result = (dia+"/"+mes+"/"+anio);
        }

        return result;
    }
	
	public static boolean VerificarCi(JTextField text) {
		String contendio=text.getText();
		if(contendio.isEmpty() || contendio.length()>8) {
			return false;
		}
		return contendio.matches("^[0-9]+$");
	}
	public static boolean VerificarNombre(JTextField text) {
		String contendio=text.getText();
		if(contendio.isEmpty() || contendio.length()>25) {
			return false;
		}
		return contendio.matches("^[A-Za-z ]+$");
	}
	public static boolean VerificarTelefono(JTextField text) {
		String contendio=text.getText();
		if(contendio.isEmpty() || contendio.length()>9) {
			return false;
		}
		return contendio.matches("^[0-9]+$");
	}
	public static boolean VerificarDireccion(JTextField text) {
		String contendio=text.getText();
		if(contendio.isEmpty() || contendio.length()>45) {
			return false;
		}
		return contendio.matches("^[A-Za-z0-9 .]+$");
	}
	public static boolean VerificarAsignatura(JTextField text) {
		String contendio=text.getText();
		if(contendio.isEmpty() || contendio.length()>20) {
			return false;
		}
		return contendio.matches("^[A-Za-z ]+$");
	}
	public static boolean VerificarGrupo(JTextField text) {
		String contendio=text.getText();
		if(contendio.isEmpty() || contendio.length()>5) {
			return false;
		}
		return contendio.matches("^[A-Za-z0-9]+$");
	}
	public static boolean VerificarIsbn(JTextField text) {
		String contendio=text.getText();
		if(contendio.isEmpty() || contendio.length()>5) {
			return false;
		}
		return contendio.matches("^[0-9]+$");
	}
	public static boolean VerificarTitulo(JTextField text) {
		String contendio=text.getText();
		if(contendio.isEmpty() || contendio.length()>50) {
			return false;
		}
		return contendio.matches("^[A-Za-z ]+$");
	}
	public static boolean VerificarNroPaginas(JTextField text) {
		String contendio=text.getText();
		if(contendio.isEmpty() || contendio.length()>4) {
			return false;
		}
		return contendio.matches("^[0-9]+$");
	}
	public static boolean VerificarEditorial(JTextField text) {
		String contendio=text.getText();
		if(contendio.isEmpty() || contendio.length()>25) {
			return false;
		}
		return contendio.matches("^[A-Za-z ]+$");
	}
	public static boolean VerificarAutor(JTextField text) {
		String contendio=text.getText();
		if(contendio.isEmpty() || contendio.length()>25) {
			return false;
		}
		return contendio.matches("^[A-Za-z ]+$");
	}
	public static boolean VerificarPais(JTextField text) {
		String contendio=text.getText();
		if(contendio.isEmpty() || contendio.length()>25) {
			return false;
		}
		return contendio.matches("^[A-Za-z ]+$");
	}
	public static boolean VerificarCantCopias(JTextField text) {
		String contendio=text.getText();
		if(contendio.isEmpty() || contendio.length()>4) {
			return false;
		}
		return contendio.matches("^[0-9]+$");
	}
}
	
