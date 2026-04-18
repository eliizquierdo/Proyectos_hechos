package pruebaControlador;

import javax.swing.*;

public class Interfaz extends JFrame {
	private JTextField nom;
	private JTextField pos;
	private JButton atras, adelante, agregar, modificar,borrar;
	private JTextArea txa;
	private JScrollPane sp;
	private JLabel it;

	public Interfaz(Controlador ctl) {
		this.setLayout(null);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.iniciarComponentes(ctl);
	}

	private void iniciarComponentes(Controlador ctl) {

		this.setTitle("Nombres");

		this.pos = new JTextField();
		this.pos.setBounds(175, 100, 120, 30);
		this.pos.setEditable(false);
		this.add(this.pos);

		this.it = new JLabel("Ingrese Texto");
		this.it.setBounds(50, 70, 120, 30);
		this.add(this.it);

		this.nom = new JTextField();
		this.nom.setBounds(50, 100, 120, 30);
		this.add(this.nom);

		this.atras = new JButton("<<");
		this.atras.setBounds(50, 170, 60, 30);
		this.atras.addActionListener(ctl);
		this.add(this.atras);
		
		this.agregar = new JButton("Agregar");
		this.agregar.setBounds(110, 170, 100, 30);
		this.agregar.addActionListener(ctl);
		this.add(this.agregar);
		
		this.modificar = new JButton("Modificar");
		this.modificar.setBounds(210, 170, 100, 30);
		this.modificar.addActionListener(ctl);
		this.add(this.modificar);
		
		this.borrar = new JButton("Borrar");
		this.borrar.setBounds(310, 170, 80, 30);
		this.borrar.addActionListener(ctl);
		this.add(this.borrar);
		
		this.adelante = new JButton(">>");
		this.adelante.setBounds(390, 170, 60, 30);
		this.adelante.addActionListener(ctl);
		this.add(this.adelante);
		
		this.txa = new JTextArea();
		this.sp = new JScrollPane(txa);
		this.sp.setBounds(50, 210, 350, 280);
		this.add(sp);

	}

	public JTextArea getTxa() {
		return txa;
	}

	public void setTxa(JTextArea txa) {
		this.txa = txa;
	}

	public JScrollPane getSp() {
		return sp;
	}

	public void setSp(JScrollPane sp) {
		this.sp = sp;
	}

	public JTextField getNom() {
		return nom;
	}

	public void setNom(JTextField nom) {
		this.nom = nom;
	}

	public JTextField getPos() {
		return pos;
	}

	public void setPos(JTextField pos) {
		this.pos = pos;
	}

	public JButton getAtras() {
		return atras;
	}

	public void setAtras(JButton atras) {
		this.atras = atras;
	}

	public JButton getAdelante() {
		return adelante;
	}

	public void setAdelante(JButton adelante) {
		this.adelante = adelante;
	}

	public JButton getAgregar() {
		return agregar;
	}

	public void setAgregar(JButton agregar) {
		this.agregar = agregar;
	}

	public JButton getModificar() {
		return modificar;
	}

	public void setModificar(JButton modificar) {
		this.modificar = modificar;
	}
	
	public JButton getBorrar(JButton borrar) {
		return borrar;
	}
	
	public void setBorrar(JButton borrar) {
		this.borrar = borrar;
	}
}
