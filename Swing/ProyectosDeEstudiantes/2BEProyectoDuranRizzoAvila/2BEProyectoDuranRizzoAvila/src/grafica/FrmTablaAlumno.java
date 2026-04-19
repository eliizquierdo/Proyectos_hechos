package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmTablaAlumno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaSocio;
	private DefaultTableModel miModelo;
	private Vector<?> titilos;

	public FrmTablaAlumno() {
		setTitle("Lista de Alumnos Registrados");
		setSize(512, 618);
		setBounds(100, 100, 512, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlSocio = new JPanel();
		pnlSocio.setBounds(38, 38, 421, 491);
		contentPane.add(pnlSocio);
		pnlSocio.setLayout(null);
		
		JScrollPane scrPane = new JScrollPane();
		scrPane.setBounds(10, 11, 401, 469);
		pnlSocio.add(scrPane);
		
		tablaSocio = new JTable();
		scrPane.setColumnHeaderView(tablaSocio);
		
		
		String titulos[]= {"Cédula","Nombre","Teléfono","Dirección"};
		miModelo=new DefaultTableModel(null,titilos);
		tablaSocio.setModel(miModelo);
		
		JLabel lblBackGroundTabla = new JLabel("");
		lblBackGroundTabla.setIcon(new ImageIcon("G:\\Proyect_02\\Imag\\BackGround\\BackgroudTabla.png"));
		lblBackGroundTabla.setBounds(0, 0, 502, 579);
		contentPane.add(lblBackGroundTabla);
	}
}
