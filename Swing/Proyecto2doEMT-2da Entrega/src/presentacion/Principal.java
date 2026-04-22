package presentacion;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Principal extends JFrame  implements ActionListener{
    
	//lo unico que contendra este JFrame sera la barra de menus
	
	//**************************************************		
	private JMenuBar mnbPrincipal = new JMenuBar(); //Barra de menus
	//**************************************************
    // Atributos privados 
    private JMenuItem itemAltaSocio,  itemVerSocios, itemEliminarSocios;
    private JMenu jMenuSocios, jMenuMateriales, jMenuPrestamos;
    private JMenuItem itemAltaMaterial, itemVerMateriales, itemEliminarMaterial; 
    private JMenuItem itemAltaPrestamo, itemVerPrestamos;
    
   
    //constructor
    public Principal() {        
    	setTitle("Menu Principal Alumnos");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setResizable(false);
    	this.setBounds(200, 50,400,400);
        iniciarComponentes();
        setLocationRelativeTo(null);
    }
    
    private void iniciarComponentes() {
    	    	
    	//barra de menu principal
    	mnbPrincipal = new JMenuBar();
    	
    	//Menú Alumnos
        jMenuSocios = new  JMenu("Socios");
        jMenuMateriales = new  JMenu("Materiales");
        jMenuPrestamos = new  JMenu("Prestamos");

        //opciones de menu Socio
        itemAltaSocio = new  JMenuItem("Agregar Socio");
        itemAltaSocio.addActionListener(this);
        
        itemEliminarSocios= new  JMenuItem("Eliminar Socio");
        itemEliminarSocios.addActionListener(this);
        
        itemVerSocios= new  JMenuItem("Ver Socios");
        itemVerSocios.addActionListener(this);
        
      //opciones de menu Material
        itemAltaMaterial = new  JMenuItem("Agregar Material");
        itemAltaMaterial.addActionListener(this);
        
        itemEliminarMaterial= new  JMenuItem("Eliminar Material");
        itemEliminarMaterial.addActionListener(this);
        
        itemVerMateriales= new  JMenuItem("Ver Materiales");
        itemVerMateriales.addActionListener(this);
        
      //opciones de menu Prestamos
        itemAltaPrestamo = new  JMenuItem("Agregar Prestamo");
        itemAltaPrestamo.addActionListener(this);
        
        itemVerPrestamos= new  JMenuItem("Ver Prestamos");
        itemVerPrestamos.addActionListener(this);
        
        //agregamos los itemMen  al menú
        jMenuSocios.add(itemAltaSocio);
        jMenuSocios.add(itemEliminarSocios);
        jMenuSocios.add(itemVerSocios);
        
        //agregamos los itemMen  al menú
        jMenuMateriales.add(itemAltaMaterial);
        jMenuMateriales.add(itemEliminarMaterial);
        jMenuMateriales.add(itemVerMateriales);
      
        //agregamos los itemMen  al menú
        jMenuPrestamos.add(itemAltaPrestamo);
        jMenuPrestamos.add(itemVerPrestamos);
        
        //agregamos el menú Alumnos a la barra de menú
        mnbPrincipal.add(jMenuSocios);
        mnbPrincipal.add(jMenuMateriales);
        mnbPrincipal.add(jMenuPrestamos);
        
        //colocamos el menú principal en el JFrame
        setJMenuBar(mnbPrincipal);   
    }

	public void actionPerformed(ActionEvent e) {
		
    	if (e.getSource()==itemAltaSocio){
    		//getInstancia es estatico... por lo tanto se invoca por medio de la Clase
			AgregarSocio altaSoc = AgregarSocio.getInstancia(); 
			altaSoc.setVisible(true);
    	}
    	if (e.getSource()==itemEliminarSocios){
    		EliminarSocio bajaSoc = EliminarSocio.getInstancia(); 
			bajaSoc.setVisible(true);
    	}
    	if (e.getSource()==itemVerSocios){	
    		ListarSocios tablaAlu = ListarSocios.getInstancia(); 
			tablaAlu.setVisible(true); 		
    	}
    	
    	if (e.getSource()==itemAltaMaterial){
    		//getInstancia es estatico... por lo tanto se invoca por medio de la Clase
			AgregarMaterial altaMat = AgregarMaterial.getInstancia(); 
			altaMat.setVisible(true);
    	}
    	if (e.getSource()==itemEliminarMaterial){
    		EliminarMaterial bajaMat = EliminarMaterial.getInstancia(); 
			bajaMat.setVisible(true);
    	}	
    	if (e.getSource()==itemVerMateriales){	
    		ListarMateriales tablaMat = ListarMateriales.getInstancia(); 
    		tablaMat.setVisible(true); 		
    	}
    	if (e.getSource()==itemAltaPrestamo){	
    		RealizarPrestamo altaPres = RealizarPrestamo.getInstancia(); 
    		altaPres.setVisible(true); 		
    	}
    	if (e.getSource()==itemVerPrestamos){	
    		ListarPrestamos tablaPres = ListarPrestamos.getInstancia(); 
    		tablaPres.setVisible(true); 		
    	}
    }
    public static void main(String args[]) { 
    	Principal m=new Principal();
    	m.setVisible(true);
    }
}