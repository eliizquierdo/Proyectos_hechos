//Vanora y Nicolas 
package grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.ListaRobots;
import logica.RobotCompetencia;
import logica.Robot;


import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCompetenciaRobots extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtID;
	private JTextField txtAnio;
	private JTextField txtVel;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JTextArea txtaRobot;
	private JCheckBox chkCompetencia;
	ListaRobots rob;
	
	public FrmCompetenciaRobots() {
		rob = new ListaRobots();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		iniciarComponentes();
        iniciarEventos();
	}
	
		
	private void iniciarComponentes() {
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(204, 87, 89, 23);
		contentPane.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(313, 87, 89, 23);
		contentPane.add(btnEliminar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(79, 20, 96, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombreR = new JLabel("Nombre");
		lblNombreR.setBounds(20, 23, 49, 14);
		contentPane.add(lblNombreR);
		
		txtaRobot = new JTextArea();
		txtaRobot.setBounds(20, 128, 382, 124);
		contentPane.add(txtaRobot);
		
		chkCompetencia = new JCheckBox("Es de competencia?");
		chkCompetencia.setBounds(282, 19, 148, 23);
		contentPane.add(chkCompetencia);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(20, 53, 49, 14);
		contentPane.add(lblID);
		
		JLabel lblAnio = new JLabel("Año:");
		lblAnio.setBounds(20, 87, 49, 14);
		contentPane.add(lblAnio);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(79, 50, 96, 20);
		contentPane.add(txtID);
		
		txtAnio = new JTextField();
		txtAnio.setColumns(10);
		txtAnio.setBounds(79, 84, 96, 20);
		contentPane.add(txtAnio);
		
		txtVel = new JTextField();
		txtVel.setColumns(10);
		txtVel.setBounds(316, 50, 96, 20);
		contentPane.add(txtVel);
		
		JLabel lblVelocidad = new JLabel("Velocidad:");
		lblVelocidad.setBounds(227, 53, 66, 14);
		contentPane.add(lblVelocidad);
	}
	
	private void iniciarEventos() {
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarRobot();
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	                    int ID = Integer.parseInt(txtID.getText()); 
						boolean eliminado = rob.eliminarRobot(ID); 

	                    if (eliminado) {
	                        JOptionPane.showMessageDialog(null, "Robot eliminado con éxito.");
	                        actualizarB(); 
	                    } else {
	                        JOptionPane.showMessageDialog(null, "No se encontró un robot con ese ID.", 
	                                                      "Error", JOptionPane.ERROR_MESSAGE);
	                    }
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(null, "Ingrese un código válido.", 
	                                                  "Error", JOptionPane.ERROR_MESSAGE);
	                }
			}
		});
	}
	
	private void ingresarRobot() {
		if (!camposVacios()) {
			try {
				String Nombre = txtNombre.getText();
				int ID = Integer.valueOf(txtID.getText());
				int Anio = Integer.valueOf(txtAnio.getText());
				double velocidad = Double.valueOf(txtVel.getText());
				
				Robot robot;
				
				if (chkCompetencia.isSelected()) {
	                robot = new RobotCompetencia(ID, Nombre, Anio, velocidad);
	            } else {
	                robot = new Robot(ID, Nombre, Anio);
	            }
				
				rob.insertar(robot);
				actualizarB();
				limpiarCampos();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(this, "Error, ingrese valores", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void actualizarB() {
		 txtaRobot.setText(rob.robot());
	}
	
	private boolean camposVacios() {
		boolean vacio = false;
		if (txtNombre.getText().isEmpty() || txtID.getText().isEmpty() || txtAnio.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos", "Campos Vacios" , JOptionPane.WARNING_MESSAGE);
			vacio = true;
		}
		return vacio;
	}
	
	private void limpiarCampos() {
        txtID.setText("");
        txtNombre.setText("");
        txtAnio.setText("");
        txtVel.setText("");
        chkCompetencia.setSelected(false);
    }
	
	public static void main(String[] args) {
		FrmCompetenciaRobots vent=new FrmCompetenciaRobots();
		vent.setVisible(true);
	}
	
}

