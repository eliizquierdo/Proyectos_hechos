package logica;

public class BlackJack {
    private MazoBlackJack mazo; // Mazo del Blackjack
    private double puntajeJugador;
    private int asesComoOnce; // Contador de Ases considerados como 11

    public BlackJack() {
        mazo = new MazoBlackJack();
        mazo.barajar();
        puntajeJugador = 0;
        asesComoOnce = 0; // Inicialmente no hay Ases valorados como 11
    }

    /** Método para obtener el mazo **/
    public MazoBlackJack getMazo() {
        return mazo;
    }

    public CartasBlackJack sacarCarta() {
        return mazo.sacarCarta();
    }

    public void sumarPuntaje(CartasBlackJack carta) {
        int valorCarta = carta.obtenerValor();

        if (valorCarta == 11) { // Es un As
            asesComoOnce++;
        }

        puntajeJugador += valorCarta;

        // Ajustar puntaje si supera 21 y hay Ases valorados como 11
        while (puntajeJugador > 21 && asesComoOnce > 0) {
            puntajeJugador -= 10; // Reduce el valor de un As de 11 a 1
            asesComoOnce--; // Actualiza el contador de Ases como 11
        }
    }

    public double getPuntajeJugador() {
        return puntajeJugador;
    }

    public boolean estaPorDebajoDeVeintiuno() {
        return puntajeJugador <= 21;
    }

    public boolean haGanado() {
        return puntajeJugador == 21;
    }
}
