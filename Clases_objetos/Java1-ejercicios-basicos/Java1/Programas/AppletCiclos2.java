import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math;

// <applet width="300" height="400" code="AppletCiclos2"></applet>

public class AppletCiclos2 extends Applet implements ActionListener {
    	Label l1, l2;
	    TextField t1, t2;
		Button b;
	

        public AppletCiclos2() {
            l1 = new Label("Numero");
            t1 = new TextField(8);
 	        l2 = new Label("Digitos");
	        t2 = new TextField(20);
	        b = new Button("SABER DIGITOS");
	        add(l1);
	        add(t1);
	        add(b);
	        add(l2);
	        add(t2);
	        b. addActionListener(this);
	    }
	    
 	    public void actionPerformed(ActionEvent ae) {
          int x = Integer.parseInt(t1.getText());
          int cant = 0;
	       do
	       {
	          x = x / 10;
	          cant++;
	       } while (cant > 0);
	       t2.setText("El numero tiene " + cant + " digitos");

	    }
}

				
				