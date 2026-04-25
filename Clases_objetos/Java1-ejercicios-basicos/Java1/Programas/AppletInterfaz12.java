import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.StringTokenizer;
// <applet width="400" height="400" code="AppletInterfaz12"></applet>

public class AppletInterfaz12 extends Applet implements ActionListener{
    	Button b1;	
	    TextField t1, t2, t3, t4;
	    Label l1, l2, l3, l4;
	    Panel p1, p2, p3, p4;

        public AppletInterfaz12() {
 			setLayout(new BorderLayout());
			p1 = new Panel(new GridLayout(2,1,5,5));
			p2 = new Panel(new FlowLayout());
			p3 = new Panel(new FlowLayout());
			p4 = new Panel(new FlowLayout());			 
			l1 = new Label("Fecha  dd/mm/aaa");
			t1 = new TextField(10);
			l2 = new Label("DIA");
			t2 = new TextField(3);
			l3 = new Label("MES");
			t3 = new TextField(3);
			l4 = new Label("AÑO");
			t4 = new TextField(3);
			b1 = new Button("Convertir");
			t2.setEditable(false);
			t3.setEditable(false);
			t4.setEditable(false);
			p1.add(l1);
			p1.add(t1);
			p2.add(l2);
			p2.add(t2);
			p3.add(l3);
			p3.add(t3);
			p4.add(l4);
			p4.add(t4);
           add(p1, BorderLayout.NORTH);
			add(p2, BorderLayout.WEST);
			add(p4, BorderLayout.EAST);
			add(p3, BorderLayout.SOUTH);
			add(b1, BorderLayout.CENTER);	
			b1.addActionListener(this);
		}
	     
	    public void actionPerformed(ActionEvent ae) {
	        StringTokenizer st = new StringTokenizer(t1.getText(), "/");
	        t2.setText(st.nextToken());
	        t3.setText(st.nextToken());
	        t4.setText(st.nextToken());
       }	        
}

				
				