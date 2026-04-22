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
public class ListarMateriales extends JDialog {
		
	private static ListarMateriales instancia;
	
	private JPanel pnlCentral;
	private DefaultTableModel miModelo;
	private JTable tablaMateriales;	
	private JScrollPane scrPanel;	//barra de desplazamiento horizontal y vertical
	
	private ListarMateriales(){
			
			setTitle("Listado de Materiales");
			setLocationRelativeTo(null);
			setResizable(true);
			iniciarComponentes();
			iniciarTabla();
			
	        ListaMateriales listado=ControladorLogica.getInstancia().devolverMateriales();
	         
		
	        //para cada posicion de la fila
	        String fila[]=new String[miModelo.getColumnCount()];
	   	
	        try{
	        	for(int i=0;i<listado.largo();i++){
	      		
	      		fila[0]=String.valueOf(listado.devolver(i).getCodigo());
	      		fila[1]=listado.devolver(i).getTitulo();
	      		fila[2]=listado.devolver(i).getAutor();
	      		fila[3]=String.valueOf(listado.devolver(i).getCant_ejemplar());
	      		fila[4]=String.valueOf(listado.devolver(i).getCant_disponible());
	      		
	      		miModelo.addRow(fila);
	        	
	        	}
	      	 // Asociar el modelo con la lista.
	        	tablaMateriales.setModel(miModelo);
	        }catch (Exception e) {
	        	System.out.println("error"+e);
	        }
		}
	        
	//salvo la primera vez (null), siempre devuelve la misma instancia
	public static ListarMateriales getInstancia(){	
		if (instancia==null)
			instancia = new ListarMateriales();
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
		tablaMateriales = new JTable();
		scrPanel.setViewportView(tablaMateriales);
	       
		//agregamos el panel a la zona correspondiendte
		this.add(pnlCentral, BorderLayout.CENTER);
		pack();		
	}
		
	public void iniciarTabla(){
		/*definimos titulos de la tabla en un array de String*/
		String titulos[]={"Codigo","Titulo", "Autor", "Cantidad Ejemplares", "Cantidad Disponible"};
		/*Instanciamos un modelo de tabla con los titulos definidos*/
		miModelo=new DefaultTableModel(null,titulos);
		/*colocamos el modelo a la tabla*/
		tablaMateriales.setModel(miModelo);
	}
}
