package paquete;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AgregarLibro extends JDialog {

	private JPanel pnlInferior, pnlSuperior;
	private JButton btnAceptar, btnCalcularPrecio;
	private JTextField txtNombre, txtAutor, txtCantidadPaginas, txtPrecio;
	private JLabel lblNombre, lblAutor, lblCantidadPaginas, lblPrecio;
	
	public AgregarLibro(){
		
		
		iniciarComponentes();
		iniciarManejadoresEventos();
	
	}

	private void iniciarComponentes() {
		
		setTitle("Ingreso de Libros");
		setLocationRelativeTo(null);
		setResizable(true);
		getContentPane().setLayout(new BorderLayout());
		
		pnlSuperior =new JPanel();   /*instanciamos el contenedor de los datos personales*/
		//crea un borde vacio que genera un espacio de 10 px en cada lado del panel
		pnlSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlSuperior.setLayout(new GridLayout(4,2,10,5)); /*definimos el Layout de 4 filas, 2 columnas y espacios*/
		
		/*Definimos  los componentes del panel superior*/
		lblNombre= new JLabel("Nombre:"); 
		txtNombre= new JTextField();
		lblAutor= new JLabel("Autor:");
		txtAutor= new JTextField();
		lblCantidadPaginas=new JLabel("Cantidad páginas:");
		txtCantidadPaginas=new JTextField();
		lblPrecio= new JLabel("Precio:");
		txtPrecio= new JTextField();
		txtPrecio.setEditable(false);
		
		/*agregamos los componentes del panel superior*/
		pnlSuperior.add(lblNombre);
		pnlSuperior.add(txtNombre);
		pnlSuperior.add(lblAutor);
		pnlSuperior.add(txtAutor);
		pnlSuperior.add(lblCantidadPaginas);
		pnlSuperior.add(txtCantidadPaginas);
		pnlSuperior.add(lblPrecio);
		pnlSuperior.add(txtPrecio);
		
		/*Agregamos los componentes al Contenedor Superior*/
		
		getContentPane().add(pnlSuperior, BorderLayout.NORTH);
		
		btnAceptar= new JButton();
		btnAceptar.setText("Aceptar");
		btnCalcularPrecio= new JButton();
		btnCalcularPrecio.setText("Calcular Precio");
		/*instanciamos el contenedor para los botones de la parte inferior*/
		pnlInferior=new JPanel();
		/*Agregamos los componentes al Contenedor Inferior*/
		
		pnlInferior.add(btnAceptar);
		pnlInferior.add(btnCalcularPrecio);
		getContentPane().add(pnlInferior, BorderLayout.SOUTH);
		
		
		
		
	}
	
	public void iniciarManejadoresEventos(){
		
		btnCalcularPrecio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double salida=0;
					String auxNombre=txtNombre.getText()+"  ";
					String auxApellidoAutor=txtAutor.getText()+"  ";
					int auxCantidadPaginas=Integer.parseInt(txtCantidadPaginas.getText());
					Libro l=new Libro(auxNombre, auxApellidoAutor, auxCantidadPaginas);
					txtPrecio.setText(""+l.precio());
					
									
				}
			});
		 
		 btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//String datos=mostrarDatos(); 
					String salida="";
					String auxNombre=txtNombre.getText()+"  ";
					String auxApellidoAutor=txtAutor.getText()+"  ";
					int auxCantidadPaginas=Integer.parseInt(txtCantidadPaginas.getText());
					Libro l=new Libro(auxNombre, auxApellidoAutor, auxCantidadPaginas);
							
					//concateno todos los String capturados
					salida=l.toString();
					JOptionPane.showMessageDialog(null, "Datos capturados:  \n("+salida+")");
					
				}
			});
		 
	}


}