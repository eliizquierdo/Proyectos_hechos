package Logica;
import java.util.ArrayList;

public class Loans {
	public static ArrayList<Loan>loans = new ArrayList<Loan>();
	
	public Loans() {
		loans = new ArrayList<>();
	}

	public void add(Loan loan) {
		loans.add(loan);
	}
	
	public void remove(int i) {
		loans.remove(i);
	}
	
	public int size() {
		return loans.size();
	}
	
	public Loan get(int i) {
		return loans.get(i);
	}
	
	
}
