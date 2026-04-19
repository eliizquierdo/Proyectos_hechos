package logica;
import grafica.*;
import java.util.ArrayList;

public class ArrayLibro { 
	
	private ArrayList<AlumnoVO>ArrayLi;
	
	public ArrayLibro() {
		ArrayLi=new ArrayList<>();
	}
	
	public void agregar(AlumnoVO ReLi) {
		ArrayLi.add(ReLi);
	}
	
	public AlumnoVO devolver(int i) {
		return(ArrayLi.get(i));
	}
	
	public String toString() {
		return "Datos del Alumno" + ArrayLi;
	}
}

