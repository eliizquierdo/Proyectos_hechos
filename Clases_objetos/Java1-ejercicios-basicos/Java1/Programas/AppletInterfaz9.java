
import java.awt.*;
import java.applet.*;

// <applet width="400" height="200" code="AppletInterfaz9"></applet>

public class AppletInterfaz9 extends Applet {
    	Button b1, b2, b3, b4, b5;	
	    TextField t1, t2, t3, t4, t5;
	    Panel p1, p2;

        public AppletInterfaz9() {
 			setLayout(new FlowLayout());
			p1 = new Panel(new GridLayout(2,2,10,10));
			p2 = new Panel(new BorderLayout());
			t1 = new TextField("a");
			t2 = new TextField("b");
			t3 = new TextField("c");
			t4 = new TextField("d");
			t5 = new TextField("e");
			b1 = new Button("b1");
			b2 = new Button("b2");
			b3 = new Button("b3");
			b4 = new Button("b4");
			b5 = new Button("b5");
			p1.add(t1);
			p1.add(t2);
			p1.add(t3);
			p1.add(t4);
			p1.add(t5);
			p2.add(b1,BorderLayout.NORTH);
			p2.add(b2, BorderLayout.EAST);
			p2.add(b3, BorderLayout.WEST);
			p2.add(b4, BorderLayout.SOUTH);
			p2.add(b5, BorderLayout.CENTER);
			add(p1);
			add(p2);
			
 	    }
}

				
				