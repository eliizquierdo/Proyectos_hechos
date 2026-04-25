import java.awt.*;
import java.applet.*;
import java.awt.event.*;

// <applet width="300" height="200" code="AppletInterfaz5"></applet>

public class AppletInterfaz5 extends Applet implements ItemListener{
    	List ch1, ch2;	

        public AppletInterfaz5() {
            ch1 = new List();
            ch2 = new List();
	        ch1.add("Primero");
	        ch1.add("Segundo");
	        ch1.add("Tercero",0);
	        ch1.add("Cuarto",0);
	        ch2.add("Uno");
	        ch2.add("Dos");
	        ch2.add("Tres");
	        ch2.add("Cuatro");
	        ch2.add("Cinco");
	        add(ch1);
	        add(ch2);
	        ch1.addItemListener(this);
	        ch2.addItemListener(this);
	    }
	    
	    public void itemStateChanged(ItemEvent ie) {
	        repaint();
	    }
	    
	    public void paint(Graphics g) {
	        String msg = "Primera lista = ";
	        msg += ch1.getSelectedItem();
	        g.drawString(msg, 0,100);
	        msg = "Segunda lista = ";
	        msg += ch2.getSelectedItem();
	        g.drawString(msg, 0,140);
	    }      
}

				
				