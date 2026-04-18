package grafica;

import logica.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtNomAu;
	private JComboBox cmbPais;
	private JButton btnAceptar;
	private JSpinner spnPaginas;

	

	
	public Principal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Users\\fisma\\eclipse-workspace\\repaso_gui\\src\\Bookshelf_JE4_BE2-removebg-preview.png"));
		setTitle("Biblioteca");
		iniciarComponentes();
		iniciarManejadoresEventos();
	}


	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingreso de libros");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Teko SemiBold", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(68, 18, 268, 60);
		contentPane.add(lblNewLabel);
		
		txtNom = new JTextField();
		txtNom.setBounds(78, 89, 326, 26);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Teko SemiBold", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 89, 92, 26);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Autor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(24, 137, 390, 116);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setFont(new Font("Teko SemiBold", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(10, 11, 68, 28);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("País");
		lblNewLabel_3.setFont(new Font("Teko SemiBold", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(10, 67, 68, 28);
		panel.add(lblNewLabel_3);
		
		txtNomAu = new JTextField();
		txtNomAu.setBounds(83, 15, 217, 24);
		panel.add(txtNomAu);
		txtNomAu.setColumns(10);
		
		cmbPais = new JComboBox();
		cmbPais.setModel(new DefaultComboBoxModel(new String[] {"Uruguay", "Argentina", "Peru", "Bolivia", "Brasil", "Chile", "Portugal", "Qatar"}));
		cmbPais.setBounds(83, 70, 217, 24);
		panel.add(cmbPais);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(167, 351, 89, 23);
		contentPane.add(btnAceptar);
		
		JLabel lblNewLabel_4 = new JLabel("Paginas");
		lblNewLabel_4.setFont(new Font("Teko SemiBold", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setBounds(34, 267, 63, 28);
		contentPane.add(lblNewLabel_4);
		
		spnPaginas = new JSpinner();
		spnPaginas.setModel(new SpinnerNumberModel(Integer.valueOf(50), Integer.valueOf(50), null, Integer.valueOf(1)));
		spnPaginas.setBounds(107, 269, 217, 24);
		contentPane.add(spnPaginas);
	}


	private void iniciarManejadoresEventos() {
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String Nombre = txtNom.getText();
				String Autor = txtNomAu.getText();
				String Pais = (String) cmbPais.getSelectedItem();
				int Pag =Integer.valueOf(spnPaginas.getValue().toString());
				Autor a = new Autor(Autor, Pais);
				Libro l = new Libro(Nombre, a, Pag);
				Biblioteca b = new Biblioteca();
				b.insertar(l);
				JOptionPane.showMessageDialog(null, "Nombre="+l.getNombre()+"\nApellido del Autor="+l.getSuAutor().getApellido()+"\nPais="+l.getSuAutor().getPais()+"\nCantidad pag="+l.getPaginas()+"\nprecio="+l.precio());
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				}
		});
		
		
		
		
	}
public static void main(String[] args) {
		Principal ventana = new Principal();
		ventana.setVisible(true);
	}
}
