package Grafica;

import Logica.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.Period;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;


public class Prueba extends JFrame {

	private JPanel contentPane;
	private JPanel panelMaterialList;
	private JPanel panelLoan;
	private JPanel panelPartner;
	private JPanel panelMaterial;
	private JPanel panelPartnerList;
	private JPanel panelLoanList;
	
	private JTextField textBookName;
	private JTextField textIsbn;
	private JTextField textNumPages;
	private JTextField textEditorialName;
	private JTextField textAutorName;
	private JTextField textAutorCountry;
	private JTextField textCI;
	private JTextField textAdress;
	private JTextField textPhone;
	private JTextField textName;
	private JTextField textBookLoan;
	private JTextField textPartnerLoan;
	
	private JLabel lblNumPages;
	private JLabel lblEditorialName;
	private JLabel lblPartnerTitle;
	private JLabel lblCI;
	private JLabel lblMaterialListTitle;
	private JLabel lblBirthDate;
	private JLabel lblDateAdmission;
	private JLabel lblSubject;
	private JLabel lblPartnerListTitle;
	private JLabel lblLoanListTitle;
	
	private JButton btnConfirm;
	private JButton btnUpdateList;
	private JButton btnConfirmPartner;
	private JButton btnUpdateList_1;
	private JButton btnLoan;
	private JButton btnUpdateList_2;
	
	private JDateChooser dateEdit;
	private JDateChooser dateAdmission;
	private JDateChooser dateBirth;
	
	private JList listMaterials;
	private JList listPartners;
	private JList listBookLoan;
	private JList listPartnerLoan;
	private JList listLoanList;
	
	private JMenu mList;
	private JMenu mMaterials;
	private JMenu mPartner;
	private JMenu mLoans;
	private JMenuItem mMaterialList;
	private JMenuItem mPartnerList;
	private JMenuItem mLoanList;
	
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPanePartnerLoan;
	private JScrollPane scrollPaneBookLoan;
	private JScrollPane scrollPaneLoanList;
	
	private JComboBox comboPartner;
	private JComboBox comboGroup;
	private JComboBox comboSubject;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba frame = new Prueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	////Listado de prestamos
		
		//Creacion del panel{
		panelLoanList = new JPanel();
		panelLoanList.setBounds(10, 35, 416, 243);
		contentPane.add(panelLoanList);
		panelLoanList.setLayout(null);
		panelLoanList.setVisible(false);
		//}
		
