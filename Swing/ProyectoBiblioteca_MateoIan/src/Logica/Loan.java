package Logica;

public class Loan {
	private Date initialDate;
	private Date finalDate;
	private Copy copy;
	private Partner partner;
	
	public Loan() {
		
	}

	public Loan(Date initialDate, Copy copy, Partner partner) {
		this.initialDate = initialDate;
		Date finalDateTemp = new Date();
		finalDateTemp = initialDate;
		if(finalDateTemp.getMonth() == 12) {
			finalDateTemp.setYear(finalDateTemp.getyear()+1);
			finalDateTemp.setMonth(1);
		}else {
			finalDateTemp.setMonth(finalDateTemp.getMonth()+1);
		}
		
		System.out.println();
		finalDate = finalDateTemp;
		this.copy = copy;
		this.partner = partner;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public Copy getCopy() {
		return copy;
	}

	public void setCopy(Copy copy) {
		this.copy = copy;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	@Override
	public String toString() {
		return "Fecha préstamo: " + initialDate.toString() + " Fecha devolución: " + finalDate.toString() + " |Copia" + copy.toString()
				+ " |Socio: " + partner.toString();
	}
	
	
}
