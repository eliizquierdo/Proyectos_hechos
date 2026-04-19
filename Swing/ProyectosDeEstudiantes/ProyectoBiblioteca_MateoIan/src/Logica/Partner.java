package Logica;

public class Partner {
	private int ci; 
	private int address;
	private int phone;
	private String name;
	
	public Partner(){
		
	}
	
	public Partner(int ci, int address, int phone, String name) {
		this.ci = ci;
		this.address = address;
		this.phone = phone;
		this.name = name;
	}

	public int getCi() {
		return ci;
	}

	public void setCi(int ci) {
		this.ci = ci;
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public String toString() {
		return " CI: " + ci + " Dirección: " + address + " Teléfono: " + phone + " Nombre: " + name + "\n";
	}
	
	
}