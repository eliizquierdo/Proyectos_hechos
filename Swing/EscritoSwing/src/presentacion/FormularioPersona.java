package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
//import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


import java.awt.Font;
import javax.swing.SwingConstants;

public class FormularioPersona extends JDialog {

	private JPanel pnlSuperior, pnlInferior;
	private JButton btnAceptar, btnLimpiar;
	private JLabel lblNewLabel;
	private JLabel lblCiudad;
	private JTextField txtNombre;
	JRadioButton rdbtnMasculino,rdbtnFemenino;
		
	public FormularioPersona(){
		
		
		iniciarComponentes();
		iniciarManejadoresEventos();
	
	}

	private void iniciarComponentes() {
		
		setTitle("Formulario Personas");
		/*tama�o de la ventana, no es necesario */
		setLocationRelativeTo(null);
		setResizable(true);
		
		pnlSuperior =new JPanel();
		pnlSuperior.setBounds(0, 0, 434, 1);/*instanciamos el contenedor de los datos personales*/
		//pone un borde con titulo
		pnlSuperior.setBorder(BorderFactory.createTitledBorder("Datos Personales")); 
		//crea un borde vacio que genera un espacio de 10 px en cada lado del panel
		pnlSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));/*definimos el Layout de 4 filas, 2 columnas y espacios*/
		
		/*Definimos  los componentes del panel superior*/
		
		
		/*agregamos los componentes del panel superior*/
		pnlSuperior.setLayout(null);
		
		lblNewLabel = new JLabel("Ingreso de datos");
		lblNewLabel.setBounds(10, 10, 202, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		pnlSuperior.add(lblNewLabel);
		
		
		//grupo=new ButtonGroup();
		btnLimpiar= new JButton();
		btnLimpiar.setText("Limpiar");
		/*instanciamos el contenedor para los botones de la parte inferior*/
		pnlInferior=new JPanel();
		pnlInferior.setBounds(0, 229, 434, 33);
		/*Agregamos los componentes al Contenedor Inferior*/
		pnlInferior.add(btnLimpiar);
		getContentPane().setLayout(null);
		//agregamos cada panel a la zona correspondiendte
		getContentPane().add(pnlSuperior);
		getContentPane().add(pnlInferior);
		
		btnAceptar= new JButton();
		btnAceptar.setText("Aceptar");
		
		pnlInferior.add(btnAceptar);
		
		JLabel lblNewLabel_1 = new JLabel("Ingreso de datos");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(10, 12, 414, 33);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(61, 58, 46, 14);
		getContentPane().add(lblNombre);
		
		lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(61, 87, 46, 14);
		getContentPane().add(lblCiudad);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(170, 56, 149, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JComboBox cmbCiudad = new JComboBox();
		cmbCiudad.setBounds(170, 87, 149, 22);
		getContentPane().add(cmbCiudad);
		/*instanciamos el contenedor para Sexo*/
		JPanel pnlSexo = new JPanel();
		pnlSexo.setBorder(BorderFactory.createTitledBorder("Sexo"));
		pnlSexo.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		ButtonGroup grupo = new ButtonGroup();
		rdbtnMasculino = new JRadioButton("Masculino",false);
		grupo.add(rdbtnMasculino);
		rdbtnFemenino = new JRadioButton("Femenino",false);
		grupo.add(rdbtnFemenino);
		/*agregamos los componentes del panel Sexo*/
		pnlSexo.add(rdbtnFemenino);
		pnlSexo.add(rdbtnMasculino);
		
		
			
	}
	
	public void iniciarManejadoresEventos(){
		
		
		 
		 
		 
	}
	
	
	
	
	

/*********************************************************/

	public static void main(String[] args) {
		FormularioPersona vent=new FormularioPersona();
		vent.setVisible(true);
		vent.pack();
	}
}