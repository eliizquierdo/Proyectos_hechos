import java.awt.*;
import java.applet.*;
import java.awt.event.*;

// <applet width="200" height="200" code="AppletDecisiones1"></applet>

public class AppletDecisiones1 extends Applet implements ActionListener {
    	Label l1, l2;
	    TextField t1, t2;
		Button b;
	

        public AppletDecisiones1() {
            l1 = new Label("Numero");
            t1 = new TextField(6);
	        l2 = new Label("Resultado");
	        t2 = new TextField(18);
	        b = new Button("Calcula");
	        add(l1);
	        add(t1);
	        add(l2);
	        add(t2);
	        add(b);
	        b. addActionListener(this);
	    }
 	    public void actionPerformed(ActionEvent ae) {
            int num = Integer.parseInt(t1.getText());
            if (num > 0)
               t2.setText("El número es positivo");
            else if (num == 0)
               t2.setText("El número es cero");
            else
               t2.setText("El número es negativo");
	    }
}

				
				