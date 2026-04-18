package logica;

import java.util.ArrayList;

public class Refugio {
	
	    private ArrayList<Animal> animals;

	    public Refugio() {
	        animals = new ArrayList<>();
	    }

	    public void addAnimal(Animal animal) {
	        animals.add(animal);
	    }

	    public void displayAnimalSounds() {
	        for (Animal animal : animals) {
	            animal.makeSound();
	        }
	    }
	}

	