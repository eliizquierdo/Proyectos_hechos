// controlador/ControladorEmpleado.java
package controlador;

import vista.FrmEmpleado;
import modelo.Empleado;
import modelo.Vendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorEmpleado {
    private FrmEmpleado vista;
    private ArrayList<Empleado> listaEmpleados; // ArrayList para almacenar empleados

    public ControladorEmpleado(FrmEmpleado vista) {
        this.vista = vista;
        this.listaEmpleados = new ArrayList<>(); // Inicializar el ArrayList

        this.vista.getBtnCalcular().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEmpleado();
            }
        });
    }

    private void agregarEmpleado() {
        double sueldo;
        Empleado empleado;

        if (vista.isVendedor()) {
            empleado = new Vendedor(
                vista.getExtras(),
                vista.getApellido(),
                vista.getJornal(),
                vista.getDias()
            );
        } else {
            empleado = new Empleado(
                vista.getApellido(),
                vista.getJornal(),
                vista.getDias()
            );
        }

        sueldo = empleado.sueldo();
        vista.setSueldo(sueldo);

        // Agregar el empleado a la lista y actualizar el JTextArea
        listaEmpleados.add(empleado);
        actualizarListaEmpleados();
    }

    // Método para actualizar la lista de empleados en el JTextArea
    private void actualizarListaEmpleados() {
        StringBuilder lista = new StringBuilder("Lista de Empleados:\n");
        lista.append("Nombre\t "+"Apellido\t"+"Jornal\t"+"Dias\t"+"Sueldo\t"+"Extra\n");
        for (Empleado emp : listaEmpleados) {
            lista.append(emp.toString()).append("\n"); // Usa toString() para mostrar la información del empleado
        }
        vista.actualizarListaEmpleados(lista.toString());
    }
}
