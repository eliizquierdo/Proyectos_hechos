package logica;

public class Cliente extends Persona {
private boolean preferencial;

public Cliente(boolean preferencial,String c,String a) {
	super(c,a);
	preferencial=preferencial;
}

public boolean isPreferencial() {
	return preferencial;
}

public void setPreferencial(boolean preferencial) {
	this.preferencial = preferencial;
}

@Override
public String toString() {
	return super.toString() + "Cliente [preferencial=" + preferencial + "]";
}	


}