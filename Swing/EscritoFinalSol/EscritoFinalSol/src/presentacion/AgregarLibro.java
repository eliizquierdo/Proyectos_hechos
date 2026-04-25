package presentacion;
 
import java.awt.GridLayout;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logica.ControladorLogica;
import logica.Libro;

 
public class AgregarLibro extends JDialog implements ActionListener {
	
	private static AgregarLibro instancia;
	
	private JPanel pnlSuperior;
	private JLabel lblTitulo, lblCodigo;
	private JTextField txtTitulo, txtCodigo;
	private JButton btnGuardar, btnLimpiar;
			
	//constructor privado!!!
	private AgregarLibro(){
		
		setTitle("Agregar Libro");
		setLocationRelativeTo(null);
		setResizable(true);
		iniciarComponentes();
		pack();
	}
	
	//salvo la primera vez (null), siempre devuelve la misma instancia
	public static AgregarLibro getInstancia(){
		
		if (instancia==null)
			instancia = new AgregarLibro();
		return instancia;
	}
	
	private void iniciarComponentes() {
		
		
		pnlSuperior =new JPanel();   
		pnlSuperior.setLayout(new GridLayout(3,2,5,5)); 
		/*genera espacio vacío alrededor para que no que todo contra los bordes*/
		pnlSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		/*Definimos  los componentes del panel superior*/
		lblCodigo=new JLabel("Codigo:"); 
		txtCodigo= new JTextField();
		lblTitulo= new JLabel("Titulo:"); 
		txtTitulo= new JTextField();
		
		btnGuardar= new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnLimpiar= new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
				
		/*agregamos los componentes del panel superior*/
		pnlSuperior.add(lblCodigo);
		pnlSuperior.add(txtCodigo);
		pnlSuperior.add(lblTitulo);
		pnlSuperior.add(txtTitulo);
	
		pnlSuperior.add(btnLimpiar);
		pnlSuperior.add(btnGuardar);
		//agregamos el panel al JFrame		
		this.add(pnlSuperior);
					
	}
	
	private void limpiar(){
		txtCodigo.setText("");
		txtTitulo.setText("");
			
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) throws NumberFormatException {
		boolean ok=false, ok1=false;
		
		if (evento.getSource()==btnGuardar){
			Libro libro1 =new Libro();
			
						try{
							 int auxCod=Integer.parseInt(txtCodigo.getText());
							 String auxTit=txtTitulo.getText();
					         
					         //verifico que ningún  dato quede vacio
					         if (!(auxTit.isEmpty())){
						        libro1.setCodigo(auxCod);
						        libro1.setTitulo(auxTit);
						         ok=ControladorLogica.getInstancia().insertarLibro(libro1);
					         }
					         else
					        	 JOptionPane.showMessageDialog(null, "Error!!, no puede dejar campos vacíos \n","Error",JOptionPane.ERROR_MESSAGE);
					         if (ok==true){
					        	 JOptionPane.showMessageDialog(null, "Datos guardados correctamente en BD  \n","Mensaje ",JOptionPane.INFORMATION_MESSAGE);
					         }else 
								 JOptionPane.showMessageDialog(null, "Error!!, ya existe esa codigo  \n","Error",JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error!!, el codigo debe ser numerico  \n","Error",JOptionPane.ERROR_MESSAGE);
				}
						
			}
		
		
		if (evento.getSource()==btnLimpiar){
			limpiar();
			
		}
		
	}
	  
}
	
