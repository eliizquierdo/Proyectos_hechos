import java.awt.*;
import java.applet.*;

// <applet width="400" height="400" code="AppletInterfaz8"></applet>

public class AppletInterfaz8 extends Applet {
    	Button b1, b2, b3;	
	    TextField t1, t2;

        public AppletInterfaz8() {
 			setLayout(new BorderLayout());
			t1 = new TextField("a");
			t2 = new TextField("b");
			b1 = new Button("b1");
			b2 = new Button("b2");
			b3 = new Button("b3");
			add(t1, BorderLayout.NORTH);
			add(t2, BorderLayout.EAST);
			add(b1, BorderLayout.WEST);
			add(b2, BorderLayout.SOUTH);
			add(b3, BorderLayout.CENTER);
			
 	    }
}

				
				