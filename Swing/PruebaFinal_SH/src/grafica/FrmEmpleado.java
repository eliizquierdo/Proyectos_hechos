//FrmEmpleado.java
package grafica;

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
	private JTextField textField;

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
	}


}
