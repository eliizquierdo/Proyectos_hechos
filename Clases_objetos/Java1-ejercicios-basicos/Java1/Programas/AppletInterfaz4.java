import java.awt.*;
import java.applet.*;
import java.awt.event.*;

// <applet width="200" height="200" code="AppletInterfaz4"></applet>

public class AppletInterfaz4 extends Applet implements ItemListener{
    	Choice ch1, ch2;	

        public AppletInterfaz4() {
            ch1 = new Choice();
            ch2 = new Choice();
	        ch1.add("Primero");
	        ch1.add("Segundo");
	        ch1.add("Tercero");
	        ch1.add("Cuarto");
	        ch2.add("Uno");
	        ch2.add("Dos");
	        ch2.add("Tres");
	        ch2.add("Cuatro");
	        ch2.add("Cinco");
	        ch1.select("Cuarto");
	        add(ch1);
	        add(ch2);
	        ch1.addItemListener(this);
	        ch2.addItemListener(this);
	    }
	    
	    public void itemStateChanged(ItemEvent ie) {
	        repaint();
	    }
	    
	    public void paint(Graphics g) {
	        String msg = "Primer menu = ";
	        msg += ch1.getSelectedItem();
	        g.drawString(msg, 0,100);
	        msg = "Segundo menu = ";
	        msg += ch2.getSelectedItem();
	        g.drawString(msg, 0,140);
	    }
	        
}

				
				