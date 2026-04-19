package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MazoBlackJack {
    private List<CartasBlackJack> baraja;

    public MazoBlackJack() {
        baraja = new ArrayList<>();
        armarMazo();
        barajar();
    }

    /** Métodos primitivos **/
    public void insertar(CartasBlackJack c) {
        baraja.add(c);
    }

    public boolean sinCartas() {
        return baraja.isEmpty();
    }

    public int cantidad() {
        return baraja.size();
    }

    /** Fin de métodos primitivos **/

    /** Arma un mazo estándar de 52 cartas **/
    private void armarMazo() {
        String[] palos = { "corazones", "diamantes", "tréboles", "picas" };

        for (String palo : palos) {
            for (int numero = 1; numero <= 13; numero++) {
                baraja.add(new CartasBlackJack(numero, palo));
            }
        }
    }

    /** Baraja el mazo **/
    public void barajar() {
        Collections.shuffle(baraja);
    }

    /** Saca una carta del mazo **/
    public CartasBlackJack sacarCarta() {
        if (sinCartas()) {
            throw new IllegalStateException("El mazo está vacío. No hay más cartas.");
        }
        return baraja.remove(0); // Devuelve y elimina la primera carta
    }

    @Override
    public String toString() {
        return "Mazo: " + baraja;
    }
}

