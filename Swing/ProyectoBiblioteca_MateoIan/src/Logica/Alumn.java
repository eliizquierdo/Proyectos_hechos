package Logica;

public class Alumn extends Partner{
	private Date birthdate;
	private int age;
	private Group group;
	
	public Alumn() {
		
	}
	
	public Alumn(Partner partner) {
		super(partner.getCi(), partner.getAddress(), partner.getPhone(), partner.getName());
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGroup() {
		return group.getNombre();
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Fecha nacimiento: " + birthdate + " Edad: " + age + " Grupo: " + group.getNombre() + " " + super.toString();
	}
	
	
}
