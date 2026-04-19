package grafica;

import java.awt.EventQueue;

import javax.swing.JOptionPane;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;

import logica.*;
import logica.clasesDeArticulo.*;
import javax.swing.JScrollBar;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JCheckBox;

public class VentanaPrincipal extends JFrame {

	//----------Variables, objetos y componentes----------------
	
	Productos listaDeProductos = new Productos();
	
	static int num = 21;
	
	ArrayList<Articulo> lista = new ArrayList<Articulo>();
	
	int code = 1;
	
	private JPanel contentPane;
	private JPanel buscadorPanel;
	private JTextField buscarInput;
	private JButton buscarBtn;
	
	JButton addProductBtn = new JButton("CREAR PORDUCTO");
	
	JPanel importadoPanel = new JPanel();

	JPanel aniadirPanel = new JPanel();
	private JPanel productPanel;
	private JButton aniadirBtn;
	private JButton verBtn;
	private final JPanel verPanel = new JPanel();
	private JTextField nombreInput;
	private JTextField precioInput;
	private JTextField unidadesInput;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel codigoFactura;
	private JLabel precioFactura;
	private JLabel unidadesFactura;
	private JLabel nombreFactura;

	JComboBox queEsCombo = new JComboBox();
	private JTextField anioInput;
	private JTextField mesInput;
	private JTextField diaInput;
	private JTextField impuestoInput;
	private JLabel lblImpuesto;
	private JPanel nacionalPanel;
	private JLabel lblDepartamento;
	private JTextField departamentoInput;
	private JLabel lblSubsidiado;

	JCheckBox subsidiadoCheck = new JCheckBox("Subsidiado");
	private JPanel importadoFactura;
	private JLabel fechaLabel;
	private JLabel Fecha;
	private JLabel impuestoLabel;
	private JLabel lblImpuesto_1;
	private JPanel nacionalFactura;
	private JLabel lblDepartamento_1;
	private JLabel lblNewLabel_6;
	private JLabel departamentoLabel;
	private JLabel subsidiadoLabel;

	
	//Llamamos A las funciones
	public VentanaPrincipal() {
		setTitle("VENTAS");
		iniciarComponentes();
		iniciarManejadoresEventos();
	}
	
