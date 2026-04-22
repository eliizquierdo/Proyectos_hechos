package presentacion;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.*;
import logica.*;
import javax.swing.JDialog;
		
@SuppressWarnings("serial")
public class AgregarMaterial extends JDialog implements ActionListener{
	
	//Aplicando patron Singleton
	//El unico objeto (instancia) de AgregarSocio durante toda la ejecucion
	private static AgregarMaterial instancia;
		
	private JPanel pnlSuperior;
	private JLabel lblCodigo, lblTitulo, lblAutor, lblAnio, lblMes, lblDia, lblIsbn, lblCantidadE, lblTipo ;
	private JTextField txtCodigo, txtTitulo, txtAutor, txtAnio, txtMes, txtDia,  txtIsbn, txtCantidadE;
	private JButton btnGuardar, btnLimpiar;
	private JComboBox<String> cmbTipo;
		
	//constructor privado
	private AgregarMaterial(){
		setTitle("Agregar Material");
		setLocationRelativeTo(null);
		setResizable(true);
		iniciarComponentes();
		pack();
	}
		
	//salvo la primera vez (null), siempre devuelve la misma instancia
	public static AgregarMaterial getInstancia(){	
		if (instancia==null)
			instancia = new AgregarMaterial();
		return instancia;		
		}
		
	private void iniciarComponentes() {
		pnlSuperior =new JPanel();   
		pnlSuperior.setLayout(new GridLayout(10,2,5,5)); 
		/*genera espacio vacio alrededor para que no que todo contra los bordes*/
		pnlSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			
		/*Definimos  los componentes del panel superior*/
		lblCodigo=new JLabel("Codigo:"); 
		txtCodigo= new JTextField();
			
		lblTitulo= new JLabel("Titulo:"); 
		txtTitulo= new JTextField();
		
		lblAutor= new JLabel("Autor/es:");
		txtAutor= new JTextField();
	
		lblCantidadE= new JLabel("Cantidad");
		txtCantidadE= new JTextField();
		
		lblTipo= new JLabel("Tipo de Material:");
			
		cmbTipo= new JComboBox<String>();
		cmbTipo.addItem("Libro");
		cmbTipo.addItem("Revista");
		cmbTipo.addActionListener(this);
			
		lblAnio= new JLabel("Año:");
		txtAnio = new JTextField();
		txtAnio.setEditable(false);	
		
		lblMes= new JLabel("Mes:");
		txtMes = new JTextField();
		txtMes.setEditable(false);	
		
		lblDia= new JLabel("Dia:");
		txtDia = new JTextField();
		txtDia.setEditable(false);	
		
		lblIsbn= new JLabel("ISBN:");
		txtIsbn = new JTextField();
		txtIsbn.setEditable(false);	
			
		btnGuardar= new JButton("Guardar");
		btnGuardar.addActionListener(this);
			
		btnLimpiar= new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
					
		/*agregamos los componentes del panel superior*/
		pnlSuperior.add(lblCodigo);
		pnlSuperior.add(txtCodigo);
		pnlSuperior.add(lblTitulo);
		pnlSuperior.add(txtTitulo);
		pnlSuperior.add(lblAutor);
		pnlSuperior.add(txtAutor);
		pnlSuperior.add(lblCantidadE);
		pnlSuperior.add(txtCantidadE);
		pnlSuperior.add(lblTipo);
		pnlSuperior.add(cmbTipo);
		pnlSuperior.add(lblAnio);
		pnlSuperior.add(txtAnio);
		pnlSuperior.add(lblMes);
		pnlSuperior.add(txtMes);
		pnlSuperior.add(lblDia);
		pnlSuperior.add(txtDia);
		pnlSuperior.add(lblIsbn);
		pnlSuperior.add(txtIsbn);
		pnlSuperior.add(btnLimpiar);
		pnlSuperior.add(btnGuardar);
		//agregamos el panel al JFrame		
		this.add(pnlSuperior);
		}
		
		public void actionPerformed(ActionEvent evento) {
			
			if(cmbTipo.getSelectedItem()== "Libro"){
				
				txtAnio.setText("");			
				txtMes.setText("");			
				txtDia.setText("");			
					
				txtIsbn.setEditable(true);	
				
				txtAnio.setEditable(false);
				txtMes.setEditable(false);
				txtDia.setEditable(false);
				
				if (evento.getSource()==btnGuardar){
					
					Libro libro1= new Libro();
					
					try{
						 int auxCod=Integer.parseInt(txtCodigo.getText());
				         String auxTit=txtTitulo.getText();
				         String auxAut=txtAutor.getText();
				         int auxCantidadE= Integer.parseInt(txtCantidadE.getText());
				         int auxIsbn=Integer.parseInt(txtIsbn.getText());
				         
				         libro1=new Libro(auxCod, auxTit, auxAut, auxCantidadE, auxIsbn);
				   				         
				         JOptionPane.showMessageDialog(null, "Datos guardados correctamente  \n","Mensaje ",JOptionPane.INFORMATION_MESSAGE);
				         
						}catch (Exception e){
				        	 System.out.println("el error fue: " +e);
							 JOptionPane.showMessageDialog(null, "Datos incorrectos, intente de nuevo  \n","Error",JOptionPane.ERROR_MESSAGE);	
						 }        
							//agrego el alumno a la lista de alumnos, a la que accedo a traves del controlador
							ControladorLogica.getInstancia().agregarMaterial(libro1);
				}			
			}
			
			if(cmbTipo.getSelectedItem()== "Revista"){
				
				txtIsbn.setText("");			

				txtAnio.setEditable(true);
				txtMes.setEditable(true);
				txtDia.setEditable(true);
				
				txtIsbn.setEditable(false);
				
				if (evento.getSource()==btnGuardar){
					
					Revista revista1 =new Revista();
					
					try{
						 int auxCod=Integer.parseInt(txtCodigo.getText());
				         String auxTit=txtTitulo.getText();
				         String auxAut=txtAutor.getText();
				         int auxCantidadE= Integer.parseInt(txtCantidadE.getText());
				         int auxDia=Integer.parseInt(txtDia.getText());
				         int auxMes=Integer.parseInt(txtMes.getText());
				         int auxAnio=Integer.parseInt(txtAnio.getText());
				         
				         Fecha fechaE= new Fecha(auxDia, auxMes, auxAnio);
				         
				         if(fechaE.fechaCorrecta()) {
				        	 revista1 =new Revista(auxCod, auxTit, auxAut, auxCantidadE, fechaE);
						   		  
					         JOptionPane.showMessageDialog(null, "Datos guardados correctamente  \n","Mensaje ",JOptionPane.INFORMATION_MESSAGE);
				         }else {
				        	 JOptionPane.showMessageDialog(null, "Fecha incorrecta, intente de nuevo  \n","Error",JOptionPane.ERROR_MESSAGE);
				         }
						}catch (Exception e){
				        	 System.out.println("el error fue: " +e);
							 JOptionPane.showMessageDialog(null, "Datos incorrectos, intente de nuevo  \n","Error",JOptionPane.ERROR_MESSAGE);	
						 }        
							//agrego el alumno a la lista de alumnos, a la que accedo a traves del controlador
							ControladorLogica.getInstancia().agregarMaterial(revista1);
				}			
			}			
			if (evento.getSource()==btnLimpiar){
				txtCodigo.setText("");
				txtTitulo.setText("");
				txtAutor.setText("");
				txtCantidadE.setText("");
				txtIsbn.setText("");
				txtAnio.setText("");			
				txtMes.setText("");			
				txtDia.setText("");					
			}		
		}	
}
