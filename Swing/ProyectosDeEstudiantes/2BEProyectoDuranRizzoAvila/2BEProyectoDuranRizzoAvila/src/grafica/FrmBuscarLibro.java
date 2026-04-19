package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class FrmBuscarLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtCopias;
	private JTextField txtPaginas;
	private JTextField txtAutor;
	private JTextField txtFecha;
	private JTextField txtEdi;
	private JTextField txtPais;
	private JTextField txtIDaBusar;


	public FrmBuscarLibro() {
		setTitle("Buscador de Libros");
		setSize(398, 524);
		setBounds(100, 100, 396, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Buscar Libro", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(42, 46, 298, 385);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblInID = new JLabel("Ingrese la ID:");
		lblInID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInID.setBounds(21, 27, 114, 14);
		panel.add(lblInID);
		
		JButton btnBuscarS = new JButton("Buscar");
		btnBuscarS.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\IconButtom\\IcBus.png"));
		btnBuscarS.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		btnBuscarS.setBounds(74, 61, 160, 38);
		panel.add(btnBuscarS);
		
		JLabel lblTit = new JLabel("Título:");
		lblTit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTit.setBounds(10, 119, 60, 14);
		panel.add(lblTit);
		
		JLabel lblNumS = new JLabel("Copias Disponibles:");
		lblNumS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumS.setBounds(10, 158, 114, 14);
		panel.add(lblNumS);
		
		JLabel lblDirS = new JLabel("Número de Páginas:");
		lblDirS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDirS.setBounds(10, 196, 125, 14);
		panel.add(lblDirS);
		
		txtTitulo = new JTextField();
		txtTitulo.setEnabled(false);
		txtTitulo.setEditable(false);
		txtTitulo.setBounds(137, 117, 141, 22);
		panel.add(txtTitulo);
		
		txtCopias = new JTextField();
		txtCopias.setEnabled(false);
		txtCopias.setEditable(false);
		txtCopias.setBounds(137, 155, 141, 22);
		panel.add(txtCopias);
		
		txtPaginas = new JTextField();
		txtPaginas.setEnabled(false);
		txtPaginas.setEditable(false);
		txtPaginas.setBounds(137, 194, 141, 22);
		panel.add(txtPaginas);
		
		txtAutor = new JTextField();
		txtAutor.setEnabled(false);
		txtAutor.setEditable(false);
		txtAutor.setBounds(137, 230, 141, 22);
		panel.add(txtAutor);
		
		JLabel lblAutores = new JLabel("Autor/es:");
		lblAutores.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAutores.setBounds(10, 232, 60, 14);
		panel.add(lblAutores);
		
		txtFecha = new JTextField();
		txtFecha.setEnabled(false);
		txtFecha.setEditable(false);
		txtFecha.setBounds(137, 337, 141, 22);
		panel.add(txtFecha);
		
		JLabel lblFechaDeEdicin = new JLabel("Fecha de Edición:");
		lblFechaDeEdicin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaDeEdicin.setBounds(10, 339, 114, 14);
		panel.add(lblFechaDeEdicin);
		
		txtEdi = new JTextField();
		txtEdi.setEnabled(false);
		txtEdi.setEditable(false);
		txtEdi.setBounds(137, 301, 141, 22);
		panel.add(txtEdi);
		
		JLabel lblEditorial = new JLabel("Editorial:");
		lblEditorial.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEditorial.setBounds(10, 303, 60, 14);
		panel.add(lblEditorial);
		
		txtPais = new JTextField();
		txtPais.setEnabled(false);
		txtPais.setEditable(false);
		txtPais.setBounds(137, 263, 141, 22);
		panel.add(txtPais);
		
		JLabel lblPas = new JLabel("País:");
		lblPas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPas.setBounds(10, 265, 60, 14);
		panel.add(lblPas);
		
		txtIDaBusar = new JTextField();
		txtIDaBusar.setBounds(112, 25, 166, 22);
		panel.add(txtIDaBusar);
		
		JLabel lblBackGroundBuscarLibro = new JLabel("");
		lblBackGroundBuscarLibro.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\BackGround\\Backgroud_Buscar.png"));
		lblBackGroundBuscarLibro.setBounds(0, 0, 380, 487);
		contentPane.add(lblBackGroundBuscarLibro);
	}
}
