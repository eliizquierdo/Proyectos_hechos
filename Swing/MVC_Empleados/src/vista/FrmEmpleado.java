// vista/FrmEmpleado.java
package vista;

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
	private JTextField txtJornal;
	private JTextField txtDias;
	private JTextField txtExtras;
	private JCheckBox chckbxEsVendedorQM;
	private JTextArea textAreaEmpleados; // JTextArea para mostrar la lista de empleados
	private JTextField textField;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	public FrmEmpleado() {
		setTitle("Empleado o Vendedor");
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 400); // Aumenté el tamaño para dar espacio al JTextArea
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

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(101, 27, 140, 20);
		panel.add(textField);

		JButton btnNewButton = new JButton("Limpiar");
		btnNewButton.setBounds(152, 164, 89, 23);
		panel.add(btnNewButton);

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

		JLabel lblDias = new JLabel("Cant. de Dias:");
		lblDias.setBounds(10, 60, 81, 14);
		panel_2.add(lblDias);

		JLabel lblJornal = new JLabel("Valor  Jornal:");
		lblJornal.setBounds(10, 29, 81, 14);
		panel_2.add(lblJornal);

		txtJornal = new JTextField();
		txtJornal.setBounds(106, 26, 86, 20);
		panel_2.add(txtJornal);
		txtJornal.setColumns(10);

		txtDias = new JTextField();
		txtDias.setBounds(106, 57, 86, 20);
		panel_2.add(txtDias);
		txtDias.setColumns(10);

		chckbxEsVendedorQM = new JCheckBox("¿Es vendedor?");
		chckbxEsVendedorQM.setBounds(6, 100, 136, 23);
		panel_2.add(chckbxEsVendedorQM);
		chckbxEsVendedorQM.setSelected(false);

		txtExtras = new JTextField();
		txtExtras.setBounds(106, 130, 86, 20);
		panel_2.add(txtExtras);
		txtExtras.setColumns(10);

		JLabel lblExtra = new JLabel("Extra");
		lblExtra.setBounds(10, 130, 31, 14);
		panel_2.add(lblExtra);

		// Agregar JTextArea para mostrar la lista de empleados
		textAreaEmpleados = new JTextArea();
		textAreaEmpleados.setTabSize(10);
		textAreaEmpleados.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textAreaEmpleados);
		scrollPane.setBounds(10, 220, 520, 90); // Dimensiones del JTextArea
		contentPane.add(scrollPane);
		
		btnNewButton_1 = new JButton("Agregar");
		btnNewButton_1.setBounds(192, 327, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.setBounds(304, 327, 89, 23);
		contentPane.add(btnNewButton_2);
	}

	// Métodos para obtener valores de los campos
	public String getApellido() {
		return txtApellido.getText();
	}

	public String getNombre() {
		return txtNombre.getText();
	}

	public double getJornal() {
		return Double.parseDouble(txtJornal.getText());
	}

	public int getDias() {
		return Integer.parseInt(txtDias.getText());
	}

	public double getExtras() {
		return Double.parseDouble(txtExtras.getText());
	}

	public boolean isVendedor() {
		return chckbxEsVendedorQM.isSelected();
	}

	public JButton getBtnCalcular() {
		return btnCalcular;
	}

	public void setSueldo(double sueldo) {
		txtSueldo.setText(String.valueOf(sueldo));
	}

	public void actualizarListaEmpleados(String lista) {
		textAreaEmpleados.setText(lista);
	}
}
