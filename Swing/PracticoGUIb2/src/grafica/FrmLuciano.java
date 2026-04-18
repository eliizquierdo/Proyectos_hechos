package grafica;
import logica.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmLuciano extends JFrame {

	private JPanel contentPane;
	private JTextField txtCoordXA;
	private JTextField txtCoordYA;
	private JTextField txtCoordXB;
	private JTextField txtCoordYB;
	private JTextField txtCalcular;
	private JButton btnCalcular;
	private JButton btnLimpiar;

	
	public FrmLuciano() {
		iniciarComponentes();
		iniciarManejadoresEventos();
		
		
	}


	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Punto A", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(28, 11, 161, 89);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCoordY = new JLabel("Coordenada Y:");
		lblCoordY.setBounds(10, 56, 80, 14);
		panel.add(lblCoordY);
		
		JLabel lblCoordX_1 = new JLabel("Coordenada X:");
		lblCoordX_1.setBounds(10, 31, 80, 14);
		panel.add(lblCoordX_1);
		
		txtCoordXA = new JTextField();
		txtCoordXA.setBounds(100, 28, 51, 20);
		panel.add(txtCoordXA);
		txtCoordXA.setColumns(10);
		
		txtCoordYA = new JTextField();
		txtCoordYA.setColumns(10);
		txtCoordYA.setBounds(100, 53, 51, 20);
		panel.add(txtCoordYA);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Punto B", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(241, 11, 161, 89);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCoordX_1_1 = new JLabel("Coordenada X:");
		lblCoordX_1_1.setBounds(10, 26, 80, 14);
		panel_1.add(lblCoordX_1_1);
		
		JLabel lblCoordY_1 = new JLabel("Coordenada Y:");
		lblCoordY_1.setBounds(10, 51, 80, 14);
		panel_1.add(lblCoordY_1);
		
		txtCoordXB = new JTextField();
		txtCoordXB.setColumns(10);
		txtCoordXB.setBounds(100, 23, 51, 20);
		panel_1.add(txtCoordXB);
		
		txtCoordYB = new JTextField();
		txtCoordYB.setColumns(10);
		txtCoordYB.setBounds(100, 48, 51, 20);
		panel_1.add(txtCoordYB);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Largo de la recta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(null);
		panel_2.setBounds(28, 118, 230, 89);
		contentPane.add(panel_2);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(10, 38, 89, 23);
		panel_2.add(btnCalcular);
		
		txtCalcular = new JTextField();
		txtCalcular.setEditable(false);
		txtCalcular.setBounds(122, 39, 86, 20);
		panel_2.add(txtCalcular);
		txtCalcular.setColumns(10);
		
		btnLimpiar = new JButton("Limpiar");
		
		btnLimpiar.setBounds(303, 184, 89, 23);
		contentPane.add(btnLimpiar);
		}


	private void iniciarManejadoresEventos() {
		
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtCoordXA.setText(null);
				txtCoordXB.setText(null);
				txtCoordYA.setText(null);
				txtCoordYB.setText(null);
				txtCalcular.setText(null);
			}
		});
		
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int valorXA=Integer.valueOf(txtCoordXA.getText());
					int valorXB=Integer.valueOf(txtCoordXB.getText());
					int valorYA=Integer.valueOf(txtCoordYA.getText());
					int valorYB=Integer.valueOf(txtCoordYB.getText());
					Punto puntoA=new Punto(valorXA,valorYA);
					Punto puntoB=new Punto(valorXB,valorYB);
					Recta r=new Recta(puntoA, puntoB);
					double largo=r.largoRecta();
					txtCalcular.setText(String.valueOf(largo));
				}catch(Exception ex) {
					txtCalcular.setText("Error");
					
				}
				
			}
		});
		
		
		
	}
}
