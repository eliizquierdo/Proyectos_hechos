package grafica;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import logica.ListaProductos;
import logica.Producto;
import logica.ProductoLimpieza;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmAgregarProducto extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textCodigo, textNombre, textPrecio, textNivel, textPromocion;
    private JCheckBox chckbxEsDeLimpieza;
    private JButton btnLimpiar, btnAgregar, btnCalcular;
    private JTextArea textAreaProductos;
    private JLabel lblAnioFab;
    private JTextField textAnioFab;
    private ListaProductos listaP;
    private JButton btnEliminar;

    public FrmAgregarProducto() {
        listaP = new ListaProductos();
        setTitle("Gestion de productos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 450);
        getContentPane().setLayout(null);
        iniciarComponentes();
        iniciarManejadoresEventos();
    }

    private void iniciarComponentes() {
        textAreaProductos = new JTextArea();
        textAreaProductos.setFont(new Font("Monospaced", Font.PLAIN, 13));
        textAreaProductos.setForeground(new Color(0, 0, 0));
        textAreaProductos.setBackground(new Color(255, 255, 255));
        textAreaProductos.setBounds(10, 177, 430, 178);
        getContentPane().add(textAreaProductos);
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos Del Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(10, 11, 220, 153);
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblCodigo = new JLabel("Codigo");
        lblCodigo.setBounds(10, 30, 46, 14);
        panel.add(lblCodigo);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(10, 55, 46, 14);
        panel.add(lblNombre);

        JLabel lblPrecio = new JLabel("Precio");
        lblPrecio.setBounds(10, 80, 46, 14);
        panel.add(lblPrecio);

        textCodigo = new JTextField();
        textCodigo.setBounds(78, 27, 86, 20);
        panel.add(textCodigo);
        textCodigo.setColumns(10);

        textNombre = new JTextField();
        textNombre.setBounds(78, 52, 86, 20);
        panel.add(textNombre);
        textNombre.setColumns(10);

        textPrecio = new JTextField();
        textPrecio.setBackground(new Color(255, 255, 255));
        textPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
        textPrecio.setForeground(new Color(0, 0, 0));
        textPrecio.setBounds(78, 77, 86, 20);
        panel.add(textPrecio);
        textPrecio.setColumns(10);

        lblAnioFab = new JLabel("AñoFabricacion");
        lblAnioFab.setBounds(10, 114, 86, 14);
        panel.add(lblAnioFab);

        textAnioFab = new JTextField();
        textAnioFab.setBounds(88, 111, 86, 20);
        panel.add(textAnioFab);
        textAnioFab.setColumns(10);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(192, 192, 192));
        panel_1.setBorder(new TitledBorder(null, "Datos del producto de Limpieza", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(236, 11, 204, 95);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);

        chckbxEsDeLimpieza = new JCheckBox("¿Es de Limpieza?");
        chckbxEsDeLimpieza.setBounds(48, 18, 105, 23);
        panel_1.add(chckbxEsDeLimpieza);

        JLabel lblNivel = new JLabel("Nivel");
        lblNivel.setBounds(20, 68, 46, 14);
        panel_1.add(lblNivel);

        textNivel = new JTextField();
        textNivel.setBounds(67, 65, 86, 20);
        panel_1.add(textNivel);
        textNivel.setColumns(10);
        textNivel.setEnabled(false);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new TitledBorder(null, "Calculo de promocion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setBackground(new Color(192, 192, 192));
        panel_2.setBounds(240, 114, 200, 50);
        getContentPane().add(panel_2);
        panel_2.setLayout(null);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(10, 16, 89, 23);
        panel_2.add(btnCalcular);

        textPromocion = new JTextField();
        textPromocion.setBounds(109, 17, 86, 20);
        panel_2.add(textPromocion);
        textPromocion.setColumns(10);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(42, 389, 89, 23);
        getContentPane().add(btnLimpiar);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(176, 389, 89, 23);
        getContentPane().add(btnAgregar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(319, 389, 89, 23);
        getContentPane().add(btnEliminar);
    }
//Eventos
    private void iniciarManejadoresEventos() {
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
        btnAgregar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			
        		int codigo=Integer.valueOf(textCodigo.getText());
        		String nombre=textNombre.getText();
        		double precio=Double.valueOf(textPrecio.getText());
        		int anioFab=Integer.valueOf(textAnioFab.getText());
        		if (chckbxEsDeLimpieza.isSelected()) {
        			int nivel=Integer.valueOf(textNivel.getText());
        			ProductoLimpieza pl=new ProductoLimpieza(codigo, nombre, precio, anioFab, nivel);
        			listaP.insertarProducto(pl);
        		}else {
        			Producto p=new Producto(codigo, nombre, precio, anioFab);
        			listaP.insertarProducto(p);
        		}
        		actualizarListaProductos();//Actualizar el JTextArea
        		limpiarCampos();
        		JOptionPane.showMessageDialog(null, "El Producto se guardo correctamente");
        	}catch(Exception ex){
        		JOptionPane.showMessageDialog(null, ex);
        	}
        }
        });
        
        
        chckbxEsDeLimpieza.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		textNivel.setEnabled(chckbxEsDeLimpieza.isSelected());
        	}
        });
        btnCalcular.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			
            		int codigo=Integer.valueOf(textCodigo.getText());
            		String nombre=textNombre.getText();
            		double precio=Double.valueOf(textPrecio.getText());
            		int anioFab=Integer.valueOf(textAnioFab.getText());
            		if (chckbxEsDeLimpieza.isSelected()) {
            			int nivel=Integer.valueOf(textNivel.getText());
            			ProductoLimpieza pl=new ProductoLimpieza(codigo, nombre, precio, anioFab, nivel);
            			textPromocion.setText(String.valueOf(pl.promocion()));
            		}else {
            			Producto p=new Producto(codigo, nombre, precio, anioFab);
            			textPromocion.setText(String.valueOf(p.promocion()));
            		}
            		
            	}catch(Exception ex){
            		JOptionPane.showMessageDialog(null, ex);
            	}
        	}
        });
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cod = JOptionPane.showInputDialog("Ingrese codigo del producto a eliminar");
                try {
                    int codigo = Integer.valueOf(cod);
                    if (listaP.estaProducto(codigo)) {
                        listaP.eliminarProducto(codigo);
                        JOptionPane.showMessageDialog(null, "El Producto fue eliminado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "El Producto no se encuentra en la lista");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocurrió un error: " + ex.getMessage());
                }
            }
        });
    }

        // Fin Manejadores Evento
        public void limpiarCampos() {
            textCodigo.setText(null);
            textNombre.setText(null);
            textPrecio.setText(null);
            textNivel.setText(null);
            textPromocion.setText(null);
            textAnioFab.setText(null);
            chckbxEsDeLimpieza.setSelected(false);
        }

        public void actualizarListaProductos() {
            textAreaProductos.setText(listaP.toString());
        }
        public static void main(String[] args) {
    		FrmAgregarProducto vent = new FrmAgregarProducto();
            vent.setVisible(true);
        }
}