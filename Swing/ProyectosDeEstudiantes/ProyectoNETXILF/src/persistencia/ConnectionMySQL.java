package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para gestionar la conexión a una base de datos MySQL.
 */
public class ConnectionMySQL {

    // URL de conexión a la base de datos
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/netxilf";
    
    // Usuario de la base de datos
    private static final String USER = "root";
    
    // Contraseña de la base de datos
    private static final String PASSWORD = "Migues469469";

    /**
     * Obtiene una conexión a la base de datos MySQL.
     *
     * @return La conexión a la base de datos.
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Verificar si la conexión es exitosa
            if (connection != null) {
                System.out.print("Conectando a la base de datos");
                System.out.println("");
                System.out.println("Conexión exitosa a la base de datos.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return connection;
    }

    /**
     * Cierra la conexión a la base de datos.
     *
     * @param connection La conexión a cerrar.
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("");
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
