package logica;

public class CartasBlackJack {
	

	    private int numero;
	    private String palo;

	    public CartasBlackJack(int numero, String palo) {
	        this.numero = numero;
	        this.palo = palo;
	    }
	    
	      public int getNumero() {
	        return numero;
	    }

	    public String getPalo() {
	        return palo;
	    }

	    // Valor de la carta para Blackjack
	    public int obtenerValor() {
	        if (numero >= 10) {
	            return 10; // J, Q, K valen 10
	        } else if (numero == 1) {
	            return 11; // As inicial como 11
	        } else {
	            return numero; // Valor nominal
	        }
	    }

	    @Override
	    public String toString() {
	        return ".\\img2\\" + palo + "\\" + numero + ".png";
	    }
	}

