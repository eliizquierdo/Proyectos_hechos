package Logica;
import java.util.ArrayList;

public class Library {
	public static ArrayList<Copy>library = new ArrayList<Copy>();

	public Library() {
		library = new ArrayList<>();
	}

	public void add(Copy copy) {
		library.add(copy);
	}
	
	public void remove(int i) {
		library.remove(i);
	}
	
	public int size() {
		return library.size();
	}
	
	public Copy get(int i) {
		return library.get(i);
	}

}