	//-----------------COMPONENTES-----------------
	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 493);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		aniadirPanel.setBackground(new Color(114, 159, 207));
		aniadirPanel.setBorder(null);
		aniadirPanel.setBounds(12, 63, 525, 382);
		contentPane.add(aniadirPanel);
		aniadirPanel.setLayout(null);
		
		productPanel = new JPanel();
		productPanel.setBounds(10, 23, 501, 347);
		aniadirPanel.add(productPanel);
		productPanel.setLayout(null);
		
		JLabel nombreLbl = new JLabel("NOMBRE");
		nombreLbl.setBounds(41, 45, 144, 14);
		productPanel.add(nombreLbl);
		
		JLabel lblNewLabel_2 = new JLabel("PRECIO COSTO");
		lblNewLabel_2.setBounds(41, 90, 117, 14);
		productPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("UNIDADES");
		lblNewLabel_3.setBounds(43, 132, 92, 14);
		productPanel.add(lblNewLabel_3);
		addProductBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addProductBtn.setBorder(null);
		addProductBtn.setBounds(307, 237, 163, 38);
		productPanel.add(addProductBtn);
		addProductBtn.setForeground(new Color(255, 255, 255));
		addProductBtn.setBackground(new Color(0, 102, 255));
		
		nombreInput = new JTextField();
		nombreInput.setColumns(10);
		nombreInput.setBorder(null);
		nombreInput.setBackground(new Color(255, 255, 255));
		nombreInput.setBounds(307, 45, 163, 31);
		productPanel.add(nombreInput);
		
		precioInput = new JTextField();
		precioInput.setColumns(10);
		precioInput.setBorder(null);
		precioInput.setBackground(new Color(255, 255, 255));
		precioInput.setBounds(307, 90, 163, 31);
		productPanel.add(precioInput);
		
		unidadesInput = new JTextField();
		unidadesInput.setColumns(10);
		unidadesInput.setBorder(null);
		unidadesInput.setBackground(new Color(255, 255, 255));
		unidadesInput.setBounds(307, 132, 163, 31);
		productPanel.add(unidadesInput);
		
		
		queEsCombo.setModel(new DefaultComboBoxModel(new String[] {"Importado", "Nacional"}));
		queEsCombo.setBounds(41, 178, 109, 24);
		productPanel.add(queEsCombo);
		
		importadoPanel.setBounds(40, 214, 255, 121);
		productPanel.add(importadoPanel);
		importadoPanel.setLayout(null);
		
		anioInput = new JTextField();
		anioInput.setBounds(129, 12, 114, 19);
		importadoPanel.add(anioInput);
		anioInput.setColumns(10);
		
		mesInput = new JTextField();
		mesInput.setColumns(10);
		mesInput.setBounds(129, 43, 114, 19);
		importadoPanel.add(mesInput);
		
		diaInput = new JTextField();
		diaInput.setColumns(10);
		diaInput.setBounds(129, 70, 114, 19);
		importadoPanel.add(diaInput);
		
		JLabel lblAnio = new JLabel("Anio");
		lblAnio.setBounds(12, 14, 70, 15);
		importadoPanel.add(lblAnio);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setBounds(12, 45, 70, 15);
		importadoPanel.add(lblMes);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(12, 72, 70, 15);
		importadoPanel.add(lblDia);
		
		impuestoInput = new JTextField();
		impuestoInput.setColumns(10);
		impuestoInput.setBounds(129, 101, 114, 19);
		importadoPanel.add(impuestoInput);
		
		lblImpuesto = new JLabel("Impuesto");
		lblImpuesto.setBounds(12, 99, 70, 15);
		importadoPanel.add(lblImpuesto);
		
		nacionalPanel = new JPanel();
		nacionalPanel.setBounds(0, 0, 0, 0);
		productPanel.add(nacionalPanel);
		nacionalPanel.setLayout(null);
		
		lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(12, 12, 117, 17);
		nacionalPanel.add(lblDepartamento);
		
		departamentoInput = new JTextField();
		departamentoInput.setBounds(145, 11, 114, 19);
		nacionalPanel.add(departamentoInput);
		departamentoInput.setColumns(10);
		
		lblSubsidiado = new JLabel("Subsidiado");
		lblSubsidiado.setBounds(12, 46, 117, 19);
		nacionalPanel.add(lblSubsidiado);
		
		subsidiadoCheck.setBounds(145, 44, 129, 23);
		nacionalPanel.add(subsidiadoCheck);
		
		JLabel lblProductos = new JLabel("Compra y Venta");
		lblProductos.setFont(new Font("Dialog", Font.BOLD, 19));
		lblProductos.setBounds(12, 0, 219, 26);
		contentPane.add(lblProductos);
		
		aniadirBtn = new JButton("CREAR");
		aniadirBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		aniadirBtn.setBorder(null);
		aniadirBtn.setForeground(new Color(255, 255, 255));
		aniadirBtn.setBackground(new Color(32, 74, 135));
		aniadirBtn.setBounds(12, 36, 87, 25);
		contentPane.add(aniadirBtn);
		verPanel.setBackground(new Color(0, 0, 0));
		verPanel.setBounds(0,0,0,0);
		contentPane.add(verPanel);
		verPanel.setLayout(null);
		

		
		buscadorPanel = new JPanel();
		buscadorPanel.setBackground(new Color(0, 0, 51));
		buscadorPanel.setBounds(370, 10, 164, 71);
		verPanel.add(buscadorPanel);
		buscadorPanel.setLayout(null);
		
		buscarInput = new JTextField();
		buscarInput.setBorder(null);
		buscarInput.setCaretColor(new Color(52, 101, 164));
		buscarInput.setSelectionColor(new Color(52, 101, 164));
		buscarInput.setSelectedTextColor(new Color(255, 255, 255));
		buscarInput.setColumns(10);
		buscarInput.setBounds(0, 12, 119, 27);
		buscadorPanel.add(buscarInput);
		
		buscarBtn = new JButton("");
		buscarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buscarBtn.setBorder(null);
		buscarBtn.setForeground(UIManager.getColor("List.dropLineColor"));
		buscarBtn.setBackground(new Color(52, 101, 164));
		buscarBtn.setIcon(new ImageIcon("/home/benjamin/Imágenes/search.png"));
		buscarBtn.setBounds(119, 12, 28, 27);
		buscadorPanel.add(buscarBtn);
		
		verBtn = new JButton("VER");
		verBtn.setForeground(new Color(255, 255, 255));
		verBtn.setBorder(null);
		verBtn.setBackground(new Color(78, 154, 6));
		verBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		verBtn.setBounds(111, 36, 97, 26);
		contentPane.add(verBtn);

		buscadorPanel.setBounds(370, 10, 150, 40);
		
		panel = new JPanel();
		panel.setBounds(67, 62, 365, 280);
		verPanel.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("FACTURA");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(129, 11, 101, 14);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(10, 48, 94, 27);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_4 = new JLabel("Codigo");
		lblNewLabel_4.setBounds(10, 87, 94, 34);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Precio");
		lblNewLabel_5.setBounds(10, 137, 46, 14);
		panel.add(lblNewLabel_5);
		
		codigoFactura = new JLabel("");
		codigoFactura.setBounds(213, 94, 101, 27);
		panel.add(codigoFactura);
		
		nombreFactura = new JLabel("");
		nombreFactura.setBounds(213, 48, 115, 14);
		panel.add(nombreFactura);
		
		precioFactura = new JLabel("");
		precioFactura.setBounds(213, 137, 101, 14);
		panel.add(precioFactura);
		
		JLabel lblNewLabel_5_1 = new JLabel("Unidades");
		lblNewLabel_5_1.setBounds(10, 167, 78, 14);
		panel.add(lblNewLabel_5_1);
		
		unidadesFactura = new JLabel("");
		unidadesFactura.setBounds(185, 167, 115, 14);
		panel.add(unidadesFactura);
		
		importadoFactura = new JPanel();
		importadoFactura.setBounds(10, 189, 260, 79);
		panel.add(importadoFactura);
		importadoFactura.setLayout(null);
		
		fechaLabel = new JLabel("");
		fechaLabel.setBounds(92, 12, 116, 15);
		importadoFactura.add(fechaLabel);
		
		Fecha = new JLabel("Fecha:");
		Fecha.setBounds(12, 12, 70, 15);
		importadoFactura.add(Fecha);
		
		impuestoLabel = new JLabel("");
		impuestoLabel.setBounds(94, 39, 70, 15);
		importadoFactura.add(impuestoLabel);
		
		lblImpuesto_1 = new JLabel("Impuesto:");
		lblImpuesto_1.setBounds(12, 40, 83, 15);
		importadoFactura.add(lblImpuesto_1);
		
		nacionalFactura = new JPanel();
		nacionalFactura.setBounds(0,0,0,0);
		panel.add(nacionalFactura);
		nacionalFactura.setLayout(null);
		
		lblDepartamento_1 = new JLabel("Departamento");
		lblDepartamento_1.setBounds(12, 12, 120, 15);
		nacionalFactura.add(lblDepartamento_1);
		
		lblNewLabel_6 = new JLabel("Subsidiado");
		lblNewLabel_6.setBounds(12, 39, 120, 15);
		nacionalFactura.add(lblNewLabel_6);
		
		departamentoLabel = new JLabel("");
		departamentoLabel.setBounds(126, 12, 105, 15);
		nacionalFactura.add(departamentoLabel);
		
		subsidiadoLabel = new JLabel("");
		subsidiadoLabel.setBounds(126, 39, 70, 15);
		nacionalFactura.add(subsidiadoLabel);

	}
	
	//--------------FUNCIONES Y EVENTOS---------------
	private void iniciarManejadoresEventos() {
		addProductBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(listaDeProductos);
				System.out.println(queEsCombo.getSelectedItem());
				Articulo a = new Articulo();
				
				if(queEsCombo.getSelectedItem() == "Nacional") {
					try {
						System.out.println(subsidiadoCheck.isSelected());
						Nacional n1 = new Nacional();					
						n1.setCodigo(code);
						code ++;
						n1.setNombre(nombreInput.getText());
						n1.setPrecioCosto(Double.parseDouble(precioInput.getText()));
						n1.setUnidades(Integer.parseInt(unidadesInput.getText()));
						n1.setDepartamento(departamentoInput.getText());
						n1.setSubsidiado(subsidiadoCheck.isSelected());
						
						lista.add(n1);
						JOptionPane.showMessageDialog(null, n1.getNombre() + " se ha agregado correctamente");
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Revisa que los campos esten llenados correctamente!");
					}

				}
				else if(queEsCombo.getSelectedItem() == "Importado") {
					Importado i1 = new Importado();
					try {
						i1.setCodigo(code);
						code ++;
						i1.setNombre(nombreInput.getText());
						i1.setPrecioCosto(Double.parseDouble(precioInput.getText()));
						i1.setUnidades(Integer.parseInt(unidadesInput.getText()));
						i1.setAnioImportacion(new Fecha(Integer.parseInt(mesInput.getText()),Integer.parseInt(diaInput.getText()),Integer.parseInt(anioInput.getText())));
						i1.setImpuesto(Double.valueOf(impuestoInput.getText()));
						
						lista.add(i1);
						JOptionPane.showMessageDialog(null, i1.getNombre() + " se ha agregado correctamente");
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Revisa que los campos esten llenados correctamente!");
					}
				}
				listaDeProductos.setLista(lista);
				System.out.println(lista);
				System.out.println(lista.indexOf(a));
				
				for(Articulo ar : lista) {
					System.out.println(ar.getNombre());
				}
			}
		});
		
		queEsCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(queEsCombo.getSelectedItem() == "Importado") {
					nacionalPanel.setBounds(0, 0, 0, 0);
					importadoPanel.setBounds(40, 214, 255, 121);
				}
				else {
					importadoPanel.setBounds(0, 0, 0, 0);
					nacionalPanel.setBounds(40, 214, 255, 121);
					System.out.println("noo");
				}
			}
		});
		
		verBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aniadirPanel.setBounds(0,0,0,0);
				verPanel.setBounds(12, 63, 525, 382);
				buscadorPanel.setBounds(370, 10, 150, 40);

			}
		});
		aniadirBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verPanel.setBounds(0,0,0,0);
				aniadirPanel.setBounds(12, 63, 525, 382);
				
			}
		});
		
		
		buscarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					nombreFactura.setText(listaDeProductos.buscar(Integer.parseInt(buscarInput.getText())).getNombre());
					precioFactura.setText(Double.toString(listaDeProductos.buscar(Integer.parseInt(buscarInput.getText())).getPrecioCosto()));
					codigoFactura.setText(Integer.toString(listaDeProductos.buscar(Integer.parseInt(buscarInput.getText())).getCodigo()));
					unidadesFactura.setText(Integer.toString(listaDeProductos.buscar(Integer.parseInt(buscarInput.getText())).getUnidades()));
					
					if(listaDeProductos.buscar(Integer.parseInt(buscarInput.getText())).toString().indexOf("Importado") >= 0) {
						importadoFactura.setBounds(10, 189, 260, 79);
						nacionalFactura.setBounds(0,0,0,0);
						int startFecha = listaDeProductos.buscar(Integer.parseInt(buscarInput.getText())).toString().indexOf("fechainicio") + 11;
						int endFecha = listaDeProductos.buscar(Integer.parseInt(buscarInput.getText())).toString().indexOf("fechafinal");
						
						int startImpuesto = listaDeProductos.buscar(Integer.parseInt(buscarInput.getText())).toString().indexOf("inicioImpuesto") + 14;
						int endImpuesto = listaDeProductos.buscar(Integer.parseInt(buscarInput.getText())).toString().indexOf("finalImpuesto");
						
						System.out.println(listaDeProductos.buscar(Integer.parseInt(buscarInput.getText())).toString() + "---" + startFecha + " " + endFecha);
						
						fechaLabel.setText(listaDeProductos.buscar(Integer.parseInt(buscarInput.getText())).toString().substring(startFecha, endFecha));
						
						impuestoLabel.setText(listaDeProductos.buscar(Integer.parseInt(buscarInput.getText())).toString().substring(startImpuesto, endImpuesto));
					}
					else {
						nacionalFactura.setBounds(10, 189, 260, 79);
						importadoFactura.setBounds(0,0,0,0);
						
						int startDepartamento = listaDeProductos.buscar(Integer.parseInt(buscarInput.getText())).toString().indexOf("departamentoInicio") + 19;
						int endDepartamento = listaDeProductos.buscar(Integer.parseInt(buscarInput.getText())).toString().indexOf("departamentoFinal");
						
						int startSubsidiado = listaDeProductos.buscar(Integer.parseInt(buscarInput.getText())).toString().indexOf("subsidiadoInicio") + 16;
						int endSubsidiado = listaDeProductos.buscar(Integer.parseInt(buscarInput.getText())).toString().indexOf("subsidiadoFinal");
						
						departamentoLabel.setText(listaDeProductos.buscar(Integer.parseInt(buscarInput.getText())).toString().substring(startDepartamento, endDepartamento));
						System.out.println(listaDeProductos.buscar(Integer.parseInt(buscarInput.getText())).toString().substring(startSubsidiado, endSubsidiado));
						if (listaDeProductos.buscar(Integer.parseInt(buscarInput.getText())).toString().substring(startSubsidiado, endSubsidiado).indexOf("true") >= 0 ) {
							subsidiadoLabel.setText("SI");
						}
						else {
							subsidiadoLabel.setText("NO");
						}
					}
				}
				catch(Exception ex) {
					buscarInput.setText("ERROR");
					System.out.println(ex);
				}
			} 
		});
	} 
}
