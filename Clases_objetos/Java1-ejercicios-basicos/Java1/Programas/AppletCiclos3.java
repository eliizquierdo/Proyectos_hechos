import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math;

// <applet width="300" height="400" code="AppletCiclos3"></applet>

public class AppletCiclos3 extends Applet implements ActionListener {
    	Label l1, l2;
	    TextField t1;
	    TextArea t;
		Button b;
	

        public AppletCiclos3() {
            l1 = new Label("Numero");
            t1 = new TextField(8);
 	        l2 = new Label("Serie");
	        t = new TextArea(20,10);
	        b = new Button("Fibonacci");
	        add(l1);
	        add(t1);
	        add(b);
	        add(l2);
	        add(t);
	        b. addActionListener(this);
	    }
	    
 	    public void actionPerformed(ActionEvent ae) {
          int n = Integer.parseInt(t1.getText());
          t.setText("1" + "\n");
          t.append("1" + "\n");
          int a = 1, b = 1, fibo;
          for (int i = 3; i<= n; i++)   // empiezo i en 3 porque ya mostre los 2 primeros
               {
                 fibo = a + b;
                 t.append("" + fibo + "\n");
                 a = b;
                 b = fibo;
               }
	    }
}

				
				