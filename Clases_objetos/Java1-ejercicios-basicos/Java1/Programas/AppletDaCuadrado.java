import java.awt.*;
import java.applet.*;
import java.awt.event.*;

// <applet width="200" height="200" code="AppletDaCuadrado"></applet>

public class AppletDaCuadrado extends Applet implements ActionListener {
    	TextField t;
		Button b;
	

        public AppletDaCuadrado() {
            t = new TextField();
	        b = new Button("Calcula");
	        add(t);
	        add(b);
	        b. addActionListener(this);
	    }
        public void paint(Graphics g) {
            int num = Integer.parseInt(t.getText());
            g.drawString("Cuadrado = "+num*num, 100, 100);
        }
	    public void actionPerformed(ActionEvent ae) {
	        repaint();
	    }
}

				
				