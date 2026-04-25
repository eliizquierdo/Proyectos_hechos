import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math;

// <applet width="200" height="200" code="AppletTeatro"></applet>

public class AppletTeatro extends Applet implements ActionListener {
    	Label l1, l2,l3;
	    TextField t1, t2;
	    TextArea ta;
		Button b1, b2;
	

        public AppletTeatro() {
            l1 = new Label("Fila");
            t1 = new TextField();
	        l2 = new Label("Asiento");
	        t2 = new TextField();
	        l3 = new Label("Resultado");
	        ta = new TextArea("", 10,10);
	        b1 = new Button("RESERVA");
	        b2 = new Button("CONSULTA");
	        add(l1);
	        add(t1);
	        add(l2);
	        add(t2);
	        add(b1);
	        add(b2);
	        add(l3);
	        add(ta);
	    }
 	    public void actionPerformed(ActionEvent ae) {
 
 
 	    }
}

				
				