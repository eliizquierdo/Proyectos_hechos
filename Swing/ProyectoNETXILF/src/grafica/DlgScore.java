package grafica;

import java.awt.BorderLayout;
import persistencia.ConnectionMySQL;
import persistencia.GestionCuentas;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.JTextField;
import javax.swing.JTextArea;

/**
 * Clase para el diálogo de puntuación que permite a los usuarios calificar y comentar un programa.
 */

public class DlgScore extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lbl1Star;
	private JLabel lbl2Star;
	private JLabel lbl3Star;
	private JLabel lbl4Star;
	private JLabel lbl5Star;
	private JLabel lbl5Stars;
	private JLabel lbl4Stars;
	private JLabel lbl3Stars;
	private JLabel lbl2Stars;
	private JLabel lbl1Stars;
	private JLabel lblScore;
	private JButton btnDone;
	private JLabel lblAddComent;
	private JLabel lblStars;
	private JTextArea textAreaComment;
	
	/**
     * Constructor para la clase DlgScore.
     * @param id_Profile Identificador del perfil del usuario.
     * @param id_Programming Identificador del programa que se está calificando.
     */

	public DlgScore(String id_Profile, int id_Programming) {
		eventStarter();
		eventHandler(id_Profile, id_Programming);
			
		
	}
	
	/**
     * Configura la apariencia inicial y el diseño del diálogo de puntuación.
     */

	private void eventStarter() {
		setBounds(500,500, 391, 677);
		setLocationRelativeTo(null);
		setResizable(false);
		JPanel pnlMainPanel = new JPanel();
		pnlMainPanel.setBackground(new Color(20, 20, 20));
		getContentPane().add(pnlMainPanel, BorderLayout.CENTER);
		pnlMainPanel.setLayout(null);
		
		JPanel pnlColorRed = new JPanel();
		pnlColorRed.setBackground(new Color(216, 31, 37));
		pnlColorRed.setForeground(Color.WHITE);
		pnlColorRed.setBounds(10, 11, 355, 616);
		pnlMainPanel.add(pnlColorRed);
		pnlColorRed.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(20, 20, 20));
		panel.setBounds(10, 11, 335, 594);
		pnlColorRed.add(panel);
		panel.setLayout(null);
		
		lblScore = new JLabel("Puntuación");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setForeground(Color.WHITE);
		lblScore.setBounds(10, 32, 315, 59);
		panel.add(lblScore);
		
		lbl5Star = new JLabel("");
		lbl5Star.setIcon(new ImageIcon("C:\\img\\StarV.jpg"));
		lbl5Star.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5Star.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbl5Star.setForeground(Color.YELLOW);
		lbl5Star.setBounds(10, 126, 50, 50);
		panel.add(lbl5Star);
		
		lbl4Star = new JLabel("");
		lbl4Star.setIcon(new ImageIcon("C:\\img\\StarV.jpg"));
		lbl4Star.setBounds(10, 187, 50, 50);
		panel.add(lbl4Star);
		
		lbl3Star = new JLabel("");
		lbl3Star.setIcon(new ImageIcon("C:\\img\\StarV.jpg"));
		lbl3Star.setBounds(10, 248, 50, 50);
		panel.add(lbl3Star);
		
		lbl2Star = new JLabel("");
		lbl2Star.setIcon(new ImageIcon("C:\\img\\StarV.jpg"));
		lbl2Star.setBounds(10, 309, 50, 50);
		panel.add(lbl2Star);
		
		lbl1Star = new JLabel("");
		lbl1Star.setIcon(new ImageIcon("C:\\img\\StarV.jpg"));
		lbl1Star.setBounds(10, 370, 50, 50);
		panel.add(lbl1Star);
		
		lbl5Stars = new JLabel("5. La recomiendo ");
		lbl5Stars.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl5Stars.setForeground(Color.WHITE);
		lbl5Stars.setBounds(104, 126, 221, 50);
		panel.add(lbl5Stars);
		
		lbl4Stars = new JLabel("4. Muy buena");
		lbl4Stars.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl4Stars.setForeground(Color.WHITE);
		lbl4Stars.setBounds(104, 187, 221, 50);
		panel.add(lbl4Stars);
		
		lbl3Stars = new JLabel("3. Buena");
		lbl3Stars.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl3Stars.setForeground(Color.WHITE);
		lbl3Stars.setBounds(104, 248, 221, 50);
		panel.add(lbl3Stars);
		
		lbl2Stars = new JLabel("2. Aceptable");
		lbl2Stars.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl2Stars.setForeground(Color.WHITE);
		lbl2Stars.setBounds(104, 309, 221, 50);
		panel.add(lbl2Stars);
		
		lbl1Stars = new JLabel("1. No me gustó");
		lbl1Stars.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl1Stars.setForeground(Color.WHITE);
		lbl1Stars.setBounds(104, 370, 221, 50);
		panel.add(lbl1Stars);
		
		lblAddComent = new JLabel("Puedes agregar un comentario(opcional).");
		lblAddComent.setForeground(Color.WHITE);
		lblAddComent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddComent.setBounds(10, 431, 315, 28);
		panel.add(lblAddComent);
		
		btnDone = new JButton("Hecho");
		btnDone.setBounds(236, 561, 89, 23);
		panel.add(btnDone);
		
		lblStars = new JLabel("");
		lblStars.setForeground(new Color(20, 20, 20));
		lblStars.setBounds(10, 11, 24, 50);
		panel.add(lblStars);
		
		textAreaComment = new JTextArea();
		textAreaComment.setLineWrap(true);
		textAreaComment.setBounds(10, 460, 315, 95);
		panel.add(textAreaComment);
		
		
	}
	
	/**
     * Configura los manejadores de eventos para varios componentes en el diálogo de puntuación.
     * @param id_Profile Identificador del perfil del usuario.
     * @param id_Programming Identificador del programa que se está calificando.
     */
	
	private void eventHandler(String id_Profile, int id_Programming) {
		
		lbl5Star.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStars.setText("5");
				lbl5Star.setIcon(new ImageIcon("C:\\img\\Star.jpg"));
				lbl4Star.setIcon(new ImageIcon("C:\\img\\Star.jpg"));
				lbl3Star.setIcon(new ImageIcon("C:\\img\\Star.jpg"));
				lbl2Star.setIcon(new ImageIcon("C:\\img\\Star.jpg"));
				lbl1Star.setIcon(new ImageIcon("C:\\img\\Star.jpg"));
			}
		});
		lbl4Star.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStars.setText("4");
				lbl5Star.setIcon(new ImageIcon("C:\\img\\StarV.jpg"));
				lbl4Star.setIcon(new ImageIcon("C:\\img\\Star.jpg"));
				lbl3Star.setIcon(new ImageIcon("C:\\img\\Star.jpg"));
				lbl2Star.setIcon(new ImageIcon("C:\\img\\Star.jpg"));
				lbl1Star.setIcon(new ImageIcon("C:\\img\\Star.jpg"));
			}
		});
		lbl3Star.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStars.setText("3");
				lbl5Star.setIcon(new ImageIcon("C:\\img\\StarV.jpg"));
				lbl4Star.setIcon(new ImageIcon("C:\\img\\StarV.jpg"));
				lbl3Star.setIcon(new ImageIcon("C:\\img\\Star.jpg"));
				lbl2Star.setIcon(new ImageIcon("C:\\img\\Star.jpg"));
				lbl1Star.setIcon(new ImageIcon("C:\\img\\Star.jpg"));
			}
		});
		lbl2Star.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStars.setText("2");
				lbl5Star.setIcon(new ImageIcon("C:\\img\\StarV.jpg"));
				lbl4Star.setIcon(new ImageIcon("C:\\img\\StarV.jpg"));
				lbl3Star.setIcon(new ImageIcon("C:\\img\\StarV.jpg"));
				lbl2Star.setIcon(new ImageIcon("C:\\img\\Star.jpg"));
				lbl1Star.setIcon(new ImageIcon("C:\\img\\Star.jpg"));
			}
		});
		lbl1Star.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStars.setText("1");
				lbl5Star.setIcon(new ImageIcon("C:\\img\\StarV.jpg"));
				lbl4Star.setIcon(new ImageIcon("C:\\img\\StarV.jpg"));
				lbl3Star.setIcon(new ImageIcon("C:\\img\\StarV.jpg"));
				lbl2Star.setIcon(new ImageIcon("C:\\img\\StarV.jpg"));
				lbl1Star.setIcon(new ImageIcon("C:\\img\\Star.jpg"));
			}
		});
		
		btnDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 LocalDate date = LocalDate.now();
				 String score = lblStars.getText();
				 int score1 = Integer.parseInt(score);
				 String comments= textAreaComment.getText();
				 boolean inserted = GestionCuentas.insertScore(id_Profile, id_Programming,date,date,score1,comments);
				 if (inserted) {
						JOptionPane.showMessageDialog(null, "Puntuación ingresada correctamente!.", "Exito",
								JOptionPane.INFORMATION_MESSAGE);
						
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "No se pudo ingresar la puntuación. Vuelva a intentarlo.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				 
				 
				 
			}
		});
		
	}
}
