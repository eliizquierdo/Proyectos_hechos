import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math;

// <applet width="200" height="200" code="AppletTel"></applet>

public class AppletTel extends Applet implements ActionListener {
    	Label l1, l2,l3;
	    TextField t1, t2,t3;
		Button b;
	

        public AppletTel() {
            l1 = new Label("TEL");
            t1 = new TextField(12);
	        l2 = new Label("ZONA");
	        t2 = new TextField(4);
	        l3 = new Label("NUMERO");
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

				
				