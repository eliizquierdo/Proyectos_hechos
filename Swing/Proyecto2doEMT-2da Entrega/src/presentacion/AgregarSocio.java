package presentacion;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logica.*;
 
@SuppressWarnings("serial")
public class AgregarSocio extends JDialog implements ActionListener {
	
	//Aplicando patron Singleton
	//El unico objeto (instancia) de AgregarSocio durante toda la ejecucion
	private static AgregarSocio instancia;
	
	private JPanel pnlSuperior;
	private JLabel lblCedula, lblNombre, lblApellido, lblGrupo, lblAsignatura, lblDireccion, lblTelefono, lblTipo ;
	private JTextField txtCedula, txtNombre, txtApellido, txtDireccion, txtAsignatura, txtGrupo, txtTelefono;
	private JButton btnGuardar, btnLimpiar;
	private JComboBox<String> cmbTipo;
	
	//constructor privado
	private AgregarSocio(){
		setTitle("Agregar Socio");
		setLocationRelativeTo(null);
		setResizable(true);
		iniciarComponentes();
		pack();
	}
	
	//salvo la primera vez (null), siempre devuelve la misma instancia
	public static AgregarSocio getInstancia(){	
		if (instancia==null)
			instancia = new AgregarSocio();
		return instancia;
	}
	
	private void iniciarComponentes() {
		pnlSuperior =new JPanel();   
		pnlSuperior.setLayout(new GridLayout(9,2,5,5)); 
		/*genera espacio vacio alrededor para que no que todo contra los bordes*/
		pnlSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		/*Definimos  los componentes del panel superior*/
		lblCedula=new JLabel("Cedula:"); 
		txtCedula= new JTextField();
		
		lblNombre= new JLabel("Nombre:"); 
		txtNombre= new JTextField();
		
		lblApellido= new JLabel("Apellido:");
		txtApellido= new JTextField();

		lblDireccion= new JLabel("Direccion:");
		txtDireccion = new JTextField();

		lblTelefono= new JLabel("Telefono:");
		txtTelefono= new JTextField();
		
		lblTipo= new JLabel("Tipo de Socio:");
		
		cmbTipo= new JComboBox<String>();
		cmbTipo.addItem("Alumno");
		cmbTipo.addItem("Docente");
		cmbTipo.addActionListener(this);
		
		lblGrupo= new JLabel("Grupo:");
		txtGrupo = new JTextField();
		txtGrupo.setEditable(false);	
		
		lblAsignatura= new JLabel("Asignatura:");
		txtAsignatura = new JTextField();
		txtAsignatura.setEditable(false);	
		
		btnGuardar= new JButton("Guardar");
		btnGuardar.addActionListener(this);
		
		btnLimpiar= new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
				
		/*agregamos los componentes del panel superior*/
		pnlSuperior.add(lblCedula);
		pnlSuperior.add(txtCedula);
		pnlSuperior.add(lblNombre);
		pnlSuperior.add(txtNombre);
		pnlSuperior.add(lblApellido);
		pnlSuperior.add(txtApellido);
		pnlSuperior.add(lblDireccion);
		pnlSuperior.add(txtDireccion);
		pnlSuperior.add(lblTelefono);
		pnlSuperior.add(txtTelefono);
		pnlSuperior.add(lblTipo);
		pnlSuperior.add(cmbTipo);
		pnlSuperior.add(lblGrupo);
		pnlSuperior.add(txtGrupo);
		pnlSuperior.add(lblAsignatura);
		pnlSuperior.add(txtAsignatura);
		pnlSuperior.add(btnLimpiar);
		pnlSuperior.add(btnGuardar);
		//agregamos el panel al JFrame		
		this.add(pnlSuperior);
	}
	
