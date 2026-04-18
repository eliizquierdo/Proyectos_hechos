package paquete;


	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

public 	class Criatura {
	    private String nombre;
	    private int vida;
	    private int ataque;
	    private int defensa;

	    public Criatura(String nombre, int vida, int ataque, int defensa) {
	        this.nombre = nombre;
	        this.vida = vida;
	        this.ataque = ataque;
	        this.defensa = defensa;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public int getVida() {
	        return vida;
	    }

	    public void recibirDaño(int daño) {
	        this.vida -= Math.max(daño - defensa, 0);
	    }

	    public int atacar() {
	        return ataque;
	    }

	    public boolean estaVivo() {
	        return vida > 0;
	    }
	}

	
	
