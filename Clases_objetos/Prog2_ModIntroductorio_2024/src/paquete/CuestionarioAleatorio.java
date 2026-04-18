package paquete;
import java.util.Random;
import java.util.Scanner;

public class CuestionarioAleatorio {
	static int usadas []= new int[4];
	static String preguntas[]= new String[4];
	static int respuestas[]= new int[4];
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int opcion;
		int salir=0, n, puntos=0;
		char respuesta;
		//cargarArrayAzar();
		
		cargarPreguntas();
		cargarRespuestas();
		cargarUsadas();
		do { 		
			n=generarPregunta();
			System.out.println("azar: "+n);
		    mostrarPreguntaN(n);
		    System.out.print("-------------------------");
		    System.out.print("Ingrese opción: ");
		    opcion = entrada.nextInt(); 
		    String resultado=chequearRespuesta(n,opcion);
		    System.out.println(resultado);
		    if (resultado.equals("Correcto"))
		    	puntos++;
		    usadas[n]=1;
		    salir++;
		} while (salir<4 );
		System.out.println("Puntos obtenidos: "+puntos);

	}

	public static String chequearRespuesta(int i, int opcionElegida) {
		String resp="";
		if (respuestas[i]==opcionElegida)
			return "Correcto";
		else
			return "Incorrecto";
		
	}
	
	
	public static void cargarPreguntas() {
		preguntas[0]="A que se dedicaba Florence Nightingale?"
				+ "\nOpciones:"
				+ "\n1) Enfermera"
				+ "\n2) Programadora"
				+ "\n3) Bióloga\n";
	    preguntas[1]="En que año nació Mary Tsingou?"
	    		+ "\nOpciones: "
	    		+ "\n1) 1828"
				+ "\n2) 1928"
				+ "\n3) 1990\n";
	    preguntas[2]="Cual fue el proyecto mas relevante de Betty Snyder Hoberton?"
	    		+ "\nOpciones:"
	    		+ "\n1) M.A.N.I.A.C"
				+ "\n2) E.N.I.A.C"
				+ "\n3) C.A.I.N.\n";
	    preguntas[3]="Donde realizó sus estudios Marie Curie?"
	    		+ "\nOpciones: "
	    		+ "\n1) UDELAR"
				+ "\n2) Universidad de Cambridge"
				+ "\n3) Universidad de París\n";
		
	}
	
	public  static void cargarRespuestas() {
		respuestas[0]=1;
		respuestas[1]=1;
		respuestas[2]=2;
		respuestas[3]=3;
	}

	public  static void mostrarPreguntaN(int n) {
		System.out.println(preguntas[n]);
	}
		 
	

	public static void cargarUsadas() {
		
		for(int i=0; i<usadas.length; i++) {
			usadas[i]= 0;
		}
	}
	
		
	public static int generarAzar(){
		Random azar=new Random();
		int num=azar.nextInt(4);
		return num;
	}
	
	private static int generarPregunta() {
		int x;
		do {
			 x=generarAzar();
		}while(usadas[x]!=0);
		return x;
	}
	
	
	
}
