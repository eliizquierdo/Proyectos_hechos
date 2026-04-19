package logica;
import java.util.Random;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Mazo {
    private ArrayList<Carta> baraja;
    private Random aleatorio;
   
    
    
    
    public Mazo() {
        aleatorio = new Random();
        baraja = new ArrayList<>();
        armarMazo();
    }
    /** Métodos primitivos **/
    public void insertar(Carta c) {
        baraja.add(c);
    }
    public void eliminar(int i) {
        baraja.remove(i);
    }
    public int cantidad() {
        return baraja.size();
    }
    public boolean sinCartas(){
        return baraja.isEmpty();
    }
    public boolean encuentra(Carta c){
        return baraja.contains(c);
    }
    public Carta devolver(int i) {
        return baraja.get(i);
    }
    /** Fin de métodos primitivos **/
/********************************************************************/     
    private void armarMazo() {
        int numero = 1;
        String palo = "basto";
        Carta carta;
        
        for (int i = 0; i < 48; i++) {
            carta = new Carta(numero,palo);
            this.insertar(carta);                        
            numero++; 
            // Si ya cargue 12 cartas de un palo ...
            if (numero == 13) {
                numero = 1;
                // ... paso al siguiente palo
                if(palo.equals("basto"))
                    palo = "copa";
                else if (palo.equals("copa"))
                    palo = "espada";
                else
                    palo = "oro";
            } // fin de if (numero == 13)
        } // fin de for
    }
/********************************************************************/           
    @Override
    public String toString() {
        return "Mazo \n" + baraja;
    }
    
    public void barajar() {
        Collections.shuffle(baraja);
    }

    public Carta sacarCarta(int index) {
        return baraja.get(index);
    }

    public int tamanio() {
        return baraja.size();
    }
}
