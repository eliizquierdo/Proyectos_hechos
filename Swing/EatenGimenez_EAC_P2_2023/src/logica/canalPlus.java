package logica;

public class canalPlus extends Canal{
private boolean plus;
public canalPlus() {
	
}
public canalPlus(boolean plus,int nu, String no, String t) {
	super(nu,no,t);
	this.plus = plus;
}
public boolean getPlus() {
	return plus;
}
public void setPlus(boolean plus) {
	this.plus = plus;
}
@Override
public String toString() {
	return "canalPlus [plus=" + plus + "," + super.toString() + "]";
}

}
