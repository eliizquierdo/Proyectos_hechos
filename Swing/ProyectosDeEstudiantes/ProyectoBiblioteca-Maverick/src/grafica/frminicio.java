package grafica;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;

public class frminicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JPasswordField pswcon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frminicio frame = new frminicio();
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
	public frminicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setForeground(new Color(255, 0, 0));
		panel.setBorder(new LineBorder(new Color(0, 128, 255), 3));
		panel.setBounds(10, 21, 356, 337);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(0, 128, 255));
		txtNombre.setBounds(93, 103, 165, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		pswcon = new JPasswordField();
		pswcon.setBounds(93, 159, 165, 20);
		panel.add(pswcon);
		
		JLabel lblNewLabel = new JLabel("contraseña");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setBounds(103, 134, 89, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("añadir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomU=txtNombre.getName();
				String conU =pswcon.getSelectedText();
				
				
				
						}
		});
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(121, 303, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("netxilf");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 59));
		lblNewLabel_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(93, 11, 191, 56);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("nombre");
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setForeground(new Color(0, 128, 255));
		lblNewLabel_2.setBounds(103, 78, 55, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("agregue un usuario o simple mente ingrese a la beta");
		lblNewLabel_3.setForeground(new Color(0, 128, 255));
		lblNewLabel_3.setBounds(37, 194, 309, 91);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("ingresar");
		btnNewButton_2.setToolTipText("");
		btnNewButton_2.setIcon(null);
		btnNewButton_2.setBackground(new Color(0, 128, 255));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			prueba p = new prueba();
				p.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(131, 369, 89, 23);
		contentPane.add(btnNewButton_2);
	}

	public frminicio(String nomU, String conU) {
		// TODO Auto-generated constructor stub
	}
}
