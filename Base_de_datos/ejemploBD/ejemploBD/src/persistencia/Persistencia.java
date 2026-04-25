package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import logica.Cliente;
import logica.ListaClientes;

public class Persistencia {

    private static Persistencia instancia;
    private String url;
    private String bd;
    private String usuario;
    private String pass;
    private String driver;
    private Connection jdbc;

    private Persistencia() {
        url = "jdbc:mysql://localhost:3306/";
        bd = "clientes";
        usuario = "root";
        pass = "";
        driver = "com.mysql.cj.jdbc.Driver";
        jdbc = conexion();
    }
    // Patrón de diseño: Singleton
    public static Persistencia getInstancia() {
        if (instancia == null) {
            instancia = new Persistencia();
        }
        return instancia;
    }
    // Conexión a la base de datos
    private Connection conexion() {
        try {
            Class.forName(driver);
            jdbc = DriverManager.getConnection(url + bd,usuario, pass);
            System.out.println("Conexión exitosa");
        } catch (Exception ex) {
            System.out.println("No se conecto a la base de datos: " + ex);
        }
        return jdbc;
    }
//*****************************************************************************
    public ListaClientes selectProfesores() {
        ListaClientes lista = new ListaClientes();
        Cliente cliente;
        ResultSet tuplas;
        String seleccionar = "SELECT * FROM cliente";

        try {
            Statement consulta = jdbc.createStatement();
            tuplas = consulta.executeQuery(seleccionar);

            while (tuplas.next()) {     // iteración en cada tupla
                cliente = new Cliente();      // Dar memoria a  un nuevo cliente
                cliente.setApellido(tuplas.getString("Apellido"));
                cliente.setEdad(tuplas.getInt("Edad"));
                cliente.setAntiguedad(tuplas.getInt("Antiguedad"));
                cliente.setSalario(tuplas.getDouble("Salario"));

                lista.insertar(cliente);
            }
        } catch (Exception e) {
            System.out.println("Imposible obtener clientes:" + e);
        }

        return lista;
    }

    public void insertarCliente(Cliente cliente) {
        PreparedStatement sentencia;
        String insertar = "insert into cliente(Apellido,Edad,Antiguedad,Salario)"
                + " values(?,?,?,?)";

        try {
            sentencia = jdbc.prepareStatement(insertar);
            // Ingresamos sentencia, orden de campos empieza en 1
            sentencia.setString(1, cliente.getApellido());
            sentencia.setInt(2, cliente.getEdad());
            sentencia.setInt(3, cliente.getAntiguedad());
            sentencia.setDouble(4, cliente.getSalario());
            // Ejecutamos sentencia
            sentencia.executeUpdate();
            System.out.println("Sentencia ejectuada con éxito");
        } catch (Exception e) {
            System.out.println("Imposible insertar cliente:" + e);
        }
    }
    
} // Fin de Persistencia

