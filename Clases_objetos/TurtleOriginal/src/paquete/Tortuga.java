package paquete;
//https://aplu.ch/home/apluhomex.jsp?site=65
import ch.aplu.turtle.*;
import java.awt.Color;

public class Tortuga {
	private Turtle t;
	
	//constructor
	public Tortuga() {
		 t = new Turtle();
		 t.setColor(Color.green);
		 t.setPenColor(Color.red); 
		// t.setLineWidth(5);
		 t.addStatusBar(20);
	}

	public void  cuadrado(int lado) {
		
		for (int i = 1; i <=4; i++){
	      t.forward(lado);
	      t.right(90);
	    }
	}	
	
	public void cambiarColorRelleno(String c) {
		t.setFillColor(c);
		
	}
	
	public void cuadradoRelleno(int x,int y,int lado) {
		t.setPos(x,y);
		
		for (int i = 1; i <=4; i++){
		      t.forward(lado);
		      t.right(90);
		    }
		t.fill(x+1,y+1);
		
	}
	
	public  void triangulo(int lado){
		
		for (int i = 1; i <=3; i++){
	      t.forward(lado);
	      t.right(120);
	    }
	}
	
	public  void cuadrado4() {
		for(int i=0; i<=4; i++) {
			this.cuadrado(20*i);
			
		}
	}
	
	public void espiral() {
	
		for (int s = 4; s < 200; s = s + 2){
		      if (s == 140)
		    	  t.setPenColor(Color.green);
		      t.forward(s);
		      t.right(90);
		      t.setStatusText("Size: " + s);
		}
	}
	
	public void escalera() {
		 for (int i = 0; i < 6; i++){
		      if (i % 2 == 0)
		        t.setPenColor(Color.red);
		      else
		        t.setPenColor(Color.green);  
		      
		      t.fd(40).rt(90).fd(40).lt(90);
		 }
	}
}