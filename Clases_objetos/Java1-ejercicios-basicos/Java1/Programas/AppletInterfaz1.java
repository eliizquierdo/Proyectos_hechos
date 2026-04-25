import java.awt.*;
import java.applet.*;

// <applet width="200" height="100" code="AppletInterfaz1"></applet>

public class AppletInterfaz1 extends Applet {
    	Label l1, l2, l3;	

        public AppletInterfaz1() {
            l1 = new Label();
            l2 = new Label("etiqueta 2");
 	        l3 = new Label("etiqueta 3", Label.CENTER);
	        add(l1);
	        add(l2);
	        add(l3);
	    }
}

				
				