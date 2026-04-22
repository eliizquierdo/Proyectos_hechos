package presentacion;

import logica.*;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ListarPrestamos extends JDialog {
		
	private static ListarPrestamos instancia;
	
	private JPanel pnlCentral;
	private DefaultTableModel miModelo;
	private JTable tablaPrestamos;	
	private JScrollPane scrPanel;	//barra de desplazamiento horizontal y vertical
	
	private ListarPrestamos(){
			
			setTitle("Listado de Prestamos");
			setLocationRelativeTo(null);
			setResizable(true);
			iniciarComponentes();
			iniciarTabla();
			
			ListaPrestamos listado=ControladorLogica.getInstancia().devolverPrestamos();
	         
		
	        //para cada posicion de la fila
	        String fila[]=new String[miModelo.getColumnCount()];
	   	
	        try{
	        	for(int i=0;i<listado.largo();i++){
	      		
	        	fila[0]=String.valueOf(listado.devolver(i).getCedsocio());      			
	      		fila[1]=String.valueOf(listado.devolver(i).getCodigo());
	      		fila[2]=String.valueOf(listado.devolver(i).getFinicio());
	      		fila[3]=listado.devolver(i).getFfin().mostrarFecha();	      		
	      		
	      		miModelo.addRow(fila);
	        	
	        	}
	      	 // Asociar el modelo con la lista.
	        	tablaPrestamos.setModel(miModelo);
	        }catch (Exception e) {
	        	System.out.println("error"+e);
	        }
		}
	        
		//salvo la primera vez (null), siempre devuelve la misma instancia
			public static ListarPrestamos getInstancia(){	
				if (instancia==null)
					instancia = new ListarPrestamos();
				return instancia;
			}

	public void iniciarComponentes(){
		pnlCentral =new JPanel();
		pnlCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnlCentral.setLayout(new BorderLayout());
		
		/*Instanciamos un scroll y lo agregamos al panel*/
		scrPanel = new JScrollPane();
		pnlCentral.add(scrPanel, BorderLayout.CENTER);
		
		/*Instanciamos una tabla y le asociamos el scroll*/
		tablaPrestamos = new JTable();
		scrPanel.setViewportView(tablaPrestamos);
	       
		//agregamos el panel a la zona correspondiendte
		this.add(pnlCentral, BorderLayout.CENTER);
		pack();		
	}
		
	public void iniciarTabla(){
		/*definimos titulos de la tabla en un array de String*/
		String titulos[]={"Cedula","Codigo","Fecha Inicio", "Fecha Fin"};
		/*Instanciamos un modelo de tabla con los titulos definidos*/
		miModelo=new DefaultTableModel(null,titulos);
		/*colocamos el modelo a la tabla*/
		tablaPrestamos.setModel(miModelo);
	}
}
