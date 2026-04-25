//import java.awt.*;
//import java.applet.*;
import javax.swing.*;

// <applet width="200" height="100" code="AppletInterfazJ1"></applet>

public class AppletInterfazJ1 extends JApplet {
    	JLabel l1, l2, l3;	

        public AppletInterfazJ1() {
            l1 = new JLabel();
            l2 = new JLabel("etiqueta 2");
 	        l3 = new JLabel("etiqueta 3", JLabel.CENTER);
	        add(l1);
	        add(l2);
	        add(l3);
	    }
}

				
				