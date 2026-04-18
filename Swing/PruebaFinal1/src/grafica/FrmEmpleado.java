package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class FrmEmpleado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSueldo;
	private JButton btnCalcular;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtNroEmpl;
	private JTextField txtValorJornal;
	private JTextField txtCantDeDias;
	private JTextField txtExtra;
	private JButton btnLimpiar;
	private JButton btnAgregar;
	private JButton btnEliminar;

	public FrmEmpleado() {
		setTitle("Empleado o Vendedor");
		iniciarComponentes();
		iniciarManejadoresEventos();
	}

	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 400); // Aumenté el tamaño para dar espacio al JTextArea
		setLocationRelativeTo(null); //Establecemos la ventana centrada
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Datos de Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 271, 198);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 61, 69, 14);
		panel.add(lblApellido);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 92, 69, 14);
		panel.add(lblNombre);

		txtApellido = new JTextField();
		txtApellido.setBounds(101, 58, 140, 20);
		panel.add(txtApellido);
		txtApellido.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(101, 89, 140, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNroDeEmpleado = new JLabel("Nro de Empl:");
		lblNroDeEmpleado.setBounds(10, 34, 96, 14);
		panel.add(lblNroDeEmpleado);

		txtNroEmpl = new JTextField();
		txtNroEmpl.setColumns(10);
		txtNroEmpl.setBounds(101, 27, 140, 20);
		panel.add(txtNroEmpl);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpiar.setBounds(146, 164, 86, 23);
		panel.add(btnLimpiar);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Sueldo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(306, 11, 224, 198);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBounds(106, 165, 86, 20);
		panel_2.add(txtSueldo);

		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(5, 164, 86, 23);
		panel_2.add(btnCalcular);
		
		JLabel lblValorJornal = new JLabel("Valor jornal:");
		lblValorJornal.setBounds(10, 34, 96, 14);
		panel_2.add(lblValorJornal);
		
		JLabel lblCantidadDeDias = new JLabel("Cant. de días:");
		lblCantidadDeDias.setBounds(10, 60, 96, 14);
		panel_2.add(lblCantidadDeDias);
		
		JLabel lblExtra = new JLabel("Extra");
		lblExtra.setBounds(10, 125, 96, 14);
		panel_2.add(lblExtra);
		
		txtValorJornal = new JTextField();
		txtValorJornal.setColumns(10);
		txtValorJornal.setBounds(106, 31, 86, 20);
		panel_2.add(txtValorJornal);
		
		txtCantDeDias = new JTextField();
		txtCantDeDias.setColumns(10);
		txtCantDeDias.setBounds(106, 57, 86, 20);
		panel_2.add(txtCantDeDias);
		
		txtExtra = new JTextField();
		txtExtra.setColumns(10);
		txtExtra.setBounds(106, 122, 86, 20);
		panel_2.add(txtExtra);
		
		JCheckBox chckbxEsVendedor = new JCheckBox("¿Es Vendedor?");
		chckbxEsVendedor.setBounds(9, 95, 97, 23);
		panel_2.add(chckbxEsVendedor);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 220, 520, 96);
		contentPane.add(textArea);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(182, 327, 86, 23);
		contentPane.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(296, 327, 86, 23);
		contentPane.add(btnEliminar);
	}
	
	public void iniciarManejadoresEventos() {
		btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
	}// Fin Manejadores Evento
	
	//limpiar
    public void limpiarCampos() {
        txtNroEmpl.setText(null);
        txtNombre.setText(null);
        txtApellido.setText(null);
        txtValorJornal.setText(null);
        txtCantDeDias.setText(null);
        txtExtra.setText(null);
        txtSueldo.setText(null);
    }
}
