package logica;
import grafica.*;
import java.util.ArrayList;

public class ArrayPrestamos { 
	
	private ArrayList<AlumnoVO>ArrayPr;
	
	public ArrayPrestamos() {
		ArrayPr=new ArrayList<>();
	}
	
	public void agregar(AlumnoVO RePre) {
		ArrayPr.add(RePre);
	}
	
	public AlumnoVO devolver(int i) {
		return(ArrayPr.get(i));
	}
	
	public String toString() {
		return "Datos del Alumno" + ArrayPr;
	}
}
