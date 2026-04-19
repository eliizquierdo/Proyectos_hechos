package grafica;

import logica.*;

import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnEntrar;
	private JTextField txtNombre;
	private JPasswordField psw;
	private JLabel lblNewLabel;
	private JTextField txtApe;


		

	public LogIn() {
		iniciarComponentes();
		iniciarEventos();
		
	}


	private void iniciarComponentes() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNetxilf = new JLabel("NEFLIZ");
		lblNetxilf.setHorizontalAlignment(SwingConstants.CENTER);
		lblNetxilf.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblNetxilf.setForeground(new Color(255, 0, 0));
		lblNetxilf.setBounds(534, 54, 195, 32);
		contentPane.add(lblNetxilf);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEntrar.setForeground(Color.BLACK);
		btnEntrar.setBackground(new Color(255, 0, 0));
		btnEntrar.setBounds(486, 354, 291, 23);
		contentPane.add(btnEntrar);
		
		psw = new JPasswordField();
		psw.setToolTipText("");
		psw.setBounds(486, 295, 291, 20);
		contentPane.add(psw);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(486, 165, 291, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblEmail = new JLabel("Nombre");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setForeground(new Color(255, 0, 0));
		lblEmail.setBounds(372, 159, 88, 32);
		contentPane.add(lblEmail);
		
		JLabel lblPasword = new JLabel("Password");
		lblPasword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPasword.setForeground(new Color(255, 0, 0));
		lblPasword.setBounds(359, 291, 117, 28);
		contentPane.add(lblPasword);
		
		lblNewLabel = new JLabel("LogIn");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 657, 88, 13);
		contentPane.add(lblNewLabel);
		
		txtApe = new JTextField();
		txtApe.setColumns(10);
		txtApe.setBounds(486, 230, 291, 20);
		contentPane.add(txtApe);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(372, 229, 82, 23);
		contentPane.add(lblNewLabel_1);
		
	}

	
	
	

	public JTextField getTxtEmail() {
		return txtNombre;
	}


	public void setTxtEmail(JTextField txtEmail) {
		this.txtNombre = txtEmail;
	}


	public JPasswordField getPsw() {
		return psw;
	}


	public void setPsw(JPasswordField psw) {
		this.psw = psw;
	}

	
	

	private void iniciarEventos() {
		
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtNombre.getText().equals("Eric")
							&& (txtApe.getText().equals("Barone")
										&& psw.getText().equals("2012"))) {
				
					
					AdministradorVO.setNombreAdmin(txtNombre.getText());
					AdministradorVO.setApellidoAdmin(txtApe.getText());
					AdministradorVO.setPasswordAdmin(psw.getText());
					
					
					setVisible(false);
					MenuPrincipal m=new MenuPrincipal();
					m.setVisible(true);
					
					
				}//if
				
				else {
					

			        //muestra el cuadro de diálogo con el mensaje "Usuario incorrecto"
			        
			        JOptionPane.showMessageDialog(null, "Usuario incorrecto", "Error"
			        			, JOptionPane.ERROR_MESSAGE);
			        
					txtNombre.setText(null);
			        txtApe.setText(null);
			        psw.setText(null);
					
					/*
					
					lo usabamos para cerrar y abrir la ventana
					se cambio por limpiar los text field
					
					setVisible(false);
					LogIn rep=new LogIn();
					rep.setVisible(true);
					
					*/
					
					
				}
				
			}
		});
		
		
	}//iniciar eventos
}//class
