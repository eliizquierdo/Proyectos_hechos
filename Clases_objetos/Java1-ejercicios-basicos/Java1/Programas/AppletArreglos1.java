import java.awt.*;
import java.applet.*;
import java.awt.event.*;

// <applet width="400" height="200" code="AppletArreglos1"></applet>

public class AppletArreglos1 extends Applet implements ActionListener{
    	Label l1, l2;
	    Button b1, b2,b3,b4;	
	    TextField t1;
	    TextArea ta1;
	    int arreglo[];
	    int conta;

        public AppletArreglos1() {
			l1 = new Label("Dato a Añadir");
			l2 = new Label("Texto para ver Arreglo");
			t1 = new TextField();
			ta1 = new TextArea(10,12);
			b1 = new Button("Añade");
			b2 = new Button("Muestra Vector");
			b3 = new Button("Limpia Vector");
			b4 = new Button("Limpia Campos");
			add(l1);
			add(t1);
			add(l2);
			add(ta1);
			add(b1);
			add(b2);
			add(b3);
			add(b4);
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			arreglo = new int[100];
			conta=0;
 	    }
	     
	    public void actionPerformed(ActionEvent ae) {
	        if (ae.getSource() == b1) {
	            if (conta > arreglo.length) {
	                ta1.setText("No se puede añadir otro elemento");
	            }
	            else {
	                arreglo[conta++] = Integer.parseInt(t1.getText());
	                t1.setText("");   
	            }
	         }
	         if (ae.getSource() == b2) {
	               ta1.setText("");
	               for (int i=0; i < conta; i++) {
	                   ta1.append("" + arreglo[i] + "\n");
	               }
	         }
	         if (ae.getSource() == b3) {
	               conta = 0;
	               arreglo = new int[100];
	         }
	         if (ae.getSource() == b4) {
					t1.setText("");
					ta1.setText("");
	         }
	    }
}

				
				