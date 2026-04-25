import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math;

// <applet width="200" height="200" code="AppletDecisiones2"></applet>

public class AppletDecisiones2 extends Applet implements ActionListener {
    	Label l1, l2, l3;
	    TextField t1, t2, t3;
		Button b;
	

        public AppletDecisiones2() {
            l1 = new Label("VALOR x");
            t1 = new TextField(6);
            l2 = new Label("VALOR y");
            t2 = new TextField(6);
	        l3 = new Label("Resultado");
	        t3 = new TextField(6);
	        b = new Button("Calcula");
	        add(l1);
	        add(t1);
	        add(l2);
	        add(t2);
	        add(l3);
	        add(t3);
	        add(b);
	        b. addActionListener(this);
	    }
 	    public void actionPerformed(ActionEvent ae) {
           double x = Double.parseDouble(t1.getText());
           double y = Double.parseDouble(t2.getText());
           double res;
		   if (y >= 0)
		      if ( x > 0)
		           res = 4 * x + 3 * Math.pow (x,2) * y - 2 * y;
		      else
		           res = Math.pow(x,2) - 4* (y - x) + Math.pow (y,2);
		   else
		      res = Math.pow (x,2) + y + y * (x-2);
		   t3.setText("" + res);
	    }
}

				
				