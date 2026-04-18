package grafica;

import logica.*;
import static grafica.FrmPrincipal.coleccion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JDateChooser;

public class InAltaAlumno extends JInternalFrame {
	
		private JPanel contentPane;
		private JPanel panelAlumno;
		private JPanel pnlCalculo;
		private JLabel lblApellido;
		private JLabel lblGrupo;
		private JLabel lblCuotaBase;
		private JTextField txtApellido;
		private JTextField txtGrupo;
		private JTextField txtCuotaBase;
		private JButton btnCalcular;
		private JTextField txtCalcular;
		private JButton btnLimpiarTexto;
		private JPanel pnlFecha;
		private JPanel pnlBecado;
		private JCheckBox chkEsBecado;
		private JLabel lblSaldoCuota;
		private JTextField txtSaldoCuota;
		private JDateChooser dateChooser;
		private JButton btnGuardar;
		
		Alumno a;
		Becado b;

		
		public InAltaAlumno() {
			setMaximizable(true);
			setClosable(true);
			//setBounds(10, 10, 450, 300);
			setTitle("Agregar Alumnos");
			iniciarComponentes();
			iniciarManejadoresEventos();
		}
		
			private void iniciarComponentes() {
				
				setBounds(10, 10, 509, 294);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				panelAlumno = new JPanel();
				panelAlumno.setBorder(new TitledBorder(null, "Datos del alumno", 
						TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelAlumno.setBounds(10, 11, 230, 107);
				contentPane.add(panelAlumno);
				panelAlumno.setLayout(null);
				
				lblApellido = new JLabel("Apellido:");
				lblApellido.setBounds(10, 22, 93, 14);
				panelAlumno.add(lblApellido);
				
				lblGrupo = new JLabel("Grupo:");
				lblGrupo.setBounds(10, 48, 93, 14);
				panelAlumno.add(lblGrupo);
				
				lblCuotaBase = new JLabel("Cuota Base:");
				lblCuotaBase.setBounds(10, 82, 93, 14);
				panelAlumno.add(lblCuotaBase);
				
				txtApellido = new JTextField();
				txtApellido.setBounds(132, 19, 86, 20);
				panelAlumno.add(txtApellido);
				txtApellido.setColumns(10);
				
				txtGrupo = new JTextField();
				txtGrupo.setBounds(132, 45, 86, 20);
				panelAlumno.add(txtGrupo);
				txtGrupo.setColumns(10);
				
				txtCuotaBase = new JTextField();
				txtCuotaBase.setBounds(132, 79, 86, 20);
				panelAlumno.add(txtCuotaBase);
				txtCuotaBase.setColumns(10);
				
				pnlCalculo = new JPanel();
				pnlCalculo.setBorder(new TitledBorder(null, "Calculo de cuota neta", 
						TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnlCalculo.setBounds(242, 129, 241, 82);
				contentPane.add(pnlCalculo);
				pnlCalculo.setLayout(null);
				
				btnCalcular = new JButton("Calcular");
				btnCalcular.setBounds(10, 35, 89, 23);
				pnlCalculo.add(btnCalcular);
				
				txtCalcular = new JTextField();
				txtCalcular.setBounds(121, 36, 110, 20);
				pnlCalculo.add(txtCalcular);
				txtCalcular.setColumns(10);
				
				pnlFecha = new JPanel();
				pnlFecha.setBorder(new TitledBorder(null, "Fecha de nacimiento", 
						TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnlFecha.setBounds(10, 129, 230, 116);
				contentPane.add(pnlFecha);
				pnlFecha.setLayout(null);
				
				dateChooser = new JDateChooser();
				dateChooser.setBounds(29, 34, 109, 20);
				pnlFecha.add(dateChooser);
				
				pnlBecado = new JPanel();
				pnlBecado.setBorder(new TitledBorder(null, "Datos de becado", 
						TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnlBecado.setBounds(250, 11, 233, 107);
				contentPane.add(pnlBecado);
				pnlBecado.setLayout(null);
				
				chkEsBecado = new JCheckBox("\u00BFEs becado?");
				chkEsBecado.setBounds(26, 23, 140, 23);
				pnlBecado.add(chkEsBecado);
				
				lblSaldoCuota = new JLabel("Saldo Cuota:");
				lblSaldoCuota.setBounds(26, 66, 88, 14);
				pnlBecado.add(lblSaldoCuota);
				
				txtSaldoCuota = new JTextField();
				txtSaldoCuota.setBounds(126, 63, 86, 20);
				pnlBecado.add(txtSaldoCuota);
				txtSaldoCuota.setColumns(10);
				
				btnGuardar = new JButton("Guardar");
				btnGuardar.setBounds(394, 222, 89, 23);
				contentPane.add(btnGuardar);
				
				btnLimpiarTexto = new JButton("Limpiar texto");
				btnLimpiarTexto.setBounds(252, 222, 115, 23);
				contentPane.add(btnLimpiarTexto);
		}
			
			private void iniciarManejadoresEventos() {
							
				btnLimpiarTexto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtApellido.setText(null);
						txtGrupo.setText(null);
						txtCuotaBase.setText(null);
						txtCalcular.setText(null);
						dateChooser.setCalendar(null);
						chkEsBecado.setSelected(false);
						txtSaldoCuota.setText(null);
						
					}	
				});
				
				btnCalcular.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							int anio = dateChooser.getCalendar().get(Calendar.YEAR);
							int mes = dateChooser.getCalendar().get(Calendar.MONTH)+1;
							int dia = dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH);
							
							Fecha f=new Fecha(dia,mes,anio);
							String apellido=txtApellido.getText();
							int grupo=Integer.valueOf(txtGrupo.getText());
							double cuota=Double.valueOf(txtCuotaBase.getText());
							
							if (chkEsBecado.isSelected()) {
								double saldoCuota=Double.valueOf(txtSaldoCuota.getText());
								b=new Becado(saldoCuota,apellido,grupo,cuota,f);
								txtCalcular.setText(String.valueOf(b.cuotaNeta()));
								
								
							}
							else {
								a=new Alumno(apellido,grupo,cuota,f);
								txtCalcular.setText(String.valueOf(a.cuotaNeta()));
								
							}
						}catch(Exception ex) {
							txtCalcular.setText("No se pudo");
							JOptionPane.showMessageDialog(null,ex);
						}
					}
				});
				
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnCalcular.doClick();//si antes de guardar no se presiona el btnCalcular da error
						if (chkEsBecado.isSelected()) {
							coleccion.agregar(b);
							JOptionPane.showMessageDialog(null, 
						    		   "Datos guardados ok","Mensaje ",
						    		   JOptionPane.INFORMATION_MESSAGE);
							
						}
						else {
							 coleccion.agregar(a);
							 JOptionPane.showMessageDialog(null, 
						    		   "Datos guardados ok","Mensaje ",
						    		   JOptionPane.INFORMATION_MESSAGE);
						}
						
					}
				});
				
			}
}
