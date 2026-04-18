package presentacion;

import logica.Calculadora;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.InputMismatchException;

import javax.swing.Action;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JLabel lblNum1, lblNum2, lblResultado;
	private JButton btnSumar, btnRestar, btnDividir, btnMultiplicar;
	private JTextField txtNum1, txtNum2;
	JTextPane txtResultado;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setTitle("CALCUADORA BASICA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNum1 = new JLabel("Numero 1:");
		lblNum1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNum1.setBounds(10, 38, 69, 14);
		contentPane.add(lblNum1);
		
		txtNum1 = new JTextField();
		txtNum1.setBounds(89, 36, 218, 20);
		contentPane.add(txtNum1);
		txtNum1.setColumns(10);
		
		lblNum2 = new JLabel("Numero 2:");
		lblNum2.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNum2.setBounds(10, 80, 69, 14);
		contentPane.add(lblNum2);
		
		txtNum2 = new JTextField();
		txtNum2.setBounds(89, 78, 218, 20);
		contentPane.add(txtNum2);
		txtNum2.setColumns(10);
		
		btnSumar = new JButton("+");
		btnSumar.setAction(action);
		btnSumar.setBounds(45, 129, 89, 23);
		contentPane.add(btnSumar);
		
		btnRestar = new JButton("-");
		btnRestar.setAction(action_1);
		btnRestar.setBounds(171, 129, 89, 23);
		contentPane.add(btnRestar);
		
		btnDividir = new JButton("/");
		btnDividir.setAction(action_2);
		btnDividir.setBounds(45, 163, 89, 23);
		contentPane.add(btnDividir);
		
		btnMultiplicar = new JButton("*");
		btnMultiplicar.setAction(action_3);
		btnMultiplicar.setBounds(171, 163, 89, 23);
		contentPane.add(btnMultiplicar);
		
		lblResultado = new JLabel("RESULTADO:");
		lblResultado.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblResultado.setBounds(10, 210, 94, 14);
		contentPane.add(lblResultado);
		
		txtResultado = new JTextPane();
		txtResultado.setBounds(114, 210, 162, 20);
		contentPane.add(txtResultado);
	}
	
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "+");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			try {
			Calculadora cal = new Calculadora();
			double n1 = Double.valueOf(txtNum1.getText());
			double n2 = Double.valueOf(txtNum2.getText());
			cal.setNum1(n1);
			cal.setNum2(n2);
			double resultado = cal.Sumar(n1, n2);
			txtResultado.setText("Total: " + resultado);
			} catch(Exception ex){
				JOptionPane.showMessageDialog(null, "No puedes utilizar letras, solo numeros");
			}
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "-");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			try {
			Calculadora cal = new Calculadora();
			double n1 = Double.valueOf(txtNum1.getText());
			double n2 = Double.valueOf(txtNum2.getText());
			cal.setNum1(n1);
			cal.setNum2(n2);
			double resultado = cal.Restar(n1, n2);
			txtResultado.setText("Total: " + resultado);
			} catch(Exception ex){
				JOptionPane.showMessageDialog(null, "No puedes utilizar letras, solo numeros");
			}
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "/");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			try {
			Calculadora cal = new Calculadora();
			double n1 = Double.valueOf(txtNum1.getText());
			double n2 = Double.valueOf(txtNum2.getText());
			cal.setNum1(n1);
			cal.setNum2(n2);
			if (n2 == 0) {
				JOptionPane.showMessageDialog(null, "No puedes dividir entre 0");
			}else {
			double resultado = cal.Dividir(n1, n2);
			txtResultado.setText("Total: " + resultado);
			}
			} catch(Exception ex){
				JOptionPane.showMessageDialog(null, "No puedes utilizar letras, solo numeros");
			}
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "*");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			try {
			Calculadora cal = new Calculadora();
			double n1 = Double.valueOf(txtNum1.getText());
			double n2 = Double.valueOf(txtNum2.getText());
			cal.setNum1(n1);
			cal.setNum2(n2);
			double resultado = cal.Multiplicar(n1, n2);
			txtResultado.setText("Total: " + resultado);
			} catch(Exception ex){
				JOptionPane.showMessageDialog(null, "No puedes utilizar letras, solo numeros");
			}
		}
	}
}
