import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math;

// <applet width="200" height="200" code="AppletDecisiones3"></applet>

public class AppletDecisiones3 extends Applet implements ActionListener {
    	Label l1, l2, l3,l4;
	    TextField t1, t2, t3,t4;
		Button b;
	

        public AppletDecisiones3() {
            l1 = new Label("VALOR 1");
            t1 = new TextField(6);
            l2 = new Label("VALOR 2");
            t2 = new TextField(6);
            l3 = new Label("VALOR 2");
            t3 = new TextField(6);
	        l4 = new Label("Resultado");
	        t4 = new TextField(16);
	        b = new Button("Calcula");
	        add(l1);
	        add(t1);
	        add(l2);
	        add(t2);
	        add(l3);
	        add(t3);
	        add(b);
	        add(l4);
	        add(t4);
	        b. addActionListener(this);
	    }
 	    public void actionPerformed(ActionEvent ae) {
           double a = Double.parseDouble(t1.getText());
           double b = Double.parseDouble(t2.getText());
           double c = Double.parseDouble(t3.getText());
           double res;
		   if (a >= b)
		      if ( a >= c)
		           t4.setText(""+ a + " es el mayor");
		      else
		           t4.setText(""+ c + " es el mayor");
		   else
		      if ( b >= c)
		           t4.setText(""+ b + " es el mayor");
		      else
		           t4.setText(""+ c + " es el mayor");
	    }
}

				
				