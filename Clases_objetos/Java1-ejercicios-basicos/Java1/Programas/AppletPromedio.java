import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math;

// <applet width="200" height="200" code="AppletPromedio"></applet>

public class AppletPromedio extends Applet implements ActionListener {
    	Label l1, l2,l3, l4;
	    TextField t1, t2,t3, t4;
		Button b;
	

        public AppletPromedio() {
            l1 = new Label("Numero 1");
            t1 = new TextField();
	        l2 = new Label("Numero 2");
	        t2 = new TextField();
	        l3 = new Label("Numero 3");
	        t3 = new TextField();
	        l4 = new Label("Promedio");
	        t4 = new TextField();
	        b = new Button("PROMEDIO");
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
            double num1 = Double.parseDouble(t1.getText());
           double num2 = Double.parseDouble(t2.getText());
           double num3 = Double.parseDouble(t3.getText());

            t4.setText(""+(num1 + num2 + num3)/3);
	    }
}

				
				