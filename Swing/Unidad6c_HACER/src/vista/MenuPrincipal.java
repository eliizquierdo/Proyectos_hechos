package vista;

import javax.swing.*;

import modelo.vo.Estudiantes;

import java.awt.*;
import java.awt.event.*;

public class MenuPrincipal extends JFrame{
    
	//creacion de la coleccion Estudiantes
	public static Estudiantes coleccion=new Estudiantes();
	
	//**************************************************		
	private JMenuBar mnbPrincipal = new JMenuBar(); //Barra de menus
	//**************************************************
		
	//menu 
	private  JMenu jMenuAlumnos;
    
	// opciones del menu Personas
    private JMenuItem itemAgregarAlumno;
    private JMenuItem itemVerAlumnos;

   
    //constructor
    public MenuPrincipal() {        
    	setTitle("Menu Principal Alumnos");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setResizable(false);
    	this.setBounds(200, 50,600,500);
        iniciarComponentes();
        iniciarManejadoresEventos();
    }
    
    private void iniciarComponentes() {
    	    	
    	//barra de menú principal
    	mnbPrincipal = new JMenuBar();
    	
    	//Menú Personas
        jMenuAlumnos = new  JMenu("Alumnos");
               
        //opciones de menú Personas
        itemAgregarAlumno = new  JMenuItem("Agregar Alumno");
        //itemAlta.addActionListener(this);
        
        itemVerAlumnos= new  JMenuItem("Ver Alumnos");
       // itemVer.addActionListener(this);
        
        //agregamos los itemMenú  al menú
        jMenuAlumnos.add(itemAgregarAlumno);
        jMenuAlumnos.add(itemVerAlumnos);
        
        //agregamos el menú Alumnos a la barra de menú
        mnbPrincipal.add(jMenuAlumnos);
        
        //colocamos el menú principal en el JFrame
        setJMenuBar(mnbPrincipal);
          
    }
    
    private void iniciarManejadoresEventos() {
		itemAgregarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmAlumno altaPer = new FrmAlumno(); 
	    		altaPer.setVisible(true);
			}
		});
		
		itemVerAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmImprime verEstudiantes = new FrmImprime(); 
				verEstudiantes.setVisible(true);
			}
		});
		
    }
       
} 
