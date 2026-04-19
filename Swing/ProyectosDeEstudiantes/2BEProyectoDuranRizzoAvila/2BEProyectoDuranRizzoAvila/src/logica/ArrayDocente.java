package logica;
import grafica.*;
import java.util.ArrayList;

public class ArrayDocente { 
	
	private ArrayList<AlumnoVO>ArrayDo;
	
	public ArrayDocente() {
		ArrayDo=new ArrayList<>();
	}
	
	public void agregar(AlumnoVO ReDo) {
		ArrayDo.add(ReDo);
	}
	
	public AlumnoVO devolver(int i) {
		return(ArrayDo.get(i));
	}
	
	public String toString() {
		return "Datos del Docente" + ArrayDo;
	}
}
