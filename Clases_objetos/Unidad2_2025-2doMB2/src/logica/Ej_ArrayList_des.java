package logica;
import java.util.*;

public class Ej_ArrayList_des {
	
	public static void main (String[] args) {

	        ArrayList<String> a = new ArrayList<String>();

	        a.add(0, "📚 Un concepto claro");
	        a.add(1, "🧠 Una pizca de lógica");
	        a.add(2, "💡 Un ejemplo práctico");
	        a.remove(2);
	        a.add(2, "💡 Un ejemplo práctico");
	        a.add(3, "🤔 Una duda compartida");
	        a.add(4, "🥳 Una sonrisa de “¡ahora lo entendí!”");

	        printAL(a);
	    }

	    public static void printAL(ArrayList<String> al) {
	        for (String element : al) {
	            System.out.println("🌟 " + element);
	        }
	        System.out.println("😄 Mensaje completo recibido: ¡Gracias por tu atención, programador estrella! 🌟");
	    }
	}

