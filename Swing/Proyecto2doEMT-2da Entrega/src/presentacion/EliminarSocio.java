package presentacion;

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

import logica.ControladorLogica;

@SuppressWarnings("serial")
public class EliminarSocio  extends JDialog implements ActionListener {
	
	private static EliminarSocio instancia;
	
	private JPanel pnlSuperior;
	private JLabel lblCedula;
	private JButton btnEliminar, btnLimpiar;
	private JTextField txtCedula;
	
	private EliminarSocio(){
		super();
		setTitle("Eliminar Socio");
		setSize(400,150);
		setResizable(false);
		this.setLocationRelativeTo(null);  
		iniciarComponentes();
	}
	
	public static EliminarSocio getInstancia(){	
		if (instancia==null)
			instancia = new EliminarSocio();
		return instancia;
	}
	
	private void iniciarComponentes(){
				
		pnlSuperior= new JPanel();
		pnlSuperior.setLayout(new GridLayout(2,2,5,5)); 
		pnlSuperior.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

		lblCedula=new JLabel("Ingrese la cedula del socio: "); 
		txtCedula= new JTextField();
		
		btnEliminar= new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		
		btnLimpiar= new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		
		pnlSuperior.add(lblCedula);
		pnlSuperior.add(txtCedula);
		pnlSuperior.add(btnLimpiar);
		pnlSuperior.add(btnEliminar);
		this.add(pnlSuperior);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==btnEliminar){
			int ced = Integer.parseInt(txtCedula.getText());
			if(ControladorLogica.getInstancia().devolverSocios().obtenerXCedula(ced) == null) {
				JOptionPane.showMessageDialog(this, "No se ha encontrado un socio con esa cédula.", "Error!", JOptionPane.ERROR_MESSAGE);
			}else {
				ControladorLogica.getInstancia().eliminarSocios(ced);
				JOptionPane.showMessageDialog(this, "Socio eliminado exitosamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
		}
		if (e.getSource()==btnLimpiar){
			txtCedula.setText("");			
		}		
    }
}