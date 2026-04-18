//Hecho por Maria llanes y Ezequiel Elías
package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import logica.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCompetenciaRobots extends JFrame {

	private static final long serialVersionUID = 1L;
	private ListaRobot listaRob;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtAnio;
	private JCheckBox chckbxIngresado;
	private JTextField txtVelocidad;	
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JTextArea txtaListaRobot;
	
	public FrmCompetenciaRobots() {
		
		
		listaRob = new ListaRobot();
		iniciarComponentes();
		iniciarManejadoresEventos();
	}
	
	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 237, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del Robot", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(171, 215, 228));
		panel.setBounds(10, 11, 288, 164);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblID = new JLabel("ID del Robot:");
		lblID.setFont(new Font("Verdana", Font.BOLD, 10));
		lblID.setBounds(10, 40, 84, 14);
		panel.add(lblID);
		
		JLabel lblNombre = new JLabel("Nombre del robot:");
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 10));
		lblNombre.setBounds(10, 81, 103, 14);
		panel.add(lblNombre);
		
		JLabel lblAnio = new JLabel("Año de ingreso:");
		lblAnio.setFont(new Font("Verdana", Font.BOLD, 10));
		lblAnio.setBounds(10, 124, 103, 14);
		panel.add(lblAnio);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtID.setBounds(139, 37, 139, 20);
		panel.add(txtID);
		txtID.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtNombre.setColumns(10);
		txtNombre.setBounds(139, 77, 139, 20);
		panel.add(txtNombre);
		
		txtAnio = new JTextField();
		txtAnio.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtAnio.setColumns(10);
		txtAnio.setBounds(139, 121, 139, 20);
		panel.add(txtAnio);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos de competencia", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(171, 215, 228));
		panel_1.setBounds(322, 11, 251, 109);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		chckbxIngresado = new JCheckBox("Participa en la competencia?");
		chckbxIngresado.setBackground(new Color(220, 237, 237));
		chckbxIngresado.setFont(new Font("Verdana", Font.BOLD, 11));
		chckbxIngresado.setBounds(10, 24, 221, 23);
		panel_1.add(chckbxIngresado);
		
		JLabel lblVelocidad = new JLabel("Velocidad:");
		lblVelocidad.setFont(new Font("Verdana", Font.BOLD, 10));
		lblVelocidad.setBounds(10, 68, 84, 14);
		panel_1.add(lblVelocidad);
		
		txtVelocidad = new JTextField();
		txtVelocidad.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtVelocidad.setColumns(10);
		txtVelocidad.setBounds(82, 65, 139, 20);
		panel_1.add(txtVelocidad);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Verdana", Font.BOLD, 11));
		btnAgregar.setBounds(346, 142, 89, 23);
		contentPane.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Verdana", Font.BOLD, 11));
		btnEliminar.setBounds(457, 142, 89, 23);
		contentPane.add(btnEliminar);
		
		txtaListaRobot = new JTextArea();
		txtaListaRobot.setBounds(10, 186, 563, 208);
		contentPane.add(txtaListaRobot);
	}
	
	private void iniciarManejadoresEventos() {
		
		btnAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ingresarRobot();
				
			}
		});
		
	}
	
	private void ingresarRobot() {	
    	if (!camposVacios()) {
    		try {
    			int id = Integer.valueOf(txtID.getText());
	    		String nombre = txtNombre.getText();
	    		int anio = Integer.valueOf(txtAnio.getText());
	    		double velocidad;   
		            if (chckbxIngresado.isSelected()) {  
		                velocidad = Double.parseDouble(txtVelocidad.getText());  
		            } else {  
		                velocidad = 0;  
		            }  
	    		RobotCompetencia r = new RobotCompetencia(id, nombre, anio, velocidad);
		    	listaRob.agregar(r);
		        actualizar();	
	        	
    		}catch(Exception ex) {
    			JOptionPane.showMessageDialog(this, "Error, ingrese valores", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    	}
    }

   private void actualizar() {
	   txtaListaRobot.setText(listaRob.listar());
   }
    
    private boolean camposVacios() {
    	boolean vacio = false;
    	
    	if (chckbxIngresado.isSelected()) {
    		if (txtID.getText().isEmpty() || txtNombre.getText().isEmpty() || txtAnio.getText().isEmpty() || txtVelocidad.getText().isEmpty()) {
       		 JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos", "Campos Vacios" , JOptionPane.WARNING_MESSAGE);
       		 vacio = true;
       	}
    	}else {
    		if (txtID.getText().isEmpty() || txtNombre.getText().isEmpty() || txtAnio.getText().isEmpty()) {
    		 JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos", "Campos Vacios" , JOptionPane.WARNING_MESSAGE);
    		 vacio = true;
    	}
    	}
    	return vacio;
    	
    }
    
    //agregado por la profe
    public static void main(String[] args) {
		FrmCompetenciaRobots ventana=new FrmCompetenciaRobots();
		ventana.setVisible(true);

	}
    
}
