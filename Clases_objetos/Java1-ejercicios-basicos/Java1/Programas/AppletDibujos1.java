import java.awt.*;
import java.applet.*;

public class AppletDibujos1 extends Applet {
	

        public void paint(Graphics g) {
            g.drawString("Hola", 100, 100);
            g.drawLine(10,10, 100, 100);
            g.drawRect(0, 0, 150, 150);
	    g.drawOval(100, 100, 100, 100);
        }
	
}

				
				