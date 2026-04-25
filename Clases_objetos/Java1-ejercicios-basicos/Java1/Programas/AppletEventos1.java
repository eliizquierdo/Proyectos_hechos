import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math;

// <applet width="150" height="200" code="AppletEventos1"></applet>

public class AppletEventos1 extends Applet implements ActionListener {
    	Label l1, l2;
	    TextField t1,t2;
		Button b1,b2;
	

        public AppletEventos1() {
            l1 = new Label("Numero");
            t1 = new TextField(8);
 	        l2 = new Label("Suma");
	        t2 = new TextField(8);
	        b1 = new Button("Suma");
	        b2 = new Button("Limpia");
	        add(l1);
	        add(t1);
	        add(b1);
	        add(b2);
	        add(l2);
	        add(t2);
	        b1. addActionListener(this);
	        b2. addActionListener(this);
	    }
	    
 	    public void actionPerformed(ActionEvent ae) {
	      if (ae.getSource() == b1) {
             int n = Integer.parseInt(t1.getText());
             int suma = 0;
             for (int i = 1; i<= n; i++) {
                    	suma += i;
             }
             t2.setText("" + suma);
          }
          if (ae.getActionCommand() == "Limpia") {
              t1.setText("");
              t2.setText("");
          }
	    }
}

				
				