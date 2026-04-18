package grafica;
/* El formulario debe incluir:

Campos para id, nombre, fabricante, año, y
 atributos específicos según el tipo de robot.
Combobox para seleccionar el tipo de robot (Industrial o Competencia).
Botones para "Agregar", "Mostrar", "Buscar", y "Eliminar".
Área de texto para mostrar los robots.*/


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logica.*;

public class FrmCompetenciaRobots extends JFrame {
    private JTextField txtId, txtNombre, txtFabricante, txtAnio, txtAtributo1, txtAtributo2;
    private JComboBox<String> cbTipoRobot;
    private JTextArea areaTexto;
    private ListaRobots listaRobots;
    private JButton btnAgregar, btnMostrar, btnBuscar, btnEliminar; // Declarar botones como variables de instancia

    public FrmCompetenciaRobots() {
        listaRobots = new ListaRobots();
        setTitle("Gestión de Competencia de Robots");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 500);
        getContentPane().setLayout(null);

        iniciarComponentes();
        iniciarManejadoresEventos();
    }

    private void iniciarComponentes() {
        // Etiquetas y campos de texto
        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(20, 20, 100, 20);
        getContentPane().add(lblId);

        txtId = new JTextField();
        txtId.setBounds(120, 20, 200, 20);
        getContentPane().add(txtId);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 60, 100, 20);
        getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 60, 200, 20);
        getContentPane().add(txtNombre);

        JLabel lblFabricante = new JLabel("Fabricante:");
        lblFabricante.setBounds(20, 100, 100, 20);
        getContentPane().add(lblFabricante);

        txtFabricante = new JTextField();
        txtFabricante.setBounds(120, 100, 200, 20);
        getContentPane().add(txtFabricante);

        JLabel lblAnio = new JLabel("Año:");
        lblAnio.setBounds(20, 140, 100, 20);
        getContentPane().add(lblAnio);

        txtAnio = new JTextField();
        txtAnio.setBounds(120, 140, 200, 20);
        getContentPane().add(txtAnio);

        // Selección de tipo de robot
        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(20, 180, 100, 20);
        getContentPane().add(lblTipo);

        cbTipoRobot = new JComboBox<>(new String[]{"Industrial", "Competencia"});
        cbTipoRobot.setBounds(120, 180, 200, 20);
        getContentPane().add(cbTipoRobot);

        // Campos adicionales para atributos específicos
        JLabel lblAtributo1 = new JLabel("Atributo 1:");
        lblAtributo1.setBounds(20, 220, 100, 20);
        getContentPane().add(lblAtributo1);

        txtAtributo1 = new JTextField();
        txtAtributo1.setBounds(120, 220, 200, 20);
        getContentPane().add(txtAtributo1);

        JLabel lblAtributo2 = new JLabel("Atributo 2:");
        lblAtributo2.setBounds(20, 260, 100, 20);
        getContentPane().add(lblAtributo2);

        txtAtributo2 = new JTextField();
        txtAtributo2.setBounds(120, 260, 200, 20);
        getContentPane().add(txtAtributo2);

        // Botones
        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(20, 300, 100, 30);
        getContentPane().add(btnAgregar);

        btnMostrar = new JButton("Mostrar");
        btnMostrar.setBounds(130, 300, 100, 30);
        getContentPane().add(btnMostrar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(240, 300, 100, 30);
        getContentPane().add(btnBuscar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(350, 300, 100, 30);
        getContentPane().add(btnEliminar);

        // Área de texto para resultados
        areaTexto = new JTextArea();
        areaTexto.setBounds(350, 20, 320, 260);
        areaTexto.setEditable(false);
        getContentPane().add(areaTexto);

        JScrollPane scrollPane = new JScrollPane(areaTexto);
        scrollPane.setBounds(350, 20, 320, 260);
        getContentPane().add(scrollPane);
    }

    private void iniciarManejadoresEventos() {
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarRobot();
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarRobots();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarRobot();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarRobot();
            }
        });
    }

    private void agregarRobot() {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String fabricante = txtFabricante.getText();
        int anio = Integer.parseInt(txtAnio.getText());
        String tipo = (String) cbTipoRobot.getSelectedItem();

        if (tipo.equals("Industrial")) {
            int capacidadCarga = Integer.parseInt(txtAtributo1.getText());
            double energiaConsumida = Double.parseDouble(txtAtributo2.getText());
            listaRobots.agregarRobot(new RobotIndustrial(id, nombre, fabricante, anio, capacidadCarga, energiaConsumida));
        } else if (tipo.equals("Competencia")) {
            double velocidadMaxima = Double.parseDouble(txtAtributo1.getText());
            String categoria = txtAtributo2.getText();
            listaRobots.agregarRobot(new RobotCompetencia(id, nombre, fabricante, anio, velocidadMaxima, categoria));
        }

        JOptionPane.showMessageDialog(this, "Robot agregado exitosamente.");
        limpiarCampos();
    }

    private void mostrarRobots() {
        areaTexto.setText("");
        for (Robot r : listaRobots.obtenerTodos()) {
            areaTexto.append(r.toString() + "\n");
        }
    }

    private void buscarRobot() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del robot a buscar:");
        areaTexto.setText("");
        for (Robot r : listaRobots.buscarPorNombre(nombre)) {
            areaTexto.append(r.toString() + "\n");
        }
    }

    private void eliminarRobot() {
        String id = JOptionPane.showInputDialog(this, "Ingrese el ID del robot a eliminar:");
        listaRobots.eliminarRobot(id);
        JOptionPane.showMessageDialog(this, "Robot eliminado, si existía.");
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtFabricante.setText("");
        txtAnio.setText("");
        txtAtributo1.setText("");
        txtAtributo2.setText("");
    }
    
    public static void main(String[] args) {
		FrmCompetenciaRobots ventana=new FrmCompetenciaRobots();
		ventana.setVisible(true);

	}
}
