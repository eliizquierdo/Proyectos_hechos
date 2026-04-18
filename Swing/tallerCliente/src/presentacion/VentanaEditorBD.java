package presentacion;

import logica.Cliente;
import logica.DivisorDeConsultas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaEditorBD extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	
	private JPanel contentPane;
	private JScrollPane scrollCampoConsulta;
	private JTextArea campoConsulta;
	private JButton botonCorrer;
	private JButton botonLimpiar;
	
	private JScrollPane scrollRespuesta;
	private JTable tableRespuesta;
	private DefaultTableModel tableModel;
	
	private JScrollPane scrollTabla;
	private JTable tableTabla;
	private DefaultTableModel tableModelTable;
	
	private static VentanaEditorBD instancia;
	private JTextField textFieldPuerto;
	
	public static VentanaEditorBD getInstance() {
		if(instancia==null) {
			instancia = new VentanaEditorBD();
		}
		return instancia;
	}
	
	private VentanaEditorBD() {
		iniciarVentana();
		iniciarCampoConsulta();
		iniciarBotones();
		
		iniciarCampoRespuesta();
		iniciarCampoTabla();
		iniciarLabelPuerto();
		iniciarTextFieldPuerto();
		
		setVisible(true);
		botonLimpiar.requestFocusInWindow();//??
		
		
	}
	
	private void iniciarVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null);
		//getContentPane().setLayout(null);		//redundante?
		setResizable(false);
		setTitle("New Data Editor");
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	private void iniciarCampoConsulta(){
		scrollCampoConsulta = new JScrollPane();
		scrollCampoConsulta.setBounds(171, 30, 582, 136);
		contentPane.add(scrollCampoConsulta);
		campoConsulta= new JTextArea();
		campoConsulta.setFont(new Font("Monospaced", Font.PLAIN, 16));
		scrollCampoConsulta.setViewportView(campoConsulta);
	}
	
	private void iniciarBotones() {
		botonCorrer = new JButton("Ejecutar");
		botonCorrer.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonCorrer.setBounds(46, 32, 89, 23);
		botonCorrer.addActionListener(this);
		contentPane.add(botonCorrer);
		
		botonLimpiar = new JButton("Limpiar");
		botonLimpiar.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonLimpiar.setBounds(46, 66, 89, 23);
		botonLimpiar.addActionListener(this);
		contentPane.add(botonLimpiar);
	}
	
	private void iniciarCampoTabla() {
		scrollTabla = new JScrollPane();
		scrollTabla.setBounds(46, 188, 707, 156);
		contentPane.add(scrollTabla);
	}
	
	private void iniciarCampoRespuesta() {
		scrollRespuesta = new JScrollPane();
		scrollRespuesta.setBounds(46, 355, 707, 169);
		contentPane.add(scrollRespuesta);
		
		String[] nombresColumnas= {"Consulta","Resultado"};
		tableModel = new DefaultTableModel(nombresColumnas,0);
		
		tableRespuesta = new JTable(tableModel);
		tableRespuesta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableRespuesta.setEnabled(false);
		scrollRespuesta.setViewportView(tableRespuesta);
	}

	public void actualizarCampoTabla(ArrayList<ArrayList<String>> tabla) {
		@SuppressWarnings("unchecked")
		ArrayList<String>[] columnas = tabla.toArray(new ArrayList[tabla.size()]);
		//extrae el cabezal para crear el modelo
		String[] cabezal = new String[columnas.length];
		for(int i=0;i<columnas.length;i++) {
			cabezal[i]=columnas[i].get(0);
		}
		//crea el modelo
		tableModelTable=new DefaultTableModel(cabezal,0);
		tableTabla = new JTable(tableModelTable);
		tableTabla.setEnabled(false);
		scrollTabla.setViewportView(tableTabla);
		//carga las tuplas
		for(int y=1;y<columnas[0].size();y++) {
			String[] tupla = new String[columnas.length];
			for(int i=0;i<columnas.length;i++) {
				tupla[i]=columnas[i].get(y);
			}
			tableModelTable.addRow(tupla);
		}
	}
	
	public void actualizarCampoRespuesta(String consulta, String resultado) {
		Object[] fila = {consulta, resultado};
		tableModel.addRow(fila);
		//Para ir a la ultima respuesta automaticamente
		int lastRow = tableModel.getRowCount()-1;
		tableRespuesta.changeSelection(lastRow, 0, false, false);
	}
	
	private void iniciarTextFieldPuerto(){
		textFieldPuerto = new JTextField();
		textFieldPuerto.setText("1234");
		textFieldPuerto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldPuerto.setBounds(46, 134, 89, 32);
		contentPane.add(textFieldPuerto);
		textFieldPuerto.setColumns(10);
	}
	
	private void iniciarLabelPuerto() {
		JLabel labelPuerto = new JLabel("Puerto:");
		labelPuerto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPuerto.setBounds(46, 100, 89, 23);
		contentPane.add(labelPuerto);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(botonCorrer==e.getSource()) {
			
			
			
			String consultas=campoConsulta.getText();
			try{
				int p=Integer.parseInt(textFieldPuerto.getText());
				Cliente.getInstance().setPuerto(p);
				DivisorDeConsultas.getInstance().mandarConsultas(consultas);
			}catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "El valor del puerto es incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if(botonLimpiar==e.getSource()) {
			campoConsulta.setText("");
		}
	}
}