package grafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import com.toedter.components.JSpinField;

import logica.Empleado;
import logica.Fecha;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import static grafica.MenuPrincipal.listaP;

public class GenEmp extends JDialog {
    static Empleado emp;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtApellido;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtCedula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GenEmp dialog = new GenEmp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GenEmp() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos Persona", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 212, 110);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblApellido = new JLabel("Apellido :");
				lblApellido.setBounds(10, 43, 71, 14);
				panel.add(lblApellido);
			}
			{
				txtApellido = new JTextField();
				txtApellido.setBounds(102, 40, 86, 20);
				panel.add(txtApellido);
				txtApellido.setColumns(10);
			}
			
			JLabel lblCedula = new JLabel("Cedula :");
			lblCedula.setBounds(10, 18, 46, 14);
			panel.add(lblCedula);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(102, 15, 86, 20);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Fecha de Ingreso", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(20, 132, 202, 85);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(32, 35, 124, 20);
		panel.add(dateChooser);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Categorias", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(232, 11, 181, 126);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Jefe de Vendedores", "Vendedor Senior", "Vendedor Junior", "Cadete"}));
		comboBox.setBounds(18, 15, 144, 22);
		panel_1.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String Cedula=txtCedula.getText();
						String Apellido=txtApellido.getText();
						String Categoria = (String) comboBox.getSelectedItem();
						int anio= dateChooser.getCalendar().get(Calendar.YEAR);
						int mes= dateChooser.getCalendar().get(Calendar.MONTH)+1;
						int dia= dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH);
						Fecha f = new Fecha(anio,mes,dia);
						emp = new Empleado(f,Categoria, Cedula, Apellido);
						JOptionPane.showMessageDialog(null,"Registrado Empleado Con exito","Creado",JOptionPane.INFORMATION_MESSAGE);
						listaP.agregar(emp);
						
					}
				});
				btnGuardar.setActionCommand("");
				buttonPane.add(btnGuardar);
				getRootPane().setDefaultButton(btnGuardar);
			}
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.exit(HIDE_ON_CLOSE);
					}
				});
				btnSalir.setActionCommand("");
				buttonPane.add(btnSalir);
			}
		}
	}
}
