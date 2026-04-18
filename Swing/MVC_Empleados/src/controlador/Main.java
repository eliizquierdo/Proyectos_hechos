package controlador;
//Main.java
import vista.FrmEmpleado;
import controlador.ControladorEmpleado;

public class Main {
 public static void main(String[] args) {
     // Crear la vista
     FrmEmpleado vista = new FrmEmpleado();

     // Crear el controlador, pasando la vista
     ControladorEmpleado controlador = new ControladorEmpleado(vista);

     // Mostrar la ventana principal
     vista.setVisible(true);
 }
}

