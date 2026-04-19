package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import persistencia.ConnectionMySQL;

/**
 * La clase `SeriesDAO` proporciona métodos para interactuar con la base de datos relacionados con las series de la aplicación NETXILF.
 */
public class SeriesDAO {

    private static Date releaseDate;

    /**
     * Inserta una serie en la base de datos.
     * @param serie La serie a insertar.
     */
    public static void insertSeries(SeriesVO serie) {
        Connection connection = null;
        try {
            connection = ConnectionMySQL.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (connection != null) {
            try {
                String sqlProgramming = "INSERT INTO PROGRAMMING (typeProgramming, nameProgramming, description, releaseDate, cover, gender, subGenre) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement statementProgramming = connection.prepareStatement(sqlProgramming,
                        Statement.RETURN_GENERATED_KEYS);

                java.sql.Date fechaSQL = new java.sql.Date(serie.getReleaseDate().getTime());
                statementProgramming.setString(1, serie.getTypeProgramming());
                statementProgramming.setString(2, serie.getProgrammingName());
                statementProgramming.setString(3, serie.getDescription());
                statementProgramming.setDate(4, fechaSQL);
                statementProgramming.setString(5, serie.getCover());
                statementProgramming.setString(6, serie.getGender());
                statementProgramming.setString(7, serie.getSubGenre());

                statementProgramming.executeUpdate();

                ResultSet generatedKeys = statementProgramming.getGeneratedKeys();
                int id_Prog = -1; // Inicializa un valor predeterminado en caso de que no se encuentre ningún valor
                if (generatedKeys.next()) {
                    id_Prog = generatedKeys.getInt(1); // Obtén el valor generado
                }

                String sqlSeries = "INSERT INTO SERIES (id_Programming, numberSeasons, numberChapter) "
                        + "VALUES (?, ?, ?)";

                PreparedStatement statementSeries = connection.prepareStatement(sqlSeries,
                        Statement.RETURN_GENERATED_KEYS);

                statementSeries.setInt(1, id_Prog);
                statementSeries.setInt(2, serie.getNumberSeasons());
                statementSeries.setInt(3, serie.getNumberChapter());

                statementSeries.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al insertar datos en la tabla 'Series': " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al ingresar. Reintente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(null, "Serie ingresada.", "Exito",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Obtiene una lista de todas las series de la base de datos.
     * @return Una lista de series.
     */
    public static ListSeries listSeries() {
        ListSeries list = new ListSeries();

        Connection connection = null;

        try {
            connection = ConnectionMySQL.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (connection != null) {
            try {
                String sqlList = "SELECT * FROM PROGRAMMING JOIN SERIES ON PROGRAMMING.id_Programming = SERIES.id_Programming";

                PreparedStatement statement = connection.prepareStatement(sqlList);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {

                    String typeProgramming = resultSet.getString("typeProgramming");
                    String nameProgramming = resultSet.getString("nameProgramming");
                    String description = resultSet.getString("description");
                    releaseDate = resultSet.getDate("releaseDate");
                    String cover = resultSet.getString("cover");
                    String gender = resultSet.getString("gender");
                    String subGenre = resultSet.getString("subGenre");
                    int numberSeasons = resultSet.getInt("numberSeasons");
                    int numberChapter = resultSet.getInt("numberChapter");
                    SeriesVO serie = new SeriesVO(typeProgramming, nameProgramming, description, cover, gender, subGenre, releaseDate, numberSeasons, numberChapter);
                    list.add(serie);

                }

            } catch (SQLException e) {
                System.err.println("Error al insertar datos en la tabla 'Clientes': " + e.getMessage());
            }
            return list;
        }
        return list;
    }

    /**
     * Elimina una serie de la base de datos.
     * @param typeProgramming El tipo de programación de la serie.
     * @param nameProgramming El nombre de la serie.
     */
    public static void deleteProgramming(String typeProgramming, String nameProgramming) {
        Connection connection = ConnectionMySQL.getConnection();

        // Primero, obtenemos el id_Programming de la programación
        String queryIdProgramming = "SELECT id_Programming FROM PROGRAMMING WHERE nameProgramming = ? AND typeProgramming = ?";

        try {
            PreparedStatement statementProgramming = connection.prepareStatement(queryIdProgramming);

            statementProgramming.setString(1, nameProgramming);
            statementProgramming.setString(2, typeProgramming);

            int id_Programming = -1; // Valor predeterminado en caso de no encontrar el administrador

            // Ejecutar la consulta
            ResultSet resultSet = statementProgramming.executeQuery();
            if (resultSet.next()) {
                id_Programming = resultSet.getInt("id_Programming");
                System.out.println("id_Prog: " + id_Programming);
            } else {
                System.out.println("No se encontró un programa con los valores proporcionados.");
            }

            resultSet.close();
            statementProgramming.close();

            // Si encontramos el id_Programming, eliminamos los registros relacionados
            if (id_Programming != -1) {

                // Eliminar de SERIES
                String deleteSerie = "DELETE FROM SERIES WHERE id_Programming = ?";
                PreparedStatement deleteSeries = connection.prepareStatement(deleteSerie);
                deleteSeries.setInt(1, id_Programming);
                deleteSeries.executeUpdate();
                deleteSeries.close();

                // Eliminar de PROGRAMMING
                String deleteProgramming = "DELETE FROM PROGRAMMING WHERE id_Programming = ?";
                PreparedStatement delProgramming = connection.prepareStatement(deleteProgramming);
                delProgramming.setInt(1, id_Programming);
                delProgramming.executeUpdate();
                delProgramming.close();

                JOptionPane.showMessageDialog(null, "Programación eliminada correctamente.", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Datos no válidos, revisar.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Obtiene una serie de la base de datos dado su ID de programación.
     * @param id_Programming El ID de programación de la serie.
     * @return La serie correspondiente al ID de programación proporcionado.
     */
    public static SeriesVO getSeries(int id_Programming) {
        Connection connection = null;

        try {
            connection = ConnectionMySQL.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        SeriesVO serie1 = null;
        if (connection != null) {
            try {
                String sqlList = "SELECT * FROM PROGRAMMING JOIN SERIES ON PROGRAMMING.id_Programming = SERIES.id_Programming WHERE PROGRAMMING.id_Programming = ?;";

                PreparedStatement statement = connection.prepareStatement(sqlList);
                statement.setInt(1, id_Programming);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {

                    String typeProgramming = resultSet.getString("typeProgramming");
                    String nameProgramming = resultSet.getString("nameProgramming");
                    String description = resultSet.getString("description");
                    releaseDate = resultSet.getDate("releaseDate");
                    String cover = resultSet.getString("cover");
                    String gender = resultSet.getString("gender");
                    String subGenre = resultSet.getString("subGenre");
                    int numberSeasons = resultSet.getInt("numberSeasons");
                    int numberChapter = resultSet.getInt("numberChapter");

                    serie1 = new SeriesVO(typeProgramming, nameProgramming, description, cover, gender,
                            subGenre, releaseDate, numberSeasons, numberChapter);

                }

            } catch (SQLException e) {
                System.err.println("Error al insertar datos en la tabla 'Clientes': " + e.getMessage());
            }
            return serie1;
        }
        return serie1;
    }

}
