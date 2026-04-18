package pruebaControlador;

import javax.swing.*;

public class Interfaz extends JFrame {
    private JTextField nom, pos;
    private JButton atras, adelante, agregar, modificar, borrar;
    private JTextArea txa;
    private JScrollPane sp;

    public Interfaz(Controlador ctl) {
        this.setLayout(null);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        iniciarComponentes(ctl);
    }

    private void iniciarComponentes(Controlador ctl) {
        this.setTitle("Gestión de Nombres");

        this.pos = new JTextField();
        this.pos.setBounds(175, 100, 120, 30);
        this.pos.setEditable(false);
        this.add(this.pos);

        JLabel it = new JLabel("Ingrese Nombre:");
        it.setBounds(50, 70, 120, 30);
        this.add(it);

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
        this.sp.setBounds(50, 210, 350, 200);
        this.add(sp);
    }

    public JTextArea getTxa() {
        return txa;
    }

    public JTextField getNom() {
        return nom;
    }

    public JTextField getPos() {
        return pos;
    }

    public JButton getAtras() {
        return atras;
    }

    public JButton getAdelante() {
        return adelante;
    }

    public JButton getAgregar() {
        return agregar;
    }

    public JButton getModificar() {
        return modificar;
    }

    public JButton getBorrar() {
        return borrar;
    }
}
