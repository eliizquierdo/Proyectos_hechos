package logica;

import java.util.ArrayList;

public class Veterinaria {

    private ArrayList<Mascota> listaMascotas;

    public Veterinaria() {
        this.listaMascotas = new ArrayList<>();
    }

    public void agregarMascota(Mascota m) {
        this.listaMascotas.add(m);
    }
    
    public void saludar() {
    	for(Mascota m:listaMascotas) {
    		m.saludar();
    	}
    }
}

