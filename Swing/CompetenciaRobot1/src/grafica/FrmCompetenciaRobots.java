package grafica;
//Luciano y Danison

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.*;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class FrmCompetenciaRobots extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtAnio;
	private JTextField txtVelocidad;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JTextField txtId;
	private JTextArea textArea;
	private JCheckBox chckbxCompetencia;
	ListaRobot listabot;

	public FrmCompetenciaRobots() {
		listabot = new ListaRobot();
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
				
		txtId = new JTextField();
		txtId.setBounds(64, 11, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(64, 42, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtAnio = new JTextField();
		txtAnio.setBounds(64, 73, 86, 22);
		contentPane.add(txtAnio);
		txtAnio.setColumns(10);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(18, 14, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNombre = new JLabel("nombre:");
		lblNombre.setBounds(10, 45, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblAnio = new JLabel("anio:");
		lblAnio.setBounds(18, 77, 46, 14);
		contentPane.add(lblAnio);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(172, 10, 89, 23);
		contentPane.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(172, 41, 89, 23);
		contentPane.add(btnEliminar);
		
		chckbxCompetencia = new JCheckBox("Competencia");
		chckbxCompetencia.setBounds(164, 73, 97, 23);
		contentPane.add(chckbxCompetencia);
		
		txtVelocidad = new JTextField();
		txtVelocidad.setBounds(64, 106, 86, 20);
		contentPane.add(txtVelocidad);
		txtVelocidad.setColumns(10);
		
		JLabel lblVelocidad = new JLabel("Velocidad");
		lblVelocidad.setBounds(10, 109, 46, 14);
		contentPane.add(lblVelocidad);
		
		textArea = new JTextArea();
		textArea.setBounds(18, 134, 406, 116);
		contentPane.add(textArea);
		   }
		    private void iniciarEventos() {
		        
		        btnAgregar.addActionListener(new ActionListener() {
		            
		            public void actionPerformed(ActionEvent e) {
		                agregarRobot();
		            }
		        });

		        btnEliminar.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	 try {
			                    int id = Integer.parseInt(txtId.getText()); 
								boolean eliminado = listabot.borrar(id); 

			                    if (eliminado) {
			                        JOptionPane.showMessageDialog(null, "Robot borrado con exito");
			                        actualizarListaRobots(); 
			                    } else {
			                        JOptionPane.showMessageDialog(null, "Robot no encontrado", "Error", JOptionPane.ERROR_MESSAGE);}
			                } catch (NumberFormatException ex) {
			                    JOptionPane.showMessageDialog(null, "Ingrese una Id valida", "Error", JOptionPane.ERROR_MESSAGE);
			                }
					}
				});
		    }

		    
		    private void agregarRobot() {
		    	if (!camposVacios()) {
			        
			        try {
			        	int id = Integer.parseInt(txtId.getText());
			    		String nombre = txtNombre.getText();
			    		int anio = Integer.parseInt(txtAnio.getText());
			    		double velocidad = Double.valueOf(txtVelocidad.getText());

			    		Robot robot;
			    		if (chckbxCompetencia.isSelected()) {
			    			robot = new RobotCompetencia(id, nombre, anio, velocidad);
			    		}else {
			    			robot = new Robot(id, nombre, anio);
			    		}
			    		listabot.insertar(robot);
			            actualizarListaRobots();
			            limpiarCampos();
			    				}catch(Exception ex) {
			    					JOptionPane.showMessageDialog(this, "Error, ingrese datos validos", "Error", JOptionPane.ERROR_MESSAGE);
			    				}
			    	 }
			    	 }

			private boolean camposVacios() {
				boolean vacio = false;
				if (txtNombre.getText().isEmpty() || txtId.getText().isEmpty() || txtAnio.getText().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Por favor, ingrese los datos", "datos vacantes" , JOptionPane.WARNING_MESSAGE);
					vacio = true;
				}
				return vacio;
			}

		    private void limpiarCampos() {
		        txtId.setText("");
		        txtNombre.setText("");
		        txtAnio.setText("");
		        txtVelocidad.setText("");
		        chckbxCompetencia.setSelected(false);
		    }

		    private void actualizarListaRobots() {
		        textArea.setText(listabot.listar());
		    }
		   
		    //agregado por la profe
		    public static void main(String[] args) {
				FrmCompetenciaRobots ventana=new FrmCompetenciaRobots();
				ventana.setVisible(true);

			}
}