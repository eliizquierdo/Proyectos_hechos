import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math;

// <applet width="200" height="200" code="AppletResiduo"></applet>

public class AppletResiduo extends Applet implements ActionListener {
    	Label l1, l2,l3;
	    TextField t1, t2,t3;
		Button b;
	

        public AppletResiduo() {
            l1 = new Label("Dividendo");
            t1 = new TextField();
	        l2 = new Label("Divisor");
	        t2 = new TextField();
	        l3 = new Label("Residuo");
	        t3 = new TextField();
	        b = new Button("RESIDUO");
	        add(l1);
	        add(t1);
	        add(l2);
	        add(t2);
	        add(b);
	        add(l3);
	        add(t3);
	        b. addActionListener(this);
	    }
 	    public void actionPerformed(ActionEvent ae) {
            double num = Double.parseDouble(t1.getText());
            t2.setText(""+Math.pow(num,2.0));
	    }
}

				
				