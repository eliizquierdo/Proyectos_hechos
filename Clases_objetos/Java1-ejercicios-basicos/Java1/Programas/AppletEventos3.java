import java.awt.*;
import java.applet.*;
import java.awt.event.*;

// <applet width="150" height="200" code="AppletEventos3"></applet>

public class AppletEventos3 extends Applet implements AdjustmentListener {
        Scrollbar s;
        int barra = 0;
	    	

        public AppletEventos3() {
 	        s = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 100);
			add(s);
	       s.addAdjustmentListener(this);
	    }
	    
	    public void paint(Graphics g) {
	        g.drawRect(40, 80, 60, 100);
	        g.fillRect(40, 80, 60, barra);
	    }
	    
 	    public void adjustmentValueChanged(AdjustmentEvent ae) {
	         barra = s.getValue();
	         repaint();
	    }
}

				
				