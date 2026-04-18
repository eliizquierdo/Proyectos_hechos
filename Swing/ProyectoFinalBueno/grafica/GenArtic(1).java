package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logica.Articulo;
import logica.Fecha;
import logica.Importado;
import logica.Nacional;
import logica.Productos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.ButtonGroup;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import static grafica.MenuPrincipal.lista;
public class GenArtic extends JDialog {

    Nacional b;
    Importado a;
    Fecha f;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblPrecioCosto;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPrecioCosto;
	private JButton btnGuardar;
	private JTextField txtCalcular;
	private JButton btnLimpiarTexto;
	private JButton btnSalir;
	private JButton btnCalcular;
	private JCheckBox chkEsNacional;
	private JCheckBox chkEsImportado;
	private JCheckBox chkSubsidiado;
	private JComboBox combobox;
	private JTextField txtImpuesto;
	private JDateChooser dateChooser;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	
	
	public GenArtic() {
		iniciarComponentes();
		iniciarManejadoresEventos();
	}
	
		private void iniciarComponentes() {
			setBounds(100, 100, 539, 294);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 0, 241, 127);
			contentPane.add(panel);
			panel.setLayout(null);
			
			lblCodigo = new JLabel("Codigo :");
			lblCodigo.setBounds(10, 22, 93, 14);
			panel.add(lblCodigo);
			
			lblNombre = new JLabel("Nombre :");
			lblNombre.setBounds(10, 48, 93, 14);
			panel.add(lblNombre);
			
			lblPrecioCosto = new JLabel("Precio Costo:");
			lblPrecioCosto.setBounds(10, 76, 93, 14);
			panel.add(lblPrecioCosto);
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(132, 19, 86, 20);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(132, 45, 86, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtPrecioCosto = new JTextField();
			txtPrecioCosto.setBounds(132, 73, 86, 20);
			panel.add(txtPrecioCosto);
			txtPrecioCosto.setColumns(10);
			
			
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Calculo de Precio Venta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(272, 126, 241, 82);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			
			txtCalcular = new JTextField();
			txtCalcular.setBounds(121, 36, 110, 20);
			panel_1.add(txtCalcular);
			txtCalcular.setColumns(10);
			
	
			JPanel panel_1_1 = new JPanel();
			panel_1_1.setLayout(null);
			panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Fecha de vencimiento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1_1.setBounds(20, 129, 241, 82);
			contentPane.add(panel_1_1);
			
			dateChooser = new JDateChooser();
			dateChooser.setBounds(48, 29, 141, 20);
			panel_1_1.add(dateChooser);
			
			btnCalcular = new JButton("Calcular");
			btnCalcular.setBounds(10, 35, 89, 23);
			panel_1.add(btnCalcular);
			
			btnLimpiarTexto = new JButton("Limpiar texto");
			btnLimpiarTexto.setBounds(282, 219, 116, 23);
			contentPane.add(btnLimpiarTexto);
			
			btnSalir = new JButton("Salir");
			btnSalir.setBounds(424, 219, 89, 23);
			contentPane.add(btnSalir);
			
            JPanel panel_1_2 = new JPanel();
			panel_1_2.setLayout(null);
			panel_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nacional/Importado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1_2.setBounds(256, 0, 267, 122);
			contentPane.add(panel_1_2);
			
			chkEsNacional = new JCheckBox("\u00BFEs Nacional?");
			buttonGroup.add(chkEsNacional);
			
			chkEsNacional.setBounds(6, 20, 116, 23);
			panel_1_2.add(chkEsNacional);
			
			chkEsImportado = new JCheckBox("\u00BFEs Importado?");
			buttonGroup.add(chkEsImportado);
			
			chkEsImportado.setBounds(6, 46, 116, 23);
			panel_1_2.add(chkEsImportado);
			
			
			combobox = new JComboBox();
			combobox.setModel(new DefaultComboBoxModel(new String[] {"Montevideo", "Interior"}));
			combobox.setBounds(155, 20, 102, 22);
			panel_1_2.add(combobox);
			
			JLabel lblImpuesto = new JLabel("Impuesto :");
			lblImpuesto.setBounds(6, 97, 87, 14);
			panel_1_2.add(lblImpuesto);
			
			txtImpuesto = new JTextField();
			txtImpuesto.setBounds(107, 94, 86, 20);
			panel_1_2.add(txtImpuesto);
			txtImpuesto.setColumns(10);
			
			chkSubsidiado = new JCheckBox("Subsidiado");
			chkSubsidiado.setBounds(6, 72, 97, 23);
			panel_1_2.add(chkSubsidiado);
			
			btnGuardar = new JButton("Guardar");
			
			btnGuardar.setBounds(178, 219, 89, 23);
			contentPane.add(btnGuardar);
	}
		
		private void iniciarManejadoresEventos() {
			
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
	   
	
			
			btnLimpiarTexto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtCodigo.setText(null);
					txtNombre.setText(null);
				    dateChooser.setCalendar(null);
				    chkEsNacional.setSelected(false);
				    chkEsImportado.setSelected(false);
				    chkSubsidiado.setSelected(false);
					txtPrecioCosto.setText(null);
					txtCalcular.setText(null);					
				}
			});
	
                btnCalcular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int anio= dateChooser.getCalendar().get(Calendar.YEAR);
					int mes= dateChooser.getCalendar().get(Calendar.MONTH)+1;
					int dia= dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH);
					
					f = new Fecha(dia,mes,anio);
					int Codigo =Integer.valueOf(txtCodigo.getText());
					String Nombre = txtNombre.getText();
					double precioCosto=Double.valueOf(txtPrecioCosto.getText());
					if (chkEsNacional.isSelected()) {
						
						double PrecioCosto=Double.valueOf(txtPrecioCosto.getText());
						String departamento = (String) combobox.getSelectedItem();
						boolean subsidio=false;
						if (chkSubsidiado.isSelected()) {
							subsidio=true;
						}
												
						b=new Nacional(Codigo,Nombre,precioCosto,departamento, subsidio, f, PrecioCosto);
					txtCalcular.setText(String.valueOf(b.precioVenta()));
					
					}
					else {
						int impuesto=Integer.valueOf(txtImpuesto.getText());
						a=new Importado(Codigo,Nombre,precioCosto,f.getAnio(),impuesto,f,precioCosto);
							txtCalcular.setText(String.valueOf(a.precioVenta()));
						}
					
				}
		        });
                btnGuardar.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				if (chkEsNacional.isSelected()) {
        					
        					lista.agregar(b);
        					JOptionPane.showMessageDialog(null,"Creado Nacional Con exito","Creado",JOptionPane.INFORMATION_MESSAGE);
        				}
        				
        				else {
        				
        					lista.agregar(a);
        					JOptionPane.showMessageDialog(null,"Creado Importado Con exito","Creado",JOptionPane.INFORMATION_MESSAGE);
        				}
        			}
        		});
			
        

}
}	



