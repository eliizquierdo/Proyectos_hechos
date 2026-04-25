package logica;

public class Libro {

	private int codigo;
    private String titulo;
        
    
    public Libro(){
    	
    }
    
    public Libro(int codigo, String titulo) {
        
        this.codigo = codigo;
        this.titulo = titulo;
    }

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", titulo=" + titulo + "]";
	}

	
    
}
