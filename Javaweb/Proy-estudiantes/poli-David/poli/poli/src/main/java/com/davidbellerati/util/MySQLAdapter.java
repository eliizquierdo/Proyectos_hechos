/*
 * Descripcion -
 *  Utilidad que encapsula metodos para manejar la coneccion con la base de datos.
 *
 * Ultima modificacion -
 *   15/11/2025 7:32 p. m
 *
 * Autores -
 *   David Bellerati
 *   Natan Souza
*/

package com.davidbellerati.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLAdapter {

    private static final String URL = "jdbc:mysql://localhost:3306/poliDeportivo?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "admin123";

    /*
     * Permite establecer conecciones con la base de datos.
     * 
     * @return Connection
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
