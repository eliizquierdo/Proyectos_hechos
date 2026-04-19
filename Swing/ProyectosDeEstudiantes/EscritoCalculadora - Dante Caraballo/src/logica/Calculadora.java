package logica;

public class Calculadora {
	
	private double num1;
	private double num2;
	
	public Calculadora() {
		
	}
	
	public Calculadora(double n1, double n2) {
		num1=n1;
		num2=n2;
	}
	
	public double Sumar(double n1, double n2) {
		double resultado = n1+n2;
		return resultado;
	}
	
	public double Restar(double n1, double n2) {
		double resultado = n1-n2;
		return resultado;
	}	
	
	public double Dividir(double n1, double n2) {
		double resultado = n1/n2;
		return resultado;
	}
	
	public double Multiplicar(double n1, double n2) {
		double resultado = n1*n2;
		return resultado;
	}	
	
	public void setNum1(double n1) {
		num1=n1;
	}
	
	public void setNum2(double n2) {
		num2=n2;
	}
	
	public double getNum1() {
		return num1;
	}
	
	public double getNum2() {
		return num2;
	}
	
}
