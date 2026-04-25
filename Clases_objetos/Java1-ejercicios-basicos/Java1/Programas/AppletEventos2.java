import java.awt.*;
import java.applet.*;
import java.awt.event.*;

// <applet width="150" height="200" code="AppletEventos2"></applet>

public class AppletEventos2 extends Applet implements AdjustmentListener {
    	Label l;
	    Scrollbar s;
	    TextField t;
	

        public AppletEventos2() {
            l = new Label("Valor de la barra de Scroll");
            t = new TextField(3);
 	        s = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 100);
			add(s);
			add(l);
			add(t);
	       s.addAdjustmentListener(this);
	    }
	    
 	    public void adjustmentValueChanged(AdjustmentEvent ae) {
	         int valor = s.getValue();
	         t.setText(""+valor);
	    }
}

				
				