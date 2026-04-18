package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Operaciones extends JFrame {

	private JPanel contentPane;
	private JTextField txtPrimeraEntrada;
	private JTextField txtSegundaEntrada;
	private JTextField txtResultado;
	private JButton btnSalir;
	private JButton btnLimpiar;
	private JButton btnConcatenar;
	private JButton btnSumar;
	private JLabel lblResultado;
	private JLabel lblSegundaEntrada;
	private JLabel lblPrimeraEntrada;
	private JPanel panel;

	/* cortar aca 
	 * 
	 */

	public Operaciones() {
		iniciarComponentes();
		iniciarManejadorEventos();

	}

		private void iniciarComponentes() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(153, 255, 255));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			panel = new JPanel();
			panel.setBackground(new Color(204, 153, 255));
			panel.setBounds(10, 11, 399, 181);
			contentPane.add(panel);
			panel.setLayout(null);

			lblPrimeraEntrada = new JLabel("Primera Entrada:");
			lblPrimeraEntrada.setBounds(16, 8, 125, 14);
			panel.add(lblPrimeraEntrada);

			txtPrimeraEntrada = new JTextField();
			txtPrimeraEntrada.setBounds(149, 5, 86, 20);
			panel.add(txtPrimeraEntrada);
			txtPrimeraEntrada.setBackground(new Color(255, 255, 255));
			txtPrimeraEntrada.setForeground(new Color(0, 0, 0));
			txtPrimeraEntrada.setColumns(10);

			lblSegundaEntrada = new JLabel("Segunda Entrada:");
			lblSegundaEntrada.setBounds(16, 55, 125, 14);
			panel.add(lblSegundaEntrada);

			txtSegundaEntrada = new JTextField();
			txtSegundaEntrada.setBounds(149, 108, 86, 20);
			panel.add(txtSegundaEntrada);
			txtSegundaEntrada.setBackground(new Color(255, 255, 255));
			txtSegundaEntrada.setColumns(10);

			lblResultado = new JLabel("Resultado:");
			lblResultado.setBounds(16, 111, 125, 14);
			panel.add(lblResultado);

			txtResultado = new JTextField();
			txtResultado.setBounds(149, 52, 86, 20);
			panel.add(txtResultado);
			txtResultado.setBackground(new Color(255, 255, 255));
			txtResultado.setColumns(10);

			btnSalir = new JButton("Salir");
		
			btnSalir.setBounds(320, 203, 104, 48);
			contentPane.add(btnSalir);

			btnLimpiar = new JButton("Limpiar");
			
			btnLimpiar.setBounds(200, 203, 109, 48);
			contentPane.add(btnLimpiar);
			
						btnConcatenar = new JButton("Concatenar");
						btnConcatenar.setBounds(10, 228, 107, 23);
						contentPane.add(btnConcatenar);
						
									btnSumar = new JButton("Sumar");
									btnSumar.setBounds(10, 203, 89, 23);
									contentPane.add(btnSumar);


	}

	private void iniciarManejadorEventos() {
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPrimeraEntrada.setText(null);
				txtSegundaEntrada.setText(null);
				txtResultado.setText(null);
			}
		});
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int nro1=Integer.valueOf(txtPrimeraEntrada.getText());
					int nro2=Integer.valueOf(txtSegundaEntrada.getText());
					txtResultado.setText(String.valueOf(nro1+nro2));
				
			}catch(Exception ex){
				Object exception;
				JOptionPane.showMessageDialog(null,"Intentalo de nuevo si no es molestia y si tiene un momentito :)");
			}
			}
		});
		btnConcatenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cadena1=txtPrimeraEntrada.getText();
				String cadena2=txtSegundaEntrada.getText();
				txtResultado.setText(cadena1+" "+cadena2);
				
			}
		});
	}
}
