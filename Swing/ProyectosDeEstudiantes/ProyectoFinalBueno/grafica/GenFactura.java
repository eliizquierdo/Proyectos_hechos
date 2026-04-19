package grafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import static grafica.MenuPrincipal.lista;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import grafica.GenArtic;
import logica.Cliente;
import logica.Empleado;
import logica.Factura;
import logica.Fecha;
import logica.Productos;
import grafica.GenCliente;
import logica.Cliente;
import static grafica.MenuPrincipal.listaFac;
import static grafica.MenuPrincipal.listaP;
import static grafica.GenCliente.Cli;
import static grafica.GenEmp.emp;
import com.toedter.calendar.JDateChooser;
public class GenFactura extends JDialog {
	static Factura Fact;
    Fecha f;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtVenta;
	private JTextField txtVendedor;
	private JTextField txtCliente;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GenFactura dialog = new GenFactura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GenFactura() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblVenta = new JLabel("Venta :");
		lblVenta.setBounds(59, 135, 66, 14);
		contentPanel.add(lblVenta);
		
		JLabel lblRealizada = new JLabel("Realizada :");
		lblRealizada.setBounds(29, 160, 66, 18);
		contentPanel.add(lblRealizada);
		
		JLabel lblVendedor = new JLabel("Vendedor :");
		lblVendedor.setBounds(59, 189, 66, 14);
		contentPanel.add(lblVendedor);
		
		JLabel lblCliente = new JLabel("Cliente :");
		lblCliente.setBounds(59, 214, 46, 14);
		contentPanel.add(lblCliente);
		
		txtVenta = new JTextField();
		txtVenta.setBounds(135, 132, 86, 20);
		contentPanel.add(txtVenta);
		txtVenta.setColumns(10);
		
		txtVendedor = new JTextField();
		txtVendedor.setBounds(135, 186, 86, 20);
		contentPanel.add(txtVendedor);
		txtVendedor.setColumns(10);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(135, 211, 86, 20);
		contentPanel.add(txtCliente);
		txtCliente.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 434, 124);
		contentPanel.add(textArea);
		
		JButton btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.setBounds(281, 185, 143, 23);
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int Codigo =Integer.valueOf(txtCodigo.getText());
				if (lista.buscar(Codigo) != null) {
					listaFac.agregar(lista.buscar2(Codigo));
					textArea.setText(listaFac.toString());
		
			}
				else {
					JOptionPane.showMessageDialog(null,"No existe producto","Buscar",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		contentPanel.add(btnAgregarProducto);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setBounds(253, 164, 46, 14);
		contentPanel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(310, 161, 86, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(94, 158, 127, 20);
		contentPanel.add(dateChooser);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 232, 434, 29);
			contentPanel.add(buttonPane);
			{
				JButton btnGuardar = new JButton("Guardar");
				btnGuardar.setBounds(224, 5, 111, 23);
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int anio= dateChooser.getCalendar().get(Calendar.YEAR);
						int mes= dateChooser.getCalendar().get(Calendar.MONTH)+1;
						int dia= dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH);
						Productos venta=listaFac;
						Fecha realizada= new Fecha(anio,mes,dia);
						txtVendedor.setText(String.valueOf(Cli.getApellido()));
						txtCliente.setText(String.valueOf(emp.getApellido()));
						Fact= new Factura(listaFac, realizada,emp, Cli);
					}
				});
				buttonPane.setLayout(null);
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
				btnSalir.setBounds(355, 5, 74, 23);
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
	}
}

