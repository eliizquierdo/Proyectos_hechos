package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import logica.*;
import javax.swing.border.TitledBorder;

public class Principal extends JFrame{
	Paquete p1= new Paquete();
	private JPanel contentPane;
    private JTextField txtNum;
    private JTextField txtNom;
    private JTextField txtTem;
    private JButton btnGuardar, btnMostrar;
    private JCheckBox chckbxPlus;
    private Label lblNum;
    

    public Principal() {        
    	setTitle("Ventana Principal");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setResizable(false);
    	this.setBounds(0,0,304,260);
    	contentPane = new JPanel();
    	setContentPane(contentPane);
    	contentPane.setLayout(null);
    	
    	
        iniciarComponentes();
        iniciarManejadoresEventos();
      
                     
    }
    
    private void iniciarComponentes() {
    	
    	JPanel panel = new JPanel();
    	panel.setBorder(new TitledBorder(null, "Ingresar Canal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    	panel.setBounds(10, 11, 256, 210);
    	contentPane.add(panel);
    	panel.setLayout(null);
    	
    	lblNum = new Label("Numero:");
    	lblNum.setBounds(10, 25, 100, 22);
    	panel.add(lblNum);
    	
    	txtNum = new JTextField();
    	txtNum.setBounds(120, 25, 96, 20);
    	panel.add(txtNum);
    	txtNum.setColumns(10);
    	
    	txtNom = new JTextField();
    	txtNom.setBounds(120, 56, 96, 20);
    	panel.add(txtNom);
    	txtNom.setColumns(10);
    	
    	txtTem = new JTextField();
    	txtTem.setBounds(120, 81, 96, 20);
    	panel.add(txtTem);
    	txtTem.setColumns(10);
    	btnGuardar = new JButton("Guardar");
    	btnGuardar.setBounds(21, 151, 89, 23);
    	panel.add(btnGuardar);
    	
    	Label lblNom = new Label("Nombre:");
    	lblNom.setBounds(10, 53, 100, 22);
    	panel.add(lblNom);
    	
    	Label lblTem = new Label("Tematica:");
    	lblTem.setBounds(10, 81, 100, 22);
    	panel.add(lblTem);
    	
    	btnMostrar = new JButton("Mostrar");
    
    	btnMostrar.setBounds(141, 151, 89, 23);
    	panel.add(btnMostrar);
    	
    	chckbxPlus = new JCheckBox("Plus?");
    	chckbxPlus.setBounds(93, 121, 97, 23);
    	panel.add(chckbxPlus);
    }

   
    private void iniciarManejadoresEventos() {
    	btnGuardar.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			String nom=txtNom.getText();
    			int num=Integer.parseInt(txtNum.getText());
    			String tem=txtTem.getText();
    			Canal c1= new Canal (num,nom,tem);
    			boolean p=chckbxPlus.isSelected();
    			if (p == true) {
    				canalPlus cp1= new canalPlus(p,num,nom,tem);
    			}
    			p1.agregar(c1);
   
    		}
    		
    	});
    	btnMostrar.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
     			JOptionPane.showMessageDialog(null,p1.toString());
    		}
    	});
	  	
    }
    public static void main(String args[]) {
    	
    	Principal p=new Principal();
    	p.setVisible(true);
    }
}