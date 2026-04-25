import java.util.Scanner;

public class programa_3 {
	Scanner input = new Scanner(System.in);
	
	public String setString() {
		String str;
		System.out.print("Ingrese un texto\n-> ");
		str = input.next();
		return str;
	}

	public void menu(String str1, String str2) {
		System.out.println(str1 + ": " + str1.length() + "\n" + str2 + ": " + str2.length());
		if(str1 != str2) {
			if (str1.length() > str2.length()) {
				System.out.println("El primer texto es más grande.");
			}
			if (str1.length() < str2.length()) {
				System.out.println("El segundo texto es más grande.");
			}
			if(str1.length()==str2.length()) {
				System.out.println("Ambos textos son igual de largos");
			}
		}
		System.out.println(str1.toUpperCase() + "\n" + str2.toLowerCase());
	}
	
}
