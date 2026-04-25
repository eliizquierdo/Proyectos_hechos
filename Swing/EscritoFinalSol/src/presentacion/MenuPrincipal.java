package presentacion;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import logica.LibrosDAO;

import logica.ControladorLogica;


public class MenuPrincipal extends JFrame  implements ActionListener{
    
	//lo único que contendrá este JFrame será la barra de menú
	
	//**************************************************		
	private JMenuBar mnbPrincipal = new JMenuBar(); //Barra de menus
	//**************************************************
	
	private static MenuPrincipal instancia;
	
	
    // Atributos privados 
    private  JMenuItem itemAltaAlumno;
    private  JMenuItem itemModificarAlumno;
    private  JMenuItem itemMostrarAlumnos;
    private  JMenuItem itemEliminarAlumno;
    private  JMenuItem itemAltaLibro;
    private  JMenuItem itemEliminarLibro;
    private  JMenuItem itemSalir;
    private  JMenuItem itemMostrarLibros;
    
    private  JMenu jMenuAlumnos;
    private  JMenu jMenuSistema;
    private JMenu jMenuLibros;
   
    //constructor privado
    private MenuPrincipal() {        
    	setTitle("Menu Principal ");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setResizable(false);
    	this.setBounds(200, 50,600,500);
        iniciarComponentes();
                           
    }
    
    private void iniciarComponentes() {
    	    	
    	//barra de menú principal
    	mnbPrincipal = new JMenuBar();
    	
    	//Menú Alumnos
        jMenuAlumnos = new  JMenu("Alumnos");
        
        jMenuLibros = new  JMenu("Libros");
               
        //opciones de menú Alumnos
        itemAltaAlumno = new  JMenuItem("Agregar Alumno");
        itemAltaAlumno.addActionListener(this);
        
        itemModificarAlumno = new  JMenuItem("Modificar Alumno");
        itemModificarAlumno.addActionListener(this);
        
        itemMostrarAlumnos= new  JMenuItem("Mostrar Alumnos");
        itemMostrarAlumnos.addActionListener(this);
        
        itemEliminarAlumno= new  JMenuItem("Eliminar Alumno");
        itemEliminarAlumno.addActionListener(this);
        
        //opciones de menú Alumnos
        itemAltaLibro = new  JMenuItem("Agregar Libro");
        itemAltaLibro.addActionListener(this);
        itemEliminarLibro= new  JMenuItem("Eliminar Libro");
        itemEliminarLibro.addActionListener(this);
        itemMostrarLibros= new  JMenuItem("Mostrar Libro");
        itemMostrarLibros.addActionListener(this);
        
        //agregamos los itemMenú  al menú
        jMenuAlumnos.add(itemAltaAlumno);
        jMenuAlumnos.add(itemModificarAlumno);
        jMenuAlumnos.add(itemEliminarAlumno);
        jMenuAlumnos.add(itemMostrarAlumnos);
        
        jMenuLibros.add(itemAltaLibro);
        jMenuLibros.add(itemEliminarLibro);
        jMenuLibros.add(itemMostrarLibros);
        
        //agregamos el menú Alumnos a la barra de menú
        mnbPrincipal.add(jMenuAlumnos);
        mnbPrincipal.add(jMenuLibros);
       
        //Menú Sistema
        jMenuSistema = new  JMenu("Sistema");
        
      //opciones de menú Sistema
        itemSalir = new  JMenuItem("Salir");
        itemSalir.addActionListener(this);
        
      //agregamos el itemMenú  al menú
        jMenuSistema.add(itemSalir);
        
        //agregamos el menú Sistema a la barra de menú
        mnbPrincipal.add(jMenuSistema);
        
        //colocamos el menú principal en el JFrame
        setJMenuBar(mnbPrincipal);
    }
    
    public static MenuPrincipal getInstancia(){
    	
     	if (instancia==null)
			instancia = new MenuPrincipal();
    	return instancia;
    }

    @Override
	public void actionPerformed(ActionEvent e) {
    	if (e.getSource()==itemAltaAlumno){
    		AgregarAlumno altaNac = AgregarAlumno.getInstancia();
			altaNac.setVisible(true);
    	}
    	if (e.getSource()==itemModificarAlumno){
			ModificarAlumno modAlu = ModificarAlumno.getInstancia(); 
			modAlu.setVisible(true);
    	}
    	
    	
    	if (e.getSource()==itemMostrarAlumnos){
			MostrarAlumnos tablaAlu = new MostrarAlumnos(); //Si la hago singleton deja de refrescarse
			tablaAlu.setVisible(true);
    	}
    	
    
    	
    	if (e.getSource()==itemEliminarAlumno){
    		int auxCed=0; 
    		boolean ok=false;
    		
    		try{
				String auxCedula=JOptionPane.showInputDialog(this,"Ingrese cédula: ","Eliminar Alumno",JOptionPane.INFORMATION_MESSAGE);
				auxCed=Integer.parseInt(auxCedula);
				ok=ControladorLogica.getInstancia().eliminarAlumno(auxCed);
				if (ok==true)
					JOptionPane.showMessageDialog(null, "Alumno eliminado correctamente  \n");	
				else
					JOptionPane.showMessageDialog(null, "No existe alumno con esa cédula  \n");	
    		}catch(Exception e1){
    			 JOptionPane.showMessageDialog(null, "Cedula incorrecta, intente de nuevo  \n","Error",JOptionPane.ERROR_MESSAGE);	
    		}
		}
    	if (e.getSource()==itemAltaLibro){
    		AgregarLibro altaNac = AgregarLibro.getInstancia();
			altaNac.setVisible(true);
    	}
    	if (e.getSource()==itemEliminarLibro){
    		int auxCod=0; 
    		boolean ok=false;
    		
    		try{
				String auxCodigo=JOptionPane.showInputDialog(this,"Ingrese código: ","Eliminar Libro",JOptionPane.INFORMATION_MESSAGE);
				auxCod=Integer.parseInt(auxCodigo);
				ok=ControladorLogica.getInstancia().eliminarLibro(auxCod);
				if (ok==true)
					JOptionPane.showMessageDialog(null, "Libro eliminado correctamente  \n");	
				else
					JOptionPane.showMessageDialog(null, "No existe libro con ese codigo \n");	
    		}catch(Exception e1){
    			 JOptionPane.showMessageDialog(null, "Codigo incorrecto, intente de nuevo  \n","Error",JOptionPane.ERROR_MESSAGE);	
    		}
		}
    	if (e.getSource()==itemMostrarLibros){
			MostrarLibros tablaLib = new MostrarLibros(); //Si la hago singleton deja de refrescarse
			tablaLib.setVisible(true);
    	}
    	
    	if (e.getSource()==itemSalir){
   		 
    		try{
				 ControladorLogica.getInstancia().desconectarBD();
	        	 JOptionPane.showMessageDialog(null, "Se desconecto correctamente  \n");	
	        	 System.exit(0);
	        }catch(Exception e1){
	    			 JOptionPane.showMessageDialog(null, "Error  \n","Error",JOptionPane.ERROR_MESSAGE);	
	        }
	        	 
    	}
    }
 }
