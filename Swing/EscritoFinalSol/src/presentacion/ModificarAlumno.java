package presentacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logica.ControladorLogica;
import logica.Alumno;
 
public class ModificarAlumno extends JDialog implements ActionListener {
	
	//Aplicando patrón Singleton
	//El único objeto (instancia) de AgregarAlumno durante toda la ejecución
	private static ModificarAlumno instancia;
		
	private JPanel pnlSuperior, pnlCentral, pnlInferior;
	private JLabel lblCedula, lblNombre, lblApellido, lblGrupo;
	private JTextField txtCedula, txtNombre, txtApellido;//, txtGrupo;
	private JButton btnBuscar, btnModificar, btnCancelar;
	private JComboBox cmbGrupo;
			
	//constructor privado
	private ModificarAlumno(){
		
		setTitle("Modificar Alumno");
		setLocationRelativeTo(null);
		setResizable(true);
		this.setLayout(new BorderLayout());
		iniciarComponentes();
		pack();
	}

	//salvo la primera vez (null), siempre devuelve la misma instancia
		public static ModificarAlumno getInstancia(){
			
			if (instancia==null)
				instancia = new ModificarAlumno();
			return instancia;
		}
		
	private void iniciarComponentes() {
		
		pnlSuperior =new JPanel();   /*instanciamos el contenedor de los datos personales*/
		
		//crea un borde vacio que genera un espacio de 10 px en cada lado del panel
		pnlSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
				
		/*Definimos  los componentes del panel superior*/
		lblCedula=new JLabel("Ingrese cédula:"); 
		txtCedula= new JTextField(10);
		btnBuscar= new JButton();
		btnBuscar.setText("Buscar");
		btnBuscar.addActionListener(this);
		
				
		/*agregamos los componentes del panel superior*/
		pnlSuperior.add(lblCedula);
		pnlSuperior.add(txtCedula);
		pnlSuperior.add(btnBuscar);
		
		/*instanciamos el contenedor para los componentes de la parte central*/
		pnlCentral=new JPanel();
		
		pnlCentral.setLayout(new GridLayout(3,2,10,10)); /*definimos el Layout de 3 filas, 2 columnas y espacios*/
		pnlCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		//Definimos  los componentes para el panel central
		lblNombre= new JLabel("Nombre:"); 
		txtNombre= new JTextField();
				
		lblApellido= new JLabel("Apellido:");
		txtApellido= new JTextField();
				
		lblGrupo= new JLabel("Grupo:");
		
		cmbGrupo = new JComboBox();
		cmbGrupo.addItem("A");
		cmbGrupo.addItem("B");
		cmbGrupo.addItem("C");
		cmbGrupo.setSelectedIndex(0);

		/*Agregamos los componentes al Contenedor Central*/
		pnlCentral.add(lblNombre);
		pnlCentral.add(txtNombre);
		pnlCentral.add(lblApellido);
		pnlCentral.add(txtApellido);
		pnlCentral.add(lblGrupo);
		pnlCentral.add(cmbGrupo);
		
		/*instanciamos el contenedor para los componentes de la parte inferior*/
		pnlInferior=new JPanel();
		
		//Definimos  los componentes para el panel inferior
		btnModificar= new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnCancelar= new JButton("Cancelar"); 
		btnCancelar.addActionListener(this);
		
		pnlInferior.add(btnModificar);
		pnlInferior.add(btnCancelar);
		
		//agregamos cada panel a la zona correspondiendte
		this.add(pnlSuperior, BorderLayout.NORTH);
		this.add(pnlCentral, BorderLayout.CENTER);
		this.add(pnlInferior,BorderLayout.SOUTH);
		
		bloquear(); //deshabilita los campos nombre, apellido y grupo	
	}
	
		
		
	private void bloquear(){
		txtNombre.setEnabled(false);
		txtApellido.setEnabled(false);
		cmbGrupo.setEnabled(false);
		btnModificar.setEnabled(false);  //lo deshabilito para activarlo luego de que ingresen la cedula
	}
	
	private void desbloquear(){
		txtNombre.setEnabled(true);
		txtApellido.setEnabled(true);
		cmbGrupo.setEnabled(true);
		btnModificar.setEnabled(true);  
	}
	
	private void limpiar(){
		txtCedula.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		cmbGrupo.setSelectedIndex(0);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		
		if (evento.getSource()==btnBuscar){
				Alumno auxAlu=null;
				int auxCedula = 0;
				//captura la cedula ingresada
				try{
					auxCedula=Integer.parseInt(txtCedula.getText());
				}catch (Exception e1){
					JOptionPane.showMessageDialog(null, "La cédula debe ser numérica  \n");
				}
								
				try{
					auxAlu=ControladorLogica.getInstancia().recuperarAlumno(auxCedula);
					txtNombre.setText(auxAlu.getNombre());
					txtApellido.setText(auxAlu.getApellido());
					cmbGrupo.removeAllItems();
					cmbGrupo.addItem(auxAlu.getGrupo());
					if (auxAlu.getGrupo().equals("A")){
						cmbGrupo.addItem("B");
						cmbGrupo.addItem("C");
						cmbGrupo.setSelectedIndex(0);
					}
					else 
						if (auxAlu.getGrupo().equals("B")){
						cmbGrupo.addItem("A");
						cmbGrupo.addItem("C");
						cmbGrupo.setSelectedIndex(0);
						}
						else{
						cmbGrupo.addItem("A");
						cmbGrupo.addItem("B");
						cmbGrupo.setSelectedIndex(0);
					}
					
					desbloquear();  //habilito los campos y el boton para poder hacer las modificaciones
				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, "Alumno no encontrado \n");
					limpiar();
				}
				
		}
		
		if (evento.getSource()==btnModificar){
			
			Alumno alumno1 =new Alumno();
			int auxCed=0;
			
			try{
				//obtengo los nuevos datos a guardar
				 auxCed=Integer.parseInt(txtCedula.getText());
		         String auxNom=txtNombre.getText();
		         String auxApe=txtApellido.getText();
		         String auxGrupo= cmbGrupo.getSelectedItem().toString();
		         //seteo el alumno modificado con los nuevos datos
		         alumno1.setCedula(auxCed);
		         alumno1.setNombre(auxNom);
		         alumno1.setApellido(auxApe);
		         alumno1.setGrupo(auxGrupo);
		         limpiar();
		         bloquear();
		         
         }catch (Exception e){
		        	 System.out.println("el error fue: " +e);
					 JOptionPane.showMessageDialog(null, "Datos incorrectos, intente de nuevo  \n","Error",JOptionPane.ERROR_MESSAGE);	
		 }        
		 try {
				boolean ok=ControladorLogica.getInstancia().modificarAlumno(alumno1);//insertarAlumnoBD(alumno1);
			 	if (ok=true)
			 		JOptionPane.showMessageDialog(null, "Datos modificados correctamente  \n","Mensaje ",JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
					e.printStackTrace();
					System.out.println("el error fue: " +e);
					JOptionPane.showMessageDialog(null, "Datos incorrectos, intente de nuevo  \n","Error",JOptionPane.ERROR_MESSAGE);	
		}
					
		}//fin boton modificar
		
		if (evento.getSource()==btnCancelar){
			this.dispose();
			limpiar();
			bloquear();
		}
	}
	
}
	
