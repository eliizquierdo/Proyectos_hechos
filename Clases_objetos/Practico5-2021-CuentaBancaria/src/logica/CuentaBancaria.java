package logica;

public class CuentaBancaria	{
	
	private String user;
	private String pass;
	private double saldo;
	

	public CuentaBancaria ()	{
		
		user = "utu";
		pass = "123";
		saldo = 500;
	}

	public CuentaBancaria(String u, String p, double s) {
    this.user = u;
    this.pass = p;
    this.saldo = s;
  }
	
	public void setUser (String u)	{
		
		user = u;
	}
	public void setPass (String p)	{
		
		pass = p;
	}
	public void setSaldo (double s)	{
		
		saldo = s;
	}
	
		
	public String getUser ()	{
		
		return user;
	}
	public String getPass ()	{
		
		return pass;
	}
	public double getSaldo ()	{
		
		return saldo;
	}
	
	public boolean validar(String u, String p) {
		if (u.equals(user) && p.equals(pass))
			return true;
		else
			return false;
	}
	
	public void depositar(double dinero) {
		if (dinero > 0) 
			saldo = saldo + dinero;
	}
	
	public Double retirar(double dinero) {
		if (dinero > 0 && dinero <= saldo)  
			saldo = saldo - dinero;
		return saldo;
	}
	
	
	@Override
	public String toString (){
				
		return "Usuario: " + user +"\\r\\nSaldo: " + saldo;
	}
	
}


