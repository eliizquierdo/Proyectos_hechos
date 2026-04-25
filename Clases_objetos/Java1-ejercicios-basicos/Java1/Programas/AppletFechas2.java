import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math;

// <applet width="200" height="200" code="AppletFechas2"></applet>

public class AppletFechas2 extends Applet implements ActionListener {
    	Label l1, l2,l3, l4,l5;
	    TextField t1, t2,t3, t4,t5;
		Button b;
	

        public AppletFechas2() {
            l1 = new Label("Año");
            t1 = new TextField();
	        l2 = new Label("Dias");
	        t2 = new TextField();
	        l3 = new Label("Año");
	        t3 = new TextField();
	        l4 = new Label("Mes");
	        t4 = new TextField();
	        l5 = new Label("Dias");
	        t5 = new TextField();
	        b = new Button("CONVERSION");
	        add(l3);
	        add(t3);
	        add(l4);
	        add(t4);
	        add(l5);
	        add(t5);
	        add(b);
	        add(l1);
	        add(t1);
	        add(l2);
	        add(t2);
	        b. addActionListener(this);
	    }
 	    public void actionPerformed(ActionEvent ae) {
 
 
 	    }
}

				
				