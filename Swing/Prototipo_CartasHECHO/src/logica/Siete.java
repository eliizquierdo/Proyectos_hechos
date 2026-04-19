package logica;

public class Siete {
	
	    private Mazo mazo;
	    private double puntajeJugador;

	    public Siete() {
	        mazo = new Mazo();
	        mazo.barajar();
	        puntajeJugador = 0;
	    }

	    public Carta sacarCarta(int index) {
	        return mazo.sacarCarta(index);
	    }

	    public void sumarPuntaje(Carta carta) {
	        puntajeJugador += carta.obtenerValor();
	    }

	    public double getPuntajeJugador() {
	        return puntajeJugador;
	    }

	    public boolean estaPorDebajoDeSiete() {
	        return puntajeJugador <= 7;
	    }

	    public boolean haGanado() {
	        return puntajeJugador == 7;
	    }
	}


