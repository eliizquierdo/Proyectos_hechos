import java.awt.*;
import java.applet.*;
import java.awt.event.*;

// <applet width="200" height="200" code="AppletMetodos2"></applet>

public class AppletMetodos2 extends Applet implements ActionListener {
		Button b;
		Punto p;
		int x, y;
	

        public AppletMetodos2() {
 	        b = new Button("DIBUJA PUNTO");
	        add(b);
	        b. addActionListener(this);
	    }
	    
	    public void paint(Graphics g) {
	       p.paint(g);
	    }
	    
 	    public void actionPerformed(ActionEvent ae) {
	       for (x = 0; x < 100; x ++) {
	          for (y=0; y < 100; y++) {
	               p = new Punto(x, y);
	               repaint();
	           }
	       }
	    }
}

				
				