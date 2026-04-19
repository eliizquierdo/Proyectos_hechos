package Logica;

public class Book {
	private int isbn;
	private int numPag;
	private String name;
	private String editorialName;
	private Date editDate;
	private String autorName;
	private String autorCountry;
	
	
	public Book() {
		
	}
	
	public Book(int isbn, int numPag, String name, String editorialName, Date editDate, String autorName, String autorCountry) {
		this.isbn = isbn;
		this.numPag = numPag;
		this.name = name;
		this.editorialName = editorialName;
		this.editDate = editDate;
		this.autorName = autorName;
		this.autorCountry = autorCountry;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getNroPag() {
		return numPag;
	}

	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}

	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEditorialName() {
		return editorialName;
	}

	public void setEditorialName(String editorialName) {
		this.editorialName = editorialName;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public String getAutorName() {
		return autorName;
	}

	public void setAutorName(String autorName) {
		this.autorName = autorName;
	}

	public String getAutorCountry() {
		return autorCountry;
	}

	public void setAutorCountry(String autorCountry) {
		this.autorCountry = autorCountry;
	}

	public int getNumPag() {
		return numPag;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", numPag=" + numPag + ", name=" + name + ", editorialName=" + editorialName
				+ ", editDate=" + editDate + ", autorName=" + autorName + ", autorCountry=" + autorCountry + "]";
	}
	
	
	
}
