import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math;

// <applet width="200" height="200" code="AppletEjCiclos1"></applet>

public class AppletEjCiclos1 extends Applet implements ActionListener {
    	Label l1, l2,l3,l4;
	    TextField t1, t2,t3;
	    TextArea ta;
		Button b;
	

        public AppletEjCiclos1() {
            l1 = new Label("Inicio");
            t1 = new TextField();
	        l2 = new Label("Fin");
	        t2 = new TextField();
	        l3 = new Label("Incremento");
	        t3 = new TextField();
	        l4 = new Label("Resultado");
	        ta = new TextArea("",10,12);
	        b = new Button("CONVERSION");
	        add(l1);
	        add(t1);
	        add(l2);
	        add(t2);
	        add(l3);
	        add(t3);
	        add(b);
	        add(l4);
	        add(ta);
	        b. addActionListener(this);
	    }
 	    public void actionPerformed(ActionEvent ae) {
 
 
 	    }
}

				
				