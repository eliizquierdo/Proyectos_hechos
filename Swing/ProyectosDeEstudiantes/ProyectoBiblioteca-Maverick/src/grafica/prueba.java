package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class prueba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prueba frame = new prueba();
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
	public prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 437);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Netxilf");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 99));
		lblNewLabel.setBounds(135, 0, 401, 135);
		contentPane.add(lblNewLabel);
		
		JButton btncerrar = new JButton("cerrar");
		btncerrar.setBackground(new Color(0, 128, 255));
		btncerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frminicio p = new frminicio();
				p.setVisible(true);
				
			
				
			}
		});
		btncerrar.setBounds(218, 220, 265, 23);
		contentPane.add(btncerrar);
		
		JButton btnpys = new JButton("peliculas y series");
		btnpys.setBackground(new Color(0, 128, 255));
		btnpys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pys a=new Pys();
				a.setVisible(true);
			}
		});
		btnpys.setBounds(218, 177, 265, 23);
		contentPane.add(btnpys);
		
		JButton btnNewButton = new JButton("configuracion\r\n");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cvideo v= new cvideo();
				v.setVisible(true);
			}
		});
		btnNewButton.setBounds(551, 364, 107, 23);
		contentPane.add(btnNewButton);
	}
}
