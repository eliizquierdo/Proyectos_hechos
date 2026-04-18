package logica;

public class Direccion {
	private String calle;
	private int numero;

//constructor por defecto
public Direccion() {
	
}

//constructor especifico
public Direccion(String c, int n) {
	calle=c;
	numero=n;
}

public String getCalle() {
	return calle;
}

public int getNumero() {
	return numero;
}

public void setCalle(String c) {
	calle=c;
}

public void setNumero(int n) {
	numero=n;
}

@Override
public String toString() {
	return "calle: "+ calle +
			"número: "+ numero;
}
	
	
	
}
