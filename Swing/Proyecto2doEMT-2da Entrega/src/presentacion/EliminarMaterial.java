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
public class EliminarMaterial extends JDialog implements ActionListener {
	
private static EliminarMaterial instancia;
	
	private JPanel pnlSuperior;
	private JLabel lblCodigo;
	private JButton btnEliminar, btnLimpiar;
	private JTextField txtCodigo;
	
	private EliminarMaterial(){
		super();
		setTitle("Eliminar Material");
		setSize(400,150);
		setResizable(false);
		this.setLocationRelativeTo(null);  
		iniciarComponentes();
	}
	
	public static EliminarMaterial getInstancia(){	
		if (instancia==null)
			instancia = new EliminarMaterial();
		return instancia;
	}
	
	private void iniciarComponentes(){
				
		pnlSuperior= new JPanel();
		pnlSuperior.setLayout(new GridLayout(2,2,5,5)); 
		pnlSuperior.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

		lblCodigo=new JLabel("Ingrese el codigo del material: "); 
		txtCodigo= new JTextField();
		
		btnEliminar= new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		
		btnLimpiar= new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		
		pnlSuperior.add(lblCodigo);
		pnlSuperior.add(txtCodigo);
		pnlSuperior.add(btnLimpiar);
		pnlSuperior.add(btnEliminar);
		this.add(pnlSuperior);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==btnEliminar){
			int cod = Integer.parseInt(txtCodigo.getText());
			if(	ControladorLogica.getInstancia().devolverMateriales().obtenerXCodigo(cod) == null) {
				JOptionPane.showMessageDialog(this, "No se ha encontrado un material con ese codigo.", "Error!", JOptionPane.ERROR_MESSAGE);
			}else {
				ControladorLogica.getInstancia().eliminarMaterial(cod);
				JOptionPane.showMessageDialog(this, "Material eliminado exitosamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
		}
		if (e.getSource()==btnLimpiar){
			txtCodigo.setText("");			
		}		
    }
}