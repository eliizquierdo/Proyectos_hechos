package grafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import logica.MoviesDAO;
import logica.SeriesDAO;

import persistencia.GestionCuentas;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * La clase DlgDelProg proporciona una interfaz gráfica para eliminar una programación (serie o película) del sistema NETXILF.
 * Permite ingresar el tipo de programación (Serie o Película) y el nombre de la programación a eliminar.
 */

public class DlgDelProg extends JDialog {

	
	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JLabel lblTypeProg;
	private JButton btnDelete;
	private JButton btnBack;
	private JTextField txtNameProg;
	private JComboBox cmbTypeProg;
	private JLabel lblNameProg;
	
	/**
     * Constructor de la clase. Inicializa la interfaz gráfica y los manejadores de eventos asociados.
     */

	public DlgDelProg() {
		try {
		    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		eventStarter();
		eventHandler();

	}
	
	/**
     * Configura los manejadores de eventos para los botones de la interfaz.
     */

	private void eventHandler() {
		
		/**
	     * ActionListener para el botón "Volver". Cierra el diálogo y muestra el menú oculto.
	     */

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgHiddenMenu oculto = new DlgHiddenMenu();
				oculto.setVisible(true);
				dispose();
			}
		});
		
		/**
	     * ActionListener para el botón "Eliminar". Borra la programación en la base de datos en base a el tipo de programación dado y el nombre de la misma.
	     */
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameProgramming = txtNameProg.getText();
				String typeProgramming = (String) cmbTypeProg.getSelectedItem();
				if(typeProgramming.equalsIgnoreCase("Serie")) {
					SeriesDAO.deleteProgramming(typeProgramming, nameProgramming);
					DlgHiddenMenu menu = new DlgHiddenMenu();
					menu.setVisible(true);
					dispose();
				}else {
					MoviesDAO.DeleteProgramming(typeProgramming, nameProgramming);
					DlgHiddenMenu menu = new DlgHiddenMenu();
					menu.setVisible(true);
					dispose();
				}
				

			}
		});
	}
	
	 /**
     * Inicializa y configura la interfaz gráfica, estableciendo propiedades como el tamaño, la ubicación y la apariencia.
     */

	private void eventStarter() {
		setResizable(false);
		setTitle("NETXILF - Eliminar Admin");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\img\\Nlogo.jpg"));
		setBounds(100, 100, 308, 233);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 0, 0), new Color(255, 0, 0)));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(10, 10, 272, 173);
		contentPanel.add(panel);
		panel.setLayout(null);

		lblTypeProg = new JLabel("Programacion a Eliminar - Tipo");
		lblTypeProg.setBounds(15, 11, 234, 23);
		panel.add(lblTypeProg);
		lblTypeProg.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTypeProg.setForeground(new Color(255, 255, 255));

		btnDelete = new JButton("Eliminar");
		btnDelete.setBounds(10, 139, 103, 23);
		panel.add(btnDelete);
		btnDelete.setActionCommand("OK");

		btnBack = new JButton("Volver");
		btnBack.setBounds(159, 139, 103, 23);
		panel.add(btnBack);
		btnBack.setActionCommand("Cancel");
		
		txtNameProg = new JTextField();
		txtNameProg.setColumns(10);
		txtNameProg.setBounds(10, 100, 252, 28);
		panel.add(txtNameProg);
		
		lblNameProg = new JLabel("Programación a Eliminar - Nombre");
		lblNameProg.setForeground(Color.WHITE);
		lblNameProg.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNameProg.setBounds(15, 75, 258, 14);
		panel.add(lblNameProg);
		
		cmbTypeProg = new JComboBox();
		cmbTypeProg.setModel(new DefaultComboBoxModel(new String[] {"", "Serie", "Pelicula"}));
		cmbTypeProg.setToolTipText("");
		cmbTypeProg.setMaximumRowCount(3);
		cmbTypeProg.setBounds(10, 37, 252, 28);
		panel.add(cmbTypeProg);

	}
}