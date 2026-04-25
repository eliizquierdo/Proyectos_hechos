import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math;

// <applet width="200" height="200" code="AppletCiclos4"></applet>

public class AppletCiclos4 extends Applet implements ActionListener {
    	Label l1, l2;
	    TextField t1,t2;
		Button b;
	

        public AppletCiclos4() {
            l1 = new Label("Numero");
            t1 = new TextField(8);
 	        l2 = new Label("Suma");
	        t2 = new TextField(8);
	        b = new Button("Suma");
	        add(l1);
	        add(t1);
	        add(b);
	        add(l2);
	        add(t2);
	        b. addActionListener(this);
	    }
	    
 	    public void actionPerformed(ActionEvent ae) {
          int n = Integer.parseInt(t1.getText());
          int suma = 0;
          for (int i = 1; i<= n; i++) {
               	suma += i;
          }
          t2.setText("" + suma);
	    }
}

				
				