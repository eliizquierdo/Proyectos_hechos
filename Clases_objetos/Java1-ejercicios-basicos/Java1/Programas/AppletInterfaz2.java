import java.awt.*;
import java.applet.*;

// <applet width="300" height="100" code="AppletInterfaz2"></applet>

public class AppletInterfaz2 extends Applet {
    	TextField t1, t2, t3, t4;	

        public AppletInterfaz2() {
            t1 = new TextField();
            t2 = new TextField(10);
 	        t3 = new TextField("Texto3");
	        t4 = new TextField("Texto4",10);
	        add(t1);
	        add(t2);
	        add(t3);
	        add(t4);
	    }
}

				
				