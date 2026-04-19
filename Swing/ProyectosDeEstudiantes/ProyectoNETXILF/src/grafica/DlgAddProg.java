package grafica;

import logica.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import persistencia.ConnectionMySQL;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.UIManager;

/**
 * DlgAddProg es una clase que es un JDialog para agregar programación, ya sea una serie o una película.
 * Permite ingresar información detallada sobre la programación, como nombre, descripción, fecha de estreno, entre otros.
 */

public class DlgAddProg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JLabel lblnameProgramming;
	private JButton btnBack;
	private JTextField txtNameProgramming;
	private JLabel lblTypeProgramming;
	private JTextField txtDescription;
	private JLabel lblDescription;
	private JLabel lblReleaseDate;
	private JTextField txtCoverURL;
	private JLabel lblCoverURL;
	private JLabel lblGenre;
	private JTextField txtGenre;
	private JLabel lblSubGenre;
	private JTextField txtSubGenre;
	private JButton btnLogin;
	private JLabel lblWarningType;
	private JLabel lblWarningName;
	private JLabel lblWarningDescription;
	private JLabel lblWarningDate;
	private JLabel lblWarningGenre;
	private JLabel lblWarningCover;
	private JLabel lblWarningSubGenre;
	private JDateChooser dtcReleaseDate;
	private JTextField txtSeasons;
	private JTextField txtChapter;
	private JComboBox cmbTypeProgramming;
	private JLabel lblSeasons;
	private JLabel lblChapter;
	private JLabel lblWarningSeasons;
	private JLabel lblWarningChapter;
	
	/**
     * Constructor de la clase DlgAddProg.
     * Inicializa y configura la apariencia del diálogo, así como también los componentes y su disposición.
     */

	public DlgAddProg() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		eventStarter();
		eventHandler();

	}
	
	/**
     * Inicializa y configura la apariencia del JDialog, así como también los componentes y su disposición.
     */
	

	private void eventStarter() {
		setResizable(false);
		setTitle("NETXILF - Agregar Programación");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\img\\Nlogo.jpg"));
		setBounds(100, 100, 278, 686);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 0, 0), new Color(255, 0, 0)));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(10, 10, 242, 626);
		contentPanel.add(panel);
		panel.setLayout(null);

		lblnameProgramming = new JLabel("Nombre");
		lblnameProgramming.setBounds(10, 75, 56, 23);
		panel.add(lblnameProgramming);
		lblnameProgramming.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblnameProgramming.setForeground(new Color(255, 255, 255));

		btnLogin = new JButton("Ingresar");
		btnLogin.setBounds(10, 592, 103, 23);
		panel.add(btnLogin);

		btnBack = new JButton("Volver");
		btnBack.setBounds(129, 592, 103, 23);
		panel.add(btnBack);

		txtNameProgramming = new JTextField();
		txtNameProgramming.setColumns(10);
		txtNameProgramming.setBounds(10, 100, 222, 28);
		panel.add(txtNameProgramming);

		lblTypeProgramming = new JLabel("Tipo de Programación");
		lblTypeProgramming.setForeground(Color.WHITE);
		lblTypeProgramming.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTypeProgramming.setBounds(10, 11, 151, 23);
		panel.add(lblTypeProgramming);

		txtDescription = new JTextField();
		txtDescription.setColumns(10);
		txtDescription.setBounds(10, 160, 222, 28);
		panel.add(txtDescription);

		lblDescription = new JLabel("Descripción");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescription.setBounds(10, 135, 78, 14);
		panel.add(lblDescription);

		lblReleaseDate = new JLabel("Fecha de Estreno");
		lblReleaseDate.setForeground(Color.WHITE);
		lblReleaseDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReleaseDate.setBounds(10, 199, 119, 14);
		panel.add(lblReleaseDate);

		txtCoverURL = new JTextField();
		txtCoverURL.setColumns(10);
		txtCoverURL.setBounds(10, 288, 222, 28);
		panel.add(txtCoverURL);

		lblCoverURL = new JLabel("URL - Caratula");
		lblCoverURL.setForeground(Color.WHITE);
		lblCoverURL.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCoverURL.setBounds(10, 263, 103, 14);
		panel.add(lblCoverURL);

		lblGenre = new JLabel("Genero");
		lblGenre.setForeground(Color.WHITE);
		lblGenre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGenre.setBounds(10, 327, 52, 14);
		panel.add(lblGenre);

		txtGenre = new JTextField();
		txtGenre.setColumns(10);
		txtGenre.setBounds(10, 352, 222, 28);
		panel.add(txtGenre);

		lblSubGenre = new JLabel("Subgenero");
		lblSubGenre.setForeground(Color.WHITE);
		lblSubGenre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubGenre.setBounds(10, 391, 78, 23);
		panel.add(lblSubGenre);

		txtSubGenre = new JTextField();
		txtSubGenre.setColumns(10);
		txtSubGenre.setBounds(10, 416, 222, 28);
		panel.add(txtSubGenre);

		lblWarningType = new JLabel("");
		lblWarningType.setForeground(Color.GRAY);
		lblWarningType.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWarningType.setBounds(171, 19, 61, 15);
		panel.add(lblWarningType);

		lblWarningName = new JLabel("");
		lblWarningName.setForeground(Color.GRAY);
		lblWarningName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWarningName.setBounds(176, 75, 56, 14);
		panel.add(lblWarningName);

		lblWarningDescription = new JLabel("");
		lblWarningDescription.setForeground(Color.GRAY);
		lblWarningDescription.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningDescription.setBounds(176, 135, 56, 14);
		panel.add(lblWarningDescription);

		lblWarningDate = new JLabel("");
		lblWarningDate.setForeground(Color.GRAY);
		lblWarningDate.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningDate.setBounds(176, 199, 56, 14);
		panel.add(lblWarningDate);

		lblWarningGenre = new JLabel("");
		lblWarningGenre.setForeground(Color.GRAY);
		lblWarningGenre.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningGenre.setBounds(176, 327, 56, 14);
		panel.add(lblWarningGenre);

		lblWarningCover = new JLabel("");
		lblWarningCover.setForeground(Color.GRAY);
		lblWarningCover.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningCover.setBounds(176, 263, 56, 14);
		panel.add(lblWarningCover);

		lblWarningSubGenre = new JLabel("");
		lblWarningSubGenre.setForeground(Color.GRAY);
		lblWarningSubGenre.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningSubGenre.setBounds(176, 391, 56, 14);
		panel.add(lblWarningSubGenre);

		cmbTypeProgramming = new JComboBox();
		cmbTypeProgramming.setModel(new DefaultComboBoxModel(new String[] { "", "Serie", "Pelicula" }));
		cmbTypeProgramming.setToolTipText("");
		cmbTypeProgramming.setMaximumRowCount(3);
		cmbTypeProgramming.setBounds(10, 37, 222, 28);
		panel.add(cmbTypeProgramming);

		dtcReleaseDate = new JDateChooser();
		dtcReleaseDate.setBounds(10, 224, 222, 28);
		dtcReleaseDate.setDateFormatString("dd/MM/yyyy"); // Formato de fecha
		panel.add(dtcReleaseDate);

		lblSeasons = new JLabel("Temporadas");
		lblSeasons.setForeground(Color.WHITE);
		lblSeasons.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSeasons.setBounds(10, 455, 91, 14);
		panel.add(lblSeasons);

		txtSeasons = new JTextField();
		txtSeasons.setColumns(10);
		txtSeasons.setBounds(10, 480, 222, 28);
		panel.add(txtSeasons);

		lblChapter = new JLabel("Capitulos");
		lblChapter.setForeground(Color.WHITE);
		lblChapter.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChapter.setBounds(10, 519, 78, 14);
		panel.add(lblChapter);

		txtChapter = new JTextField();
		txtChapter.setColumns(10);
		txtChapter.setBounds(10, 544, 222, 28);
		panel.add(txtChapter);

		lblWarningSeasons = new JLabel("");
		lblWarningSeasons.setForeground(Color.GRAY);
		lblWarningSeasons.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningSeasons.setBounds(176, 455, 56, 14);
		panel.add(lblWarningSeasons);

		lblWarningChapter = new JLabel("");
		lblWarningChapter.setForeground(Color.GRAY);
		lblWarningChapter.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWarningChapter.setBounds(176, 519, 56, 14);
		panel.add(lblWarningChapter);

	}
	
	 /**
     * Configura los manejadores de eventos y escuchadores para la funcionalidad del diálogo.
     */

	private void eventHandler() {

		cmbTypeProgramming.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcion = (String) cmbTypeProgramming.getSelectedItem();
				if (opcion.equals("Pelicula")) {
					txtChapter.setEnabled(false);
					txtSeasons.setEnabled(false);
				} else {
					txtChapter.setEnabled(true);
					txtSeasons.setEnabled(true);
				}
			}
		});
		
		 /**
	     * ActionListener para el botón "Ingresar". Valida los campos de entrada y agrega la programación a la base de datos.
	     * Si es una serie, realiza validaciones adicionales para las temporadas y capítulos.
	     */

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Validaciones.verifyNameFull(txtNameProgramming)) {
					lblWarningName.setText("");
				} else {
					lblWarningName.setText("Incorrecto");
				}

				if (Validaciones.verifyNameNoRestriction(txtDescription)) {
					lblWarningDescription.setText("");
				} else {
					lblWarningDescription.setText("Incorrecto");
				}

				if (Validaciones.verifyNameNoRestriction(txtCoverURL)) {
					lblWarningCover.setText("");
				} else {
					lblWarningCover.setText("Incorrecto");
				}

				if (Validaciones.verifyName(txtGenre)) {
					lblWarningGenre.setText("");
				} else {
					lblWarningGenre.setText("Incorrecto");
				}

				
				
				Date Date = ((JDateChooser) dtcReleaseDate).getDate();
				if((Date == null)) {
					lblWarningDate.setText("Incorrecto");
				}else {
					lblWarningDate.setText("");
				}
				
				String typeProgramming = (String) cmbTypeProgramming.getSelectedItem();
				if(typeProgramming.equals("")) {
					lblWarningType.setText("Incorrecto");
				}else {
					lblWarningType.setText("");
				}

				if (lblWarningType.getText().equals("") && lblWarningName.getText().equals("") && lblWarningDescription.getText().equals("")
						&& lblWarningDescription.getText().equals("") && lblWarningDate.getText().equals("")
						&& lblWarningCover.getText().equals("") && lblWarningGenre.getText().equals("")
						&& lblWarningSubGenre.getText().equals("")) {

					if (cmbTypeProgramming.getSelectedItem().equals("Serie")) {
						
						if (Validaciones.verifyPhoneNumber2(txtSeasons)) {
							lblWarningSeasons.setText("");
						} else {
							lblWarningSeasons.setText("Incorrecto");
						}

						if (Validaciones.verifyPhoneNumber2(txtChapter)) {
							lblWarningChapter.setText("");
						} else {
							lblWarningChapter.setText("Incorrecto");
						}
						
						if (lblWarningSeasons.getText().equals("") && lblWarningChapter.getText().equals("")) {
							int numberSeasons = Integer.parseInt(txtSeasons.getText());
							int numberChapter = Integer.parseInt(txtChapter.getText());
							
							SeriesVO serie = new SeriesVO(typeProgramming, txtNameProgramming.getText(),
									txtDescription.getText(), txtCoverURL.getText(), txtGenre.getText(),
									txtSubGenre.getText(), ((JDateChooser) dtcReleaseDate).getDate(), numberSeasons,
									numberChapter);
							SeriesDAO.insertSeries(serie);
							DlgHiddenMenu oculto = new DlgHiddenMenu();
							oculto.setVisible(true);
							dispose();
						}

					} else {
						
						MoviesVO movie = new MoviesVO(typeProgramming, txtNameProgramming.getText(),
								txtDescription.getText(), txtCoverURL.getText(), txtGenre.getText(),
								txtSubGenre.getText(), ((JDateChooser) dtcReleaseDate).getDate());
						MoviesDAO.insertMovie(movie);
						DlgHiddenMenu oculto = new DlgHiddenMenu();
						oculto.setVisible(true);
						dispose();

					}

				}
			}
		});
		
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

	}

}
