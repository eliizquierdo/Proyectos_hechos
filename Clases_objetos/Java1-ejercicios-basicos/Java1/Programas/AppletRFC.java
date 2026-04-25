import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math;

// <applet width="200" height="200" code="AppletRFC"></applet>

public class AppletRFC extends Applet implements ActionListener {
    	Label l1, l2,l3;
	    TextField t1, t2,t3;
		Button b;
	

        public AppletRFC() {
            l1 = new Label("RFC");
            t1 = new TextField(12);
	        l2 = new Label("clave");
	        t2 = new TextField(4);
	        l3 = new Label("fecha");
	        t3 = new TextField(8);
	        b = new Button("TOKENIZAR");
	        add(l1);
	        add(t1);
	        add(b);
	        add(l2);
	        add(t2);
	        add(l3);
	        add(t3);
	        b. addActionListener(this);
	    }
 	    public void actionPerformed(ActionEvent ae) {
 
 
 	    }
}

				
				