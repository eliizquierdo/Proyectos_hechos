package presentacion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import logica.*;

@SuppressWarnings("serial")
public class RealizarPrestamo  extends JDialog implements ActionListener {
	
	private static RealizarPrestamo instancia;
	
	private JPanel pnlSuperior;
	private JLabel lblCedula, lblCodigo, lblFinicio, lblFini, lblFfin, lblDia, lblMes, lblAnio, lblSalto;
	private JButton btnGuardar, btnLimpiar;
	private JTextField txtCedula, txtCodigo, txtDia, txtMes, txtAnio;
	
	private RealizarPrestamo(){
		super();
		setTitle("Agregar Prestamo");
		setResizable(false);
		this.setLocationRelativeTo(null);  
		iniciarComponentes();
		pack();
	}
	
	public static RealizarPrestamo getInstancia(){	
		if (instancia==null)
			instancia = new RealizarPrestamo();
		return instancia;
	}
	
	private void iniciarComponentes(){
				
		pnlSuperior= new JPanel();
		pnlSuperior.setLayout(new GridLayout(8,2,5,5)); 
		pnlSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		lblCedula=new JLabel("Ingrese la cedula del socio: "); 
		txtCedula= new JTextField();
		
		lblCodigo=new JLabel("Ingrese el codigo del material: "); 
		txtCodigo= new JTextField();
				
		/***************************************************************************************/
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");  //defino el formato de la fecha 
		Date fechaActual = new Date();	//toma la fecha del sistema
		String fechaSistema=formatoFecha.format(fechaActual);	//le da el formato definido	
		//System.out.println("La fecha actual del sistema es: "+fechaSistema.toString());
		/***************************************************************************************/


		lblFinicio=new JLabel("Fecha de Inicio: ");
		lblFini= new JLabel();
		lblFini.setText(fechaSistema);
		
		lblFfin=new JLabel("Ingrese Fecha de fin: "); 

		lblSalto=new JLabel("			");
		
		lblDia=new JLabel("Ingrese el dia: "); 
		txtDia= new JTextField();
		
		lblMes=new JLabel("Ingrese el mes: "); 
		txtMes= new JTextField();
		
		lblAnio=new JLabel("Ingrese el año: "); 
		txtAnio= new JTextField();
		
		btnGuardar= new JButton("Guardar");
		btnGuardar.addActionListener(this);
		
		btnLimpiar= new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		
		pnlSuperior.add(lblCedula);
		pnlSuperior.add(txtCedula);
		pnlSuperior.add(lblCodigo);
		pnlSuperior.add(txtCodigo);
		pnlSuperior.add(lblFinicio);
		pnlSuperior.add(lblFini);
		pnlSuperior.add(lblFfin);
		pnlSuperior.add(lblSalto);;
		pnlSuperior.add(lblDia);
		pnlSuperior.add(txtDia);
		pnlSuperior.add(lblMes);
		pnlSuperior.add(txtMes);
		pnlSuperior.add(lblAnio);
		pnlSuperior.add(txtAnio);
		pnlSuperior.add(btnLimpiar);
		pnlSuperior.add(btnGuardar);
		this.add(pnlSuperior);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==btnGuardar){
			
			int auxCed = Integer.parseInt(txtCedula.getText());
			int auxCod = Integer.parseInt(txtCodigo.getText());
			if(ControladorLogica.getInstancia().devolverSocios().obtenerXCedula(auxCed) == null || ControladorLogica.getInstancia().devolverMateriales().obtenerXCodigo(auxCod) == null ) {
				JOptionPane.showMessageDialog(this, "Socio y/o Material incorrectos, intente nuevamente.", "Error!", JOptionPane.ERROR_MESSAGE);
			}else {
				
				Prestamos prestamo= new Prestamos();
				
				try{
			         String auxFinicio=	lblFini.getText();     
			         Fecha auxFfin= new Fecha(Integer.parseInt(txtDia.getText()), Integer.parseInt(txtMes.getText()), Integer.parseInt(txtAnio.getText()));
			         
			         int dia = Integer.parseInt(auxFinicio.substring(0, 2));
			         int mes = Integer.parseInt(auxFinicio.substring(3, 5));
			         int anio = Integer.parseInt(auxFinicio.substring(6 , 10));
			        
			         Fecha fechaact= new Fecha(dia, mes, anio);

			         if(auxFfin.fechaCorrecta()) {
			        	 
			        	if(fechaact.esMenor(auxFfin)) {
			        		 prestamo.setCedsocio(auxCed);
					         prestamo.setCodigo(auxCod);
					         prestamo.setFfin(auxFfin);
					         prestamo.setFinicio(auxFinicio);
					         
					         JOptionPane.showMessageDialog(null, "Datos guardados correctamente  \n","Mensaje ",JOptionPane.INFORMATION_MESSAGE);
			        	}else {
				        	 JOptionPane.showMessageDialog(null, "Fecha incorrecta, intente de nuevo  \n","Error",JOptionPane.ERROR_MESSAGE);	
				         }			        	
			         }else {
			        	 JOptionPane.showMessageDialog(null, "Fecha incorrecta, intente de nuevo  \n","Error",JOptionPane.ERROR_MESSAGE);	
			         }
				}catch (Exception exe){
			       	 System.out.println("el error fue: " +e);
						 JOptionPane.showMessageDialog(null, "Datos incorrectos, intente de nuevo  \n","Error",JOptionPane.ERROR_MESSAGE);	
					 }
				ControladorLogica.getInstancia().agregarPrestamo(prestamo);
				ControladorLogica.getInstancia().devolverMateriales().obtenerXCodigo(auxCod).setCant_disponible(1);
			}			
		}
		
		if (e.getSource()==btnLimpiar){
			txtCedula.setText("");
			txtCodigo.setText("");
			txtDia.setText("");
			txtMes.setText("");
			txtAnio.setText("");
		}
    }
}