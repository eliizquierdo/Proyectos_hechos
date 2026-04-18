package consola;

import logica.Animal;
import logica.Refugio;
import logica.Gato;

public class Principal {
		    public static void main(String[] args) {
		    	Refugio shelter = new Refugio();

	        Animal cat = new Animal("Mittens");
	        Gato dog = new Gato("Buddy");

	        shelter.addAnimal(cat);
	        shelter.addAnimal(dog);

	        shelter.displayAnimalSounds();
	    }
	}

