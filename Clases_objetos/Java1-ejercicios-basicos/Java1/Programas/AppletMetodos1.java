import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math;

// <applet width="200" height="200" code="AppletMetodos1"></applet>

public class AppletMetodos1 extends Applet implements ActionListener {
    	Label l1, l2, l3,l4;
	    TextField t1, t2, t3,t4;
		Button b;
		Punto p;
	

        public AppletMetodos1() {
            l1 = new Label("X");
            t1 = new TextField(4);
            l2 = new Label("Y");
            t2 = new TextField(4);
	        b = new Button("DIBUJA PUNTO");
	        add(l1);
	        add(t1);
	        add(l2);
	        add(t2);
	        add(b);
	        b. addActionListener(this);
	    }
	    
	    public void paint(Graphics g) {
	       p.paint(g);
	    }
	    
 	    public void actionPerformed(ActionEvent ae) {
	       int x = Integer.parseInt(t1.getText());
	       int y = Integer.parseInt(t1.getText());
	       p = new Punto(x, y);
	       repaint();
	    }
}

				
				