		//Boton para actualizar la lista{
		btnUpdateList_2 = new JButton("Actualizar");
		btnUpdateList_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> listModel3 = new DefaultListModel<String>();
				for(int i=0;i<PartnerList.partnerList.size();i++) {
					
					listModel3.add(i, Loans.loans.get(i).toString());
				}
				listLoanList.setModel(listModel3);
			}
		});
		btnUpdateList_2.setBounds(310, 6, 96, 21);
		panelLoanList.add(btnUpdateList_2);
		//}
		
		//Titulo de la pagina{
		lblLoanListTitle = new JLabel("Prestamos");
		lblLoanListTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoanListTitle.setBounds(174, 10, 75, 13);
		panelLoanList.add(lblLoanListTitle);
		//}
		
		//Panel para poder scrollear{
		scrollPaneLoanList = new JScrollPane();
		scrollPaneLoanList.setBounds(10, 38, 396, 195);
		panelLoanList.add(scrollPaneLoanList);
		//}
		
		//Lista de los prestamos{
		listLoanList = new JList();
		scrollPaneLoanList.setViewportView(listLoanList);
		//}
		
	////////
		
	////Listado de Socios
		
		//Creacion del panel{
		panelPartnerList = new JPanel();
		panelPartnerList.setBounds(10, 35, 416, 243);
		contentPane.add(panelPartnerList);
		panelPartnerList.setLayout(null);
		panelPartnerList.setVisible(false);
		//}
		
		//Titulo de la pagina{
		lblPartnerListTitle = new JLabel("Lista de socios");
		lblPartnerListTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPartnerListTitle.setBounds(158, 10, 95, 13);
		panelPartnerList.add(lblPartnerListTitle);
		//}
		
		//Panel para poder scrollear{
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 36, 396, 197);
		panelPartnerList.add(scrollPane_1);
		//}
		
		//Boton para actualizar la lista{
		btnUpdateList_1 = new JButton("Actualizar");
		btnUpdateList_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> listModel2 = new DefaultListModel<String>();
				for(int i=0;i<PartnerList.partnerList.size();i++) {
					
					listModel2.add(i, PartnerList.partnerList.get(i).toString());
				}
				listPartners.setModel(listModel2);
				listPartnerLoan.setModel(listModel2);
			}
		});
		btnUpdateList_1.setBounds(310, 6, 96, 21);
		panelPartnerList.add(btnUpdateList_1);
		//}
		
		//Lista de los prestamos{
		listPartners = new JList();
		scrollPane_1.setViewportView(listPartners);
		//}
		
		//Ventana emergente para poder eliminar Socios{
		listPartners.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				 String[] options = {"Eliminar", "Cancelar"};
				
				 int selection = JOptionPane.showOptionDialog(
				            null, "Selecciona una opción:", "Cuadro de diálogo con 2 opciones",
				            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				            null, options, options[0]);
				        
				        if (selection == 0) {
				            JOptionPane.showMessageDialog(null, "Has seleccionado Opción 1");
				            PartnerList.partnerList.remove(listPartners.getSelectedIndex());
				            
				            DefaultListModel<String> listModel2 = new DefaultListModel<String>();
							for(int i=0;i<PartnerList.partnerList.size();i++) {
								
								listModel2.add(i, PartnerList.partnerList.get(i).toString());
							}
							listPartners.setModel(listModel2);
				        } else if (selection == 1) {
				            
				        }
			}
		});
		//}
		
	////////
	
	////Prestamos
		
		//Creacion del panel{
		panelLoan = new JPanel();
		panelLoan.setBounds(10, 35, 416, 243);
		contentPane.add(panelLoan);
		panelLoan.setLayout(null);
		panelLoan.setVisible(false);
		//}
		
		//Titulo de la pagina{
		JLabel lblLoan = new JLabel("Prestamos");
		lblLoan.setBounds(171, 10, 75, 13);
		lblLoan.setHorizontalAlignment(SwingConstants.CENTER);
		panelLoan.add(lblLoan);
		//}
		
		//Panel de Scroll para la lista de libros{
		scrollPaneBookLoan = new JScrollPane();
		scrollPaneBookLoan.setBounds(10, 33, 190, 172);
		panelLoan.add(scrollPaneBookLoan);
		//}
		
		//Lista de libros{
		listBookLoan = new JList();
		listBookLoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textBookLoan.setText("ISBN: " + Library.library.get(listBookLoan.getSelectedIndex()).getBook().getIsbn());
				if(!textBookLoan.getText().isEmpty() && !textBookLoan.getText().isBlank()) {
					if(!textPartnerLoan.getText().isEmpty() && !textPartnerLoan.getText().isBlank()) {
						btnLoan.setEnabled(true);
					}else{
						btnLoan.setEnabled(false);
					}
				}else {
					btnLoan.setEnabled(false);
				}
			}
		});
		scrollPaneBookLoan.setViewportView(listBookLoan);
		//}
		
		//Panel de Scroll para la lista de socios{
		scrollPanePartnerLoan = new JScrollPane();
		scrollPanePartnerLoan.setBounds(210, 33, 196, 172);
		panelLoan.add(scrollPanePartnerLoan);
		//}
		
		//Lista de socios{
		listPartnerLoan = new JList();
		listPartnerLoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				textPartnerLoan.setText("CI: " + PartnerList.partnerList.get(listPartnerLoan.getSelectedIndex()).getCi());
				if(!textBookLoan.getText().isEmpty() && !textBookLoan.getText().isBlank()) {
					if(!textPartnerLoan.getText().isEmpty() && !textPartnerLoan.getText().isBlank()) {
						btnLoan.setEnabled(true);
					}else{
						btnLoan.setEnabled(false);
					}
				}else {
					btnLoan.setEnabled(false);
				}
				
			}
		});
		scrollPanePartnerLoan.setViewportView(listPartnerLoan);
		//}
		
		//Boton para confirmar prestamo{
		btnLoan = new JButton("Prestar");
		btnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Date initialDate = new Date();
				initialDate.setDay(LocalDate.now().getDayOfMonth());
				initialDate.setMonth(LocalDate.now().getMonthValue());
				initialDate.setYear(LocalDate.now().getYear());
				
				Copy copy = new Copy(Library.library.get(listBookLoan.getSelectedIndex()).getBook());
				Library.library.get(listBookLoan.getSelectedIndex()).setState(State.PRESTADO);
				copy.setState(State.PRESTADO);
				Loan loan = new Loan(initialDate, copy, PartnerList.partnerList.get(listPartnerLoan.getSelectedIndex()));
				Loans.loans.add(loan);
			}
		});
		btnLoan.setEnabled(false);
		btnLoan.setBounds(165, 215, 85, 21);
		panelLoan.add(btnLoan);
		//}
		
		//Mostrar los datos del libro mientras es seleccionado{
		textBookLoan = new JTextField();
		textBookLoan.setHorizontalAlignment(SwingConstants.CENTER);
		textBookLoan.setEditable(false);
		textBookLoan.setBounds(10, 215, 141, 19);
		panelLoan.add(textBookLoan);
		textBookLoan.setColumns(10);
		//}
		
		//Mostrar los datos del socio mientras es seleccionado{
		textPartnerLoan = new JTextField();
		textPartnerLoan.setHorizontalAlignment(SwingConstants.CENTER);
		textPartnerLoan.setEditable(false);
		textPartnerLoan.setColumns(10);
		textPartnerLoan.setBounds(265, 216, 141, 19);
		panelLoan.add(textPartnerLoan);
		panelLoan.setVisible(false);
		//}
		
	////////
		
	////Socios
		//Creacion del panel{
		panelPartner = new JPanel();
		panelPartner.setBounds(10, 35, 416, 243);
		contentPane.add(panelPartner);
		panelPartner.setBackground(SystemColor.control);
		panelPartner.setLayout(null);
		panelPartner.setVisible(false);
		//}
		
		//Titulo de la pagina{
		lblPartnerTitle = new JLabel("Añadir socio");
		lblPartnerTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPartnerTitle.setBounds(163, 10, 82, 13);
		panelPartner.add(lblPartnerTitle);
		//}
		
		//Ingreso de datos{
		lblCI = new JLabel("CI:");
		lblCI.setBounds(10, 37, 65, 13);
		panelPartner.add(lblCI);
		
		textCI = new JTextField();
		textCI.setBounds(76, 34, 96, 19);
		panelPartner.add(textCI);
		textCI.setColumns(10);
		
		JLabel lblAdress = new JLabel("Dirección:");
		lblAdress.setBounds(10, 80, 65, 13);
		panelPartner.add(lblAdress);
		
		textAdress = new JTextField();
		textAdress.setBounds(76, 77, 96, 19);
		panelPartner.add(textAdress);
		textAdress.setColumns(10);
		
		JLabel lblPhone = new JLabel("Teléfono:");
		lblPhone.setBounds(10, 121, 65, 13);
		panelPartner.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setBounds(76, 118, 96, 19);
		panelPartner.add(textPhone);
		textPhone.setColumns(10);
		
		JLabel lblName = new JLabel("Nombre:");
		lblName.setBounds(10, 165, 65, 13);
		panelPartner.add(lblName);
		
		textName = new JTextField();
		textName.setBounds(76, 162, 96, 19);
		panelPartner.add(textName);
		textName.setColumns(10);
		
		comboPartner = new JComboBox<String>();
		comboPartner.setBounds(269, 33, 82, 21);
		panelPartner.add(comboPartner);
		panelPartner.setVisible(false);
		comboPartner.addItem("Alumno");
		comboPartner.addItem("Profesor");
		
		lblDateAdmission = new JLabel("Fecha admisión:");
		lblDateAdmission.setBounds(193, 80, 100, 13);
		panelPartner.add(lblDateAdmission);
		lblDateAdmission.setVisible(false);
		
		dateAdmission = new JDateChooser();
		dateAdmission.setBounds(292, 77, 101, 19);
		panelPartner.add(dateAdmission);
		dateAdmission.setVisible(false);
		
		lblSubject = new JLabel("Materia:");
		lblSubject.setBounds(193, 121, 82, 13);
		panelPartner.add(lblSubject);
		lblSubject.setVisible(false);
		
		comboSubject = new JComboBox();
		comboSubject.setBounds(292, 117, 101, 21);
		panelPartner.add(comboSubject);
		comboSubject.addItem("Matematicas");
		comboSubject.addItem("Ingles");
		comboSubject.addItem("Física");
		comboSubject.addItem("Química");
		comboSubject.addItem("Historia");
		comboSubject.addItem("Geografía");
		comboSubject.setVisible(false);
		
		lblBirthDate = new JLabel("Fecha Nacimiento:");
		lblBirthDate.setBounds(200, 80, 106, 13);
		panelPartner.add(lblBirthDate);
		
		dateBirth = new JDateChooser();
		dateBirth.setBounds(316, 77, 82, 19);
		panelPartner.add(dateBirth);
		
		JLabel lblGroup = new JLabel("Grupo:");
		lblGroup.setBounds(200, 121, 45, 13);
		panelPartner.add(lblGroup);
		
		comboGroup = new JComboBox();
		comboGroup.setBounds(316, 117, 82, 21);
		panelPartner.add(comboGroup);
		comboGroup.addItem("A1");
		comboGroup.addItem("A2");
		comboGroup.addItem("B1");
		comboGroup.addItem("B2");
		//}
		
		//Añadir socios
		btnConfirmPartner = new JButton("Añadir");
		
		btnConfirmPartner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partner partner = new Partner();
				partner.setCi(Integer.parseInt(textCI.getText()));
				partner.setAddress(Integer.parseInt(textAdress.getText()));
				partner.setName(textName.getText());
				partner.setPhone(Integer.parseInt(textPhone.getText()));
				if(comboPartner.getSelectedItem().toString().equals("Alumno")){
					Alumn alumn = new Alumn(partner);
					if(comboGroup.getSelectedItem().toString().equals("A1")) {
						alumn.setGroup(Group.A1);
					}
					else if(comboGroup.getSelectedItem().toString().equals("A2")) {
						alumn.setGroup(Group.A2);
					}
					else if(comboGroup.getSelectedItem().toString().equals("B1")) {
						alumn.setGroup(Group.B1);
					}
					else if(comboGroup.getSelectedItem().toString().equals("B2")) {
						alumn.setGroup(Group.B2);
					}
					Date date = new Date();
					date.setDay(dateBirth.getDate().getDay());
					date.setMonth(dateBirth.getDate().getMonth());
					date.setYear(dateBirth.getDate().getYear() + 1900);
					
					alumn.setBirthdate(date);
					alumn.setAge((LocalDate.now().getYear() - dateBirth.getDate().getYear()) - 1900);
					PartnerList.partnerList.add(alumn);
				}
				else if(comboPartner.getSelectedItem().toString().equals("Profesor")) {
					Teacher teacher = new Teacher(partner);
					Date date = new Date();
					date.setDay(dateAdmission.getDate().getDay());
					date.setMonth(dateAdmission.getDate().getMonth());
					date.setYear(dateAdmission.getDate().getYear() + 1900);
					teacher.setAdmissionDate(date);
					if(comboSubject.getSelectedItem().toString().equals("Física")) {
						teacher.setSubject(Subject.FISICA);
					}
					else if(comboSubject.getSelectedItem().toString().equals("Geografía")) {
						teacher.setSubject(Subject.GEOGRAFIA);
					}
					else if(comboSubject.getSelectedItem().toString().equals("Historia")) {
						teacher.setSubject(Subject.HISTORIA);
					}
					else if(comboSubject.getSelectedItem().toString().equals("Ingles")) {
						teacher.setSubject(Subject.INGLES);
					}
					else if(comboSubject.getSelectedItem().toString().equals("Matematicas")) {
						teacher.setSubject(Subject.MATEMATICAS);
					}
					else if(comboSubject.getSelectedItem().toString().equals("Química")) {
						teacher.setSubject(Subject.QUIMICA);
					}
					PartnerList.partnerList.add(teacher);
				}
			}
		});
		btnConfirmPartner.setBounds(308, 199, 85, 21);
		panelPartner.add(btnConfirmPartner);
		//}
		
		//Mostrar u ocultar elementos según la selección{
		 comboPartner.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	                if (e.getStateChange() == ItemEvent.SELECTED) {
	                    String selectedOption = (String) comboPartner.getSelectedItem();
	                    
	                    if ("Alumno".equals(selectedOption)) {
	                    	lblBirthDate.setVisible(true);
	                    	dateBirth.setVisible(true);
	                    	lblGroup.setVisible(true);
	                    	comboGroup.setVisible(true);
	                    	
	                    	lblDateAdmission.setVisible(false);
	                    	dateAdmission.setVisible(false);
	                    	lblSubject.setVisible(false);
	                    	comboSubject.setVisible(false);
	                    } else if ("Profesor".equals(selectedOption)) {
	                    	lblDateAdmission.setVisible(true);
	                    	dateAdmission.setVisible(true);
	                    	lblSubject.setVisible(true);
	                    	comboSubject.setVisible(true);
	                    	
	                    	lblBirthDate.setVisible(false);
	                    	dateBirth.setVisible(false);
	                    	lblGroup.setVisible(false);
	                    	comboGroup.setVisible(false);
	                    }
	                }
	            }
	        });
		//}
		 
	////Listado de materiales
		
		//Creacion del panel{
		panelMaterialList = new JPanel();
		panelMaterialList.setBounds(10, 35, 416, 243);
		contentPane.add(panelMaterialList);
		panelMaterialList.setLayout(null);
		panelMaterialList.setVisible(false);
		//}
		
		//Titulo de la pagina{
		lblMaterialListTitle = new JLabel("Lista de materiales");
		lblMaterialListTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaterialListTitle.setBounds(146, 10, 112, 13);
		panelMaterialList.add(lblMaterialListTitle);
		//}
		
		//Boton para actualizar la lista{
		btnUpdateList = new JButton("Actualizar");
		btnUpdateList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> listModel = new DefaultListModel<String>();
				for(int i=0;i<Library.library.size();i++) {
					listModel.add(i, Library.library.get(i).toString());
				}
				listMaterials.setModel(listModel);
				listBookLoan.setModel(listModel);
			}
		});
		btnUpdateList.setBounds(310, 6, 96, 21);
		panelMaterialList.add(btnUpdateList);
		//}
		
		//Panel de Scroll{
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 396, 197);
		panelMaterialList.add(scrollPane);
		//}
		
		//Listado del material{
		listMaterials = new JList();
		scrollPane.setViewportView(listMaterials);
		listMaterials.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 String[] options = {"Eliminar", "Cancelar"};
				 int selection = JOptionPane.showOptionDialog(
				            null, "Selecciona una opción:", "Cuadro de diálogo con 3 opciones",
				            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				            null, options, options[0]);
				        
				        if (selection == 0) {
				            JOptionPane.showMessageDialog(null, "Se a eliminado");
				            Library.library.remove(listMaterials.getSelectedIndex());
				            
				            DefaultListModel<String> listModel = new DefaultListModel<String>();
							for(int i=0;i<Library.library.size();i++) {
								listModel.add(i, Library.library.get(i).toString());
							}
							listMaterials.setModel(listModel);
				        } else if (selection == 1) {
				        	
				        }
			}
		});
		//}
		
	////////
		
	////Materiales
		
		//Creacion del panel{
		panelMaterial = new JPanel();
		panelMaterial.setBounds(10, 35, 416, 243);
		contentPane.add(panelMaterial);
		panelMaterial.setLayout(null);
		panelMaterial.setVisible(false);
		//}
		
		//Titulo de la pagina
		JLabel lblMaterialTitle = new JLabel("Añadir libro");
		lblMaterialTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaterialTitle.setBounds(165, 10, 74, 13);
		panelMaterial.add(lblMaterialTitle);
		//}¨
		
		//Ingreso de Datos
		JLabel lblBookName = new JLabel("Título: ");
		lblBookName.setBounds(10, 49, 45, 13);
		panelMaterial.add(lblBookName);
		
		textBookName = new JTextField();
		textBookName.setBounds(112, 46, 96, 19);
		panelMaterial.add(textBookName);
		textBookName.setColumns(10);
		
		JLabel lblisbn = new JLabel("ISBN: ");
		lblisbn.setBounds(10, 81, 45, 13);
		panelMaterial.add(lblisbn);
		
		textIsbn = new JTextField();
		textIsbn.setBounds(112, 78, 96, 19);
		panelMaterial.add(textIsbn);
		textIsbn.setColumns(10);
		
		lblNumPages = new JLabel("Núm. Páginas:");
		lblNumPages.setBounds(10, 110, 85, 13);
		panelMaterial.add(lblNumPages);
		
		textNumPages = new JTextField();
		textNumPages.setBounds(112, 107, 96, 19);
		panelMaterial.add(textNumPages);
		textNumPages.setColumns(10);
		
		lblEditorialName = new JLabel("Nombre Editorial:");
		lblEditorialName.setBounds(10, 139, 101, 13);
		panelMaterial.add(lblEditorialName);
		
		textEditorialName = new JTextField();
		textEditorialName.setBounds(112, 136, 96, 19);
		panelMaterial.add(textEditorialName);
		textEditorialName.setColumns(10);
		
		dateEdit = new JDateChooser();
		dateEdit.setBounds(112, 170, 96, 19);
		panelMaterial.add(dateEdit);
		
		JLabel lblEditDate = new JLabel("Fecha edición:");
		lblEditDate.setBounds(10, 176, 85, 13);
		panelMaterial.add(lblEditDate);
		
		JLabel lblAutorName = new JLabel("Nombre autor:");
		lblAutorName.setBounds(218, 49, 82, 13);
		panelMaterial.add(lblAutorName);
		
		textAutorName = new JTextField();
		textAutorName.setBounds(310, 46, 96, 19);
		panelMaterial.add(textAutorName);
		textAutorName.setColumns(10);
		
		JLabel lblAutorCountry = new JLabel("País autor:");
		lblAutorCountry.setBounds(218, 81, 82, 13);
		panelMaterial.add(lblAutorCountry);
		
		textAutorCountry = new JTextField();
		textAutorCountry.setBounds(310, 78, 96, 19);
		panelMaterial.add(textAutorCountry);
		textAutorCountry.setColumns(10);
		//}
		
		//Boton para añadir libro{
		btnConfirm = new JButton("Añadir");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				date.setDay(dateEdit.getDate().getDay());
				date.setMonth(dateEdit.getDate().getMonth());
				date.setYear(dateEdit.getDate().getYear()+ 1900);
				
				Book book = new Book();
				book.setIsbn(Integer.parseInt(textIsbn.getText()));
				book.setName(textBookName.getText());
				book.setAutorCountry(textAutorCountry.getText());
				book.setEditorialName(textEditorialName.getText());
				book.setEditDate(date);
				book.setAutorName(textAutorName.getText());
				book.setNumPag(Integer.parseInt(textNumPages.getText()));
				Copy copy = new Copy(book);
				copy.setState(State.GUARDADO);
				Library.library.add(copy);
			}
		});
		btnConfirm.setForeground(new Color(255, 255, 255));
		btnConfirm.setBounds(304, 212, 85, 21);
		panelMaterial.add(btnConfirm);
		btnConfirm.setBackground(Color.darkGray);
		//}
		
	////////
		
		//Menu
		
		//Creacion de la barra de menu{
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 436, 22);
		contentPane.add(menuBar);
		//}
		
		//Creacion de las secciones del menu{
		mLoans = new JMenu("Prestamos");
		mList = new JMenu("Listas");
		mPartner = new JMenu("Socios");
		mMaterials = new JMenu("Materiales");
		mMaterialList = new JMenuItem("Materiales");
		mPartnerList = new JMenuItem("Socios");
		mLoanList = new JMenuItem("Prestamos");
		//}
		
		//Añadir esas secciones al menu{
		mList.add(mMaterialList);
		mList.add(mPartnerList);
		mList.add(mLoanList);
		menuBar.add(mMaterials);
		menuBar.add(mPartner);
		menuBar.add(mLoans);
		menuBar.add(mList);
		//}
		
		//Cambio de pantalla
		mLoanList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allInvisible();
				panelLoanList.setVisible(true);
			}
		});		
			
		mPartnerList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					allInvisible();
					panelPartnerList.setVisible(true);
			}
		});
				
		mMaterials.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				allInvisible();
				panelMaterial.setVisible(true);
			}
		});
		
		mPartner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				allInvisible();
				panelPartner.setVisible(true);
			}
		});
		
		mMaterialList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allInvisible();
				panelMaterialList.setVisible(true);
			}
		});
		
		mLoans.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				allInvisible();
				panelLoan.setVisible(true);
		
			}
		});
		//}
	}
	public void allInvisible() {
		panelMaterial.setVisible(false);
		panelMaterialList.setVisible(false);
		panelPartner.setVisible(false);
		panelPartnerList.setVisible(false);
		panelLoan.setVisible(false);
		panelLoanList.setVisible(false);
	}
}


