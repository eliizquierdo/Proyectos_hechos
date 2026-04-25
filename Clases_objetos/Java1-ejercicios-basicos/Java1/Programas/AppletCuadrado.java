import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math;

// <applet width="200" height="200" code="AppletCuadrado"></applet>

public class AppletCuadrado extends Applet implements ActionListener {
    	Label l1, l2;
	    TextField t1, t2;
		Button b;
	

        public AppletCuadrado() {
            l1 = new Label("Numero");
            t1 = new TextField();
	        l2 = new Label("Cuadrado");
	        t2 = new TextField();
	        b = new Button("Calcula");
	        add(l1);
	        add(t1);
	        add(l2);
	        add(t2);
	        add(b);
	        b. addActionListener(this);
	    }
 	    public void actionPerformed(ActionEvent ae) {
            double num = Double.parseDouble(t1.getText());
            t2.setText(""+Math.pow(num,2.0));
	    }
}

				
				