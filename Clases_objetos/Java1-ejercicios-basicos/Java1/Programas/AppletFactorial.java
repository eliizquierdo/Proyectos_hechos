import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math;

// <applet width="200" height="200" code="AppletFactorial"></applet>

public class AppletFactorial extends Applet implements ActionListener {
    	Label l1, l2;
	    TextField t1, t2;
		Button b;
	

        public AppletFactorial() {
            l1 = new Label("Numero");
            t1 = new TextField();
	        l2 = new Label("Factorial");
	        t2 = new TextField();
	        b = new Button("CALCULAR");
	        add(l1);
	        add(t1);
	        add(b);
	        add(l2);
	        add(t2);
	        b. addActionListener(this);
	    }
 	    public void actionPerformed(ActionEvent ae) {
 
 
 	    }
}

				
				