	public void actionPerformed(ActionEvent evento) {
		
		if(cmbTipo.getSelectedItem()== "Alumno"){
			
			txtAsignatura.setText("");			

			txtGrupo.setEditable(true);	
			
			txtAsignatura.setEditable(false);
			
			if (evento.getSource()==btnGuardar){
				
				Alumno alumno1 =new Alumno();
				
				try{
					 int auxCed=Integer.parseInt(txtCedula.getText());
			         String auxNom=txtNombre.getText();
			         String auxApe=txtApellido.getText();
			         String auxDireccion= txtDireccion.getText();
			         int auxTelefono=Integer.parseInt(txtTelefono.getText());
			         String auxGrupo= txtGrupo.getText();
			         
			         if(ControladorLogica.getInstancia().devolverSocios().obtenerXCedula(auxCed) == null) {

				         alumno1.setCedula(auxCed);
				         alumno1.setNombre(auxNom);
				         alumno1.setApellido(auxApe);
				         alumno1.setDireccion(auxDireccion);
				         alumno1.setTelefono(auxTelefono);
				         alumno1.setGrupo(auxGrupo);
				     	
				         JOptionPane.showMessageDialog(null, "Datos guardados correctamente  \n","Mensaje ",JOptionPane.INFORMATION_MESSAGE);
					    
				         	
				    }else {
				    	JOptionPane.showMessageDialog(this, "Socio anteriormente agregado.", "Error!", JOptionPane.ERROR_MESSAGE);
						 } 
				}catch (Exception e){
			        	 System.out.println("el error fue: " +e);
						 JOptionPane.showMessageDialog(null, "Datos incorrectos, intente de nuevo  \n","Error",JOptionPane.ERROR_MESSAGE);	
				}        
				//agrego el alumno a la lista de alumnos, a la que accedo a traves del controlador
				ControladorLogica.getInstancia().agregarSocio(alumno1);
			}			
		}
		
		if(cmbTipo.getSelectedItem()== "Docente"){

			txtGrupo.setText("");			

			txtGrupo.setEditable(false);	

			txtAsignatura.setEditable(true);
			
			if (evento.getSource()==btnGuardar){
				
				Docente docente1 =new Docente();
				
				try{
					 int auxCed=Integer.parseInt(txtCedula.getText());
			         String auxNom=txtNombre.getText();
			         String auxApe=txtApellido.getText();
			         String auxDireccion= txtDireccion.getText();
			         int auxTelefono=Integer.parseInt(txtTelefono.getText());
			         String auxAsignatura= txtAsignatura.getText();
			         
			         if(ControladorLogica.getInstancia().devolverSocios().obtenerXCedula(auxCed) == null) {
				         docente1.setCedula(auxCed);
				         docente1.setNombre(auxNom);
				         docente1.setApellido(auxApe);
				         docente1.setDireccion(auxDireccion);
				         docente1.setTelefono(auxTelefono);
				         docente1.setAsignatura(auxAsignatura);
				         
				         JOptionPane.showMessageDialog(null, "Datos guardados correctamente  \n","Mensaje ",JOptionPane.INFORMATION_MESSAGE);
			         }else {
					    	JOptionPane.showMessageDialog(this, "Socio anteriormente agregado.", "Error!", JOptionPane.ERROR_MESSAGE);
			         } 
			      }catch (Exception e){
			        	 System.out.println("el error fue: " +e);
						 JOptionPane.showMessageDialog(null, "Datos incorrectos, intente de nuevo  \n","Error",JOptionPane.ERROR_MESSAGE);	
			      }        
						//agrego el alumno a la lista de alumnos, a la que accedo a traves del controlador
						ControladorLogica.getInstancia().agregarSocio(docente1);
			}
		}
		if (evento.getSource()==btnLimpiar){
			txtCedula.setText("");
			txtNombre.setText("");
			txtApellido.setText("");
			txtDireccion.setText("");
			txtTelefono.setText("");
			txtAsignatura.setText("");
			txtGrupo.setText("");			
		}		
	}	
}