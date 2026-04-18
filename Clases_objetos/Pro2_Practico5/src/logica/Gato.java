package logica;

public class Gato extends Animal {
    public Gato(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof woof!");
    }
}

