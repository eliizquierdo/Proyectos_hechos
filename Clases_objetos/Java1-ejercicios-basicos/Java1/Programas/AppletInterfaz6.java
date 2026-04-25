import java.awt.*;
import java.applet.*;

// <applet width="400" height="400" code="AppletInterfaz6"></applet>

public class AppletInterfaz6 extends Applet {
    	TextArea ta1, ta2, ta3;	

        public AppletInterfaz6() {
 			ta1 = new TextArea();
			ta2 = new TextArea("",10,12,TextArea.SCROLLBARS_HORIZONTAL_ONLY);
			ta3 = new TextArea("",5,5,TextArea.SCROLLBARS_BOTH);
			add(ta1);
			add(ta2);
			add(ta3);
 	    }
}

				
				