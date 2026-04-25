import java.awt.*;
import java.applet.*;
import java.awt.event.*;


// <applet width="200" height="200" code="AppletEjEventos1"></applet>

public class AppletEjEventos1 extends Applet  {
    	Label l1, l2,l3;
	    Scrollbar t1, t2,t3;
	

        public AppletEjEventos1() {
            l1 = new Label("Rojo");
            t1 = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 100);
	        l2 = new Label("Azul");
	        t2 = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 100);
	        l3 = new Label("Amarillo");
	        t3 = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 100);
	        add(l1);
	        add(t1);
	        add(l2);
	        add(t2);
	        add(l3);
	        add(t3);
	    }
 	    public void paint(Graphics g) {
            g.setColor(Color.blue);
                  g.fillOval(100,100,100,100);
 	    }
}

				
				