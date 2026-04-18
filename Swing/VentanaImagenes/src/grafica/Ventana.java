package grafica;

//explicación aquí: https://codejavu.blogspot.com/2014/01/imagenes-en-java.html

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.SwingConstants;


public class Ventana extends JFrame implements ActionListener {
 
 private Container contenedor;//declaramos el contenedor
 JButton salir;//declaramos el objeto Boton
 JLabel labelTitulo;//declaramos el objeto Label
 JLabel labelImagen;

 
 public Ventana(){
  /**permite iniciar las propiedades de los componentes*/
  iniciarComponentes();
     /**Asigna un titulo a la barra de titulo*/
  setTitle("CoDejaVu : Imagenes en Java");
  /**tamaño de la ventana*/
  setSize(500,520);
  /**pone la ventana en el Centro de la pantalla*/
  setLocationRelativeTo(null);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }

 private void iniciarComponentes() {
  contenedor=getContentPane();//instanciamos el contenedor
  contenedor.setLayout(null);
  
  /**Propiedades del boton, lo instanciamos, posicionamos y
   * activamos los eventos*/
  salir=new JButton();
  salir.setHorizontalAlignment(SwingConstants.LEFT);
  salir.setFont(new Font("Tahoma", Font.BOLD, 11));
  salir.setText("Salir");
  salir.setBounds(343,430,107,30);
  salir.setIcon(new ImageIcon(Ventana.class.getResource("/images/aceptar.png")));
  salir.addActionListener(this);
  
  labelImagen=new JLabel();
  labelImagen.setBounds(50,70,400,330);
  labelImagen.setIcon(new ImageIcon(Ventana.class.getResource("/images/fondo.png")));
  labelImagen.setBorder(javax.swing.BorderFactory.createBevelBorder
        (javax.swing.border.BevelBorder.RAISED));
  
  /**Propiedades del Label, lo instanciamos, posicionamos y
   * activamos los eventos*/
  labelTitulo= new JLabel();
  labelTitulo.setForeground(new Color(255, 0, 0));
  labelTitulo.setBackground(new Color(128, 0, 255));
  labelTitulo.setText("setIcon");
  labelTitulo.setFont(new java.awt.Font("Comic Sans MS", 0, 28));
  labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
  labelTitulo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
  labelTitulo.setBounds(100, 10, 300, 40);
  
  /**Agregamos los componentes al Contenedor*/
  contenedor.add(labelTitulo);
  contenedor.add(salir);
  contenedor.add(labelImagen);
 }

 /**Agregamos el evento al momento de llamar la otra ventana*/
 @Override
 public void actionPerformed(ActionEvent evento) {
  if (evento.getSource()==salir)
  {
   int respuesta = JOptionPane.showConfirmDialog(this,
     "Esta seguro que desea salir?", "Confirmación",
     JOptionPane.YES_NO_OPTION);
   if (respuesta == JOptionPane.YES_NO_OPTION)
   {
    System.exit(0);
   }
  }
 }
}

