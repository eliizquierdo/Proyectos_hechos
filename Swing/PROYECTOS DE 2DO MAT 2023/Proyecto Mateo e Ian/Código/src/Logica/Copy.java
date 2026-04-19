package Logica;

public class Copy{
	private State state;
	private Book book;
	
	
	public Copy(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getState() {
		return state.getNombre();
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Estado: " + state.getNombre() + " " + book.toString();
	}
	
}
