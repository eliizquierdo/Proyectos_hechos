import java.awt.*;
import java.applet.*;

 // <applet width="200" height="200" code="Pru2"></applet>

public class Pru2 extends Applet {
	

        public void paint(Graphics g) {
            boolean b;
            int num = 13;
            b = num % 2 == 0;
            g.drawString("num =  "+num + " igual a cero? =" + b, 0, 100);
        }
	
}

				
				