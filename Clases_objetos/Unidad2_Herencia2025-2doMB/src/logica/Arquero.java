package logica;

public class Arquero extends Personaje{
	  private int ataqueDistancia;
	    private int cantFlechas;

	    public Arquero() {
	    }

	    public Arquero(String nombre, int salud,int defensa, int ataqueDistancia, int cantFlechas) {
	        super(nombre, salud, defensa);
	        this.ataqueDistancia = ataqueDistancia;
	        this.cantFlechas = cantFlechas;
	    }

	    public int getAtaqueDistancia() {
	        return ataqueDistancia;
	    }

	    public int getCantFlechas() {
	        return cantFlechas;
	    }

	    public void setAtaqueDistancia(int ataqueDistancia) {
	        this.ataqueDistancia = ataqueDistancia;
	    }

	    public void setCantFlechas(int cantFlechas) {
	        this.cantFlechas = cantFlechas;
	    }

	    public void dispararFlecha(Personaje p) {
	      /*  if (cantFlechas > 0) {
	            cantFlechas--; 
	            int daño = this.ataqueDistancia;
	        } else {
	            System.out.println("No quedan flechas!");
	        }*/
	    	 p.setSalud(p.getSalud() - this.getAtaqueDistancia());
	         this.setCantFlechas(getCantFlechas() - 1);
	    }

	    public void recargarFlecha() {
	        if (cantFlechas == 0) {
	            cantFlechas = 10;
	            System.out.println("El arquero ha recargado 10 flechas.");
	        } else {
	            System.out.println("Aún tienes " + cantFlechas + " flechas. No necesitas recargar.");
	        }
	    }

	    @Override
	    public String toString() {
	        return super.toString() + "\nCantFlechas: " + cantFlechas + "\nAtaqueDistancia: " + ataqueDistancia;
	    }
}
