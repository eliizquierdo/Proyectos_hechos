import java.awt.*;
import java.applet.*;
import java.awt.event.*;


// <applet width="200" height="200" code="AppletEjEventos2"></applet>

public class AppletEjEventos2 extends Applet  {
    	Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12,b13,b14,b15,b16;
	   TextField t;
	   Panel p1, p2, p3, p4,p5, p6, p7, p8;

        public AppletEjEventos2() {
            b0 = new Button(".");
            b1 = new Button("0");
            b2 = new Button("1");
            b3 = new Button("2");
            b4 = new Button("3");
            b5 = new Button("4");
            b6 = new Button("5");
            b7 = new Button("6");
            b8 = new Button("7");
            b9 = new Button("8");
            b10 = new Button("9");
            b11 = new Button("+");
            b12 = new Button("-");
            b13 = new Button("*");
            b14 = new Button("/");
            b15 = new Button("=");
            b16 = new Button("C");
            t = new TextField(12);
            setLayout(new GridLayout(8,1,5,5));
            p1 = new Panel(new GridLayout(1,1,5,5));
            p2 = new Panel(new GridLayout(1,3,5,5));
            p3 = new Panel(new GridLayout(1,3,5,5));
            p4 = new Panel(new GridLayout(1,3,5,5));
            p5 = new Panel(new GridLayout(1,2,5,5));
            p6 = new Panel(new GridLayout(1,2,5,5));
            p7 = new Panel(new GridLayout(1,2,5,5));
            p8 = new Panel(new GridLayout(1,2,5,5));
            p1.add(t);
            p2.add(b2);
            p2.add(b3);
            p2.add(b4);
            p3.add(b5);
            p3.add(b6);
            p3.add(b7);
            p4.add(b8);
            p4.add(b9);
            p4.add(b10);
            p5.add(b0);
            p5.add(b1);
            p6.add(b11);
            p6.add(b12);
            p7.add(b13);
            p7.add(b14);
            p8.add(b15);
            p8.add(b16);
	        add(p1);
	        add(p2);
	        add(p3);
	        add(p4);
	        add(p5);
	        add(p6);
	        add(p7);
	        add(p8);
	    }
}					