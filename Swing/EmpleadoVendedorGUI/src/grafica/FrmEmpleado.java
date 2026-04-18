package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;		//diferencia entre JFrame y JDialog
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logica.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class FrmEmpleado extends JFrame{

	private JPanel contentPane;
	private JPanel panelEmpleado;
	private JPanel pnlSueldo;
	private JLabel lblApellido;
	private JLabel lblNombre;
	private JLabel lblJornal;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtJornal;
	private JButton btnCalcular;
	private JTextField txtCalcular;
	private JButton btnLimpiarTexto;
	private JPanel pnlBecado;
	private JCheckBox chkEsVendedor;
	private JLabel lblExtra;
	private JComboBox comboDias;
	private JTextField txtExtra;
	private JButton btnSalir;
	
	Empleado a;
	Vendedor b;

	
	public FrmEmpleado() {
		setTitle("Empleado");
		iniciarComponentes();
		iniciarManejadoresEventos();
	}
	
		private void iniciarComponentes() {
			
			setBounds(100, 100, 509, 291);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			panelEmpleado = new JPanel();
			panelEmpleado.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del empleado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelEmpleado.setBounds(10, 11, 230, 200);
			contentPane.add(panelEmpleado);
			panelEmpleado.setLayout(null);
			
			lblApellido = new JLabel("Apellido:");
			lblApellido.setBounds(10, 22, 93, 14);
			panelEmpleado.add(lblApellido);
			
			lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 48, 93, 14);
			panelEmpleado.add(lblNombre);
			
			lblJornal = new JLabel("Jornal:");
			lblJornal.setBounds(10, 82, 93, 14);
			panelEmpleado.add(lblJornal);
			
			txtApellido = new JTextField();
			txtApellido.setBounds(132, 19, 86, 20);
			panelEmpleado.add(txtApellido);
			txtApellido.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(132, 45, 86, 20);
			panelEmpleado.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtJornal = new JTextField();
			txtJornal.setBounds(132, 79, 86, 20);
			panelEmpleado.add(txtJornal);
			txtJornal.setColumns(10);
			
			JLabel lblDias = new JLabel("D\u00EDas");
			lblDias.setBounds(10, 120, 46, 14);
			panelEmpleado.add(lblDias);
			
			comboDias = new JComboBox();
			comboDias.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
			comboDias.setBounds(132, 116, 53, 22);
			panelEmpleado.add(comboDias);
			
			pnlSueldo = new JPanel();
			pnlSueldo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Sueldo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnlSueldo.setBounds(250, 129, 223, 82);
			contentPane.add(pnlSueldo);
			pnlSueldo.setLayout(null);
			
			btnCalcular = new JButton("Calcular");
			btnCalcular.setBounds(10, 35, 89, 23);
			pnlSueldo.add(btnCalcular);
			
			txtCalcular = new JTextField();
			txtCalcular.setBounds(121, 36, 92, 20);
			pnlSueldo.add(txtCalcular);
			txtCalcular.setColumns(10);
			
			pnlBecado = new JPanel();
			pnlBecado.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos para el vendedor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnlBecado.setBounds(250, 11, 223, 107);
			contentPane.add(pnlBecado);
			pnlBecado.setLayout(null);
			
			chkEsVendedor = new JCheckBox("\u00BFEs vendedor?");
			chkEsVendedor.setBounds(6, 23, 140, 23);
			pnlBecado.add(chkEsVendedor);
			
			lblExtra = new JLabel("Extra:");
			lblExtra.setBounds(10, 66, 86, 14);
			pnlBecado.add(lblExtra);
			
			txtExtra = new JTextField();
			txtExtra.setBounds(126, 63, 86, 20);
			pnlBecado.add(txtExtra);
			txtExtra.setColumns(10);
			
			btnSalir = new JButton("Salir");
			btnSalir.setBounds(384, 222, 89, 23);
			contentPane.add(btnSalir);
			
			btnLimpiarTexto = new JButton("Limpiar texto");
			btnLimpiarTexto.setBounds(250, 222, 127, 23);
			contentPane.add(btnLimpiarTexto);
	}
		
		private void iniciarManejadoresEventos() {
						
			btnLimpiarTexto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtApellido.setText(null);
					txtNombre.setText(null);
					txtJornal.setText(null);
					txtCalcular.setText(null);
					chkEsVendedor.setSelected(false);
					txtExtra.setText(null);
					
				}	
			});
			
			btnCalcular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					try {
						String apellido=txtApellido.getText();
						String nombre=txtNombre.getText();
						double jornal=Double.valueOf(txtJornal.getText());
						int dias=Integer.valueOf(comboDias.getSelectedItem().toString());
								
						if (chkEsVendedor.isSelected()) {
							double extra=Double.valueOf(txtExtra.getText());
							b=new Vendedor(apellido,nombre,jornal,dias,extra);
							txtCalcular.setText(String.valueOf(b.sueldo()));
						}
						else {
							a=new Empleado(apellido,nombre,jornal,dias);
							txtCalcular.setText(String.valueOf(a.sueldo()));
						}
					}catch(Exception ex) {
						txtCalcular.setText("No se pudo");
						JOptionPane.showMessageDialog(null,ex);
					}
				}
			});
			
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			
			
			
		}
		
		public static void main(String args[]) {
	    	
	    	FrmEmpleado a=new FrmEmpleado();
	    	a.setVisible(true);
	    }
}
