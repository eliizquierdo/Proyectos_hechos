package grafica;
//Realizado por Cabrera 2do BJ

import java.awt.BorderLayout;
import java.awt.EventQueue;

import logica.CuentaBancaria;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrmCuentaBancaria extends JFrame {

	private JPanel contentPane;
	private final JLabel lblPass = new JLabel("pass");
	private JTextField txtUser;
	private JTextField txtPass;
	private JTextField txtVerSaldo;
	private JTextField txtCantidad;
	private JButton btnVerSaldo;
	private JButton btnRetirar;
	private JButton btnDepositar;
    CuentaBancaria cb = new CuentaBancaria();
    String u, p;

	public FrmCuentaBancaria() {
		setTitle("Cuenta Bancaria");
		iniciarComponentes();
		iniciarManejadoresEventos();
	}
	
	public void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("user");
		lblUser.setBounds(10, 31, 46, 14);
		contentPane.add(lblUser);
		lblPass.setBounds(10, 67, 98, 31);
		contentPane.add(lblPass);
		
		txtUser = new JTextField();
		txtUser.setBounds(64, 28, 137, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setBounds(64, 72, 137, 20);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		txtVerSaldo = new JTextField();
		txtVerSaldo.setBounds(115, 126, 86, 20);
		contentPane.add(txtVerSaldo);
		txtVerSaldo.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(271, 72, 137, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		btnVerSaldo = new JButton("Ver saldo");
		btnVerSaldo.setBounds(10, 125, 89, 23);
		
		contentPane.add(btnVerSaldo);
		
		btnRetirar = new JButton("Retirar");
		btnRetirar.setBounds(243, 125, 89, 23);
		contentPane.add(btnRetirar);
		btnDepositar = new JButton("Depositar");
		btnDepositar.setBounds(350, 125, 89, 23);
		contentPane.add(btnDepositar);
		
		
	}
	
	public void iniciarManejadoresEventos() {
		
		
		btnVerSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				u = String.valueOf(txtUser.getText());
				p = String.valueOf(txtPass.getText());
				if (cb.validar(u, p) ) {
					txtVerSaldo.setText(Double.toString(cb.getSaldo()));
				}
				
			}
		});
		
		
		
		btnRetirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cb.validar(u, p)) {
					double r = Double.valueOf(txtCantidad.getText());
					txtVerSaldo.setText(Double.toString(cb.retirar(r)));
				}
				
			}
		});
		
		
		
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double d = Double.valueOf(txtCantidad.getText());
				cb.depositar(d);
				double s = cb.getSaldo();
				txtVerSaldo.setText(Double.toString(s));
			}
		});
		
		
		
	}
	
	public static void main(String[] args) {
		FrmCuentaBancaria ventana = new FrmCuentaBancaria();
		ventana.setVisible(true);
	}
}
