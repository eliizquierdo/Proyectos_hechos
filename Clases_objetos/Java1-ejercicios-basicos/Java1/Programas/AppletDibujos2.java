import java.awt.*;
import java.applet.*;

// <applet width="400" height="200" code="AppletDibujos2"></applet>

public class AppletDibujos2 extends Applet {
	

        public void paint(Graphics g) {
            g.drawString("Juan Perez", 150, 80);
            g.setColor(Color.red);
            g.drawRect(100, 50, 200, 50);
        }
	
}

				
				