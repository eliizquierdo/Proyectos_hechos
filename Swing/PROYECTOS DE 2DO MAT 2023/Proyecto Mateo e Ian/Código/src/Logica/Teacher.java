package Logica;

public class Teacher extends Partner{
	private Date admissionDate;
	private Subject subject;
	
	public Teacher() {
		
	}

	public Teacher(Partner partner) {
		super(partner.getCi(), partner.getAddress(), partner.getPhone(), partner.getName());
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getSubject() {
		return subject.getNombre();
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Fecha de ingreso: " + admissionDate.toString() + " Materia: " + subject.getNombre() + " " + super.toString();
	}
	
	
}
