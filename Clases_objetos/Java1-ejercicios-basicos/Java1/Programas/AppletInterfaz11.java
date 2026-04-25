import java.awt.*;
import java.applet.*;

// <applet width="400" height="400" code="AppletInterfaz11"></applet>

public class AppletInterfaz11 extends Applet {
    	Button b1, b2;	
	    TextField t1, t2, t3, t4, t5;
	    Panel p1, p2;

        public AppletInterfaz11() {
 			setLayout(new BorderLayout());
			p1 = new Panel(new FlowLayout());
			p2 = new Panel(new FlowLayout());
			t1 = new TextField("a");
			t2 = new TextField("b");
			t3 = new TextField("c");
			t4 = new TextField("d");
			t5 = new TextField("e");
			b1 = new Button("b1");
			b2 = new Button("b2");
			add(t1, BorderLayout.SOUTH);
			add(t2, BorderLayout.EAST);
			add(t3, BorderLayout.WEST);
			p1.add(t4);
			p1.add(t5);
			p2.add(b1);
			p2.add(b2);
			add(p1, BorderLayout.NORTH);
			add(p2, BorderLayout.CENTER);
 	    }
}

				
				