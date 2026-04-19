package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import logica.Docente;
import logica.Fecha;
import logica.Libro;

public class FrmReLibros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtTitulo;
	private JTextField txtCopias;
	private JTextField txtPaginas;
	private JTextField txtAutor;
	private JTextField txtPais;
	private JTextField txtEdi;
	private JDateChooser dateChooser;

	public FrmReLibros() {
		setTitle("Registar Libro");
		setSize(455, 627);
		setBounds(100, 100, 454, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlRLibro = new JPanel();
		pnlRLibro.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registrar Libro", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlRLibro.setBounds(66, 46, 298, 185);
		contentPane.add(pnlRLibro);
		pnlRLibro.setLayout(null);
		
		JLabel lblId = new JLabel("I.D:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblId.setBounds(25, 39, 46, 14);
		pnlRLibro.add(lblId);
		
		JLabel lblTitulo = new JLabel("Título:");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTitulo.setBounds(25, 75, 46, 14);
		pnlRLibro.add(lblTitulo);
		
		JLabel lblCopias = new JLabel("Copias Disponibles:");
		lblCopias.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCopias.setBounds(25, 111, 121, 14);
		pnlRLibro.add(lblCopias);
		
		JLabel lblPaginas = new JLabel("Número de Páginas:");
		lblPaginas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPaginas.setBounds(25, 145, 121, 14);
		pnlRLibro.add(lblPaginas);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(156, 37, 105, 20);
		pnlRLibro.add(txtId);
		
		txtTitulo = new JTextField();
		txtTitulo.setText("");
		txtTitulo.setBounds(156, 73, 105, 20);
		pnlRLibro.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtCopias = new JTextField();
		txtCopias.setBounds(156, 108, 105, 20);
		pnlRLibro.add(txtCopias);
		txtCopias.setColumns(10);
		
		txtPaginas = new JTextField();
		txtPaginas.setBounds(155, 143, 106, 20);
		pnlRLibro.add(txtPaginas);
		txtPaginas.setColumns(10);
		
		JPanel pnlAutor = new JPanel();
		pnlAutor.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Autor/es", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlAutor.setBounds(66, 238, 298, 114);
		contentPane.add(pnlAutor);
		pnlAutor.setLayout(null);
		
		JLabel lblAutor = new JLabel("Autor/es:");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAutor.setBounds(36, 38, 74, 14);
		pnlAutor.add(lblAutor);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(143, 35, 117, 20);
		pnlAutor.add(txtAutor);
		txtAutor.setColumns(10);
		
		JLabel lblPais = new JLabel("País:");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPais.setBounds(34, 72, 46, 14);
		pnlAutor.add(lblPais);
		
		txtPais = new JTextField();
		txtPais.setBounds(143, 69, 117, 20);
		pnlAutor.add(txtPais);
		txtPais.setColumns(10);
		
		JPanel pnlEditorial = new JPanel();
		pnlEditorial.setLayout(null);
		pnlEditorial.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Editorial", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlEditorial.setBounds(66, 357, 298, 114);
		contentPane.add(pnlEditorial);
		
		JLabel lblEditorial = new JLabel("Editorial:");
		lblEditorial.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEditorial.setBounds(39, 41, 74, 14);
		pnlEditorial.add(lblEditorial);
		
		txtEdi = new JTextField();
		txtEdi.setColumns(10);
		txtEdi.setBounds(156, 38, 107, 20);
		pnlEditorial.add(txtEdi);
		
		JLabel lblfEdi = new JLabel("Fecha de Edición:");
		lblfEdi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblfEdi.setBounds(37, 75, 109, 14);
		pnlEditorial.add(lblfEdi);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(156, 69, 107, 20);
		pnlEditorial.add(dateChooser);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText(null);
				txtTitulo.setText(null);
				txtCopias.setText(null);
				txtPaginas.setText(null);
				txtAutor.setText(null);
				txtPais.setText(null);
				txtEdi.setText(null);
				dateChooser.setToolTipText(null);
			}
		});
		
		
		btnLimpiar.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		btnLimpiar.setHorizontalAlignment(SwingConstants.LEFT);
		btnLimpiar.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\IconButtom\\IcLimp.png"));
		btnLimpiar.setBounds(54, 485, 148, 46);
		contentPane.add(btnLimpiar);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int anio = dateChooser.getCalendar().get(Calendar.YEAR);
					int mes = dateChooser.getCalendar().get(Calendar.MONTH);
					int dia = dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH);
					
					int Id=Integer.valueOf(txtId.getText());
					String Titulo=txtTitulo.getText();
					int Copias=Integer.valueOf(txtCopias.getText());
					int Paginas=Integer.valueOf(txtPaginas.getText());
					String Autor=txtAutor.getText();
					String Pais=txtPais.getText();
					String Editorial=txtEdi.getText();
					Fecha FechaEd=new Fecha (dia, mes, anio);
					
					Libro ReLi = new Libro(Id, Titulo, Copias, Paginas, Autor, Pais, Editorial, FechaEd);
					
				}catch (Exception ex ) {
					JOptionPane.showMessageDialog(null, ex);
				
				}
			
				
			}
		});
		btnRegistrar.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		btnRegistrar.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\IconButtom\\IcSave.png"));
		btnRegistrar.setBounds(230, 485, 148, 46);
		contentPane.add(btnRegistrar);
		
		JLabel lblBackGroundLibro = new JLabel("");
		lblBackGroundLibro.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\BackGround\\Backgroud_Lib.png"));
		lblBackGroundLibro.setBounds(0, 0, 438, 587);
		contentPane.add(lblBackGroundLibro);
		
	}
}
