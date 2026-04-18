package modelo.conexion;

import java.sql.*;

public class Conexion {

    /*Parametros de conexion */
    String bd = "instituto";
    String login = "root";
    String password = "admin123";
    String url = "jdbc:mysql://localhost/" + bd + "?useTimezone=true&serverTimezone=UTC";

    private Connection con;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");    // obtiene el driver para MySQL
            con = DriverManager.getConnection(url, login, password); // obtiene  la conexión
            if (con != null) {
                System.out.println("Conexión a base de datos " + bd + " OK\n");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void desconectar() {
        try {
            System.out.println("Desconectado de base de datos " + bd + " OK\n");
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al desconectar");
        }
    }

    public Connection getConnection() {
        return con;
    }
}
