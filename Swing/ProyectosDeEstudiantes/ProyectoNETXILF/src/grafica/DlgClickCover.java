package grafica;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import persistencia.ConnectionMySQL;

import logica.MoviesVO;
import logica.SeriesVO;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * DlgClickCover es una clase que un JDialog que muestra detalles de una programación específica
 * al hacer clic en su carátula. Puede mostrar información como el nombre, descripción, género, subgénero,
 * fecha de estreno, y más, dependiendo de si es una película o una serie.
 */

public class DlgClickCover extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JLabel lblDescription;
	private JLabel lblTitle;
	private JLabel lblCover;
	private JLabel lblLogo;
	private JLabel lblGenre;
	private JLabel lblSiteReleaseDate;
	private JLabel lblSiteNumberChapters;
	private JLabel lblSiteNumberSeasons;
	private JLabel lblSiteSubGenre;
	private JLabel lblSiteGenre;
	private JLabel lblSubGenre;
	private JLabel lblNumberSeasons;
	private JLabel lblNumberChapters;
	private JLabel lblReleaseDate;
	private JLabel lblEndWatching;


	/**
     * Constructor de la clase DlgClickCover para películas.
     * @param id_Profile El ID del perfil de usuario.
     * @param id_Programming El ID de la programación.
     * @param typeProgramming El tipo de programación (película o serie).
     * @param programmingName El nombre de la programación.
     * @param description La descripción de la programación.
     * @param cover La URL de la carátula.
     * @param gender El género de la programación.
     * @param subGenre El subgénero de la programación.
     * @param releaseDate La fecha de estreno de la programación.
     */
	
	public DlgClickCover(String id_Profile, int id_Programming, String typeProgramming, String programmingName, String description, String cover, String gender,
			String subGenre, Date releaseDate) {
		
		try {
		    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		eventStarter(id_Programming, typeProgramming, programmingName, description, cover, gender,
				subGenre, releaseDate);
		
		eventHandler(id_Profile, id_Programming);
	}
	
	/**
     * Constructor de la clase DlgClickCover para series.
     * @param id_Profile El ID del perfil de usuario.
     * @param id_Programming El ID de la programación.
     * @param typeProgramming El tipo de programación (película o serie).
     * @param programmingName El nombre de la programación.
     * @param description La descripción de la programación.
     * @param cover La URL de la carátula.
     * @param gender El género de la programación.
     * @param subGenre El subgénero de la programación.
     * @param releaseDate La fecha de estreno de la programación.
     * @param numberSeasons El número de temporadas de la serie.
     * @param numberChapter El número de capítulos de la serie.
     */
	
	public DlgClickCover(String id_Profile, int id_Programming, String typeProgramming, String programmingName, String description, String cover, String gender,
			String subGenre, Date releaseDate, int numberSeasons, int numberChapter) {
		
		try {
		    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		eventStarter(id_Programming, typeProgramming, programmingName, description, cover, gender, subGenre,  releaseDate, numberSeasons, numberChapter);
		
		eventHandler(id_Profile, id_Programming);
	}

	/**
     * Inicializa los componentes y la apariencia del diálogo.
     * @param id_Programming El ID de la programación.
     * @param typeProgramming El tipo de programación (película o serie).
     * @param programmingName El nombre de la programación.
     * @param description La descripción de la programación.
     * @param cover La URL de la carátula.
     * @param gender El género de la programación.
     * @param subGenre El subgénero de la programación.
     * @param releaseDate La fecha de estreno de la programación.
     * @param numberSeasons El número de temporadas de la serie (solo para series).
     * @param numberChapter El número de capítulos de la serie (solo para series).
     */
	
	
	private void eventStarter(int id_Programming, String typeProgramming, String programmingName, String description, String cover, String gender,
			String subGenre, Date releaseDate, int numberSeasons, int numberChapter) {
		
		
		setBounds(500, 500, 1000, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblTitle = new JLabel();
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblTitle.setForeground(Color.white);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(492, 77, 482, 47);
		lblTitle.setText(programmingName);
		panel.add(lblTitle);
		
		lblDescription = new JLabel();
		// Formatear el texto como HTML
		String htmlText = "<html>" + description + "</html>";
		lblDescription.setText(htmlText);
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescription.setForeground(Color.white);
		lblDescription.setVerticalAlignment(SwingConstants.TOP);
		lblDescription.setBounds(502, 135, 472, 120);
		panel.add(lblDescription);
		
		lblCover = new JLabel("");
		lblCover.setIcon(new ImageIcon(cover));
		lblCover.setBounds(10, 11, 471, 639);
		panel.add(lblCover);
		
		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon("C:\\img\\NetxilfCh.jpg"));
		lblLogo.setVerticalAlignment(SwingConstants.TOP);
		lblLogo.setForeground(Color.RED);
		lblLogo.setBounds(492, 11, 483, 55);
		panel.add(lblLogo);
		
		lblGenre = new JLabel("Genero:");
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGenre.setVerticalAlignment(SwingConstants.TOP);
		lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenre.setForeground(Color.WHITE);
		lblGenre.setBounds(492, 292, 482, 31);
		panel.add(lblGenre);
		
		lblSubGenre = new JLabel("SubGenero:");
		lblSubGenre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSubGenre.setVerticalAlignment(SwingConstants.TOP);
		lblSubGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubGenre.setForeground(Color.WHITE);
		lblSubGenre.setBounds(502, 368, 472, 23);
		panel.add(lblSubGenre);
		
		lblNumberSeasons = new JLabel("Cantidad de temporadas:");
		lblNumberSeasons.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumberSeasons.setVerticalAlignment(SwingConstants.TOP);
		lblNumberSeasons.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberSeasons.setForeground(Color.WHITE);
		lblNumberSeasons.setBounds(492, 436, 482, 23);
		panel.add(lblNumberSeasons);
		
		lblNumberChapters = new JLabel("Cantidad de capítulos:");
		lblNumberChapters.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumberChapters.setVerticalAlignment(SwingConstants.TOP);
		lblNumberChapters.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberChapters.setForeground(Color.WHITE);
		lblNumberChapters.setBounds(492, 504, 482, 23);
		panel.add(lblNumberChapters);
		
		lblReleaseDate = new JLabel("Fecha de estreno:");
		lblReleaseDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblReleaseDate.setVerticalAlignment(SwingConstants.TOP);
		lblReleaseDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblReleaseDate.setForeground(Color.WHITE);
		lblReleaseDate.setBounds(492, 572, 482, 23);
		panel.add(lblReleaseDate);
		
		lblSiteGenre = new JLabel(gender);
		lblSiteGenre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSiteGenre.setForeground(Color.LIGHT_GRAY);
		lblSiteGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiteGenre.setBounds(492, 334, 482, 23);
		panel.add(lblSiteGenre);
		
		lblSiteSubGenre = new JLabel(subGenre);
		lblSiteSubGenre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSiteSubGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiteSubGenre.setForeground(Color.LIGHT_GRAY);
		lblSiteSubGenre.setBounds(492, 402, 482, 23);
		panel.add(lblSiteSubGenre);
		
		
		String numberSeasonsLabel = String.valueOf(numberSeasons);
		lblSiteNumberSeasons = new JLabel(numberSeasonsLabel);
		lblSiteNumberSeasons.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSiteNumberSeasons.setForeground(Color.LIGHT_GRAY);
		lblSiteNumberSeasons.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiteNumberSeasons.setBounds(492, 470, 482, 23);
		panel.add(lblSiteNumberSeasons);
		
		String numberChaptersLabel = String.valueOf(numberChapter);
		lblSiteNumberChapters = new JLabel(numberChaptersLabel);
		lblSiteNumberChapters.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSiteNumberChapters.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiteNumberChapters.setForeground(Color.LIGHT_GRAY);
		lblSiteNumberChapters.setBounds(492, 538, 482, 23);
		panel.add(lblSiteNumberChapters);
		
		String releaseDateLabel = String.valueOf(releaseDate);
		lblSiteReleaseDate = new JLabel(releaseDateLabel);
		lblSiteReleaseDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSiteReleaseDate.setForeground(Color.LIGHT_GRAY);
		lblSiteReleaseDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiteReleaseDate.setBounds(492, 606, 482, 23);
		panel.add(lblSiteReleaseDate);
		
		lblEndWatching = new JLabel("Ya termine de verla");
		lblEndWatching.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEndWatching.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndWatching.setForeground(Color.WHITE);
		lblEndWatching.setBounds(502, 627, 472, 23);
		panel.add(lblEndWatching);
	}
	
	/**
     * Inicializa los componentes y la apariencia del diálogo para películas.
     * @param id_Programming El ID de la programación.
     * @param typeProgramming El tipo de programación (película o serie).
     * @param programmingName El nombre de la programación.
     * @param description La descripción de la programación.
     * @param cover La URL de la carátula.
     * @param gender El género de la programación.
     * @param subGenre El subgénero de la programación.
     * @param releaseDate La fecha de estreno de la programación.
     */
	
	private void eventStarter(int id_Programming, String typeProgramming, String programmingName, String description, String cover, String gender,
			String subGenre, Date releaseDate) {
		
		
		setBounds(500, 500, 1000, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblTitle = new JLabel();
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblTitle.setForeground(Color.white);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(492, 77, 482, 47);
		lblTitle.setText(programmingName);
		panel.add(lblTitle);
		
		lblDescription = new JLabel();
		// Formatear el texto como HTML
		String htmlText = "<html>" + description + "</html>";
		lblDescription.setText(htmlText);
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescription.setForeground(Color.white);
		lblDescription.setVerticalAlignment(SwingConstants.TOP);
		lblDescription.setBounds(502, 135, 472, 120);
		panel.add(lblDescription);
		
		lblCover = new JLabel("");
		lblCover.setIcon(new ImageIcon(cover));
		lblCover.setBounds(10, 11, 471, 639);
		panel.add(lblCover);
		
		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon("C:\\img\\NetxilfCh.jpg"));
		lblLogo.setVerticalAlignment(SwingConstants.TOP);
		lblLogo.setForeground(Color.RED);
		lblLogo.setBounds(492, 11, 483, 55);
		panel.add(lblLogo);
		
		lblGenre = new JLabel("Genero:");
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGenre.setVerticalAlignment(SwingConstants.TOP);
		lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenre.setForeground(Color.WHITE);
		lblGenre.setBounds(492, 292, 482, 31);
		panel.add(lblGenre);
		
		lblSubGenre = new JLabel("SubGenero:");
		lblSubGenre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSubGenre.setVerticalAlignment(SwingConstants.TOP);
		lblSubGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubGenre.setForeground(Color.WHITE);
		lblSubGenre.setBounds(502, 368, 472, 23);
		panel.add(lblSubGenre);
		
		lblReleaseDate = new JLabel("Fecha de estreno:");
		lblReleaseDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblReleaseDate.setVerticalAlignment(SwingConstants.TOP);
		lblReleaseDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblReleaseDate.setForeground(Color.WHITE);
		lblReleaseDate.setBounds(492, 436, 482, 23);
		panel.add(lblReleaseDate);
		
		lblSiteGenre = new JLabel(gender);
		lblSiteGenre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSiteGenre.setForeground(Color.LIGHT_GRAY);
		lblSiteGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiteGenre.setBounds(492, 334, 482, 23);
		panel.add(lblSiteGenre);
		
		lblSiteSubGenre = new JLabel(subGenre);
		lblSiteSubGenre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSiteSubGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiteSubGenre.setForeground(Color.LIGHT_GRAY);
		lblSiteSubGenre.setBounds(492, 402, 482, 23);
		panel.add(lblSiteSubGenre);
				
		String releaseDateLabel = String.valueOf(releaseDate);
		lblSiteReleaseDate = new JLabel(releaseDateLabel);
		lblSiteReleaseDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSiteReleaseDate.setForeground(Color.LIGHT_GRAY);
		lblSiteReleaseDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiteReleaseDate.setBounds(492, 470, 482, 23);
		panel.add(lblSiteReleaseDate);
		
		lblEndWatching = new JLabel("Ya termine de verla");
		lblEndWatching.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEndWatching.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndWatching.setForeground(Color.WHITE);
		lblEndWatching.setBounds(502, 627, 472, 23);
		panel.add(lblEndWatching);
	}
	
	/**
     * Manejador de eventos para el clic en la etiqueta "Ya termine de verla".
     * Abre un diálogo para evaluar la programación.
     * @param id_Profile El ID del perfil de usuario.
     * @param id_Programming El ID de la programación.
     */
	
	
	private void eventHandler(String id_Profile, int id_Programming) {
		lblEndWatching.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DlgScore score=new DlgScore(id_Profile, id_Programming);
				score.setVisible(true);
				
			}
		});
	}
	
	

}
