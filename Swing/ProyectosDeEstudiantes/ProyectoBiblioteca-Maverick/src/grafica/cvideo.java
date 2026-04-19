package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cvideo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cvideo frame = new cvideo();
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
	public cvideo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnvolver = new JButton("volver");
		btnvolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prueba p = new prueba();
				p.setVisible(true);
			}
		});
		btnvolver.setBackground(new Color(0, 128, 255));
		btnvolver.setBounds(164, 227, 89, 23);
		contentPane.add(btnvolver);
		
		JLabel lblNewLabel = new JLabel("no ay configuracion temporalmente ya que solo es una beta");
		lblNewLabel.setBounds(20, 14, 387, 14);
		lblNewLabel.setForeground(new Color(0, 128, 255));
		contentPane.add(lblNewLabel);
	}

}
