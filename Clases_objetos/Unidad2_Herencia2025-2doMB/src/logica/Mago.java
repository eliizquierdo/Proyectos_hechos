package logica;

public class Mago extends Personaje {
	private int poder;
	private int mana;

	public Mago() {
		super();
	}

	public Mago(String nombre, int salud, int defensa, int poder, int mana) {
		super(nombre, salud, defensa);
		this.poder = poder;
		this.mana = mana;
	}

	public int getPoder() {
		return poder;
	}

	public void setPoder(int poder) {
		this.poder = poder;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public void lanzarHechizo(Personaje p) {
		int vidaActualizada = p.getSalud() - this.poder;
		p.setSalud(vidaActualizada);
		System.out.println(
				p.getNombre() + " perdió " + this.poder + " puntos de vida por el ataque de " + this.getNombre() + ".");
	}

	@Override
	public String toString() {
		return super.toString() + "\nPoder: " + poder + "\nMana: " + mana;
	}

}
