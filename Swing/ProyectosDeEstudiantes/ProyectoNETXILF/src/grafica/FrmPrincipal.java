package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.MoviesDAO;
import logica.MoviesVO;
import logica.SeriesDAO;
import logica.SeriesVO;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

/**
 * Clase principal que representa la interfaz gráfica principal de la aplicación.
 * Esta clase extiende JFrame y muestra información sobre películas y series.
 */

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNETXILF;
	private JScrollPane scrollPane;
	private Timer timer;
	private int currentIndex1 = 0;
	private int currentIndex2 = 0;
	private int currentIndex3 = 0;

	private String[] imageCarrousel1 = { "C:\\img\\Carrousel\\Stranger.jpg", "C:\\img\\Carrousel\\Batman.jpg",
			"C:\\img\\Carrousel\\BreakingBad.jpg", "C:\\img\\Carrousel\\DoctorWho.jpg",
			"C:\\img\\Carrousel\\Friends.jpg", "C:\\img\\Carrousel\\GOT.jpg", "C:\\img\\Carrousel\\Mandalorian.jpg",
			"C:\\img\\Carrousel\\Outlander.jpg", "C:\\img\\Carrousel\\Punisher.jpg", "C:\\img\\Carrousel\\TheCrown.jpg",
			"C:\\img\\Carrousel\\Titanic.jpg", "C:\\img\\Carrousel\\Vikings.jpg", "C:\\img\\Carrousel\\Witcher.jpg",
			"C:\\img\\Carrousel\\Umbrella.jpg" }; // Rutas de las imágenes

	private String[] imageCarrousel2 = { "C:\\img\\Carrousel\\Umbrella.jpg", "C:\\img\\Carrousel\\Stranger.jpg",
			"C:\\img\\Carrousel\\Batman.jpg", "C:\\img\\Carrousel\\BreakingBad.jpg",
			"C:\\img\\Carrousel\\DoctorWho.jpg", "C:\\img\\Carrousel\\Friends.jpg", "C:\\img\\Carrousel\\GOT.jpg",
			"C:\\img\\Carrousel\\Mandalorian.jpg", "C:\\img\\Carrousel\\Outlander.jpg",
			"C:\\img\\Carrousel\\Punisher.jpg", "C:\\img\\Carrousel\\TheCrown.jpg", "C:\\img\\Carrousel\\Titanic.jpg",
			"C:\\img\\Carrousel\\Vikings.jpg", "C:\\img\\Carrousel\\Witcher.jpg"

	}; // Rutas de las imágenes

	private String[] imageCarrousel3 = { "C:\\img\\Carrousel\\Witcher.jpg", "C:\\img\\Carrousel\\Umbrella.jpg",
			"C:\\img\\Carrousel\\Stranger.jpg", "C:\\img\\Carrousel\\Batman.jpg", "C:\\img\\Carrousel\\BreakingBad.jpg",
			"C:\\img\\Carrousel\\DoctorWho.jpg", "C:\\img\\Carrousel\\Friends.jpg", "C:\\img\\Carrousel\\GOT.jpg",
			"C:\\img\\Carrousel\\Mandalorian.jpg", "C:\\img\\Carrousel\\Outlander.jpg",
			"C:\\img\\Carrousel\\Punisher.jpg", "C:\\img\\Carrousel\\TheCrown.jpg", "C:\\img\\Carrousel\\Titanic.jpg",
			"C:\\img\\Carrousel\\Vikings.jpg"

	}; // Rutas de las imágenes

	private JPanel pnlCatalog;
	private JPanel pnlRow1;
	private JLabel lblGenreRow1;
	private JPanel pnlGenreRow1;
	private JPanel pnlRow2;
	private JLabel lblGenreRow2;
	private JPanel pnlGenreRow2;
	private JPanel pnlRow3;
	private JLabel lblGenreRow3;
	private JPanel pnlGenreRow3;
	private JLabel lbl1Row1BlackMirror;
	private JLabel lbl7Row1Inception;
	private JLabel lbl6Row1JurassicPark;
	private JLabel lbl5Row1Interestellar;
	private JLabel lbl4Row1Avatar;
	private JLabel lbl3Row1Mandalorian;
	private JLabel lbl2Row1StrangerThings;
	private JLabel lbl1Row2GameOfThrones;
	private JLabel lbl7Row2TheChroniclesOfNarnia;
	private JLabel lbl6RowHarryPotterAndThePhilosophersStone;
	private JLabel lbl5Row2ShadowAndBone;
	private JLabel lbl2Row2TheWitcher;
	private JLabel lbl1Row3BreakingBad;
	private JLabel lbl4Row3ForestGump;
	private JLabel lbl3Row3PeakyBlinders;
	private JLabel lbl2Row3TheCrown;
	private JLabel lbl6Row3TheShawShankRedemption;
	private JLabel lbl5Row3Lost;
	private JPanel pnlRow4;
	private JPanel pnlRow5;
	private JPanel pnlRow6;
	private JPanel pnlRow7;
	private JLabel lblGenreRow4;
	private JPanel pnlGenreRow4;
	private JLabel lbl1Row4Friends;
	private JLabel lbl3Row4HotelBudapest;
	private JLabel lbl4Row4BrooklynNineNine;
	private JLabel lbl5Row4Superbad;
	private JLabel lbl6Row4AnchormanTheLegendofRonBurgundy;
	private JLabel lbl7Row4JaneTheVirgin;
	private JLabel lblGenreRow5;
	private JPanel pnlGenreRow5;
	private JLabel lbl1Row5Titanic;
	private JLabel lbl2Row5Outlander;
	private JLabel lbl4Row5WheHarryMetSally;
	private JLabel lbl5Row5PrideAndPrejudice;
	private JLabel lbl6Row5TheNotebook;
	private JLabel lbl7Row5LaLaLand;
	private JLabel lbl3Row5Bridgerton;
	private JLabel lblGenreRow6;
	private JPanel pnlGenreRow6;
	private JLabel lbl1Row6TheDarkKnight;
	private JLabel lbl2Row6Daredevil;
	private JLabel lbl3Row6Arrow;
	private JLabel lbl5Row6TheUmbrellaAcademy;
	private JLabel lbl6Row6DieHard;
	private JLabel lbl7Row6MadMaxFuryRoad;
	private JLabel lblGenreRow7;
	private JPanel pnlGenreRow7;
	private JLabel lbl1Row7TheSecretLifeOfWalterMitty;
	private JLabel lbl2Row7TheAdventureOfTintin;
	private JLabel lbl3Row7TheGoonies;
	private JLabel lbl4Row7Vikings;
	private JLabel lbl5Row7Up;
	private JLabel lbl6Row7PiratesOfTheCaribbean;
	private JLabel lbl7Row7IndianaJoneRaidersOfTheLostArk;
	private JLabel lbl3Row2TLOTRFellowship;
	private JLabel lbl4Row2TLOTRTheTwoTowers;
	private JLabel lbl7Row3TheGodFather;
	private JLabel lbl4Row6ThePunisher;
	private JLabel lbl2Row4TheOffice;
	private JPanel pnlDownPanel;
	private JLabel lblPreferences;
	private JLabel lblRecomendations;
	private JLabel lblProfilePic;
	private JLabel lbl8Row1DoctorWho;
	private JLabel lbl8Row2HisDarkMaterials;
	private JLabel lbl8Row3TheRevenant;
	private JLabel lbl8Row5500DaysOfSummer;
	private JLabel lbl8Row6JohnWick;
	private JLabel lbl8Row7KingKong;
	private JPanel pnlImagesCarrousel;
	private JLabel lblImageCarrousel1;
	private JLabel lblImageCarrousel2;
	private JLabel lblImageCarrousel3;
	private JLabel lbl8Row4TheDevilWearsPrada;
	
	/**
     * Constructor de la clase FrmPrincipal.
     *
     * @param nombre       El nombre del usuario.
     * @param id_Profile   El identificador del perfil del usuario.
     */

	public FrmPrincipal(String nombre, String id_Profile) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\img\\Nlogo.jpg"));
		setTitle("NETXILF");
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		eventStarter(nombre, id_Profile);
		eventHandler(id_Profile);

	}
	
	/**
     * Inicia los eventos y la interfaz gráfica.
     *
     * @param nombre       El nombre del usuario.
     * @param id_Profile   El identificador del perfil del usuario.
     */
	private void eventStarter(String nombre, String id_Profile) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(4, 1));

		timer = new Timer(2500, new ActionListener() { // Cambia la imagen cada 2 segundos
			@Override
			public void actionPerformed(ActionEvent e) {
				showNextPicture();
				showNextPicture1();
				showNextPicture2();

			}
		});
		timer.start();

		scrollPane = new JScrollPane();

		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		JPanel pnlMainPanel = new JPanel();
		pnlMainPanel.setBackground(new Color(20, 20, 20));
		scrollPane.setViewportView(pnlMainPanel);
		pnlMainPanel.setLayout(new BorderLayout(0, 0));

		pnlCatalog = new JPanel();
		pnlCatalog.setBackground(new Color(20, 20, 20));
		pnlMainPanel.add(pnlCatalog, BorderLayout.CENTER);
		pnlCatalog.setLayout(new GridLayout(7, 1, 0, 0));

		pnlRow1 = new JPanel();
		pnlRow1.setBackground(new Color(20, 20, 20));
		pnlCatalog.add(pnlRow1);
		pnlRow1.setLayout(new BorderLayout(0, 0));

		lblGenreRow1 = new JLabel("");
		lblGenreRow1.setIcon(new ImageIcon("C:\\img\\nombreCategoriasSciFi.jpg"));
		lblGenreRow1.setFont(new Font("Noto Mono", Font.BOLD, 26));
		lblGenreRow1.setForeground(new Color(255, 0, 0));
		lblGenreRow1.setBackground(Color.WHITE);
		pnlRow1.add(lblGenreRow1, BorderLayout.NORTH);

		pnlGenreRow1 = new JPanel();
		pnlGenreRow1.setBackground(new Color(20, 20, 20));
		pnlRow1.add(pnlGenreRow1, BorderLayout.CENTER);
		pnlGenreRow1.setLayout(new GridLayout(0, 8, 10, 0));

		lbl1Row1BlackMirror = new JLabel("");
		lbl1Row1BlackMirror.setBackground(Color.WHITE);
		lbl1Row1BlackMirror.setForeground(Color.WHITE);
		lbl1Row1BlackMirror.setIcon(new ImageIcon("C:\\img\\ChBlackMirror.jpg"));
		pnlGenreRow1.add(lbl1Row1BlackMirror);

		lbl2Row1StrangerThings = new JLabel("");

		lbl2Row1StrangerThings.setIcon(new ImageIcon("C:\\img\\ChStrangerThings.jpg"));
		pnlGenreRow1.add(lbl2Row1StrangerThings);

		lbl3Row1Mandalorian = new JLabel("");

		lbl3Row1Mandalorian.setIcon(new ImageIcon("C:\\img\\ChMandalorian.jpg"));
		pnlGenreRow1.add(lbl3Row1Mandalorian);

		lbl4Row1Avatar = new JLabel("");

		lbl4Row1Avatar.setIcon(new ImageIcon("C:\\img\\ChAvatar.jpg"));
		pnlGenreRow1.add(lbl4Row1Avatar);

		lbl5Row1Interestellar = new JLabel("");
		lbl5Row1Interestellar.setIcon(new ImageIcon("C:\\img\\ChInterestellar.jpg"));
		pnlGenreRow1.add(lbl5Row1Interestellar);

		lbl6Row1JurassicPark = new JLabel("");
		lbl6Row1JurassicPark.setIcon(new ImageIcon("C:\\img\\ChJurrasic.jpg"));
		pnlGenreRow1.add(lbl6Row1JurassicPark);

		lbl7Row1Inception = new JLabel("");
		lbl7Row1Inception.setIcon(new ImageIcon("C:\\img\\ChInception.jpg"));
		pnlGenreRow1.add(lbl7Row1Inception);

		lbl8Row1DoctorWho = new JLabel("");
		lbl8Row1DoctorWho.setIcon(new ImageIcon("C:\\img\\ChDoctorWho.jpg"));
		pnlGenreRow1.add(lbl8Row1DoctorWho);

		pnlRow2 = new JPanel();
		pnlRow2.setBackground(new Color(20, 20, 20));
		pnlCatalog.add(pnlRow2);
		pnlRow2.setLayout(new BorderLayout(0, 0));

		lblGenreRow2 = new JLabel("");
		lblGenreRow2.setForeground(new Color(255, 0, 0));
		lblGenreRow2.setIcon(new ImageIcon("C:\\img\\nombreCategoriasFantasia.jpg"));
		lblGenreRow2.setFont(new Font("Noto Mono", Font.BOLD, 26));
		pnlRow2.add(lblGenreRow2, BorderLayout.NORTH);

		pnlGenreRow2 = new JPanel();
		pnlGenreRow2.setBackground(new Color(20, 20, 20));
		pnlRow2.add(pnlGenreRow2, BorderLayout.CENTER);
		pnlGenreRow2.setLayout(new GridLayout(0, 8, 10, 0));

		lbl1Row2GameOfThrones = new JLabel("");
		lbl1Row2GameOfThrones.setIcon(new ImageIcon("C:\\img\\ChGameOfThrone.jpg"));
		pnlGenreRow2.add(lbl1Row2GameOfThrones);

		lbl2Row2TheWitcher = new JLabel("");
		lbl2Row2TheWitcher.setIcon(new ImageIcon("C:\\img\\ChTheWitcher.jpg"));
		pnlGenreRow2.add(lbl2Row2TheWitcher);

		lbl3Row2TLOTRFellowship = new JLabel("");

		lbl3Row2TLOTRFellowship.setIcon(new ImageIcon("C:\\img\\ChTLOTR.jpg"));
		pnlGenreRow2.add(lbl3Row2TLOTRFellowship);

		lbl4Row2TLOTRTheTwoTowers = new JLabel("");
		lbl4Row2TLOTRTheTwoTowers.setIcon(new ImageIcon("C:\\img\\ChTLOTR2.jpg"));
		pnlGenreRow2.add(lbl4Row2TLOTRTheTwoTowers);

		lbl5Row2ShadowAndBone = new JLabel("");
		lbl5Row2ShadowAndBone.setIcon(new ImageIcon("C:\\img\\chShadowAndBone.jpg"));
		pnlGenreRow2.add(lbl5Row2ShadowAndBone);

		lbl6RowHarryPotterAndThePhilosophersStone = new JLabel("");
		lbl6RowHarryPotterAndThePhilosophersStone.setIcon(new ImageIcon("C:\\img\\ChHarryPotter1.jpg"));
		pnlGenreRow2.add(lbl6RowHarryPotterAndThePhilosophersStone);

		lbl7Row2TheChroniclesOfNarnia = new JLabel("");
		lbl7Row2TheChroniclesOfNarnia.setIcon(new ImageIcon("C:\\img\\ChNarnia.jpg"));
		pnlGenreRow2.add(lbl7Row2TheChroniclesOfNarnia);

		lbl8Row2HisDarkMaterials = new JLabel("");
		lbl8Row2HisDarkMaterials.setIcon(new ImageIcon("C:\\img\\ChHisDarkMaterials.jpg"));
		pnlGenreRow2.add(lbl8Row2HisDarkMaterials);

		pnlRow3 = new JPanel();
		pnlRow3.setForeground(new Color(20, 20, 20));
		pnlRow3.setBackground(new Color(20, 20, 20));
		pnlCatalog.add(pnlRow3);
		pnlRow3.setLayout(new BorderLayout(0, 0));

		lblGenreRow3 = new JLabel("");
		lblGenreRow3.setIcon(new ImageIcon("C:\\img\\nombreCategoriasDrama.jpg"));
		lblGenreRow3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenreRow3.setVerticalAlignment(SwingConstants.BOTTOM);
		pnlRow3.add(lblGenreRow3, BorderLayout.NORTH);

		pnlGenreRow3 = new JPanel();
		pnlGenreRow3.setForeground(new Color(20, 20, 20));
		pnlGenreRow3.setBackground(new Color(20, 20, 20));
		pnlRow3.add(pnlGenreRow3, BorderLayout.CENTER);
		pnlGenreRow3.setLayout(new GridLayout(0, 8, 10, 0));

		lbl1Row3BreakingBad = new JLabel("");
		lbl1Row3BreakingBad.setIcon(new ImageIcon("C:\\img\\ChBreakingBad.jpg"));
		pnlGenreRow3.add(lbl1Row3BreakingBad);

		lbl2Row3TheCrown = new JLabel("");
		lbl2Row3TheCrown.setIcon(new ImageIcon("C:\\img\\ChTheCrown.jpg"));
		pnlGenreRow3.add(lbl2Row3TheCrown);

		lbl3Row3PeakyBlinders = new JLabel("");
		lbl3Row3PeakyBlinders.setIcon(new ImageIcon("C:\\img\\ChPeakyBlinders.jpg"));
		pnlGenreRow3.add(lbl3Row3PeakyBlinders);

		lbl4Row3ForestGump = new JLabel("");
		lbl4Row3ForestGump.setIcon(new ImageIcon("C:\\img\\ChForestGump.jpg"));
		pnlGenreRow3.add(lbl4Row3ForestGump);

		lbl5Row3Lost = new JLabel("");
		lbl5Row3Lost.setIcon(new ImageIcon("C:\\img\\ChLost.jpg"));
		pnlGenreRow3.add(lbl5Row3Lost);

		lbl6Row3TheShawShankRedemption = new JLabel("");
		lbl6Row3TheShawShankRedemption.setIcon(new ImageIcon("C:\\img\\ChRedemption.jpg"));
		pnlGenreRow3.add(lbl6Row3TheShawShankRedemption);

		lbl7Row3TheGodFather = new JLabel("");
		lbl7Row3TheGodFather.setIcon(new ImageIcon("C:\\img\\ChFather.jpg"));
		pnlGenreRow3.add(lbl7Row3TheGodFather);

		lbl8Row3TheRevenant = new JLabel("");
		lbl8Row3TheRevenant.setIcon(new ImageIcon("C:\\img\\ChRevenant.jpg"));
		pnlGenreRow3.add(lbl8Row3TheRevenant);

		pnlRow4 = new JPanel();
		pnlRow4.setBackground(new Color(20, 20, 20));
		pnlCatalog.add(pnlRow4);
		pnlRow4.setLayout(new BorderLayout(0, 0));

		lblGenreRow4 = new JLabel("");
		lblGenreRow4.setIcon(new ImageIcon("C:\\img\\nombreCategoriasComedia.jpg"));
		lblGenreRow4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenreRow4.setBackground(Color.WHITE);
		lblGenreRow4.setVerticalAlignment(SwingConstants.BOTTOM);
		pnlRow4.add(lblGenreRow4, BorderLayout.NORTH);

		pnlGenreRow4 = new JPanel();
		pnlGenreRow4.setBackground(new Color(20, 20, 20));
		pnlRow4.add(pnlGenreRow4, BorderLayout.CENTER);
		pnlGenreRow4.setLayout(new GridLayout(0, 8, 10, 0));

		lbl1Row4Friends = new JLabel("");
		lbl1Row4Friends.setIcon(new ImageIcon("C:\\img\\ChFriends.jpg"));
		pnlGenreRow4.add(lbl1Row4Friends);

		lbl2Row4TheOffice = new JLabel("");
		lbl2Row4TheOffice.setIcon(new ImageIcon("C:\\img\\ChTheOffice.jpg"));
		pnlGenreRow4.add(lbl2Row4TheOffice);

		lbl3Row4HotelBudapest = new JLabel("");
		lbl3Row4HotelBudapest.setIcon(new ImageIcon("C:\\img\\ChHotelBudapest.jpg"));
		pnlGenreRow4.add(lbl3Row4HotelBudapest);

		lbl4Row4BrooklynNineNine = new JLabel("");
		lbl4Row4BrooklynNineNine.setIcon(new ImageIcon("C:\\img\\ChBrooklyn.jpg"));
		pnlGenreRow4.add(lbl4Row4BrooklynNineNine);

		lbl5Row4Superbad = new JLabel("");
		lbl5Row4Superbad.setIcon(new ImageIcon("C:\\img\\ChSuperBad.jpg"));
		pnlGenreRow4.add(lbl5Row4Superbad);

		lbl6Row4AnchormanTheLegendofRonBurgundy = new JLabel("");
		lbl6Row4AnchormanTheLegendofRonBurgundy.setIcon(new ImageIcon("C:\\img\\ChAnchorman.jpg"));
		pnlGenreRow4.add(lbl6Row4AnchormanTheLegendofRonBurgundy);

		lbl7Row4JaneTheVirgin = new JLabel("");
		lbl7Row4JaneTheVirgin.setIcon(new ImageIcon("C:\\img\\ChJaneTheVirgin.jpg"));
		pnlGenreRow4.add(lbl7Row4JaneTheVirgin);

		lbl8Row4TheDevilWearsPrada = new JLabel("");
		lbl8Row4TheDevilWearsPrada.setIcon(new ImageIcon("C:\\img\\ChTheDevil.jpg"));
		pnlGenreRow4.add(lbl8Row4TheDevilWearsPrada);

		pnlRow5 = new JPanel();
		pnlRow5.setBackground(new Color(20, 20, 20));
		pnlCatalog.add(pnlRow5);
		pnlRow5.setLayout(new BorderLayout(0, 0));

		lblGenreRow5 = new JLabel("");
		lblGenreRow5.setIcon(new ImageIcon("C:\\img\\nombreCategoriasRomance.jpg"));
		lblGenreRow5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenreRow5.setVerticalAlignment(SwingConstants.BOTTOM);
		pnlRow5.add(lblGenreRow5, BorderLayout.NORTH);

		pnlGenreRow5 = new JPanel();
		pnlGenreRow5.setBackground(new Color(20, 20, 20));
		pnlRow5.add(pnlGenreRow5, BorderLayout.CENTER);
		pnlGenreRow5.setLayout(new GridLayout(0, 8, 10, 0));

		lbl1Row5Titanic = new JLabel("");
		lbl1Row5Titanic.setIcon(new ImageIcon("C:\\img\\ChTitanic.jpg"));
		pnlGenreRow5.add(lbl1Row5Titanic);

		lbl2Row5Outlander = new JLabel("");
		lbl2Row5Outlander.setIcon(new ImageIcon("C:\\img\\ChOutlander.jpg"));
		pnlGenreRow5.add(lbl2Row5Outlander);

		lbl3Row5Bridgerton = new JLabel("");
		lbl3Row5Bridgerton.setIcon(new ImageIcon("C:\\img\\ChBridgerton.jpg"));
		pnlGenreRow5.add(lbl3Row5Bridgerton);

		lbl4Row5WheHarryMetSally = new JLabel("");
		lbl4Row5WheHarryMetSally.setIcon(new ImageIcon("C:\\img\\ChHarrySally.jpg"));
		pnlGenreRow5.add(lbl4Row5WheHarryMetSally);

		lbl5Row5PrideAndPrejudice = new JLabel("");
		lbl5Row5PrideAndPrejudice.setIcon(new ImageIcon("C:\\img\\ChPrideAndPredjuice.jpg"));
		pnlGenreRow5.add(lbl5Row5PrideAndPrejudice);

		lbl6Row5TheNotebook = new JLabel("");
		lbl6Row5TheNotebook.setIcon(new ImageIcon("C:\\img\\ChTheNotebook.jpg"));
		pnlGenreRow5.add(lbl6Row5TheNotebook);

		lbl7Row5LaLaLand = new JLabel("");
		lbl7Row5LaLaLand.setIcon(new ImageIcon("C:\\img\\ChLaLaLand.jpg"));
		pnlGenreRow5.add(lbl7Row5LaLaLand);

		lbl8Row5500DaysOfSummer = new JLabel("");
		lbl8Row5500DaysOfSummer.setIcon(new ImageIcon("C:\\img\\Ch500DaysSummer.jpg"));
		pnlGenreRow5.add(lbl8Row5500DaysOfSummer);

		pnlRow6 = new JPanel();
		pnlRow6.setBackground(new Color(20, 20, 20));
		pnlCatalog.add(pnlRow6);
		pnlRow6.setLayout(new BorderLayout(0, 0));

		lblGenreRow6 = new JLabel("");
		lblGenreRow6.setIcon(new ImageIcon("C:\\img\\nombreCategoriasAccion.jpg"));
		lblGenreRow6.setVerticalAlignment(SwingConstants.BOTTOM);
		pnlRow6.add(lblGenreRow6, BorderLayout.NORTH);

		pnlGenreRow6 = new JPanel();
		pnlGenreRow6.setBackground(new Color(20, 20, 20));
		pnlRow6.add(pnlGenreRow6, BorderLayout.CENTER);
		pnlGenreRow6.setLayout(new GridLayout(0, 8, 10, 0));

		lbl1Row6TheDarkKnight = new JLabel("");
		lbl1Row6TheDarkKnight.setIcon(new ImageIcon("C:\\img\\ChBatman.jpg"));
		pnlGenreRow6.add(lbl1Row6TheDarkKnight);

		lbl2Row6Daredevil = new JLabel("");
		lbl2Row6Daredevil.setIcon(new ImageIcon("C:\\img\\ChDaredevil.jpg"));
		pnlGenreRow6.add(lbl2Row6Daredevil);

		lbl3Row6Arrow = new JLabel("");
		lbl3Row6Arrow.setIcon(new ImageIcon("C:\\img\\ChArrow.jpg"));
		pnlGenreRow6.add(lbl3Row6Arrow);

		lbl4Row6ThePunisher = new JLabel("");
		lbl4Row6ThePunisher.setIcon(new ImageIcon("C:\\img\\ChPunisher.jpg"));
		pnlGenreRow6.add(lbl4Row6ThePunisher);

		lbl5Row6TheUmbrellaAcademy = new JLabel("");
		lbl5Row6TheUmbrellaAcademy.setIcon(new ImageIcon("C:\\img\\ChUmbrella.jpg"));
		pnlGenreRow6.add(lbl5Row6TheUmbrellaAcademy);

		lbl6Row6DieHard = new JLabel("");
		lbl6Row6DieHard.setIcon(new ImageIcon("C:\\img\\ChDieHard.jpg"));
		pnlGenreRow6.add(lbl6Row6DieHard);

		lbl7Row6MadMaxFuryRoad = new JLabel("");
		lbl7Row6MadMaxFuryRoad.setIcon(new ImageIcon("C:\\img\\ChMadMax.jpg"));
		pnlGenreRow6.add(lbl7Row6MadMaxFuryRoad);

		lbl8Row6JohnWick = new JLabel("");
		lbl8Row6JohnWick.setIcon(new ImageIcon("C:\\img\\ChJhonWick.jpg"));
		pnlGenreRow6.add(lbl8Row6JohnWick);

		pnlRow7 = new JPanel();
		pnlRow7.setBackground(new Color(20, 20, 20));
		pnlCatalog.add(pnlRow7);
		pnlRow7.setLayout(new BorderLayout(0, 0));

		lblGenreRow7 = new JLabel("");
		lblGenreRow7.setIcon(new ImageIcon("C:\\img\\nombreCategoriasAventura.jpg"));
		lblGenreRow7.setVerticalAlignment(SwingConstants.BOTTOM);
		pnlRow7.add(lblGenreRow7, BorderLayout.NORTH);

		pnlGenreRow7 = new JPanel();
		pnlGenreRow7.setBackground(new Color(20, 20, 20));
		pnlRow7.add(pnlGenreRow7, BorderLayout.CENTER);
		pnlGenreRow7.setLayout(new GridLayout(0, 8, 10, 0));

		lbl1Row7TheSecretLifeOfWalterMitty = new JLabel("");
		lbl1Row7TheSecretLifeOfWalterMitty.setIcon(new ImageIcon("C:\\img\\ChWalter.jpg"));
		pnlGenreRow7.add(lbl1Row7TheSecretLifeOfWalterMitty);

		lbl2Row7TheAdventureOfTintin = new JLabel("");
		lbl2Row7TheAdventureOfTintin.setIcon(new ImageIcon("C:\\img\\ChTintin.jpg"));
		pnlGenreRow7.add(lbl2Row7TheAdventureOfTintin);

		lbl3Row7TheGoonies = new JLabel("");
		lbl3Row7TheGoonies.setIcon(new ImageIcon("C:\\img\\ChGoonies.jpg"));
		pnlGenreRow7.add(lbl3Row7TheGoonies);

		lbl4Row7Vikings = new JLabel("");
		lbl4Row7Vikings.setIcon(new ImageIcon("C:\\img\\ChVikings.jpg"));
		pnlGenreRow7.add(lbl4Row7Vikings);

		lbl5Row7Up = new JLabel("");
		lbl5Row7Up.setIcon(new ImageIcon("C:\\img\\ChUp.jpg"));
		pnlGenreRow7.add(lbl5Row7Up);

		lbl6Row7PiratesOfTheCaribbean = new JLabel("");
		lbl6Row7PiratesOfTheCaribbean.setIcon(new ImageIcon("C:\\img\\ChPiratas.jpg"));
		pnlGenreRow7.add(lbl6Row7PiratesOfTheCaribbean);

		lbl7Row7IndianaJoneRaidersOfTheLostArk = new JLabel("");
		lbl7Row7IndianaJoneRaidersOfTheLostArk.setIcon(new ImageIcon("C:\\img\\ChIndiana.jpg"));
		pnlGenreRow7.add(lbl7Row7IndianaJoneRaidersOfTheLostArk);

		lbl8Row7KingKong = new JLabel("");
		lbl8Row7KingKong.setIcon(new ImageIcon("C:\\img\\ChKingKong.jpg"));
		pnlGenreRow7.add(lbl8Row7KingKong);

		pnlImagesCarrousel = new JPanel();
		pnlImagesCarrousel.setBackground(new Color(20, 20, 20));
		pnlMainPanel.add(pnlImagesCarrousel, BorderLayout.NORTH);
		pnlImagesCarrousel.setLayout(new GridLayout(0, 3, 0, 0));

		lblImageCarrousel1 = new JLabel("");
		lblImageCarrousel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageCarrousel1.setIcon(new ImageIcon(""));
		pnlImagesCarrousel.add(lblImageCarrousel1);

		lblImageCarrousel2 = new JLabel("");
		lblImageCarrousel2.setHorizontalAlignment(SwingConstants.CENTER);
		pnlImagesCarrousel.add(lblImageCarrousel2);

		lblImageCarrousel3 = new JLabel("");
		lblImageCarrousel3.setHorizontalAlignment(SwingConstants.CENTER);
		pnlImagesCarrousel.add(lblImageCarrousel3);

		lblNETXILF = new JLabel("");
		lblNETXILF.setIcon(new ImageIcon("C:\\img\\BannerPrincipal.jpg"));
		lblNETXILF.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNETXILF, BorderLayout.NORTH);

		pnlDownPanel = new JPanel();
		pnlDownPanel.setBackground(new Color(20, 20, 20));
		contentPane.add(pnlDownPanel, BorderLayout.SOUTH);
		pnlDownPanel.setLayout(new BorderLayout(0, 0));

		lblPreferences = new JLabel("Recomendaciones +  ");
		lblPreferences.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreferences.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreferences.setForeground(Color.RED);
		pnlDownPanel.add(lblPreferences, BorderLayout.EAST);

		lblRecomendations = new JLabel("Bienvenido " + nombre);
		lblRecomendations.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRecomendations.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecomendations.setForeground(Color.RED);
		pnlDownPanel.add(lblRecomendations, BorderLayout.CENTER);

		lblProfilePic = new JLabel("(FotoPerfil)");
		lblProfilePic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProfilePic.setForeground(Color.RED);
		pnlDownPanel.add(lblProfilePic, BorderLayout.WEST);
	}
	
	/**
     * Manejador de eventos para componentes específicos.
     *
     * @param id_Profile   El identificador del perfil del usuario.
     */

	private void eventHandler(String id_Profile) {

		// Row 1
		addMouseListener(lbl1Row1BlackMirror, "serie", 22, id_Profile);
		addMouseListener(lbl2Row1StrangerThings, "serie", 1, id_Profile);
		addMouseListener(lbl3Row1Mandalorian, "serie", 19, id_Profile);
		addMouseListener(lbl4Row1Avatar, "movie", 30, id_Profile);
		addMouseListener(lbl5Row1Interestellar, "movie", 34, id_Profile);
		addMouseListener(lbl6Row1JurassicPark, "movie", 31, id_Profile);
		addMouseListener(lbl7Row1Inception, "movie", 29, id_Profile);
		addMouseListener(lbl8Row1DoctorWho, "serie", 6, id_Profile);

		// Row 2
		addMouseListener(lbl1Row2GameOfThrones, "serie", 2, id_Profile);
		addMouseListener(lbl2Row2TheWitcher, "serie", 21, id_Profile);
		addMouseListener(lbl3Row2TLOTRFellowship, "movie", 27, id_Profile);
		addMouseListener(lbl4Row2TLOTRTheTwoTowers, "movie", 47, id_Profile);
		addMouseListener(lbl5Row2ShadowAndBone, "serie", 16, id_Profile);
		addMouseListener(lbl6RowHarryPotterAndThePhilosophersStone, "movie", 35, id_Profile);
		addMouseListener(lbl7Row2TheChroniclesOfNarnia, "movie", 36, id_Profile);
		addMouseListener(lbl8Row2HisDarkMaterials, "serie", 11, id_Profile);

		// Row 3
		addMouseListener(lbl1Row3BreakingBad, "serie", 3, id_Profile);
		addMouseListener(lbl2Row3TheCrown, "serie", 17, id_Profile);
		addMouseListener(lbl3Row3PeakyBlinders, "serie", 23, id_Profile);
		addMouseListener(lbl4Row3ForestGump, "movie", 28, id_Profile);
		addMouseListener(lbl5Row3Lost, "serie", 5, id_Profile);
		addMouseListener(lbl6Row3TheShawShankRedemption, "movie", 32, id_Profile);
		addMouseListener(lbl7Row3TheGodFather, "movie", 33, id_Profile);
		addMouseListener(lbl8Row3TheRevenant, "movie", 46, id_Profile);

		// Row 4
		addMouseListener(lbl1Row4Friends, "serie", 18, id_Profile);
		addMouseListener(lbl2Row4TheOffice, "serie", 24, id_Profile);
		addMouseListener(lbl3Row4HotelBudapest, "movie", 48, id_Profile);
		addMouseListener(lbl4Row4BrooklynNineNine, "serie", 20, id_Profile);
		addMouseListener(lbl5Row4Superbad, "movie", 37, id_Profile);
		addMouseListener(lbl6Row4AnchormanTheLegendofRonBurgundy, "movie", 38, id_Profile);
		addMouseListener(lbl7Row4JaneTheVirgin, "serie", 9, id_Profile);
		addMouseListener(lbl8Row4TheDevilWearsPrada, "movie", 56, id_Profile);

		// Row 5
		addMouseListener(lbl1Row5Titanic, "movie", 25, id_Profile);
		addMouseListener(lbl2Row5Outlander, "serie", 7, id_Profile);
		addMouseListener(lbl3Row5Bridgerton, "serie", 8, id_Profile);
		addMouseListener(lbl4Row5WheHarryMetSally, "movie", 51, id_Profile);
		addMouseListener(lbl5Row5PrideAndPrejudice, "serie", 10, id_Profile);
		addMouseListener(lbl6Row5TheNotebook, "movie", 39, id_Profile);
		addMouseListener(lbl7Row5LaLaLand, "movie", 40, id_Profile);
		addMouseListener(lbl8Row5500DaysOfSummer, "movie", 41, id_Profile);

		// Row6
		addMouseListener(lbl1Row6TheDarkKnight, "movie", 26, id_Profile);
		addMouseListener(lbl2Row6Daredevil, "serie", 12, id_Profile);
		addMouseListener(lbl3Row6Arrow, "serie", 13, id_Profile);
		addMouseListener(lbl4Row6ThePunisher, "serie", 14, id_Profile);
		addMouseListener(lbl5Row6TheUmbrellaAcademy, "serie", 15, id_Profile);
		addMouseListener(lbl6Row6DieHard, "movie", 42, id_Profile);
		addMouseListener(lbl7Row6MadMaxFuryRoad, "movie", 43, id_Profile);
		addMouseListener(lbl8Row6JohnWick, "movie", 44, id_Profile);

		// Row7
		addMouseListener(lbl1Row7TheSecretLifeOfWalterMitty, "movie", 49, id_Profile);
		addMouseListener(lbl2Row7TheAdventureOfTintin, "movie", 50, id_Profile);
		addMouseListener(lbl3Row7TheGoonies, "movie", 52, id_Profile);
		addMouseListener(lbl4Row7Vikings, "serie", 4, id_Profile);
		addMouseListener(lbl5Row7Up, "movie", 53, id_Profile);
		addMouseListener(lbl6Row7PiratesOfTheCaribbean, "movie", 54, id_Profile);
		addMouseListener(lbl7Row7IndianaJoneRaidersOfTheLostArk, "movie", 45, id_Profile);
		addMouseListener(lbl8Row7KingKong, "movie", 55, id_Profile);

	}

	private void addMouseListener(JLabel label, String type, int id, String id_Profile) {
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if ("serie".equals(type)) {
					openMenuSerie(id, id_Profile);
				}

				else if ("movie".equals(type)) {
					openMenuMovie(id, id_Profile);
				}
			}

		});
	}
	
	/**
     * Maneja los datos para crear un DlgClickCover para series.
     *
     * @param id_Profile   El identificador del perfil del usuario.
     * * @param id_Programming   El identificador de la programación visualizada.
     */

	public void openMenuSerie(int id_Programming, String id_Profile) {
		SeriesVO serie = SeriesDAO.getSeries(id_Programming);

		String typeProgramming = serie.getTypeProgramming();
		String programmingName = serie.getProgrammingName();
		String description = serie.getDescription();
		String cover = serie.getCover();
		String gender = serie.getGender();
		String subGenre = serie.getSubGenre();
		Date releaseDate = serie.getReleaseDate();
		int numberSeasons = serie.getNumberSeasons();
		int numberChapter = serie.getNumberChapter();

		DlgClickCover a1 = new DlgClickCover(id_Profile, id_Programming, typeProgramming, programmingName, description, cover, gender, subGenre,
				releaseDate, numberSeasons, numberChapter);
		a1.setVisible(true);
	}

	/**
     * Maneja los datos para crear un DlgClickCover para peliculas.
     *
     * @param id_Profile   El identificador del perfil del usuario.
     * * @param id_Programming   El identificador de la programación visualizada.
     */
	public void openMenuMovie(int id_Programming, String id_Profile) {
		MoviesVO serie = MoviesDAO.getMovies(id_Programming);

		String typeProgramming = serie.getTypeProgramming();
		String programmingName = serie.getProgrammingName();
		String description = serie.getDescription();
		String cover = serie.getCover();
		String gender = serie.getGender();
		String subGenre = serie.getSubGenre();
		Date releaseDate = serie.getReleaseDate();

		DlgClickCover a1 = new DlgClickCover(id_Profile, id_Programming, typeProgramming, programmingName, description, cover, gender, subGenre,
				releaseDate);
		a1.setVisible(true);
	}
	
	/**
     * Muestra la siguiente imagen en el carrousel dentro de la pantalla principal de NETXILF.
     */

	private void showNextPicture() {
		if (currentIndex1 >= imageCarrousel1.length) {
			currentIndex1 = 0;
		}
		ImageIcon icon = new ImageIcon(imageCarrousel1[currentIndex1]);
		lblImageCarrousel1.setIcon(icon);

		currentIndex1++;
	}
	
	/**
     * Muestra la siguiente imagen en el carrousel dentro de la pantalla principal de NETXILF.
     */

	private void showNextPicture1() {
		if (currentIndex2 >= imageCarrousel2.length) {
			currentIndex2 = 0;
		}
		ImageIcon icon = new ImageIcon(imageCarrousel2[currentIndex2]);
		lblImageCarrousel2.setIcon(icon);

		currentIndex2++;
	}
	
	/**
     * Muestra la siguiente imagen en el carrousel dentro de la pantalla principal de NETXILF.
     */

	private void showNextPicture2() {
		if (currentIndex3 >= imageCarrousel3.length) {
			currentIndex3 = 0;
		}
		ImageIcon icon = new ImageIcon(imageCarrousel3[currentIndex3]);
		lblImageCarrousel3.setIcon(icon);

		currentIndex3++;

	}
}
