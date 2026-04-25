
// <applet width="400" height="200" code="AppletEjemploProy"></applet>

import java.awt.*;
import javax.swing.*;

public class AppletEjemploProy extends JPanel {

    	JLabel l1, l2, l3;
	    JButton b1;
	    JButton  b2,b3,b4, b5;	
	    JTextField t1, t2, t3;
	    TextArea ta1;
	    JPanel p1, p2, p3, p4, p5, p6;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo del Proyecto Final");
        frame.setContentPane(new AppletEjemploProy());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();    
        frame.setVisible(true);
    }


    public AppletEjemploProy() {
			l1 = new JLabel("Matricula");
			l2 = new JLabel("Nombre");
			l3 = new JLabel("Promedio");
			t1 = new JTextField(8);
			t2 = new JTextField(20);
			t3 = new JTextField(6);
			ta1 = new TextArea("",10,22,TextArea.SCROLLBARS_VERTICAL_ONLY);
			ImageIcon icono1 = new ImageIcon("backup.gif", "ALTA");
			ImageIcon icono2 = new ImageIcon("trash1.gif", "BAJA");
			ImageIcon icono3 = new ImageIcon("filview1.gif", "CONSULTA");
			ImageIcon icono4 = new ImageIcon("server04.gif", "LISTA");
			ImageIcon icono5 = new ImageIcon("graph04.gif", "MEJOR ALUMNO");
 			b1 = new JButton("ALTA",icono1);
			b2 = new JButton("BAJA",icono2);
			b3 = new JButton("CONSULTA",icono3);
			b4 = new JButton("LISTA",icono4);
			b5 = new JButton("MEJOR ALUMNO",icono5);
			p1 = new JPanel(new FlowLayout());
			p2 = new JPanel(new GridLayout(3,1,5,5));
			p3 = new JPanel(new GridLayout(1,1,5,5));
			p4 = new JPanel(new GridLayout(1,1,5,5));
			p5 = new JPanel(new GridLayout(1,2,5,5));
			p6 = new JPanel(new GridLayout(1,2,5,5));
			p1.add(l1);
			p1.add(t1);
			p1.add(l2);
			p1.add(t2);
			p1.add(l3);
			p1.add(t3);
			p3.add(ta1);
			p5.add(b1);
			p5.add(b2);
			p2.add(p5);
			p6.add(b3);
			p6.add(b4);
			p2.add(p6);
			p4.add(b5);
			p2.add(p4);
			setLayout(new GridLayout(3,1,5,5));
			add(p1);
			add(p2);
			add(p3);
    }
}

				