package graphic;

import logic.*;
import persistence.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;

	private JFrame frmMain = new JFrame("Programa");

	private JTabbedPane tabbedPane;

	// Variables para el entorno de Inicio
	private JPanel pnlHome;
	private JLabel lblHome;
	private JTextArea txtHomeDescription;
	private JPanel pnlHomeDescriptionBackground;
	private JPanel pnHomeDesign;
	private JPanel pnHomeDesignBackground;

	// Variables para el entorno de Información
	private JPanel pnlInfo;
	private JComboBox cmbOptions;
	private JTextField txtName;
	private JTextField txtDate_b;
	private JTextField txtDate_d;
	private JTextField txtNationality;
	private JTextField txtOccupation;
	private JTextArea txtAchievement;
	private JTextArea txtDescription;
	JPanel pnlImg = new JPanel();
	private JPanel pnlInfoDesignBackground;
	private JLabel lblInfo;
	private JLabel lblCalc;
	private JLabel lblName;
	private JLabel lblOptions;
	private JLabel lblOccupation;
	private JLabel lblAchievement;
	private JLabel lblDescription;
	private JPanel pnlNameBackground;
	private JPanel pnlCmbBackground;
	private JPanel pnlDateDBackground;
	private JPanel pnlDateBBackground;
	private JPanel pnlNationalityBackground;
	private JPanel pnlOccupationBackground;
	private JPanel pnlAchievementBackground;
	private JPanel pnlDescriptionBackground;
	private JPanel pnlImgBackroundVertical;
	private JPanel pnlImgBackroundHorizontal;

	// Variables para el entorno de Calculadora
	private JPanel pnlCalc;
	private AgePercentageCalculator ageCalculator;
	private JLabel lblAveragePercentage;
	private JPanel pnlPercentage;
	private JPanel pnlPercentageBackground;
	private JTextField txtAveragePercentage;
	private JTextField txtGetResult;
	private JButton btnClear;
	private JLabel lblResult;
	private JButton btnCalc;
	private JComboBox cmbNationalityOption;
	private JPanel pnlCalcDesign;
	private JPanel pnlCalcDesignBackground;
	private JPanel pnlCalculator;
	private JPanel pnlCalculatorBackground;

	private InfoDataAccessObject infoDAO;

	private Connect conn;

	private boolean isExiting = false;

	public Main() {
		startComponents();
		startEvents();
		conn = new Connect(); // Inicializar la conexión
		infoDAO = new InfoDataAccessObject(conn); // Pasar la conexión al DAO
		loadDataIntoComboBoxForInfo(); // Cargar los datos en el JComboBox del pnlInfo
		loadDataIntoComboBoxForCalc(); // Cargar los datos en el JComboBox del pnlCalc
		ageCalculator = new AgePercentageCalculator(conn);
	}

	// Método para la inicialización de componentes
	private void startComponents() {
		frmMain.setTitle("PMI");
		frmMain.setResizable(false);
		frmMain.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmMain.setSize(760, 605);
		frmMain.setMaximumSize(new Dimension(1200, 800));
		frmMain.getContentPane().setLayout(new BorderLayout());

		// Sirve para controlar el cierre de la ventana
		frmMain.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				closeApplication();
			}
		});

		tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(0, 0, 886, 593);

		// LLamada a los métodos para sus respectivos paneles
		loadHome();
		loadInfo();
		loadCalc();

		frmMain.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		frmMain.setVisible(true);
	}

	// Método para la carga de los elementos en el pnlHome
	private void loadHome() {
		pnlHome = new JPanel();
		pnlHome.setBackground(new Color(221, 242, 255));
		pnlHome.setLayout(null);
		lblHome = new JLabel("INICIO");
		lblHome.setForeground(new Color(0, 46, 79));
		lblHome.setBackground(new Color(0, 46, 79));
		lblHome.setToolTipText("");
		lblHome.setBounds(70, 27, 107, 41);
		lblHome.setFont(new Font("Miriam Libre", Font.BOLD, 30));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		pnlHome.add(lblHome);
		tabbedPane.addTab("INICIO", pnlHome);

		pnHomeDesign = new JPanel();
		pnHomeDesign.setBackground(new Color(183, 228, 255));
		pnHomeDesign.setBounds(70, 27, 107, 41);
		pnlHome.add(pnHomeDesign);

		pnHomeDesignBackground = new JPanel();
		pnHomeDesignBackground.setBackground(new Color(0, 46, 76));
		pnHomeDesignBackground.setBounds(59, 36, 107, 41);
		pnlHome.add(pnHomeDesignBackground);

		txtHomeDescription = new JTextArea();
		txtHomeDescription.setWrapStyleWord(true);
		txtHomeDescription.setEditable(false);
		txtHomeDescription.setForeground(new Color(0, 46, 79));
		txtHomeDescription.setBackground(new Color(183, 228, 255));
		txtHomeDescription.setFont(new Font("Miriam Libre", Font.PLAIN, 15));
		txtHomeDescription.setLineWrap(true);
		txtHomeDescription.setText(
				"Bienvenid@ a este programa parte del módulo introductorio sobre la importancia de las mujeres en el campo de la informática. En un mundo cada vez más impulsado por la tecnología, es esencial reconocer y celebrar las contribuciones excepcionales de las mujeres en el desarrollo y avance de la informática. \r\n\r\nEste programa destaca el legado de 23 mujeres visionarias que, entre una multitud de contribuyentes, han dejado una huella imborrable en la historia de la informática. Este programa es una ventana al fascinante mundo de las mujeres en la informática, destacando sus logros extraordinarios, sus nnovaciones revolucionarias y su impacto duradero en la sociedad. \r\n\r\nExploraremos sus contribuciones innovadoras que han dado forma al panorama tecnológico que conocemos hoy en día. Desde pioneras como Ada Lovelace hasta figuras contemporáneas como Carol Shaw y Joanna Rutkowska, cada una de ellas, \r\ncon su ingenio, determinación y visión, ha dejado una marca indeleble en el mundo de la informática.");
		txtHomeDescription.setBounds(70, 121, 614, 365);
		pnlHome.add(txtHomeDescription);

		pnlHomeDescriptionBackground = new JPanel();
		pnlHomeDescriptionBackground.setBackground(new Color(0, 46, 76));
		pnlHomeDescriptionBackground.setBounds(59, 132, 614, 365);
		pnlHome.add(pnlHomeDescriptionBackground);
	}

	// Método para la carga de los elementos en el pnlInfo
	private void loadInfo() {
		pnlInfo = new JPanel();
		pnlInfo.setBackground(new Color(221, 242, 255));
		pnlInfo.setLayout(null);
		lblInfo = new JLabel("INFORMACIÓN");
		lblInfo.setBackground(new Color(255, 255, 255));
		lblInfo.setForeground(new Color(0, 46, 79));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setFont(new Font("Miriam Libre", Font.BOLD, 30));
		lblInfo.setBounds(70, 27, 212, 35);
		pnlInfo.add(lblInfo);
		tabbedPane.addTab("INFORMACIÓN", pnlInfo);

		JPanel pnlInfoDesign = new JPanel();
		pnlInfoDesign.setBackground(new Color(183, 228, 255));
		pnlInfoDesign.setBounds(70, 27, 212, 35);
		pnlInfo.add(pnlInfoDesign);

		pnlInfoDesignBackground = new JPanel();
		pnlInfoDesignBackground.setBackground(new Color(0, 46, 76));
		pnlInfoDesignBackground.setBounds(59, 36, 212, 35);
		pnlInfo.add(pnlInfoDesignBackground);

		lblOptions = new JLabel("OP");
		lblOptions.setBackground(new Color(0, 46, 79));
		lblOptions.setForeground(new Color(0, 46, 79));
		lblOptions.setFont(new Font("Miriam Libre", Font.PLAIN, 15));
		lblOptions.setHorizontalAlignment(SwingConstants.CENTER);
		lblOptions.setBounds(321, 0, 47, 30);
		pnlInfo.add(lblOptions);

		cmbOptions = new JComboBox<>();
		cmbOptions.setBackground(new Color(183, 228, 255));
		cmbOptions.setForeground(new Color(0, 46, 79));
		cmbOptions.setBounds(321, 29, 47, 30);
		pnlInfo.add(cmbOptions);

		pnlCmbBackground = new JPanel();
		pnlCmbBackground.setBackground(new Color(0, 46, 76));
		pnlCmbBackground.setBounds(310, 41, 47, 30);
		pnlInfo.add(pnlCmbBackground);

		lblName = new JLabel("NOMBRE");
		lblName.setBackground(new Color(255, 255, 255));
		lblName.setForeground(new Color(0, 46, 79));
		lblName.setFont(new Font("Miriam Libre", Font.PLAIN, 15));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(391, 0, 286, 30);
		pnlInfo.add(lblName);

		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setForeground(new Color(0, 46, 79));
		txtName.setBackground(new Color(183, 228, 255));
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setBounds(391, 28, 289, 30);
		pnlInfo.add(txtName);

		pnlNameBackground = new JPanel();
		pnlNameBackground.setBackground(new Color(0, 46, 76));
		pnlNameBackground.setBounds(381, 41, 289, 30);
		pnlInfo.add(pnlNameBackground);

		JLabel lblDate_b = new JLabel("FECHA NAC.");
		lblDate_b.setBackground(new Color(255, 255, 255));
		lblDate_b.setForeground(new Color(0, 46, 79));
		lblDate_b.setFont(new Font("Miriam Libre", Font.PLAIN, 15));
		lblDate_b.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_b.setBounds(391, 69, 135, 30);
		pnlInfo.add(lblDate_b);

		txtDate_b = new JTextField();
		txtDate_b.setEditable(false);
		txtDate_b.setForeground(new Color(0, 46, 79));
		txtDate_b.setBackground(new Color(183, 228, 255));
		txtDate_b.setHorizontalAlignment(SwingConstants.CENTER);
		txtDate_b.setBounds(391, 99, 135, 30);
		pnlInfo.add(txtDate_b);

		pnlDateBBackground = new JPanel();
		pnlDateBBackground.setBackground(new Color(0, 46, 76));
		pnlDateBBackground.setBounds(381, 110, 135, 30);
		pnlInfo.add(pnlDateBBackground);

		JLabel lblDate_d = new JLabel("FECHA DEF.");
		lblDate_d.setBackground(new Color(255, 255, 255));
		lblDate_d.setForeground(new Color(0, 46, 79));
		lblDate_d.setFont(new Font("Miriam Libre", Font.PLAIN, 15));
		lblDate_d.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_d.setBounds(542, 71, 135, 30);
		pnlInfo.add(lblDate_d);

		txtDate_d = new JTextField();
		txtDate_d.setEditable(false);
		txtDate_d.setForeground(new Color(0, 46, 79));
		txtDate_d.setBackground(new Color(183, 228, 255));
		txtDate_d.setHorizontalAlignment(SwingConstants.CENTER);
		txtDate_d.setBounds(542, 99, 135, 30);
		pnlInfo.add(txtDate_d);

		pnlDateDBackground = new JPanel();
		pnlDateDBackground.setBackground(new Color(0, 46, 76));
		pnlDateDBackground.setBounds(532, 110, 138, 30);
		pnlInfo.add(pnlDateDBackground);

		JLabel lblNationality = new JLabel("NACIONALIDAD");
		lblNationality.setBackground(new Color(255, 255, 255));
		lblNationality.setForeground(new Color(0, 46, 79));
		lblNationality.setHorizontalAlignment(SwingConstants.CENTER);
		lblNationality.setFont(new Font("Miriam Libre", Font.PLAIN, 15));
		lblNationality.setBounds(321, 140, 356, 30);
		pnlInfo.add(lblNationality);

		txtNationality = new JTextField();
		txtNationality.setEditable(false);
		txtNationality.setForeground(new Color(0, 46, 79));
		txtNationality.setBackground(new Color(183, 228, 255));
		txtNationality.setHorizontalAlignment(SwingConstants.CENTER);
		txtNationality.setBounds(321, 170, 356, 30);
		pnlInfo.add(txtNationality);

		pnlNationalityBackground = new JPanel();
		pnlNationalityBackground.setBackground(new Color(0, 46, 76));
		pnlNationalityBackground.setBounds(310, 181, 360, 30);
		pnlInfo.add(pnlNationalityBackground);

		lblOccupation = new JLabel("OCUPACIÓN");
		lblOccupation.setBackground(new Color(255, 255, 255));
		lblOccupation.setForeground(new Color(0, 46, 79));
		lblOccupation.setHorizontalAlignment(SwingConstants.CENTER);
		lblOccupation.setFont(new Font("Miriam Libre", Font.PLAIN, 15));
		lblOccupation.setBounds(321, 211, 356, 30);
		pnlInfo.add(lblOccupation);

		txtOccupation = new JTextField();
		txtOccupation.setEditable(false);
		txtOccupation.setForeground(new Color(0, 46, 79));
		txtOccupation.setBackground(new Color(183, 228, 255));
		txtOccupation.setHorizontalAlignment(SwingConstants.CENTER);
		txtOccupation.setBounds(321, 240, 356, 30);
		pnlInfo.add(txtOccupation);

		pnlOccupationBackground = new JPanel();
		pnlOccupationBackground.setBackground(new Color(0, 46, 76));
		pnlOccupationBackground.setBounds(310, 252, 360, 30);
		pnlInfo.add(pnlOccupationBackground);

		lblAchievement = new JLabel("LOGRO/S");
		lblAchievement.setBackground(new Color(255, 255, 255));
		lblAchievement.setForeground(new Color(0, 46, 79));
		lblAchievement.setHorizontalAlignment(SwingConstants.CENTER);
		lblAchievement.setFont(new Font("Miriam Libre", Font.PLAIN, 15));
		lblAchievement.setBounds(321, 281, 356, 35);
		pnlInfo.add(lblAchievement);

		txtAchievement = new JTextArea();
		txtAchievement.setForeground(new Color(0, 46, 79));
		txtAchievement.setBackground(new Color(183, 228, 255));
		txtAchievement.setBounds(321, 315, 356, 43);
		pnlInfo.add(txtAchievement);

		pnlAchievementBackground = new JPanel();
		pnlAchievementBackground.setBackground(new Color(0, 46, 76));
		pnlAchievementBackground.setBounds(310, 327, 360, 43);
		pnlInfo.add(pnlAchievementBackground);

		lblDescription = new JLabel("DESCRIPCIÓN");
		lblDescription.setBackground(new Color(255, 255, 255));
		lblDescription.setForeground(new Color(0, 46, 79));
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setFont(new Font("Miriam Libre", Font.PLAIN, 15));
		lblDescription.setBounds(72, 369, 605, 35);
		pnlInfo.add(lblDescription);

		txtDescription = new JTextArea();
		txtDescription.setForeground(new Color(0, 46, 79));
		txtDescription.setBackground(new Color(183, 228, 255));
		txtDescription.setBounds(73, 404, 604, 83);
		pnlInfo.add(txtDescription);

		pnlDescriptionBackground = new JPanel();
		pnlDescriptionBackground.setBackground(new Color(0, 46, 76));
		pnlDescriptionBackground.setBounds(59, 415, 611, 83);
		pnlInfo.add(pnlDescriptionBackground);

		pnlImgBackroundVertical = new JPanel();
		pnlImgBackroundVertical.setBackground(new Color(0, 46, 76));
		pnlImgBackroundVertical.setBounds(59, 110, 11, 260);
		pnlInfo.add(pnlImgBackroundVertical);

		pnlImgBackroundHorizontal = new JPanel();
		pnlImgBackroundHorizontal.setBackground(new Color(0, 46, 76));
		pnlImgBackroundHorizontal.setBounds(59, 358, 212, 12);
		pnlInfo.add(pnlImgBackroundHorizontal);
	}

	// Método para la carga de los elementos en el pnlCalc
	private void loadCalc() {
		pnlCalc = new JPanel();
		pnlCalc.setBackground(new Color(221, 242, 255));
		pnlCalc.setForeground(new Color(221, 242, 255));
		pnlCalc.setLayout(null);
		lblCalc = new JLabel("CALCULADORA");
		lblCalc.setForeground(new Color(0, 46, 79));
		lblCalc.setBounds(70, 27, 212, 35);
		lblCalc.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalc.setFont(new Font("Miriam Libre", Font.BOLD, 30));
		pnlCalc.add(lblCalc);
		tabbedPane.addTab("CALCULADORA", pnlCalc);

		pnlCalcDesign = new JPanel();
		pnlCalcDesign.setBackground(new Color(183, 228, 255));
		pnlCalcDesign.setBounds(70, 27, 212, 35);
		pnlCalc.add(pnlCalcDesign);

		pnlCalcDesignBackground = new JPanel();
		pnlCalcDesignBackground.setBackground(new Color(0, 46, 76));
		pnlCalcDesignBackground.setBounds(59, 36, 212, 35);
		pnlCalc.add(pnlCalcDesignBackground);

		pnlPercentage = new JPanel();
		pnlPercentage.setBackground(new Color(183, 228, 255));
		pnlPercentage.setBounds(198, 145, 342, 43);
		pnlCalc.add(pnlPercentage);
		pnlPercentage.setLayout(null);

		lblAveragePercentage = new JLabel("PROMEDIO DE EDAD GENERAL");
		lblAveragePercentage.setFont(new Font("Miriam Libre", Font.PLAIN, 15));
		lblAveragePercentage.setBackground(new Color(0, 46, 76));
		lblAveragePercentage.setBounds(10, 0, 269, 43);
		pnlPercentage.add(lblAveragePercentage);

		txtAveragePercentage = new JTextField();
		txtAveragePercentage.setText("77.60");
		txtAveragePercentage.setHorizontalAlignment(SwingConstants.CENTER);
		txtAveragePercentage.setFont(new Font("Miriam Libre", Font.PLAIN, 11));
		txtAveragePercentage.setBounds(274, 9, 58, 27);
		pnlPercentage.add(txtAveragePercentage);
		txtAveragePercentage.setForeground(Color.WHITE);
		txtAveragePercentage.setEditable(false);
		txtAveragePercentage.setColumns(10);
		txtAveragePercentage.setBackground(new Color(0, 46, 76));

		pnlPercentageBackground = new JPanel();
		pnlPercentageBackground.setBackground(new Color(0, 46, 76));
		pnlPercentageBackground.setBounds(187, 155, 342, 43);
		pnlCalc.add(pnlPercentageBackground);

		pnlCalculator = new JPanel();
		pnlCalculator.setBackground(new Color(183, 228, 255));
		pnlCalculator.setBounds(198, 209, 342, 181);
		pnlCalc.add(pnlCalculator);
		pnlCalculator.setLayout(null);

		cmbNationalityOption = new JComboBox();
		cmbNationalityOption.setBounds(10, 11, 323, 37);
		pnlCalculator.add(cmbNationalityOption);
		cmbNationalityOption.setBackground(new Color(0, 46, 76));
		cmbNationalityOption.setForeground(new Color(255, 255, 255));

		txtGetResult = new JTextField();
		txtGetResult.setHorizontalAlignment(SwingConstants.CENTER);
		txtGetResult.setFont(new Font("Miriam Libre", Font.PLAIN, 11));
		txtGetResult.setBounds(10, 76, 58, 37);
		pnlCalculator.add(txtGetResult);
		txtGetResult.setEditable(false);
		txtGetResult.setBackground(new Color(0, 46, 76));
		txtGetResult.setForeground(new Color(255, 255, 255));
		txtGetResult.setColumns(10);

		lblResult = new JLabel("PROMEDIO PARA ESTA NACIONALIDAD");
		lblResult.setBounds(74, 76, 259, 35);
		pnlCalculator.add(lblResult);
		lblResult.setForeground(new Color(0, 46, 79));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Miriam Libre", Font.PLAIN, 15));

		btnCalc = new JButton("Calcular");
		btnCalc.setBounds(10, 136, 130, 33);
		pnlCalculator.add(btnCalc);
		btnCalc.setBackground(new Color(0, 46, 76));
		btnCalc.setForeground(new Color(255, 255, 255));
		btnCalc.setFont(new Font("Tahoma", Font.PLAIN, 15));

		btnClear = new JButton("Limpiar");
		btnClear.setBounds(205, 136, 128, 33);
		pnlCalculator.add(btnClear);
		btnClear.setBackground(new Color(0, 46, 76));
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));

		pnlCalculatorBackground = new JPanel();
		pnlCalculatorBackground.setBackground(new Color(0, 46, 76));
		pnlCalculatorBackground.setBounds(187, 223, 342, 181);
		pnlCalc.add(pnlCalculatorBackground);
		pnlCalculatorBackground.setLayout(null);
	}

	// Método específico para la carga de imagenes en el pnlInfo
	public void loadImage(int selectedID) {
		pnlImg.removeAll();
		pnlImg.setBounds(70, 99, 212, 259);
		pnlInfo.add(pnlImg);

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PROJECT", "root", "1234");
			String sql = "SELECT img FROM PERSON WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, selectedID);
			rs = stmt.executeQuery();

			if (rs.next()) {
				String imgName = rs.getString("img");
				String imgPath = "D:\\Proyecto_Modulo_Introductorio\\Intro_Module_Project\\media\\" + imgName;
				File file = new File(imgPath); // Se crea un objeto File que representa el archivo de imagen

				// Verificar si el archivo de imagen existe
				if (file.exists()) {
					BufferedImage image = ImageIO.read(file); // Lee la imagen desde el archivo
					JLabel lblImage = new JLabel(new ImageIcon(image));
					pnlImg.add(lblImage); // Agrega el JLabel al JPanel
					pnlInfo.revalidate(); // Actualiza el panel principal
				}
			}
		} catch (SQLException | IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	// Método para cargar datos en el JComboBox para información
	private void loadDataIntoComboBoxForInfo() {
		Connect conn = null;
		try {
			conn = new Connect();
			InfoDataAccessObject infoDAO = new InfoDataAccessObject(conn);
			List<Integer> ids = infoDAO.getAllIDs(); // Obtener todas las IDs de la base de datos
			DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>(ids.toArray(new Integer[0])); // Crear un modelo de ComboBox predeterminado con el contenido de la lista "ids"
			cmbOptions.setModel(model);
			cmbOptions.setSelectedIndex(0);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.closeConnection(); // Cerrar la conexión en cualquier caso
			}
		}
	}
	
	// Método para cargar datos en el JComboBox para la calculadora
	private void loadDataIntoComboBoxForCalc() {
		Connect conn = null;
		try {
			conn = new Connect();
			InfoDataAccessObject infoDAO = new InfoDataAccessObject(conn);
			List<String> nationalities = infoDAO.getAllNationalities(); // Obtener todas las nacionalidades de la base de datos
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(nationalities.toArray(new String[0])); // Crear un modelo de ComboBox predeterminado con el contenido de la lista "nationalities"
			cmbNationalityOption.setModel(model);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.closeConnection();
			}
		}
	}

	// Método para asignar los datos a los JTextField.
	private void fillFieldsWithData(InfoValueObject infoVO) {
		txtName.setText(infoVO.getName());
		txtDate_b.setText(infoVO.getDate_b());
		txtDate_d.setText(infoVO.getDate_d());
		txtNationality.setText(infoVO.getNationality());
		txtOccupation.setText(infoVO.getOccupation());
		txtAchievement.setText(infoVO.getAchievement());
		txtDescription.setText(infoVO.getDescription());
	}

	// Método manejador de eventos.
	private void startEvents() {
		cmbOptions.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedID = (int) cmbOptions.getSelectedItem();
				Connect conn = null;

				try {
					conn = new Connect();
					InfoDataAccessObject infoDAO = new InfoDataAccessObject(conn);
					InfoValueObject infoVO = infoDAO.getInfoByID(selectedID);
					fillFieldsWithData(infoVO); // Llenar los campos con la información recuperada
					loadImage(selectedID); // Cargar la imagen correspondiente al ID seleccionado
				} catch (SQLException ex) {
					System.out.println("Error al obtener la información desde la base de datos: " + ex.getMessage());
					ex.printStackTrace();
				} finally {
					if (conn != null) {
						conn.closeConnection();
					}
				}
			}
		});

		cmbNationalityOption.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedNationality = (String) cmbNationalityOption.getSelectedItem();
				Connect conn = null;
				try {
					conn = new Connect();
					InfoDataAccessObject infoDAO = new InfoDataAccessObject(conn);
				} finally {
					if (conn != null) {
						conn.closeConnection(); // Cerrar la conexión en cualquier caso
					}
				}
			}
		});

		btnCalc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedNationality = (String) cmbNationalityOption.getSelectedItem();
				Connect conn = null;
				try {
					conn = new Connect();
					if (txtGetResult.getText().isEmpty()) {
						AgePercentageCalculator ageCalculator = new AgePercentageCalculator(conn);
						double averageAge = ageCalculator.calcAgePercentByNationality(selectedNationality);
						txtGetResult.setText(String.format("%.2f", averageAge));
					} else {
						JOptionPane.showMessageDialog(frmMain, "Limpie el campo antes de continuar.", "Campo no vacío",
								JOptionPane.WARNING_MESSAGE);
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				} finally {
					if (conn != null) {
						conn.closeConnection(); // Cerrar la conexión en cualquier caso
					}
				}
			}
		});

		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtGetResult.setText("");
			}
		});
	}
	
	// Método para cerrar la conexión
	private void closeConnection() {
		if (conn != null) {
			conn.closeConnection();
		}
	}

	// Método para manejar el cierre de la aplicación
	private void closeApplication() {
		isExiting = true; // Indicar que la aplicación está cerrándose
		closeConnection(); // Cerrar la conexión solo si la aplicación se está cerrando completamente
		frmMain.dispose(); // Cerrar la ventana solo si la aplicación se está cerrando completamente
	}

	// Método principal para iniciar la aplicación
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
