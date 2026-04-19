package grafica;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import logica.MoviesVO;
import logica.PersonsVO;
import logica.SeriesVO;
import java.awt.Toolkit;

/**
 * Ventana de diálogo que muestra una lista de personas.
 */
public class DlgListPersons extends JDialog {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel tableModel;
    private TableRowSorter<DefaultTableModel> sorter;
    private JTextField filterText;
    private JScrollPane scrollPane;
    private JPanel filterPanel;
    private JButton filterButton;
    private JPanel buttonPanel;
    private JButton okButton;
    private JButton backButton;

    /**
     * Constructor de la clase.
     */
    public DlgListPersons() {
        setTitle("Lista de Personas");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\img\\Nlogo.jpg"));
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        eventStarter();
        eventHandler();
    }

    /**
     * Configura los manejadores de eventos para los componentes de la interfaz.
     */
    private void eventHandler() {
        filterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = filterText.getText();
                if (text.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1, 5, 6));
                }
            }
        });

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Puedes agregar lógica para procesar la selección y aplicar las acciones deseadas aquí
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra el diálogo
            }
        });
    }

    /**
     * Inicializa y configura los componentes de la interfaz.
     */
    private void eventStarter() {
        // Crear la tabla y su modelo
        table = new JTable();
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(tableModel);

        // Agregar columnas a la tabla
        tableModel.addColumn("ID");
        tableModel.addColumn("Tipo de Persona");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Apellido");
        tableModel.addColumn("Ciudad");
        tableModel.addColumn("País");
        tableModel.addColumn("Teléfono 1");
        tableModel.addColumn("Teléfono 2");
        tableModel.addColumn("Email (Admin)");
        tableModel.addColumn("Contraseña (Admin)");

        // Agregar un panel con una barra de desplazamiento para la tabla
        scrollPane = new JScrollPane(table);

        // Configurar el ordenamiento y filtro de la tabla
        sorter = new TableRowSorter<DefaultTableModel>(tableModel);
        table.setRowSorter(sorter);

        // Agregar un filtro para buscar por nombre, sub-género y género
        filterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        filterText = new JTextField(20);
        filterButton = new JButton("Filtrar");
        filterPanel.add(filterText);
        filterPanel.add(filterButton);

        // Crear un panel con los botones OK y VOLVER
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        okButton = new JButton("OK");
        backButton = new JButton("VOLVER");
        buttonPanel.add(okButton);
        buttonPanel.add(backButton);

        // Agregar componentes al contenido
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(filterPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Ajustar automáticamente el ancho de las columnas al contenido
        adjustColumnWidth();

        // Establecer el tamaño mínimo y preferido de la ventana
        setSize(new Dimension(1800, 400));

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
    }

    /**
     * Método para actualizar la tabla con un ArrayList de objetos PersonsVO.
     *
     * @param dataSerie Lista de objetos PersonsVO que se utilizarán para actualizar la tabla.
     */
    public void updateTable(ArrayList<PersonsVO> dataSerie) {
        tableModel.setRowCount(0); // Limpia todas las filas

        String prevIdPersons = null; // Inicializa prevIdPersons como null

        for (PersonsVO person : dataSerie) {
            String currentIdPersons = person.getId_Persons();

            if (prevIdPersons == null || !currentIdPersons.equals(prevIdPersons)) {
                // Si prevIdPersons es null o es diferente, agrega la fila tal como está
                String[] phones = person.getPhones();
                String phoneValue1 = phones.length > 0 ? phones[0] : "";
                String phoneValue2 = phones.length > 1 ? phones[1] : "";

                tableModel.addRow(new Object[]{currentIdPersons, person.getTypePerson(), person.getNamePerson(), person.getLastName(),
                        person.getCity(), person.getCountry(), phoneValue1, phoneValue2,
                        person.getEmailAdmin(), person.getPasswordAdmin()});

                prevIdPersons = currentIdPersons; // Actualiza prevIdPersons
            } else {
                // Combina el valor de la columna 6 en la columna 7 de la fila anterior
                String phoneValue6 = (String) tableModel.getValueAt(tableModel.getRowCount() - 1, 6);
                String phoneValue7 = person.getPhones().length > 0 ? person.getPhones()[0] : "";
                tableModel.setValueAt(phoneValue7, tableModel.getRowCount() - 1, 7);
            }
        }

        // Ajustar automáticamente el ancho de las columnas al contenido después de
        // actualizar la tabla
        adjustColumnWidth();
    }

    /**
     * Ajusta automáticamente el ancho de las columnas al contenido de la tabla.
     */
    private void adjustColumnWidth() {
        JTableHeader header = table.getTableHeader();
        TableColumnModel columnModel = table.getColumnModel();

        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = header.getDefaultRenderer()
                    .getTableCellRendererComponent(table, column, false, false, -1, column).getPreferredSize().width;

            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width, width);
            }

            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
}
